package cn.controller;

import cn.api.CommonResult;
import cn.entity.User;
import cn.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/admin/login")
    @CrossOrigin // 后端跨域
    public CommonResult login(@RequestBody User user) {
        return loginService.login(user);
    }
}
