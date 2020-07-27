package com.gang.antsso.auth.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Classname AlgorithmType
 * @Description TODO
 * @Date 2020/5/31 17:30
 * @Created by zengzg
 */
@Configuration
@ConfigurationProperties(prefix = "ant.sso")
@Component
public class AntSSOConfiguration {

    private String key;


    private AlgorithmConfig algorithmConfig;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public AlgorithmConfig getAlgorithmConfig() {
        return algorithmConfig;
    }

    public void setAlgorithmConfig(AlgorithmConfig algorithmConfig) {
        this.algorithmConfig = algorithmConfig;
    }
}
