package cn.service;

import cn.mapper.DeviceMapper;
import cn.mapper.IOTMessageMapper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.entity.IOTMessage;
import cn.api.CommonResult;
import cn.entity.Device;

@Service
public class MessageService {

    @Autowired
    private IOTMessageMapper iotMessageMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    public CommonResult deviceMessage(String request) {
        int device_id = Integer.parseInt(request.substring(request.indexOf(":") + 2,
                request.length() - 2));

        ArrayList<IOTMessage> messageList = iotMessageMapper.selectMessageByDeviceId(device_id);
        int messageNum = messageList.size();
        if (messageNum == 0) {
            return CommonResult.failed("no message");
        }
        ArrayList<String> messageStrList = new ArrayList<String>();
        for (IOTMessage message : messageList) {
            messageStrList.add(message.toString());
        }
        return CommonResult.success(messageStrList, Integer.toString(messageNum));
    }
}
