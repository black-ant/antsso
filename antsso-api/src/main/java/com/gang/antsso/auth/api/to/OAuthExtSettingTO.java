package com.gang.antsso.auth.api.to;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname OAuthExtSettingTO
 * @Description TODO
 * @Date 2020/5/1 22:41
 * @Created by zengzg
 */

public class OAuthExtSettingTO {


    private String settingType;

    private String settingBody;

    private Map<String, String> extMap;


    /**
     * @param settingType
     * @param settingBody
     * @return
     */
    public static OAuthExtSettingTO getInstance(String settingType, String settingBody) {
        OAuthExtSettingTO oAuthExtSettingTO = new OAuthExtSettingTO();
        oAuthExtSettingTO.setSettingBody(settingBody);
        oAuthExtSettingTO.setSettingType(settingType);
        return oAuthExtSettingTO;
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public OAuthExtSettingTO addExtMap(String key, String value) {
        extMap = extMap == null ? new HashMap<>() : extMap;
        extMap.put(key, value);
        return this;
    }


    public String getSettingType() {
        return settingType;
    }

    public void setSettingType(String settingType) {
        this.settingType = settingType;
    }

    public String getSettingBody() {
        return settingBody;
    }

    public void setSettingBody(String settingBody) {
        this.settingBody = settingBody;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }
}
