package com.gang.antsso.logic.auth.token;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * @Classname AntVCodeAuthenticationToken
 * @Description TODO
 * @Date 2020/5/2 12:53
 * @Created by zengzg
 */
public class AntVCodeAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal;
    private String credentials;
    private String type;

    public AntVCodeAuthenticationToken(Object principal, String credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        this.type = "common";
        setAuthenticated(false);
    }

    public AntVCodeAuthenticationToken(Object principal, String credentials, String type) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        this.type = StringUtils.isEmpty(type) ? "common" : type;
        setAuthenticated(false);
    }

    public AntVCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = null;
        super.setAuthenticated(true); // must use super, as we override
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param isAuthenticated
     * @throws IllegalArgumentException
     */
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        //        if (isAuthenticated) {
        //            throw new IllegalArgumentException(
        //                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list
        //                    instead");
        //        }

        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
