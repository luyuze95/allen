package com.luyuze.allen.dto;

import com.luyuze.allen.validators.PasswordEqual;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@PasswordEqual
public class UserRegisterDTO {

    @Length(min = 6, max = 20)
    private String username;

    @Length(min = 6, max = 20)
    private String password;

    @Length(min = 6, max = 20)
    private String confirmPassword;

    // 级联的dto对象加上@Valid注解标识
}
