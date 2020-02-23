package com.gang.antsso.auth.api.entity;

import lombok.Data;

/**
 * @Classname UserInfoSearch
 * @Description TODO
 * @Date 2020/1/26 21:10
 * @Created by zengzg
 */
@Data
public class UserInfoSearch {

    // 唯一键
    private String primaryKey;

    // 唯一 Code
    private String userCode;

    // OpenId
    private String openId;

    // Logic Class
    private String logicClass;

    // Seach Info
    private SearchItem searchItem;

    public UserInfoSearch() {
    }

    public UserInfoSearch(String primaryKey) {
        this.primaryKey = primaryKey;
    }
}
