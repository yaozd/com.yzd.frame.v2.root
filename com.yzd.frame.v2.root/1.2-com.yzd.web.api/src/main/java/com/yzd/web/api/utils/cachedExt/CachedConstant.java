package com.yzd.web.api.utils.cachedExt;

import com.yzd.common.cache.utils.setting.CachedSetting;

/***
 * 统一的缓存常量存储
 */
public class CachedConstant {
    //具体的项目缓存编号可以查看wiki
    //http://w.hb.com/docs/show/11
    private static String com_yzd_web_api="P01";

    public static final CachedSetting SaveTemptestLockForAccessUUIDType =new CachedSetting(com_yzd_web_api,"save_temptest_lock",60,10,5,"保存临时测试数据锁缓存1分钟：保证临时测试相关操作顺序执行");
    //通过用户id形式-红包领取锁
    public static CachedSetting GetHongbaoLockForUserIdType=new CachedSetting(com_yzd_web_api,"get_hongbao_lock",60,10,5,"红包活动锁缓存1分钟：保证红包相关操作顺序执行");
    //通过AccessUUID形式-红包领取锁
    public static CachedSetting GetHongbaoLockForAccessUUIDType=new CachedSetting(com_yzd_web_api,"get_hongbao_lock",60,10,5,"红包活动锁缓存1分钟：保证红包相关操作顺序执行");
}
