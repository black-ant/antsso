package com.gang.antsso.auth.api.to;

import com.gang.antsso.auth.api.type.AntAuthType;
import lombok.Data;

/**
 * @Classname UserInfoSearchTO
 * @Description TODO
 * @Date 2020/1/26 21:10
 * @Created by zengzg
 */
@Data
public class UserInfoSearchTO<T> {

    // 唯一键
    private T searchInfo;

    private String authType;

    private OAuthExtSettingTO oAuthExtSettingTO;

    private UserCheckInfoTO userCheckInfoTO;

    public UserInfoSearchTO() {
    }

    public UserInfoSearchTO(T searchInfo) {
        this.searchInfo = searchInfo;
    }

    public UserInfoSearchTO addCheckInfo(String saltCode, String cipherCode) {
        UserCheckInfoTO checkInfoTO = new UserCheckInfoTO(saltCode, cipherCode);
        this.setUserCheckInfoTO(checkInfoTO);
        return this;
    }

    public UserInfoSearchTO setType(AntAuthType antAuthType) {
        this.authType = antAuthType.getCode();
        return this;
    }

    public UserInfoSearchTO setType(String antAuthType) {
        this.authType = antAuthType;
        return this;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public T getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(T searchInfo) {
        this.searchInfo = searchInfo;
    }

    public OAuthExtSettingTO getoAuthExtSettingTO() {
        return oAuthExtSettingTO;
    }

    public void setoAuthExtSettingTO(OAuthExtSettingTO oAuthExtSettingTO) {
        this.oAuthExtSettingTO = oAuthExtSettingTO;
    }
}
