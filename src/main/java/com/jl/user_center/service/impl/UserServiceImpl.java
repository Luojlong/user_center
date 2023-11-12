package com.jl.user_center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jl.user_center.model.domain.User;
import com.jl.user_center.service.UserService;
import com.jl.user_center.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author 99367
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2023-11-10 16:54:16
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
    // 校验
        // 判断为空
        if (StringUtils.isAllBlank(userAccount, userPassword, checkPassword))
            return -1;
        if (userAccount.length() < 4)
            return -1;
        if (checkPassword.length() < 8 || userPassword.length() < 8)
            return -1;

        // 账户不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (!matcher.find())
            return -1;
        if (!userPassword.equals(checkPassword))
            return -1;

        // 账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = this.count(queryWrapper);
        if (count > 0)
            return -1;

    //加密
        final String SALT = "JLkuaishixi";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean saveResult = this.save(user);
        if (!saveResult)
            return -1;

        return user.getId();
    }
}




