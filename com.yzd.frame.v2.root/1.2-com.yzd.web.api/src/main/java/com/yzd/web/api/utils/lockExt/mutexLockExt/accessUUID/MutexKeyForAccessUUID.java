package com.yzd.web.api.utils.lockExt.mutexLockExt.accessUUID;

import com.yzd.common.cache.utils.setting.CachedSetting;
import com.yzd.web.api.utils.cachedExt.CachedConstant;

/***
 * 通过Token中访问UUID的值进行互斥Key的集合
 * 注：每个Key当且仅当，只能使用一次
 */
public enum MutexKeyForAccessUUID {
    //注：每个Key当且仅当，只能使用一次
    //保存临时测试数据
    SaveTemptestLock(CachedConstant.SaveTemptestLockForAccessUUIDType),
    //领取红包操作
    GetHongbaoLock(CachedConstant.GetHongbaoLockForAccessUUIDType);

    /***
     *
     * @param cachedSetting
     */
    MutexKeyForAccessUUID(CachedSetting cachedSetting){
        this.cachedSetting=cachedSetting;
    }
    private CachedSetting cachedSetting;

    public CachedSetting getCachedSetting() {
        return cachedSetting;
    }
}
