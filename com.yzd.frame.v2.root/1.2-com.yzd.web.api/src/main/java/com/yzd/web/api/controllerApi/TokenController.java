package com.yzd.web.api.controllerApi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${appPath}/api/token")
public class TokenController {

    @PostMapping("getBaseToken")
    public String getBaseToken(){
        return "test";
    }

}
