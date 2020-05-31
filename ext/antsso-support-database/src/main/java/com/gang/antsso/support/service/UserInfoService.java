package com.gang.antsso.support.service;

import com.gang.antsso.auth.api.logic.IOAuthUserInfoHandler;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.support.dao.SupportUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname UserInfoService
 * @Description TODO
 * @Date 2020/5/31 17:15
 * @Created by zengzg
 */
@Component
public class UserInfoService implements IOAuthUserInfoHandler<String> {

    @Autowired
    private SupportUserRepository supportUserRepository;

    @Autowired
    private UserInfoConversion conversion;


    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {
        SsoUserEntity userEntity = supportUserRepository.findByUserName(userInfoSearchTO.getSearchInfo());
        return conversion.conversion(userEntity, null);
    }

    @Override
    public UserInfo checkUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {
        return null;
    }
}
