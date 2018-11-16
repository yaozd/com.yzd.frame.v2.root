package com.yzd.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = {"/","/index"})
    public String index() {
        return "home/index";
    }
}

