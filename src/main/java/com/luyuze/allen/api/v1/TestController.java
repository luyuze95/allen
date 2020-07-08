package com.luyuze.allen.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/test")
public class TestController {

    @GetMapping("")
    public Object test() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "hello111");
        return map;
    }
}
