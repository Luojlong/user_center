package com.jl.user_center.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jl.user_center.model.domain.User;
import com.jl.user_center.model.domain.request.UserLoginRequest;
import com.jl.user_center.model.domain.request.UserRegisterRequest;
import com.jl.user_center.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.jl.user_center.constant.UserConstant.ADMIN_ROLE;
import static com.jl.user_center.constant.UserConstant.USER_LOGIN_STATE;

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

    @GetMapping("/search")
    public List<User> searchUsers(String username, HttpServletRequest request){
        // 仅管理员可查询
        if(!isAdmin(request))
            return new ArrayList<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username))
            queryWrapper.like("username", username);
        List<User> userlist = userService.list(queryWrapper);
        return userlist.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
    }

    @PostMapping("/delete")
    public boolean deleteUser(@RequestBody long id, HttpServletRequest request){
        // 仅管理员可删除
        if(!isAdmin(request))
            return false;
        if (id <= 0)
            return false;
        return userService.removeById(id);
    }

    /**
     * // 仅管理员可操作
     * @param request
     * @return bool
     */
    private boolean isAdmin(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User)userObj;
        if (user == null || user.getUserRole() != ADMIN_ROLE)
            return false;
        return true;
    }
}
