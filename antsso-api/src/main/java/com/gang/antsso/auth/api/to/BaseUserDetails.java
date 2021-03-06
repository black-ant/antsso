package com.gang.antsso.auth.api.to;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname OAuthUserDetailsTO
 * @Description TODO
 * @Date 2020/1/12 17:53
 * @Created by zengzg
 */
@Data
public class BaseUserDetails extends AbstractUserDetails<GrantedAuthority> implements UserDetails {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseUserDetails() {
    }

    public BaseUserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BaseUserDetails(UserInfo userInfo, List<GrantedAuthority> authRoles) {
        this.username = userInfo.getUsername();
        this.password = userInfo.getPassword();
        this.rolesList = changeRoles(authRoles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public List<UserRolesTO> changeRoles(List<GrantedAuthority> authRoles) {
        logger.info("------> rhis is in roles change <-------");
        List<UserRolesTO> list = new LinkedList<>();
        authRoles.stream().forEach(item -> {
            UserRolesTO userRolesTO = new UserRolesTO("1", item.getAuthority());
            list.add(userRolesTO);
        });

        return list;
    }

}
