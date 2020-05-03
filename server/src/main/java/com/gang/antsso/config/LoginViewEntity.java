package com.gang.antsso.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Classname LoginEntity
 * @Description TODO
 * @Date 2020/5/3 17:24
 * @Created by zengzg
 */
@Configuration
@ConfigurationProperties(prefix = "ant.sso.view")
@Component
public class LoginViewEntity {

    private Map<String, String> viewMap;

    public Map<String, String> getViewMap() {
        return viewMap;
    }

    public void setViewMap(Map<String, String> viewMap) {
        this.viewMap = viewMap;
    }
}
