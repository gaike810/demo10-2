package com.example.demo.modle;


import lombok.Data;

@Data
public class UserToken {

    private String token; //请求时携带的token
    private String userId; //用户ID
    private UserToken user;//登录信息

}
