package com.jl.user_center.controller;

import com.jl.user_center.model.domain.User;
import com.jl.user_center.model.domain.request.UserLoginRequest;
import com.jl.user_center.model.domain.request.UserRegisterRequest;
import com.jl.user_center.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户接口
 * @author JL
 */
// 加了这个注解 返回值类型都是json
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    // @RequestBody使得前端传来的json能对应上
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if (userRegisterRequest == null)
            return null;
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword))
            return null;
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/login")
    // @RequestBody使得前端传来的json能对应上
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
        if (userLoginRequest == null)
            return null;
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();

        if (StringUtils.isAnyBlank(userAccount, userPassword))
            return null;
        return userService.doLogin(userAccount, userPassword, request);
    }

}
