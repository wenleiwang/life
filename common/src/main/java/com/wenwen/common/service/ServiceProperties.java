package com.wenwen.common.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author WangWenLei
 * @DATE: 2020/10/30
 **/
@ConfigurationProperties("hello")
public class ServiceProperties {
    /**
     * A message for the service.
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
