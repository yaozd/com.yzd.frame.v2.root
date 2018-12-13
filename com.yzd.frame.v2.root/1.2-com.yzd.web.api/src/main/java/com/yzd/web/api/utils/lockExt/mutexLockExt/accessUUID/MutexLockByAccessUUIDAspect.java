package com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID;

import com.yzd.common.cache.redis.sharded.ShardedRedisUtil;
import com.yzd.common.cache.utils.setting.CachedSetting;
import com.yzd.common.token.session.CurrentUser;
import com.yzd.common.token.session.CurrentUserContextHolder;
import com.yzd.web.api.model.response._base.JsonResultError;
import com.yzd.web.api.utils.aspectExt.AspectUtil;
import com.yzd.web.api.utils.dateExt.DateUtil;
import com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID.MutexLockByAccessUUID;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/***
 * 通过Token中访问UUID值的互斥锁（顺序执行锁），作用：保证同一操作的顺序执行
 */
@Aspect
@Component
@Order(90)
public class MutexLockByAccessUUIDAspect {
    @Pointcut("@annotation(com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID.MutexLockByAccessUUID)")
    public void setJoinPoint() {
    }

    @Around(value = "setJoinPoint()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {

        CurrentUser user = CurrentUserContextHolder.get();
        if (user == null) {
            return new JsonResultError("没有找到有效Token");
        }
        Method method = AspectUtil.getMethod(proceedingJoinPoint);
        MutexLockByAccessUUID mutexLockByAccessUUID=AspectUtil.getAnnotation(method,MutexLockByAccessUUID.class);
        CachedSetting cachedSetting =mutexLockByAccessUUID.key().getCachedSetting();
        String fullKey=cachedSetting.getKeyFullName()+"byUUID:"+user.getAccessUUID();
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
