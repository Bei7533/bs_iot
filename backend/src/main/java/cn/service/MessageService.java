package cn.service;

import cn.mapper.DeviceMapper;
import cn.mapper.IOTMessageMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.TreeMap;

import org.hibernate.mapping.List;
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
        String online = "false";
        IOTMessage latestMessage = messageList.get(messageList.size() - 1);
        // 获取最新消息的log_time
        String logTimeString = latestMessage.getTimestamp().toString();
        // 将log_time转换为Date对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date logTime = dateFormat.parse(logTimeString);
            // 获取当前时间
            Date currentTime = new Date();
            // 计算时间差，单位为毫秒
            long timeDifference = currentTime.getTime() - logTime.getTime();
            // 判断时间差是否在两分钟以内
            if (timeDifference <= 2 * 60 * 1000) {
                online = "true";
                // System.out.println("设备在线");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<String> messageStrList = new ArrayList<String>();
        for (IOTMessage message : messageList) {
            messageStrList.add(message.toString());
        }
        return CommonResult.success(messageStrList, Integer.toString(messageNum), online);
    }

    private int timeDifference(LocalDateTime start) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime tomorrow = currentTime.plusDays(1);
        tomorrow = tomorrow.withHour(0);
        tomorrow = tomorrow.withMinute(0);
        tomorrow = tomorrow.withSecond(0);

        long timeDifference = Duration.between(start, tomorrow).toDaysPart();
        return (int) timeDifference;
    }

    public CommonResult dateMessage(String username) {
        ArrayList<Device> deviceList = deviceMapper.selectDevicesByUsername(username);
        Integer deviceNum = deviceList.size();
        ArrayList<IOTMessage> messageList = new ArrayList<IOTMessage>();
        for (Device d : deviceList) {
            messageList.addAll(iotMessageMapper.selectMessageByDeviceId(d.getDevice_id()));
        }
        Collections.sort(messageList);
        int weekEnd = messageList.size() - 1;
        TreeMap<String, Integer> dateMessageMap = new TreeMap<String, Integer>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        String today = currentTime.format(dateFormat);
        today = today.substring(0, today.indexOf(" "));
        for (IOTMessage m : messageList) {
            // 获取log_time
            String logTimeString = m.getTimestamp().toString();
            // 将log_time转换为Date对象
            try {
                LocalDateTime logTime = m.getTimestamp().toLocalDateTime();
                int timeDifference = timeDifference(logTime);
//                System.out.println(timeDifference);
                if (timeDifference >= 7) {
                    weekEnd = messageList.indexOf(m);
                    break;
                }
                String date = logTimeString.substring(0, logTimeString.indexOf(" "));
                if (dateMessageMap.containsKey(date)) {
                    dateMessageMap.put(date, dateMessageMap.get(date) + 1);
                } else {
                    dateMessageMap.put(date, 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ArrayList<String> messageStrList = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            String date = currentTime.minusDays(i).format(dateFormat);
            date = date.substring(0, date.indexOf(" "));
            if (!dateMessageMap.containsKey(date)) {
                dateMessageMap.put(date, 0);
            }
        }

        for (String date : dateMessageMap.keySet()) {
            messageStrList.add(date + ":" + dateMessageMap.get(date));
//            System.out.println(date + ":" + dateMessageMap.get(date));
        }
        return CommonResult.success(messageStrList, "7");
    }

}
