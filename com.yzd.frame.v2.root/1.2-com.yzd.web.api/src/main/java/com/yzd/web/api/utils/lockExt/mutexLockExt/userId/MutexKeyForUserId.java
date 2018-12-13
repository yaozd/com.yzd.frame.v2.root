package com.yzd.web.api.utils.lockExt.mutexLockExt.userId;

import com.yzd.common.cache.utils.setting.CachedSetting;
import com.yzd.web.api.utils.cachedExt.CachedConstant;

/***
 * 通过用户ID值进行互斥Key的集合
 * 注：每个Key当且仅当，只能使用一次
 */
public enum MutexKeyForUserId {
    //注：每个Key当且仅当，只能使用一次
    //领取红包操作
    GetHongbaoLock(CachedConstant.GetHongbaoLockForUserIdType);

    /***
     *
     * @param cachedSetting
     */
    MutexKeyForUserId(CachedSetting cachedSetting){
        this.cachedSetting=cachedSetting;
    }
    private CachedSetting cachedSetting;

    public CachedSetting getCachedSetting() {
        return cachedSetting;
    }
}
