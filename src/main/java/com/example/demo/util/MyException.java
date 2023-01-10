package com.example.demo.util;


public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误编码
     */
    private ResultCodeJoin errorCode;

    private String message;


    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public MyException(ResultCodeJoin errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public MyException(String message) {
        super(message);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode 错误编码
     * @param message   信息描述
     */
    public MyException(ResultCodeJoin errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResultCodeJoin getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ResultCodeJoin errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
