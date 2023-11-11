package cn.service;

import java.sql.Timestamp;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.api.CommonResult;
import cn.entity.User;
import cn.mapper.UserMapper;
import io.micrometer.common.util.StringUtils;

import static cn.api.ResultCode.VALIDATE_FAILED;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public CommonResult login(User user) {

        if (StringUtils.isEmpty(user.getUsername())) {
            return CommonResult.validateFailed("用户名不能为空");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return CommonResult.validateFailed("密码不能为空");
        }
        // 通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_name", user.getUsername());

        List<User> uerList = userMapper.selectOneCustom(user.getUsername());
        if (uerList.isEmpty())
            return CommonResult.failed(VALIDATE_FAILED);

        User uer = uerList.get(0);
        // 比较密码
        // System.out.println(uer.getUsername()+" " +uer.getPassword());
        if (user.getPassword().equals(uer.getPassword())) {
            Date currentTime = new Date();
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(currentTime.getTime());
            userMapper.updateLastLoginTime(user.getUsername(), sqlDate);
            return CommonResult.success(uer.getUsername(), "登录成功");
        }
        return CommonResult.failed(VALIDATE_FAILED);
    }
}
