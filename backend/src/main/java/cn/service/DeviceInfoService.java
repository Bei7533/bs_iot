package cn.service;

import cn.api.CommonResult;
import cn.api.CommonResult;
import cn.entity.Device;
import cn.mapper.DeviceMapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DeviceInfoService {

    @Autowired
    private DeviceMapper deviceMapper;

    public CommonResult deviceInfo(String username) {
        List<Device> deviceList = deviceMapper.selectDevicesByUsername(username);
        int deviceNum = deviceList.size();
        String deviceListStr = "";
        if (deviceNum > 0) {
            deviceListStr = deviceList.toString();
            System.out.println(deviceListStr);
        }
        String response = "{\"deviceNum\":" + deviceNum + ",\"deviceList\":" + deviceListStr + "}";
        return CommonResult.success(response);
    }
}
