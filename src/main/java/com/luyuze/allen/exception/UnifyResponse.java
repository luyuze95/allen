package com.luyuze.allen.exception;

import lombok.Data;

/**
 * 全局统一返回格式
 */
@Data
public class UnifyResponse {

    // 自定义内部返回码
    private Integer code;
    // 自定义内部返回说明信息
    private String message;
    // 本次请求的方法和url信息
    private String request;

    public UnifyResponse(Integer code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }
}
