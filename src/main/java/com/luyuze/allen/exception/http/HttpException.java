package com.luyuze.allen.exception.http;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpException extends RuntimeException {

    // 自定义的返回码
    protected Integer code;

    // http返回的状态码
    protected Integer httpStatusCode = 500;
}
