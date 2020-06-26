package com.gang.antsso.vcode.service;

import com.gang.antsso.auth.api.logic.IOAuthUserInfoHandler;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname VCodeUserInfoService
 * @Description TODO
 * @Date 2020/6/7 15:40
 * @Created by zengzg
 */
@Component
public class VCodeUserInfoService implements IOAuthUserInfoHandler<String> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VCodeUserInfoConversion conversion;

    @Autowired
    private VcodeCacheLogic cacheLogic;


    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {
        SsoUserEntity userEntity = userRepository.findByUserName(userInfoSearchTO.getSearchInfo());
        return conversion.conversion(userEntity, null);
    }

    @Override
    public UserInfo checkUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setCheckStatus(Boolean.FALSE);
        if (userInfoSearchTO.getUserCheckInfoTO() == null) {
            userInfo.setCheckInfo("UserCheckInfoTO is null , No found userChcek info");
        } else {
            String code = cacheLogic.getCode(userInfoSearchTO.getUserCheckInfoTO().getSaltCode());
            if (StringUtils.isNotEmpty(code) && code.equals(userInfoSearchTO.getUserCheckInfoTO().getCipherCode())) {
                logger.info("------> check user code success <-------");
                userInfo.setCheckStatus(Boolean.TRUE);
            } else {
                userInfo.setCheckInfo("Check Code Failure ,Code is null or Code is failure");
            }
        }

        if (userInfo.getCheckStatus()) {
            SsoUserEntity ssoUserEntity = userRepository.findByUserMobileOrUserEmail(userInfoSearchTO.getSearchInfo());
            if (ssoUserEntity != null) {
                ssoUserEntity.buildEntity(userInfo);
            } else {
                userInfo.setCheckStatus(Boolean.FALSE);
                userInfo.setCheckInfo("Sso User undefined ");
            }
        }

        return userInfo;
    }
}

