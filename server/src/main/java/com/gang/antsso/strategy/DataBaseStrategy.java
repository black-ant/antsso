package com.gang.antsso.strategy;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.logic.OAuthUserInfo;
import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.repository.SsoAppTypeRepository;
import com.gang.antsso.ext.database.DataBaseLogic;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.common.lib.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname UsernameStrategy
 * @Description TODO
 * @Date 2020/2/23 14:39
 * @Created by zengzg
 */
@Component
public class DataBaseStrategy implements IStrategyLogic {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReflectionUtils reflectionUtils;

    @Autowired
    private SsoAppTypeRepository appTypeRepository;

    @Override
    public UserInfo getUserInfo(UserInfoSearch userInfoSearch) {
        try {

            SsoAppTypeEntity appType = appTypeRepository.findByTypeCode(userInfoSearch.getAuthType());

            logger.info("------> this appType is :{} <-------", appType.getTypeName());

            OAuthUserInfo oAuthUserInfo = reflectionUtils.classLoadReflect(appType.getTypeClass());

            return oAuthUserInfo.getUserInfo(userInfoSearch);

        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
        return null;

    }

}