package com.gang.antsso.saml.provider;

import com.gang.antsso.auth.api.error.AntSsoException;
import com.gang.antsso.saml.config.IdpConfiguration;
import com.gang.antsso.saml.token.FederatedUserAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.Arrays;

import static com.gang.antsso.auth.api.type.AntAuthPartType.ALL;


public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    private final IdpConfiguration idpConfiguration;

    public AuthenticationProvider(IdpConfiguration idpConfiguration) {
        this.idpConfiguration = idpConfiguration;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (StringUtils.isEmpty(authentication.getPrincipal())) {
            throw new AntSsoException("Principal may not be empty");
        }
        if (idpConfiguration.getAuthenticationMethod().equals(ALL)) {
            return new FederatedUserAuthenticationToken(
                    authentication.getPrincipal(),
                    authentication.getCredentials(),
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")));
        } else {
            return idpConfiguration.getUsers().stream()
                    .filter(token ->
                            token.getPrincipal().equals(authentication.getPrincipal()) &&
                                    token.getCredentials().equals(authentication.getCredentials()))
                    .findFirst().map(userAuthenticationToken ->
                            //need to copy or else credentials are erased for future logins
                            userAuthenticationToken.clone())
                    .orElseThrow(() -> new AntSsoException("User not found or bad credentials") {
                    });
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
