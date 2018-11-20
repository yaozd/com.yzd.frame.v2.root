package com.yzd.web.api.controllerApi;

import com.yzd.web.api.model.response._base.JsonResult;
import com.yzd.web.api.model.response._base.JsonResultOk;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${appPath}/api/user")
public class UserControllerAPI {

    @GetMapping("details")
    public JsonResult details(){

        return new JsonResultOk("details");
    }
}