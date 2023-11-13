package com.jl.user_center.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户组册请求体
 * @author JL
 */
// 生成getter setter方法
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
