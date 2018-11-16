package com.yzd.web.common.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring boot自定义异常处理
 * http://blog.csdn.net/whatlookingfor/article/details/51548923
 * Container Configuration in Spring Boot 2
 * https://www.baeldung.com/embeddedservletcontainercustomizer-configurableembeddedservletcontainer-spring-boot
 * */
@Controller
@RequestMapping("error")
public class ErrorController {

    @RequestMapping( "404")
    public String  error404() {
        return "error/404";
    }
}
