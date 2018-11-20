package com.yzd.web.api.common.interceptorExt;

import com.yzd.common.token.enumExt.ErrorCodeJWT;
import com.yzd.common.token.jwtExt.JWTUtil3;
import com.yzd.common.token.jwtExt.VerifyResultJWT;
import com.yzd.common.token.session.CurrentUser;
import com.yzd.common.token.session.CurrentUserContextHolder;
import com.yzd.web.api.model.response._base.JsonResultError;
import com.yzd.web.api.utils.fastjsonExt.FastJsonUtil;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())){
            return true;
        }
        String accessToken = httpServletRequest.getHeader("Authorization");
        if(StringUtils.isBlank(accessToken)){
            //4100
            int errorCode=ErrorCodeJWT.NotFoundTokenFail.getValue();
            httpServletResponse.setStatus(errorCode);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            String jsonResult = FastJsonUtil.serialize(new JsonResultError("Not Found Token In Header",errorCode));
            httpServletResponse.getWriter().write(jsonResult);
            return false;
        }
        //验证前必须要先移除ThreadLocal中的用户信息，防止用户串联在一起
        CurrentUserContextHolder.remove();
        //验证是否通过
        VerifyResultJWT verifyResultJWT = JWTUtil3.verifyToken(accessToken);
        if(BooleanUtils.isNotTrue(verifyResultJWT.getIsOk())){
            //4101
            int errorCode=ErrorCodeJWT.VerifyTokenFail.getValue();
            httpServletResponse.setStatus(errorCode);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            String jsonResult = FastJsonUtil.serialize(new JsonResultError(verifyResultJWT.getErrorMsg(),errorCode));
            httpServletResponse.getWriter().write(jsonResult);
            return false;
        }
        //验证通过后把用户信息放入ThreadLocal中
        CurrentUser currentUser= FastJsonUtil.deserialize(verifyResultJWT.getUserJson(),CurrentUser.class);
        CurrentUserContextHolder.set(currentUser);
        return true;
    }
}
