package com.gang.antsso.auth.api.to;

import com.gang.antsso.auth.api.type.InternetType;

import java.util.Map;

/**
 * @Classname InternetRequestTO
 * @Description TODO
 * @Date 2020/5/1 13:39
 * @Created by zengzg
 */
public class InternetRequestTO {

    private InternetType type;

    private OAuthExtSettingTO oAuthExtSettingTO;

    private String info;

    private Map<String, Object> params;

    public InternetType getType() {
        return type;
    }

    public void setType(InternetType type) {
        this.type = type;
    }

    public OAuthExtSettingTO getoAuthExtSettingTO() {
        return oAuthExtSettingTO;
    }

    public String backSettingBody() {
        return oAuthExtSettingTO == null ? "" : getoAuthExtSettingTO().getSettingBody();
    }

    public void setoAuthExtSettingTO(OAuthExtSettingTO oAuthExtSettingTO) {
        this.oAuthExtSettingTO = oAuthExtSettingTO;
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
