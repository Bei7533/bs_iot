package cn.controller;

import cn.api.CommonResult;
import cn.entity.IOTMessage;
import cn.service.DeviceInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceInfoController {
    @Autowired
    DeviceInfoService deviceInfoService;

    @PostMapping(value = "/admin/deviceinfo")
    @CrossOrigin // 后端跨域
    public CommonResult deviceInfo(@RequestBody String username) {
//        System.out.println("deviceinfo");
        return deviceInfoService.deviceInfo(username);
    }
}
