package com.gang.antsso.core.logic.strategy;

import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.logic.IOAuthUserInfoHandler;
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

            IOAuthUserInfoHandler handler = getHandlerByAppType(userInfoSearchTO);
            return handler.searchUserInfo(userInfoSearchTO);

        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public UserInfo checkUserInfo(UserInfoSearchTO userInfoSearchTO) {
        try {

            IOAuthUserInfoHandler handler = getHandlerByAppType(userInfoSearchTO);
            return handler.checkUserInfo(userInfoSearchTO);

        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
        return null;
    }


    /**
     * 根据Type 选择操作类
     *
     * @param userInfoSearchTO
     * @return
     */
    public IOAuthUserInfoHandler getHandlerByAppType(UserInfoSearchTO userInfoSearchTO) {

        SsoAppTypeEntity appType = appTypeRepository.findByTypeCode(userInfoSearchTO.getAuthType());

        logger.info("------> this appType is :{} <-------", appType.getTypeName());

        return reflectionUtils.springClassLoad(appType.getTypeClass());
    }
}
