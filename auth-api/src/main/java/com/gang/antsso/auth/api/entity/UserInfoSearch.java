package com.gang.antsso.auth.api.entity;

import com.gang.antsso.auth.api.type.AntAuthType;
import lombok.Data;

/**
 * @Classname UserInfoSearch
 * @Description TODO
 * @Date 2020/1/26 21:10
 * @Created by zengzg
 */
@Data
public class UserInfoSearch<T> {

    // 唯一键
    private T searchInfo;

    private String authType;


    public UserInfoSearch() {
    }

    public UserInfoSearch(T searchInfo) {
        this.searchInfo = searchInfo;
    }

    public UserInfoSearch setType(AntAuthType antAuthType) {
        this.authType = antAuthType.getCode();
        return this;
    }

    public UserInfoSearch setType(String antAuthType) {
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
}
