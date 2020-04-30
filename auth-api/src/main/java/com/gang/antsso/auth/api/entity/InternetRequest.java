package com.gang.antsso.auth.api.entity;

import com.gang.antsso.auth.api.type.InternetType;

import java.util.Map;

/**
 * @Classname InternetRequest
 * @Description TODO
 * @Date 2020/4/30 22:25
 * @Created by zengzg
 */
public class InternetRequest {

    private InternetType internetType;

    private String info;

    private Map<String, Object> params;

    public InternetType getInternetType() {
        return internetType;
    }

    public void setInternetType(InternetType internetType) {
        this.internetType = internetType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
