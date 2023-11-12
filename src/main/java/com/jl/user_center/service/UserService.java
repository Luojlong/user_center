package com.jl.user_center.service;

import com.jl.user_center.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 99367
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-11-10 16:54:16
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);
}
