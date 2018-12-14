package com.yzd.web.api.common.config;

import com.yzd.web.api.common.exceptionExt.TokenValidException;
import com.yzd.web.api.common.exceptionExt.UnauthorizedException;
import com.yzd.web.api.common.paramValidExt.ParamValidException;
import com.yzd.web.api.model.response._base.JsonResult;
import com.yzd.web.api.model.response._base.JsonResultError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /***
     * 500 服务器内部未知异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    JsonResult handleControllerException(Exception ex) {
        //生产上会用统一的的输出格式- new JsonResultList
        //当前属于api请求参数的格式验证异常-所以状态是200
        return JsonResultError.buildForInnerError(ex.getMessage());
    }
    /***
     * 如果抛出UnauthorizedException，将被该异常处理器截获来显示没有权限信息
     * @param ex
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    JsonResult handleControllerExceptionForUnauthorized(Exception ex) {
        return JsonResultError.Unauthorized;
    }
    /***
     * 请求参数格式不正确
     * @param ex
     * @return
     */
    @ExceptionHandler(ParamValidException.class)
    @ResponseBody
    JsonResult handleControllerExceptionForParamValid(Exception ex) {
        //生产上会用统一的的输出格式- new JsonResultList
        //当前属于api请求参数的格式验证异常-所以状态是200
        return JsonResultError.buildForJsonError(ex.getMessage());
    }
    /***
     * 请求参数格式不正确
     * @param ex
     * @return
     */
    @ExceptionHandler(TokenValidException.class)
    @ResponseBody
    JsonResult handleControllerExceptionForTokenValid(Exception ex) {
        //生产上会用统一的的输出格式- new JsonResultList
        //当前属于api请求参数的格式验证异常-所以状态是200
        return JsonResultError.build(ex.getMessage());
    }
}
