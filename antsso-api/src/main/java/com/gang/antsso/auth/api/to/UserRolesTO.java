package com.gang.antsso.auth.api.to;

import lombok.Data;

/**
 * @Classname UserRolesTO
 * @Description TODO
 * @Date 2020/1/12 18:06
 * @Created by zengzg
 */
@Data
public class UserRolesTO {

    private String id;

    private String name;

    public UserRolesTO() {
    }

    public UserRolesTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
