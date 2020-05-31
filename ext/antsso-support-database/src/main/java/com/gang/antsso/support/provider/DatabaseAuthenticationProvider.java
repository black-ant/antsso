package com.gang.antsso.support.provider;

import com.gang.antsso.auth.api.config.AlgorithmConfig;
import com.gang.antsso.auth.api.config.AntSSOConfiguration;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.utils.PwdUtils;
import com.gang.antsso.support.service.UserInfoService;
import com.gang.antsso.support.token.DatabaseUserToken;
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
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname DatabaseAuthenticationProvider
 * @Description TODO
 * @Date 2020/5/31 17:10
 * @Created by zengzg
 */
@Component
public class DatabaseAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AntSSOConfiguration antSSOConfiguration;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (authentication.getPrincipal() == null)
                ? "NONE_PROVIDED" : String.valueOf(authentication.getPrincipal());
        String password = (String) authentication.getCredentials();

        if (StringUtils.isEmpty(password)) {
            throw new BadCredentialsException("密码不能为空");
        }

        UserInfo user = userInfoService.searchUserInfo(new UserInfoSearchTO<String>(username));
        if (null == user) {
            throw new BadCredentialsException("用户不存在");
        }
        if (password.length() != 32) {
            password = PwdUtils.AESencode(password, AlgorithmConfig.getAlgorithmKey());
        }

        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("用户名或密码不正确");
        }

        DatabaseUserToken result = new DatabaseUserToken(
                username,
                new BCryptPasswordEncoder().encode(password),
                listUserGrantedAuthorities(user.getUserid()));

        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (DatabaseUserToken.class.isAssignableFrom(authentication));
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
