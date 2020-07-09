package com.luyuze.allen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 读取exception-code.properties配置文件中的lu.codes前缀的配置，并存入一个map中
 */
@ConfigurationProperties(prefix = "lu")
@PropertySource(value = "classpath:config/exception-code.properties")
@Component
public class ExceptionCodeConfiguration {

    private Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }

    /**
     * 根据code获取map中的code对应的错误信息
     * @param code
     * @return
     */
    public String getMessage(int code) {
        return codes.get(code);
    }
}
