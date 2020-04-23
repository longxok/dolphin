package com.dolphin.spring.security.controller;

import com.dolphin.spring.security.service.IService;
import com.dolphin.spring.security.service.impl.ServiceAB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello controller";
    }

    @Autowired
    private ServiceAB serviceAB;
    // 登录页，跳转到/templates/login.html页面
    @GetMapping("/login")
    public String login() {
        serviceAB.toString();
        return "login";
    }

//    @GetMapping("/service")
//    @ResponseBody
//    public String service() {
//         serviceMap.get("serviceCC").sayHello();
//        return "1";
//    }

    // 首页，跳转到/templates/index.html页面
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
