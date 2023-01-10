package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.modle.UserInfomation;
import com.example.demo.service.UserService;
import com.example.demo.util.KamUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userdao;

    @Override
    public Integer userRegister(UserInfomation userInfomation) {
        userInfomation.setUser_id(KamUtil.get32UUID());
        return userdao.userRegister(userInfomation);
    }

    @Override
    public Map<String, Object> selectuserinfo(String userPhone) {
        return userdao.selectuserinfo(userPhone);
    }

    @Override
    public Integer countRegister(String user_phone) {

        return userdao.countRegister(user_phone);
    }

    @Override
    public Integer userLogin(UserInfomation userInfomation) {
        return userdao.userLogin(userInfomation);
    }

    @Override
    public Integer updateUserNickname(UserInfomation userInfomation) {
        return userdao.updateUserNickname(userInfomation);
    }

    @Override
    public int addfeedback(UserInfomation userInfomation) {
        return userdao.addfeedback(userInfomation);
    }
}

