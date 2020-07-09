package com.luyuze.allen.exception.http;

/**
 * 401 Unauthorized 异常
 */
public class UnauthorizedException extends HttpException {

    public UnauthorizedException(int code) {
        this.httpStatusCode = 401;
        this.code = code;
    }
}
