package com.example.demo.dao;

//import com.wql.xueyiche.entity.UserInfomation;

import com.example.demo.modle.UserInfomation;

import java.util.Map;

public interface UserDao {

    Integer userRegister(UserInfomation userInfomation);

    Map<String, Object> selectuserinfo(String user_phone);

    Integer countRegister(String user_phone);

    Integer userLogin(UserInfomation userInfomation);

    Integer updateUserNickname(UserInfomation userInfomation);

    int addfeedback(UserInfomation userInfomation);

}
