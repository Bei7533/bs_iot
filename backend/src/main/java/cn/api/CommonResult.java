package cn.api;

import java.util.ArrayList;

import org.hibernate.mapping.List;

import cn.entity.Device;
import cn.entity.User;

public class CommonResult {
    private long code;
    private String message;
    private String data;
    private User user;
    private Device device;
    private ArrayList<String> stringList;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 登录成功
    public static CommonResult success(String data) {
        return new CommonResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static CommonResult success(String data, String message) {
        return new CommonResult(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static CommonResult success(User user, String time_str) {
        CommonResult res = new CommonResult();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMessage(time_str);
        res.setUserInfo(user);
        return res;
    }

    public static CommonResult success(Device device) {
        CommonResult res = new CommonResult();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setDeviceInfo(device);
        return res;
    }

    public static CommonResult success(ArrayList<String> deviceList, String device_num) {
        CommonResult res = new CommonResult();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMessage(device_num);
        res.setStringList(deviceList);
        return res;
    }

    public static CommonResult success(ArrayList<String> messageList, String device_num, String online) {
        CommonResult res = new CommonResult();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMessage(device_num);
        res.setData(online);
        res.setStringList(messageList);
        return res;
    }
    // 登录失败
    public static CommonResult failed(IErrorCode errorCode) {
        return new CommonResult(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static CommonResult failed(String message) {
        return new CommonResult(ResultCode.FAILED.getCode(), message, null);
    }

    public static CommonResult failed() {
        return failed(ResultCode.FAILED);
    }

    // 参数验证失败返回结果
    public static CommonResult validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    public static CommonResult validateFailed(String message) {
        return new CommonResult(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    // 未登录返回结果
    public static CommonResult unauthorized(String data) {
        return new CommonResult(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    // 未授权返回结果
    public static CommonResult illegalemail(String data) {
        return new CommonResult(ResultCode.ILLEGAL.getCode(), ResultCode.ILLEGAL.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public User getUserInfo() {
        return user;
    }

    public void setUserInfo(User user) {
        this.user = user;
    }

    public Device getDeviceInfo() {
        return device;
    }

    public void setDeviceInfo(Device device) {
        this.device = device;
    }

    public ArrayList<String> getStringList() {
        return stringList;
    }

    public void setStringList(ArrayList<String> deviceList) {
        this.stringList = deviceList;
    }
}
