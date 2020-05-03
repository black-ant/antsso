package com.gang.antsso.logic.auth.provide;

import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.logic.AntUserLogic;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname OAuthUsernamePasswordAuthenticationProvide
 * @Description TODO
 * @Date 2020/5/2 14:24
 * @Created by zengzg
 */
@Component
public class OAuthUsernamePasswordAuthenticationProvide implements AuthenticationProvider {

    @Autowired
    private AntUserLogic userLogic;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        String password = (String) authentication.getCredentials();

        if (StringUtils.isEmpty(password)) {
            throw new BadCredentialsException("密码不能为空");
        }

        SsoUserEntity user = userLogic.getByUsername(username);
        if (null == user) {
            throw new BadCredentialsException("用户不存在");
        }
        if (password.length() != 32) {
            password = DigestUtils.md5Hex(password);
        }
        if (!password.equals(user.getUserPassword())) {
            throw new BadCredentialsException("用户名或密码不正确");
        }

        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                username,
                new BCryptPasswordEncoder().encode(password),
                listUserGrantedAuthorities(user.getId()));

        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private Set<GrantedAuthority> listUserGrantedAuthorities(String uid) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (StringUtils.isEmpty(uid)) {
            return authorities;
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}
