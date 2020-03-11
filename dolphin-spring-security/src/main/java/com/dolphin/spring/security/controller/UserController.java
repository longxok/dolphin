package com.dolphin.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello controller";
    }

    // 登录页，跳转到/templates/login.html页面
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 首页，跳转到/templates/index.html页面
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
