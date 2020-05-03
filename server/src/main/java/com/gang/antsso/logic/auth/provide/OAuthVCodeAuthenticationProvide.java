package com.gang.antsso.logic.auth.provide;

import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.type.AntAuthType;
import com.gang.antsso.logic.auth.token.AntVCodeAuthenticationToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname OAuthVCodeAuthenticationProvide
 * @Description TODO
 * @Date 2020/5/2 12:25
 * @Created by zengzg
 */
@Component
public class OAuthVCodeAuthenticationProvide extends BaseAuthenticationProvider implements AuthenticationProvider {

    /**
     * 通过登录名获取正常的用户 + 校验验证码是否正确
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String mobile = (authentication.getPrincipal() == null)
                ? "NONE_PROVIDED" : String.valueOf(authentication.getPrincipal());
        String code = (String) authentication.getCredentials();

        if (StringUtils.isEmpty(code)) {
            throw new BadCredentialsException("验证码不能为空");
        }

        UserInfo user = super.checkUserInfo(mobile, code, AntAuthType.VOCDE);

        if (!user.getCheckStatus()) {
            throw new BadCredentialsException(user.getCheckInfo());
        }

        AntVCodeAuthenticationToken result = new AntVCodeAuthenticationToken(user.getUsername(),
                listUserGrantedAuthorities(user.getUserid()));
        result.setDetails(authentication.getDetails());

        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AntVCodeAuthenticationToken.class.isAssignableFrom(authentication);
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
