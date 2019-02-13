package com.yzd.web.api.utils.preconditionsExt;

import com.yzd.web.api.common.exceptionExt.DataValidException;
import com.yzd.web.api.common.paramValidExt.ParamValidException;
import com.yzd.web.api.utils.fastjsonExt.FastJsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据校验
 * 数据检查验证，进行代码校验的工具类
 * 参考：guava的Preconditions
 */
public class PreconditionsUtil {
    /**
     * 请求参数不合法-返回JSON类型错误信息
     * -返回JSON类型的字符串错误信息-返回数据所主要用于页面做数据反显
     * @param b
     * @param key
     * @param value
     */
    public static void checkParamsThrowException(boolean b, String key,String value) {
        if (b) {
            Map<String, String> errorMap=new HashMap<>(1);
            errorMap.put(key,value);
            String error=FastJsonUtil.serialize(errorMap);
            throw new ParamValidException(error);
        }
    }

    /**
     * 请求参数不合法-返回字符串类型错误信息
     * -返回数据主要用于页面弹出提示，在页面不做数据反显
     * @param b
     * @param error
     */
    public static void checkDataThrowException(boolean b, String error) {
        if (b) {
            throw new DataValidException(error);
        }
    }
}
