package com.gang.antsso.auth.api.to;

import java.util.Map;

/**
 * @Classname MFAResponse
 * @Description TODO
 * @Date 2020/7/27 11:33
 * @Created by zengzg
 */
public class MFAResponse {

    private Boolean status;

    private Map<String, String> info;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }
}
