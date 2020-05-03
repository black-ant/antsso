package com.gang.antsso.logic.auth.provide;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Classname OAuthQRCodeAuthenticationProvide
 * @Description TODO
 * @Date 2020/5/2 12:26
 * @Created by zengzg
 */
@Component
public class OAuthQRCodeAuthenticationProvide implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
