package com.luyuze.allen.api.v1;

import com.luyuze.allen.exception.http.UnauthorizedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unauthorized")
public class UnauthorizedController {

    @RequestMapping("")
    public Object unauthorized() {
        throw new UnauthorizedException(10004);
    }
}
