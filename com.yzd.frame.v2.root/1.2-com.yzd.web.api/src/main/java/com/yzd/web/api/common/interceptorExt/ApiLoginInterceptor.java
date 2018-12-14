package com.yzd.web.api.common.interceptorExt;

import com.yzd.common.token.enumExt.ErrorCodeJWT;
import com.yzd.common.token.session.CurrentUser;
import com.yzd.common.token.session.CurrentUserContextHolder;
import com.yzd.web.api.model.response._base.JsonResult;
import com.yzd.web.api.model.response._base.JsonResultError;
import com.yzd.web.api.utils.fastjsonExt.FastJsonUtil;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        //验证用户是否登陆
        CurrentUser currentUser = CurrentUserContextHolder.get();
        boolean isLogin = currentUser != null && currentUser.getId()!=null;
        if (BooleanUtils.isNotTrue(isLogin)) {
            //403
            JsonResult forbiddenAccessJsonResultError=JsonResultError.ForbiddenAccess;
            response.setStatus(forbiddenAccessJsonResultError.getCode());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String jsonResult = FastJsonUtil.serialize(forbiddenAccessJsonResultError);
            response.getWriter().write(jsonResult);
            return false;
        }
        return true;
    }
}
