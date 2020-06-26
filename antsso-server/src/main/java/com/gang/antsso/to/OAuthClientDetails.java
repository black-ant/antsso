package com.gang.antsso.to;

import com.gang.antsso.datacenter.entity.SsoClientEntity;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @Classname OAuthClientDetails
 * @Description TODO
 * @Date 2020/3/7 20:09
 * @Created by zengzg
 */

public class OAuthClientDetails extends SsoClientEntity implements ClientDetails {

    private Pattern BCRYPT_PATTERN = Pattern
            .compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");


    public OAuthClientDetails() {
    }

    public OAuthClientDetails(SsoClientEntity entity) {
        super(entity);
    }


    @Override
    public String getClientId() {
        return super.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {

        if (StringUtils.isNotBlank(super.getResourceId())) {
            return new HashSet<>(Arrays.asList(super.getResourceId().split(",")));
        } else {
            return new HashSet<>();
        }

    }

    @Override
    public boolean isSecretRequired() {
        return Boolean.TRUE;
    }

    @Override
    public String getClientSecret() {

        // Security 5 的 默认加密处理
        if (!BCRYPT_PATTERN.matcher(super.getClientSecret()).matches()) {
            return "{bcrypt}" + new BCryptPasswordEncoder().encode(super.getClientSecret());
        } else {
            return super.getClientSecret();
        }
    }

    @Override
    public boolean isScoped() {
        return Boolean.TRUE;
    }

    @Override
    public Set<String> getScope() {
        if (StringUtils.isNotBlank(super.getScopes())) {
            return new HashSet<>(Arrays.asList(super.getScopes().split(",")));
        } else {
            return new HashSet<>();
        }

    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        if (StringUtils.isNotBlank(super.getGrantType())) {
            return new HashSet<>(Arrays.asList(super.getGrantType().split(",")));
        } else {
            return new HashSet<>();
        }

    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        if (StringUtils.isNotBlank(super.getClientRedirectUrl())) {
            return new HashSet<>(Arrays.asList(super.getClientRedirectUrl().split(",")));
        } else {
            return new HashSet<>();
        }

    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authRoles = new ArrayList<GrantedAuthority>();
        authRoles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authRoles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authRoles;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return super.getAccesstokenTimeout() == 0 ? 3600 : super.getAccesstokenTimeout();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return super.getRefushTimeout() == 0 ? 86400 : super.getRefushTimeout();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return Boolean.TRUE;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
