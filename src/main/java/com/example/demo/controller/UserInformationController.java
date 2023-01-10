package com.example.demo.controller;

import com.example.demo.TokenUtils;
import com.example.demo.modle.UserInfomation;
import com.example.demo.service.UserService;
import com.example.demo.util.KamUtil;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserInformationController {

    private static Logger logger = Logger.getLogger(testController.class);

    @Resource
    private UserService userService;


    //意见反馈
    @ResponseBody
    @RequestMapping(value = "/gettoken.do", produces = "text/html;charset=UTF-8")
    public String getToken(UserInfomation userInfomation) {


        try {

            String a = TokenUtils.token("1111", "2222");

            return KamUtil.returnSuccess(a);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }

    //用户登录
    @RequestMapping(value = "/login.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userLogin(UserInfomation userInfomation) {

        if (StringUtils.isEmpty(userInfomation.getUser_phone())) {
            return KamUtil.returnParamError("手机号不能为空");
        }
        if (StringUtils.isEmpty(userInfomation.getUser_password())) {
            return KamUtil.returnParamError("密码不能为空");
        }
        try {
            int countRegist = userService.countRegister(userInfomation.getUser_phone());
            if (countRegist == 0) {
                return KamUtil.returnParamMsg(412, "此号码未注册，请注册～");
            }
            int flag = userService.userLogin(userInfomation);
            if (flag > 0) {
                Map<String, Object> map = userService.selectuserinfo(userInfomation.getUser_phone());
                String userid = String.valueOf(map.get("user_id"));
                return KamUtil.returnSuccess(map);
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }

    //用户注册
    @ResponseBody
    @RequestMapping(value = "/register.do", produces = "text/html;charset=UTF-8")
    public String userRegister(UserInfomation userInfomation) {
        if (userInfomation.getUser_phone().length() != 11) {
            return KamUtil.returnError("手机号码不合法");
        }
        if (StringUtils.isEmpty(userInfomation.getUser_password())) {
            return KamUtil.returnParamError("密码不能为空");
        }
        try {
            //是否注册过
            int countRegist = userService.countRegister(userInfomation.getUser_phone());
            if (countRegist > 0) {
                return KamUtil.returnParamMsg(400, "当前用户已存在");
            }
            int result = userService.userRegister(userInfomation);
            if (result > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError("注册失败，请稍后～");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }

    //修改昵称
    @ResponseBody
    @RequestMapping(value = "/updatenickname.do", produces = "text/html;charset=UTF-8")
    public String updateNickname(UserInfomation userInfomation) {
        if (StringUtils.isEmpty(userInfomation.getUser_id())) {
            return KamUtil.returnParamError("user_id不能为空");
        }
        try {
            int flag = userService.updateUserNickname(userInfomation);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }

    //意见反馈
    @ResponseBody
    @RequestMapping(value = "/addfeedback.do", produces = "text/html;charset=UTF-8")
    public String addfeedback(UserInfomation userInfomation) {
        if (StringUtils.isEmpty(userInfomation.getUser_id())) {
            return KamUtil.returnParamError("user_id不能为空");
        }
        if (StringUtils.isEmpty(userInfomation.getF_user_phone())) {
            return KamUtil.returnParamError("手机号不能为空");
        }
        if (StringUtils.isEmpty(userInfomation.getF_content())) {
            return KamUtil.returnParamError("反馈内容不能为空");
        }

        try {
            userInfomation.setF_user_id(userInfomation.getUser_id());
            int flag = userService.addfeedback(userInfomation);
            if (flag > 0) {
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }

}
