package com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID;

import com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID.MutexKeyForAccessUUID;

import java.lang.annotation.*;


/***
 * 通过Token中访问UUID值的互斥锁（顺序执行锁），作用：保证同一操作的顺序执行
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface MutexLockByAccessUUID {
    MutexKeyForAccessUUID key();
}