package com.yzd.common.cache.redis.sharded;

import com.yzd.common.cache.redis.cache.CacheKeyList;
import com.yzd.common.cache.utils.wrapper.CachedWrapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zd.yao on 2017/3/17.
 */
public class ShardedRedisUtil_UnitTest {
    @Test
    public void setExample() {
        ShardedRedisUtil redisUtil = ShardedRedisUtil.getInstance();
        String result = redisUtil.set("ShardedRedisUtilUnitTest", "2017031701");
        assertThat(result).isEqualTo("OK");
    }
    @Test
    public void setExampleWithCacheKey() {
        ShardedRedisUtil redisUtil = ShardedRedisUtil.getInstance();
        //P01.HelloWorld:b0baee9d279d34fa1dfd71aadb908c3f
        CachedWrapper<String> result = redisUtil.getPublicCachedWrapperByMutexKey(CacheKeyList.HelloWorld, "1112121",()->{
            return "cache data";
        });
        System.out.println(result.getData());
        assertThat(result).isNotNull();
    }
}
