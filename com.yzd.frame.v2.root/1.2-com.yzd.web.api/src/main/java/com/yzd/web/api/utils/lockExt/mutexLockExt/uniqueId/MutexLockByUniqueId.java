package com.yzd.web.api.utils.lockExt.mutexLockExt.uniqueId;

import java.lang.annotation.*;

/***
 * 通过唯一Id的互斥锁（顺序执行锁），作用：保证同一操作的顺序执行
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface MutexLockByUniqueId {
    MutexKeyForUniqueId key();
}