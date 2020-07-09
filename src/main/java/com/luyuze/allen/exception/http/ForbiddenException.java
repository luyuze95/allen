package com.luyuze.allen.exception.http;

/**
 * 403 forbidden 异常
 */
public class ForbiddenException extends HttpException {

    public ForbiddenException(int code) {
        this.httpStatusCode = 403;
        this.code = code;
    }
}
