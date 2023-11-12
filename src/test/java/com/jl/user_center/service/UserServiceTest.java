package com.jl.user_center.service;
import java.util.Date;

import com.jl.user_center.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser(){
        User user = new User();
        user.setUsername("ljl");
        user.setUserAccount("314");
        user.setAvatarUrl("https://ts2.cn.mm.bing.net/th?id=ORMS.2b4627c163aea4ee1e5f715a1741cd23&pid=Wdp&w=300&h=156&qlt=90&c=1&rs=1&dpr=1.25&p=0");
        user.setGender(0);
        user.setUserPassword("sjkdhk");
        user.setPhone("dfasf");
        user.setEmail("dsfaf");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);

    }

    @Test
    void userRegister() {
        String userAccount = "sds";
        String userPassword = "123456";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount,userPassword,checkPassword);
        Assertions.assertEquals(-1, result);
    }
}