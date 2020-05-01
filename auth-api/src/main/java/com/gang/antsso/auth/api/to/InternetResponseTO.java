package com.gang.antsso.auth.api.to;

import com.gang.antsso.auth.api.to.UserInfo;

import java.util.Map;

/**
 * @Classname InternetResponseTO
 * @Description TODO
 * @Date 2020/4/30 22:25
 * @Created by zengzg
 */
public class InternetResponseTO {

    private Boolean status;

    private UserInfo userInfo;

    private Map<String, String> extMap;

    private String responseMsg;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
