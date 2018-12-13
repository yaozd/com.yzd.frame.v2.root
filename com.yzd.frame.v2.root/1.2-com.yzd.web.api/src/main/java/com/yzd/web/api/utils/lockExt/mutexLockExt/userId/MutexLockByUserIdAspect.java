package com.yzd.web.api.utils.lockExt.mutexLockExt.userId;

import com.yzd.common.cache.redis.sharded.ShardedRedisUtil;
import com.yzd.common.cache.utils.setting.CachedSetting;
import com.yzd.common.token.session.CurrentUser;
import com.yzd.common.token.session.CurrentUserContextHolder;
import com.yzd.web.api.model.response._base.JsonResultError;
import com.yzd.web.api.utils.aspectExt.AspectUtil;
import com.yzd.web.api.utils.dateExt.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(90)
public class MutexLockByUserIdAspect {
    @Pointcut("@annotation(com.yzd.web.api.utils.lockExt.mutexLockExt.userId.MutexLockByUserId)")
    public void setJoinPoint() {
    }

    @Around(value = "setJoinPoint()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {

        CurrentUser user = CurrentUserContextHolder.get();
        if (user == null) {
            return new JsonResultError("尚未登录");
        }
        Method method = AspectUtil.getMethod(proceedingJoinPoint);
        MutexLockByUserId mutexLockByUserId=AspectUtil.getAnnotation(method,MutexLockByUserId.class);
        CachedSetting cachedSetting =mutexLockByUserId.key().getCachedSetting();
        String fullKey=cachedSetting.getKeyFullName()+"byUserId:"+user.getId();
        int secondsEx=cachedSetting.getKeyExpireSec();
        String timestamp=DateUtil.nowToString();//timestamp表示互斥锁的创建时间
        ShardedRedisUtil redisUtil = ShardedRedisUtil.getInstance();
        String isLock = redisUtil.set(fullKey, timestamp, "nx", "ex", secondsEx);
        if(!"OK".equalsIgnoreCase(isLock)){
            return new JsonResultError("操作正在执行，请不要重复提交！");
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw new IllegalStateException(throwable);
        }finally {
            redisUtil.del(fullKey);
        }
    }
}
