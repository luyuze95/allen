package com.luyuze.allen.exception.http;

/**
 * 500 interval server error 异常
 */
public class ServerErrorException extends HttpException {

    public ServerErrorException(int code){
        this.httpStatusCode = 500;
        this.code = code;
    }
}
