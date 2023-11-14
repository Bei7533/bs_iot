package cn.controller;

import cn.api.CommonResult;
import cn.entity.IOTMessage;
import cn.service.DeviceInfoService;
import cn.service.MessageService;
import jakarta.mail.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceInfoController {
    @Autowired
    DeviceInfoService deviceInfoService;

    @Autowired
    MessageService messageService;

    @PostMapping(value = "/admin/deviceinfo")
    @CrossOrigin // 后端跨域
    public CommonResult deviceInfo(@RequestBody String username) {
        // System.out.println("deviceinfo");
        username = username.substring(username.indexOf(":") + 2, username.length() - 2);
        return deviceInfoService.deviceInfo(username);
    }

    @PostMapping(value = "/admin/deviceinfoedit")
    @CrossOrigin // 后端跨域
    public CommonResult deviceInfoEdit(@RequestBody String request) {
        return deviceInfoService.deviceInfoEdit(request);
    }

    @PostMapping(value = "/admin/deviceinfoadd")
    @CrossOrigin // 后端跨域
    public CommonResult deviceInfoAdd(@RequestBody String request) {
        return deviceInfoService.deviceInfoAdd(request);
    }

    @PostMapping(value = "/admin/deviceinfodelete")
    @CrossOrigin // 后端跨域
    public CommonResult deviceInfoDelete(@RequestBody String request) {
        return deviceInfoService.deviceInfoDelete(request);
    }

    @PostMapping(value = "/admin/devicemessage")
    @CrossOrigin // 后端跨域
    public CommonResult deviceMessage(@RequestBody String request) {
        return messageService.deviceMessage(request);
    }
}
