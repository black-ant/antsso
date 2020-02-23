package com.gang.antsso.logic;

import org.checkerframework.checker.units.qual.C;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Classname UserRolesLogic
 * @Description TODO
 * @Date 2020/2/23 14:45
 * @Created by zengzg
 */
@Component
public class UserRolesLogic {

    /**
     * 通过主键查询角色
     *
     * @param key
     * @return
     */
    public ArrayList<GrantedAuthority> getUserRoles(String key) {
        ArrayList<GrantedAuthority> authRoles = new ArrayList<GrantedAuthority>();
        authRoles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authRoles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authRoles;
    }

    /**
     * 通过类型查询角色
     *
     * @return
     */
    public ArrayList<GrantedAuthority> getUserRolesByType() {
        ArrayList<GrantedAuthority> authRoles = new ArrayList<GrantedAuthority>();
        authRoles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authRoles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authRoles;
    }
}
