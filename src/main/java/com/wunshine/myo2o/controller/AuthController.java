package com.wunshine.myo2o.controller;

import com.google.code.kaptcha.Constants;
import com.wunshine.myo2o.entity.LocalAuth;
import com.wunshine.myo2o.entity.LogLogin;
import com.wunshine.myo2o.entity.PersonInfo;
import com.wunshine.myo2o.service.AuthService;
import com.wunshine.myo2o.service.LogLoginService;
import com.wunshine.myo2o.service.PersonInfoService;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.util.digester.Digester;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private PersonInfoService personInfoService;
    @Autowired
    private LogLoginService logLoginService;

    @GetMapping("login")
    public String login(LocalAuth auth, Map<String, Object> map, String code, HttpServletRequest request) {
        if (auth.getUserName() == null || auth.getPassword() == null) {
            return "login";
        }
        HttpSession session = request.getSession();
        String realCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (realCode.equalsIgnoreCase(code)) {
            LogLogin logLogin = new LogLogin();
            logLogin.setLoginname(auth.getUserName());
            logLogin.setLogintime(new Date());
            logLogin.setLoginip(request.getRemoteAddr());
            logLoginService.addLoginLog(logLogin);
            return checkPsd(auth, map, session);
        } else {
            map.put("msg", "验证码错误");
            return "login";
        }
    }



    @GetMapping("regist")
    public String regist(LocalAuth localAuth) {
        //插入personinfo
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName(localAuth.getUserName());
        personInfo.setAdminFlag(0);
        personInfoService.insertPersonInfo(personInfo);

        //插入auth
        localAuth.setUserId(personInfo.getUserId());
        //md5加密
        String opassword = localAuth.getPassword();
        byte[] bytes = DigestUtils.md5Digest(opassword.getBytes());
        String npassword = new String(bytes);
        localAuth.setPassword(npassword);
        localAuth.setCreateTime(new Date());
        authService.regist(localAuth);
        return "redirect:login";
    }

    @GetMapping("checkName")
    @ResponseBody
    public String checkName(String userName) {
        LocalAuth localAuth = new LocalAuth();
        localAuth.setUserName(userName);
        LocalAuth login = authService.login(localAuth);
        if (login == null) {
            return "2";
        } else {
            return "1";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("personInfo");
        return "redirect:login";

    }

    private String checkPsd(LocalAuth auth, Map<String, Object> map, HttpSession session) {
        String oldPsd = auth.getPassword();
        byte[] bytes = DigestUtils.md5Digest(oldPsd.getBytes());
        String newPsd = new String(bytes);
        auth.setPassword(newPsd);
        LocalAuth login = authService.login(auth);
        if (login == null) {
            map.put("msg", "用户名或者密码错误");
            return "login";
        } else {
            PersonInfo personInfo = personInfoService.findPersonInfoById(login.getUserId());
            session.setAttribute("personInfo", personInfo);
            return "index";
        }
    }
}
