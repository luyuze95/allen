package com.luyuze.allen.api.v1;

import com.luyuze.allen.dto.LoginDTO;
import com.luyuze.allen.entity.User;
import com.luyuze.allen.exception.http.UnauthorizedException;
import com.luyuze.allen.service.UserService;
import com.luyuze.allen.utils.EncryptUtil;
import com.luyuze.allen.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("token")
@Validated
public class TokenController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public Object getToken(
            @RequestBody @Validated LoginDTO loginDTO
            ) {
        User user = userService.getUser(loginDTO.getUsername());
        if (user == null) {
            return new UnauthorizedException(10003);
        }
        if (!EncryptUtil.checkPasswordHash(loginDTO.getPassword(), user.getPassword())) {
            return new UnauthorizedException(10003);
        }
        Map<String, String> map = new HashMap<>();
        map.put("token", JWTUtil.sign(user.getUsername(), user.getPassword()));
        return map;
    }
}
