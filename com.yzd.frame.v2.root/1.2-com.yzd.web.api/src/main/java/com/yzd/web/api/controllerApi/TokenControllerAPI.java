package com.yzd.web.api.controllerApi;

import com.yzd.common.token.jwtExt.JWTUtil3;
import com.yzd.common.token.session.CurrentUser;
import com.yzd.web.api.model.response._base.JsonResult;
import com.yzd.web.api.model.response._base.JsonResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${appPath}/api/token")
public class TokenControllerAPI {

    /***
     * 创建 token,当user为null时是未登录的访问token
     * @return
     */
    @PostMapping("getBaseToken")
    public JsonResult getBaseToken(){
        //创建 token,当user为null时是未登录的访问token
        String token= JWTUtil3.createToken(CurrentUser.createEmptyUser());
        return new JsonResultData(token);
    }

}