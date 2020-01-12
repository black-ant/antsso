package com.gang.antsso.lib.to;

import lombok.Data;

/**
 * @Classname UserRoles
 * @Description TODO
 * @Date 2020/1/12 18:06
 * @Created by zengzg
 */
@Data
public class UserRoles {

    private String id;

    private String name;

    public UserRoles() {
    }

    public UserRoles(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
