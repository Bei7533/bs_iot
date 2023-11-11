package cn.service;

import cn.api.CommonResult;
import cn.entity.User;

public interface LoginService {
    public CommonResult login(User user);
}
