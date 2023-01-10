package com.example.demo.util;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCodeJoin {
    /**
     * 成功
     **/
    SUCCESS(0),
    /**
     * 账号密码错误
     **/
    PASSWORD_ERROR(100),
    /**
     * IP地址不符
     **/
    IP_MIS_MATCHING(101),
    /**
     * IP获取异常
     **/
    IP_ERROR(199),
    /**
     * 厂家ID不存在
     **/
    FACTORY_ID_ERROR(102),
    /**
     * 必填信息不完整
     **/
    REQUIRED_LOCK(200),
    /**
     * 数据格式错误
     **/
    FORMAT_ERROR(201),
    /**
     * JSON协议错误
     **/
    JOSN_ERROR(300),
    /**
     * 请求URL错误
     **/
    URL_ERROR(404),
    /**
     * 接口内部错误（请联系技术支撑）
     **/
    INSIDE_ERROR(500),
    /**
     * 接口服务繁忙，稍后重试
     **/
    PORT_BUSY(600),
    /**
     * 未知错误（请联系技术支撑）
     **/
    UNKNOWN_ERROR(999);

    private final int status;


    private ResultCodeJoin(int status) {
        this.status = status;
    }

    public int getValue() {
        return status;
    }
}
