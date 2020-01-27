package com.gang.antsso.easy;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.logic.OAuthUserInfo;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.UserRepository;
import com.gang.antsso.lib.to.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname DataBaseLogic
 * @Description TODO
 * @Date 2020/1/26 21:02
 * @Created by zengzg
 */
@Component
public class DataBaseLogic implements OAuthUserInfo {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo getUserInfo(UserInfoSearch userInfoSearch) {

        SsoUserEntity ssoUserEntity = userRepository.findById(userInfoSearch.getPrimaryKey()).get();

        UserInfo userInfo = new UserInfo();

        BeanUtils.copyProperties(ssoUserEntity, userInfo);

        // Other Info
        userInfo.setUserid(ssoUserEntity.getId());
        userInfo.setUsername(ssoUserEntity.getUserName());
        userInfo.setPassword(ssoUserEntity.getUserPassword());

        return userInfo;
    }
}