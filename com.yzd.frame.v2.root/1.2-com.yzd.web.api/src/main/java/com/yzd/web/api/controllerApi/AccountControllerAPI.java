package com.yzd.web.api.controllerApi;

import com.yzd.web.api.common.paramValidExt.ParamValid;
import com.yzd.web.api.model.request.account.LoginForm;
import com.yzd.web.api.model.response._base.JsonResult;
import com.yzd.web.api.model.response._base.JsonResultOk;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${appPath}/api/account")
public class AccountControllerAPI {
    @PostMapping("doLogin")
    public JsonResult doLogin(@ParamValid LoginForm loginForm) {
        return new JsonResultOk("doLogin") ;
    }

    @PostMapping("doLogout")
    public JsonResult doLogout(){
        return new JsonResultOk() ;
    }
}
