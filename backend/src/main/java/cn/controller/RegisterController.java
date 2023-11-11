package cn.controller;

import cn.api.CommonResult;
import cn.entity.User;
import cn.mapper.UserMapper;
import cn.service.RegisterService;
import cn.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    SendMailService sendMailService;

    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/admin/register")
    public CommonResult register(@RequestBody Map<String, String> registerInfo) {
        System.out.println("Controller");
        return registerService.register(registerInfo);
    }

    @RequestMapping("/send")
    public CommonResult sendMail(@RequestBody String email) {
        email = email.substring(email.indexOf(":") + 2, email.length() - 2);
        return sendMailService.sendMail(email);
    }

}
