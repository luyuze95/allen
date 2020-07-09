package com.luyuze.allen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luyuze.allen.mapper")
public class AllenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllenApplication.class, args);
    }

}
