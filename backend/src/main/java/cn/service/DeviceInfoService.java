package cn.service;

import cn.api.CommonResult;
import cn.api.CommonResult;
import cn.entity.Device;
import cn.mapper.DeviceMapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DeviceInfoService {

    @Autowired
    private DeviceMapper deviceMapper;

    public CommonResult deviceInfo(String username) {
        ArrayList<Device> deviceList = deviceMapper.selectDevicesByUsername(username);
        Integer deviceNum = deviceList.size();
        ArrayList<String> deviceStrList = new ArrayList<String>();
        for (Device device : deviceList) {
            deviceStrList.add(device.toString());
        }
        return CommonResult.success(deviceStrList, deviceNum.toString());
    }

    public CommonResult deviceInfoEdit(String request) {
        System.out.println(request);
        String[] requestList = request.split(",");
        int device_id = Integer
                .parseInt(requestList[0].substring(requestList[0].indexOf(":") + 2, requestList[0].length() - 1));
        String device_name = requestList[1].substring(requestList[1].indexOf(":") + 2, requestList[1].length() - 1);
        String device_type = requestList[2].substring(requestList[2].indexOf(":") + 2, requestList[2].length() - 1);
        String device_disc = requestList[3].substring(requestList[3].indexOf(":") + 2, requestList[3].length() - 2);
        // System.out.println(device_id);
        // System.out.println(device_name);
        // System.out.println(device_type);
        // System.out.println(device_disc);
        deviceMapper.updateDeviceName(device_id, device_name);
        deviceMapper.updateDeviceType(device_id, device_type);
        deviceMapper.updateDeviceDisc(device_id, device_disc);
        return CommonResult.success("success");
    }

    public CommonResult deviceInfoAdd(String request) {
        System.out.println(request);
        String[] requestList = request.split(",");
        // {"username":"beiiii","device_name":"1111","device_type":"mobile_phone","device_discript":"22222"}
        String username = requestList[0].substring(requestList[0].indexOf(":") + 2, requestList[0].length() - 1);
        String device_name = requestList[1].substring(requestList[1].indexOf(":") + 2, requestList[1].length() - 1);
        String device_type = requestList[2].substring(requestList[2].indexOf(":") + 2, requestList[2].length() - 1);
        String device_disc = requestList[3].substring(requestList[3].indexOf(":") + 2, requestList[3].length() - 2);
        System.out.println(username);
        System.out.println(device_name);
        System.out.println(device_type);
        System.out.println(device_disc);
        deviceMapper.insertDevice(device_name, device_type, device_disc, username);
        ArrayList<Device> deviceList = deviceMapper.selectDevicesByUsername(username);
        Device new_device = deviceList.get(deviceList.size() - 1);
        Integer device_id = new_device.getDevice_id();
        System.out.println(device_id);
        return CommonResult.success(device_id.toString());
    }

    public CommonResult deviceInfoDelete(String request) {
        int device_id = Integer
                .parseInt(request.substring(request.indexOf(":") + 2, request.length()-2));
        deviceMapper.deleteDevice(device_id);
        return CommonResult.success("success");
    }
}
