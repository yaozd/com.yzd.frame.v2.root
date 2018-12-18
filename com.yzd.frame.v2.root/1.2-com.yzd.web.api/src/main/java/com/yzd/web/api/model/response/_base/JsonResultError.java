package com.yzd.web.api.model.response._base;

import com.yzd.web.api.common.exceptionExt.DataValidException;
import com.yzd.web.api.common.paramValidExt.ParamValidException;
import com.yzd.web.api.utils.enumExt.JsonResultCodeEnum;
import com.yzd.web.api.utils.fastjsonExt.FastJsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/20.
 */

public class JsonResultError {
    private JsonResultError() {
        throw new IllegalStateException("JsonResultError class");
    }
    public static final JsonResult Unauthorized=new JsonResult(JsonResultCodeEnum.ERROR.Unauthorized.getCode(),JsonResultCodeEnum.ERROR.Unauthorized.getMessage());

    public static final JsonResult ForbiddenAccess=new JsonResult(JsonResultCodeEnum.ERROR.ForbiddenAccess.getCode(),JsonResultCodeEnum.ERROR.ForbiddenAccess.getMessage());

    public static final JsonResult RepeatedSubmitRequest=new JsonResult(JsonResultCodeEnum.ERROR.RepeatedSubmitRequest.getCode(),JsonResultCodeEnum.ERROR.RepeatedSubmitRequest.getMessage());

    public static final JsonResult AlreadyReceive=new JsonResult(JsonResultCodeEnum.ERROR.AlreadyReceive.getCode(),JsonResultCodeEnum.ERROR.AlreadyReceive.getMessage());

    public static final JsonResult NotFoundTokenFail=new JsonResult(JsonResultCodeEnum.ERROR.NotFoundTokenFail.getCode(),JsonResultCodeEnum.ERROR.NotFoundTokenFail.getMessage());

    public static final JsonResult VerifyTokenFail=new JsonResult(JsonResultCodeEnum.ERROR.VerifyTokenFail.getCode(),JsonResultCodeEnum.ERROR.VerifyTokenFail.getMessage());

    public static final JsonResult GetTokenFail=new JsonResult(JsonResultCodeEnum.ERROR.GetTokenFail.getCode(),JsonResultCodeEnum.ERROR.GetTokenFail.getMessage());

    public static final JsonResult RefreshTokenFail=new JsonResult(JsonResultCodeEnum.ERROR.RefreshTokenFail.getCode(),JsonResultCodeEnum.ERROR.RefreshTokenFail.getMessage());


    /***
     * 请求参数不合法-返回字符串类型错误信息
     * -返回数据主要用于页面弹出提示，在页面不做数据反显
     * @param error
     * @return
     */
    public static JsonResult build(String error){
        return new JsonResult(JsonResultCodeEnum.ERROR.DataValidFail.getCode(),error);
    }

    /***
     * 请求参数不合法-返回JSON类型错误信息
     * -返回JSON类型的字符串错误信息-返回数据所主要用于页面做数据反显
     * @param errorMap
     * @return
     */
    public static JsonResult buildForJsonError(Map<String, String> errorMap){
        String errorJosn=FastJsonUtil.serialize(errorMap);
        return new JsonResult(JsonResultCodeEnum.ERROR.InvalidRequestParametersReturnJsonError.getCode(),errorJosn);
    }

    /***
     * 请求参数不合法-返回JSON类型错误信息
     * -返回JSON类型的字符串错误信息-返回数据所主要用于页面做数据反显
     * @param errorJosn
     * @return
     */
    public static JsonResult buildForJsonError(String errorJosn){
        return new JsonResult(JsonResultCodeEnum.ERROR.InvalidRequestParametersReturnJsonError.getCode(),errorJosn);
    }

    /***
     * 服务器内部未知异常
     * @param error
     * @return
     */
    public static JsonResult buildForInnerError(String error) {
        return new JsonResult(JsonResultCodeEnum.ERROR.InnerError.getCode(),error);
    }

    /***
     * 请求参数不合法-返回字符串类型错误信息
     * -返回数据主要用于页面弹出提示，在页面不做数据反显
     * @param error
     * @return
     */
    public static DataValidException newDataValidException(String error){
        return new DataValidException(error);
    }

    /***
     * 请求参数不合法-返回JSON类型错误信息
     * -返回JSON类型的字符串错误信息-返回数据所主要用于页面做数据反显
     * @param key
     * @param value
     * @return
     */
    public static ParamValidException newParamValidException(String key,String value){
        Map<String, String> errorMap=new HashMap<>(1);
        errorMap.put(key,value);
        String error=FastJsonUtil.serialize(errorMap);
        return new ParamValidException(error);
    }
}
