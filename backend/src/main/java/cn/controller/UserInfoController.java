package cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.api.CommonResult;
import cn.entity.User;
import cn.mapper.UserMapper;
import cn.service.UserInfoService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserInfoController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoService UserInfoService;

    @PostMapping(value = "/admin/userinfo", produces = { "text/html;charset=UTF-8;", "application/json;" })
    public CommonResult getUserInfo(@RequestBody String username) {
        username = username.substring(username.indexOf(":") + 2, username.length() - 2);
        return UserInfoService.getUserInfo(username);
    }

    @PostMapping(value = "/admin/userinfoedit")
    public CommonResult editUserInfo(@RequestBody String request) {
        return UserInfoService.editUserInfo(request);
    }
}
