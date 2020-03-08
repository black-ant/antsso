package com.gang.antsso.logic;

import com.gang.antsso.datacenter.entity.SsoClientEntity;
import com.gang.antsso.datacenter.repository.SsoClientRepository;
import com.gang.antsso.to.OAuthClientDetails;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * @Classname OAuthClientDetailsService
 * @Description TODO
 * @Date 2020/3/7 20:07
 * @Created by zengzg
 */
@Component
public class OAuthClientDetailsService implements ClientDetailsService {

    @Autowired
    private SsoClientRepository repository;

    @Override
    @Cacheable(cacheNames = "sso-client", key = "#s")
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        SsoClientEntity entity = repository.findByClientId(s);
        return new OAuthClientDetails(entity);
    }
}
