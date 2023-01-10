package com.example.demo.service;

import com.example.demo.modle.UserInfomation;
//import com.wql.xueyiche.entity.UserInfomation;

import java.util.Map;

public interface UserService {
    Integer userRegister(UserInfomation userInfomation);

    Map<String, Object> selectuserinfo(String user_phone);

    Integer countRegister(String user_phone);

    Integer userLogin(UserInfomation userInfomation);

    Integer updateUserNickname(UserInfomation userInfomation);

    int addfeedback(UserInfomation userInfomation);
}
