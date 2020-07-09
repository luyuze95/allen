package com.luyuze.allen.api.v1;

import com.luyuze.allen.dto.UserRegisterDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @PostMapping("/list")
    public Object test(
            @RequestBody @Validated UserRegisterDTO userRegisterDTO
            ) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "hello");
        return map;
    }

}
