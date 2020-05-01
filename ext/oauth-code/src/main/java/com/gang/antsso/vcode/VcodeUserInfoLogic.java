package com.gang.antsso.vcode;

import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.logic.IOAuthUserInfo;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname VcodeUserInfoLogic
 * @Description TODO
 * @Date 2020/3/14 20:35
 * @Created by zengzg
 */
@Component
public class VcodeUserInfoLogic implements IOAuthUserInfo<String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {
        SsoUserEntity ssoUserEntity = userRepository.findByUserMobile(userInfoSearchTO.getSearchInfo());

        UserInfo userInfo = new UserInfo();

        BeanUtils.copyProperties(ssoUserEntity, userInfo);

        // Other Info
        userInfo.setUserid(ssoUserEntity.getId());
        userInfo.setUsername(ssoUserEntity.getUserName());
        userInfo.setPassword(ssoUserEntity.getUserPassword());

        return userInfo;
    }
}
