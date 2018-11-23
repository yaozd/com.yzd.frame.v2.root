package com.yzd.web.api.controllerApi;

import com.yzd.common.token.enumExt.ErrorCodeJWT;
import com.yzd.common.token.jwtExt.JWTUtil3;
import com.yzd.common.token.jwtExt.RefreshResultJWT;
import com.yzd.common.token.session.CurrentUser;
import com.yzd.common.token.utils.signExt.SignUtil;
import com.yzd.web.api.common.exceptionExt.TokenValidException;
import com.yzd.web.api.common.paramValidExt.ParamValid;
import com.yzd.web.api.model.request.token.BaseTokenForm;
import com.yzd.web.api.model.request.token.GetBaseTokenForm;
import com.yzd.web.api.model.request.token.RefreshTokenFrom;
import com.yzd.web.api.model.response._base.JsonResult;
import com.yzd.web.api.model.response._base.JsonResultData;
import com.yzd.web.api.model.response._base.JsonResultError;
import com.yzd.web.api.utils.fastjsonExt.FastJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("${appPath}/api/token")
public class TokenControllerAPI {

    //有效时间范围
    private static final Long min5=5*60*1000L;

    /***
     * 创建 token,当user为null时是未登录的访问token
     * @return
     */
    @PostMapping("getBaseToken")
    public JsonResult getBaseToken(@RequestBody @ParamValid GetBaseTokenForm form, String sign){
        if(log.isDebugEnabled()){
            String input=FastJsonUtil.serialize(form);
            log.debug("getBaseToken方法：请求参数={};请求签名={};正确签名={}",input,sign,SignUtil.create(form));
        }
        filterForGetBaseToken(form,sign);
        //创建 token,当user为null时是未登录的访问token
        String token= JWTUtil3.createToken(CurrentUser.createEmptyUser());
        return new JsonResultData(token);
    }

    /***
     * 刷新token
     * @param form
     * @param sign
     * @return
     */
    @PostMapping(value = "refreshToken")
    public JsonResult refreshToken(@RequestBody @ParamValid RefreshTokenFrom form, String sign){
        if(log.isDebugEnabled()){
            log.debug(SignUtil.create(form));
        }
        filterForGetBaseToken(form, sign);
        RefreshResultJWT refreshResultJWT=JWTUtil3.refreshToken(form.getRefreshToken(),CurrentUser.class);
        if(refreshResultJWT.getIsOk()){
           return new JsonResultData(refreshResultJWT.getToken());
        }
        return new JsonResultError(refreshResultJWT.getErrorMsg(), ErrorCodeJWT.RefreshTokenFail.getValue());
    }
    /***
     * getBaseToken方法的请求数据有效性进行过滤验证
     * @param form
     * @param sign
     */
    private void filterForGetBaseToken(BaseTokenForm form, String sign) {
        if(StringUtils.isBlank(sign)){
            throw new TokenValidException("//签名不能为空");
        }
        Long tokenTimestamp= NumberUtils.createLong(form.getTimestamp());
        Long nowTimestamp=System.currentTimeMillis();
        Long diffVal=Math.abs(nowTimestamp-tokenTimestamp);
        if(diffVal>min5){
            throw new TokenValidException("//只接受5分钟内的时间差");
        }
        if(BooleanUtils.isNotTrue(SignUtil.check(form, sign))){
            throw new TokenValidException("//签名不正确");
        }
    }
}