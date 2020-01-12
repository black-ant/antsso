package com.gang.antsso.lib.to;

import lombok.Data;

/**
 * @Classname UserInfo
 * @Description TODO
 * @Date 2019/11/21 22:25
 * @Created by zengzg
 */
@Data
public class UserInfo {

    private String userid;
    private String username;

    private String password;
    private String token;

    public UserInfo() {
    }

    public UserInfo(String userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }
}
