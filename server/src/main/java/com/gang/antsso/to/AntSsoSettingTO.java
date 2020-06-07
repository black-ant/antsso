package com.gang.antsso.to;

/**
 * @Classname AntSsoSettingTO
 * @Description TODO
 * @Date 2020/6/7 15:50
 * @Created by zengzg
 */
public class AntSsoSettingTO {

    private String filter;
    private String provider;
    private String token;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
