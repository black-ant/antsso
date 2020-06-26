package com.gang.antsso.vcode.provider;

import com.gang.antsso.auth.api.config.AntSSOConfiguration;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.vcode.service.VCodeUserInfoService;
import com.gang.antsso.vcode.token.VCodeUserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
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
 * @Classname VCodeAuthenticationProvider
 * @Description TODO
 * @Date 2020/6/7 15:38
 * @Created by zengzg
 */
@Component
public class VCodeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private VCodeUserInfoService userInfoService;

    @Autowired
    private AntSSOConfiguration antSSOConfiguration;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String mobile = (authentication.getPrincipal() == null)
                ? "NONE_PROVIDED" : String.valueOf(authentication.getPrincipal());
        String code = (String) authentication.getCredentials();

        if (org.apache.commons.lang3.StringUtils.isEmpty(code)) {
            throw new BadCredentialsException("验证码不能为空");
        }
        // 校验用户和验证码
        UserInfoSearchTO userInfoSearchTO = new UserInfoSearchTO<String>(mobile).addCheckInfo(mobile, code);
        UserInfo user = userInfoService.checkUserInfo(userInfoSearchTO);

        if (!user.getCheckStatus()) {
            throw new BadCredentialsException(user.getCheckInfo());
        }

        VCodeUserToken result = new VCodeUserToken(
                mobile,
                new BCryptPasswordEncoder().encode(user.getPassword()),
                listUserGrantedAuthorities(user.getUserid()));

        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (VCodeUserToken.class.isAssignableFrom(authentication));
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
