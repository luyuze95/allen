package com.luyuze.allen.exception.http;

/**
 * 404 notfound 异常
 */
public class NotFoundException extends HttpException {

    public NotFoundException(int code) {
        this.httpStatusCode = 404;
        this.code = code;
    }
}
