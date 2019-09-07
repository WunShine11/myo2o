package com.wunshine.myo2o.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("direct")
public class DirectController {

    @RequestMapping("login.html")
    public String login() {
        return "login";
    }

    @GetMapping("login")
    public String login(String userName,String password) {
        System.out.println(userName+password);
        return "index";
    }

    @RequestMapping("regist.html")
    public String Regist() {
        return "regist";
    }

    @RequestMapping("main.html")
    public String main() {
        return "common/main";
    }
    @RequestMapping("userInfo.html")
    public String userInfo() {
        return "user/userInfo";
    }


}
