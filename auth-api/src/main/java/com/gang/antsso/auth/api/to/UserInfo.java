package com.gang.antsso.auth.api.to;


import lombok.Data;

import java.util.List;

/**
 * @Classname UserInfo
 * @Description TODO
 * @Date 2019/11/21 22:25
 * @Created by zengzg
 */
@Data
public class UserInfo {

    protected Boolean checkStatus;
    protected String checkInfo;

    protected String userid;
    protected String username;

    protected String password;
    protected String token;

    protected List<RoleInfo> list;

    public UserInfo() {
    }

    public UserInfo(String userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }
}
