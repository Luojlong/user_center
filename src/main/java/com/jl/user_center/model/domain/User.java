package com.jl.user_center.model.domain;


import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
* 用户
* @TableName user
*/
@TableName(value = "user")
@Data
public class User implements Serializable {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 
    */

    private String username;
    /**
    * 
    */

    private String userAccount;
    /**
    * 用户头像
    */

    private String avatarUrl;
    /**
    * 
    */

    private Integer gender;
    /**
    * 
    */

    private String userPassword;
    /**
    * 
    */

    private String phone;
    /**
    * 
    */

    private String email;
    /**
    * 0 -- 正常
    */

    private Integer userStatus;
    /**
    * 
    */

    private Date createTime;
    /**
    * 
    */

    private Date updateTime;

    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
//    private void setId(Long id){
//    this.id = id;
//    }
//
//    /**
//    *
//    */
//    private void setUsername(String username){
//    this.username = username;
//    }
//
//    /**
//    *
//    */
//    private void setUserAccount(String userAccount){
//    this.userAccount = userAccount;
//    }
//
//    /**
//    * 用户头像
//    */
//    private void setAvatarUrl(String avatarUrl){
//    this.avatarUrl = avatarUrl;
//    }
//
//    /**
//    *
//    */
//    private void setGender(Integer gender){
//    this.gender = gender;
//    }
//
//    /**
//    *
//    */
//    private void setUserPassword(String userPassword){
//    this.userPassword = userPassword;
//    }
//
//    /**
//    *
//    */
//    private void setPhone(String phone){
//    this.phone = phone;
//    }
//
//    /**
//    *
//    */
//    private void setEmail(String email){
//    this.email = email;
//    }
//
//    /**
//    * 0 -- 正常
//    */
//    private void setUserStatus(Integer userStatus){
//    this.userStatus = userStatus;
//    }
//
//    /**
//    *
//    */
//    private void setCreateTime(Date createTime){
//    this.createTime = createTime;
//    }
//
//    /**
//    *
//    */
//    private void setUpdateTime(Date updateTime){
//    this.updateTime = updateTime;
//    }
//
//    /**
//    *
//    */
//    private void setIsDelete(Integer isDelete){
//    this.isDelete = isDelete;
//    }
//
//
//    /**
//    *
//    */
//    private Long getId(){
//    return this.id;
//    }
//
//    /**
//    *
//    */
//    private String getUsername(){
//    return this.username;
//    }
//
//    /**
//    *
//    */
//    private String getUserAccount(){
//    return this.userAccount;
//    }
//
//    /**
//    * 用户头像
//    */
//    private String getAvatarUrl(){
//    return this.avatarUrl;
//    }
//
//    /**
//    *
//    */
//    private Integer getGender(){
//    return this.gender;
//    }
//
//    /**
//    *
//    */
//    private String getUserPassword(){
//    return this.userPassword;
//    }
//
//    /**
//    *
//    */
//    private String getPhone(){
//    return this.phone;
//    }
//
//    /**
//    *
//    */
//    private String getEmail(){
//    return this.email;
//    }
//
//    /**
//    * 0 -- 正常
//    */
//    private Integer getUserStatus(){
//    return this.userStatus;
//    }
//
//    /**
//    *
//    */
//    private Date getCreateTime(){
//    return this.createTime;
//    }
//
//    /**
//    *
//    */
//    private Date getUpdateTime(){
//    return this.updateTime;
//    }
//
//    /**
//    *
//    */
//    private Integer getIsDelete(){
//    return this.isDelete;
//    }

}
