package com.gang.antsso.auth.api.to;

import java.util.Map;

/**
 * @Classname MFARequest
 * @Description TODO
 * @Date 2020/7/27 11:33
 * @Created by zengzg
 */
public class MFARequest {

    private String type;

    private String config;

    private Map<String, String> info;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }
}
