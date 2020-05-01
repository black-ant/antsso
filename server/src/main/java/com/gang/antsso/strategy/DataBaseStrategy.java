package com.gang.antsso.strategy;

import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.logic.IOAuthUserInfo;
import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.repository.SsoAppTypeRepository;
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
    public UserInfo searchUserInfo(UserInfoSearchTO userInfoSearchTO) {
        try {

            SsoAppTypeEntity appType = appTypeRepository.findByTypeCode(userInfoSearchTO.getAuthType());

            logger.info("------> this appType is :{} <-------", appType.getTypeName());

            IOAuthUserInfo oAuthUserInfo = reflectionUtils.classLoadReflect(appType.getTypeClass());

            return oAuthUserInfo.searchUserInfo(userInfoSearchTO);

        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
        return null;
    }
}
