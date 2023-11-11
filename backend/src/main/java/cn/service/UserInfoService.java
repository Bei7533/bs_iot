package cn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.api.CommonResult;
import cn.entity.User;

import static cn.api.ResultCode.ILLEGAL;
import static cn.api.ResultCode.VALIDATE_FAILED;
import cn.mapper.UserMapper;

@Service
public class UserInfoService {
    @Autowired
    private UserMapper userMapper;

    public CommonResult getUserInfo(String userName) {
        // System.out.println("Get info");
        if (userName == null) {
            return CommonResult.failed(VALIDATE_FAILED);
        }
        List<User> uerList = userMapper.selectOneCustom(userName);
        if (uerList.isEmpty())
            return CommonResult.failed(VALIDATE_FAILED);
        User uer = uerList.get(0);
        String time_str = uer.getLastLoginTime().toString();
        time_str = time_str.substring(0, time_str.length() - 2);
        return CommonResult.success(uer, time_str);
    }

    public CommonResult editUserInfo(String request) {
        if (request == null) {
            return CommonResult.failed(VALIDATE_FAILED);
        }

        String userName = request.substring(request.indexOf(":") + 2, request.indexOf(",") - 1);
        String editContent = request.substring(request.indexOf("editContent") + 14, request.indexOf("editIndex") - 3);
        String editIndex = request.substring(request.indexOf("editIndex") + 11, request.indexOf("}"));
        List<User> uerList = userMapper.selectOneCustom(userName);

        if (uerList.isEmpty())
            return CommonResult.failed(VALIDATE_FAILED);
        if (editIndex.equals("1"))
            userMapper.updateEmail(userName, editContent);
        else if (editIndex.equals("2")) {
            // JSONObject jsonInfo = new JSONObject();
            // String _userName = java.net.URLEncoder.encode(userName, "UTF-8");
            // userName = userName.replace("+", "%20");
            // byte byteUser[] = Base64.encodeBase64(userName.getBytes());
            // String String_userName = new String(byteUser);

            userMapper.updateUserDescript(userName, editContent);
        } else if (editIndex.equals("0")) {
            if (!userMapper.selectOneCustom(editContent).isEmpty())
                return CommonResult.failed(ILLEGAL);
            userMapper.updateUsername(userName, editContent);
            // userMapper.deleteUser(userName);
        } else if (editIndex.equals("5")) {
            userMapper.updatePassword(userName, editContent);
        } else
            return CommonResult.failed(VALIDATE_FAILED);
        return CommonResult.success("修改成功");
    }
}
