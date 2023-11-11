package cn.service;

import cn.api.CommonResult;
import cn.entity.User;
import cn.mapper.UserMapper;

import static cn.api.ResultCode.ILLEGAL;
import static cn.api.ResultCode.VALIDATE_FAILED;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RegisterService {
    @Autowired
    private UserMapper userMapper;

    public CommonResult register(Map<String, String> registerInfo) {

        String userName = registerInfo.get("userName");
        String email = registerInfo.get("email");
        String password = registerInfo.get("password");
        String verification = registerInfo.get("verification");
        List<User> uerList = userMapper.selectOneCustom(userName);
        if (!uerList.isEmpty()) {
            return CommonResult.failed(ILLEGAL);
        }

        boolean flag = VerificationCode.isCodeValid(verification);
        if (flag) {
            System.out.println("verification success");
            User user = new User();
            user.setUsername(userName);
            user.setEmail(email);
            user.setPassword(password);
            userMapper.insertUser(userName, email, password);
            return CommonResult.success("注册成功");
        }
        return CommonResult.failed(VALIDATE_FAILED);
    }
}
