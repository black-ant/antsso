package com.gang.antsso.strategy;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.logic.OAuthUserInfo;
import com.gang.antsso.ext.database.DataBaseLogic;
import com.gang.antsso.lib.to.UserInfo;
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

    @Override
    public UserInfo getUserInfo(UserInfoSearch userInfoSearch) {
        try {

            userInfoSearch.setLogicClass(DataBaseLogic.class.getName());

            OAuthUserInfo oAuthUserInfo = reflectionUtils.springClassLoad(userInfoSearch.getLogicClass());

            return oAuthUserInfo.getUserInfo(userInfoSearch);

        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
        return null;

    }

}
