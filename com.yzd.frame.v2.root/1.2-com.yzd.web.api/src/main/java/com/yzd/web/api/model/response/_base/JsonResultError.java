package com.yzd.web.api.model.response._base;

import com.yzd.web.api.utils.enumExt.JsonResultCodeEnum;
import com.yzd.web.api.utils.fastjsonExt.FastJsonUtil;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/20.
 */

public class JsonResultError {
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
     * @param error
     * @return
     */
    public static JsonResult build(String error){
        return new JsonResult(JsonResultCodeEnum.ERROR.InvalidRequestParametersReturnStringError.getCode(),error);
    }

    /***
     * 请求参数不合法-返回JSON类型错误信息
     * @param errorMap
     * @return
     */
    public static JsonResult build(Map<String, String> errorMap){
        String errorJosn=FastJsonUtil.serialize(errorMap);
        return new JsonResult(JsonResultCodeEnum.ERROR.InvalidRequestParametersReturnJsonError.getCode(),errorJosn);
    }

    /***
     * 请求参数不合法-返回JSON类型错误信息
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
}
