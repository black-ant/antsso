package com.gang.antsso.easy;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.logic.OAuthUserInfo;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.UserRepository;
import com.gang.antsso.auth.api.to.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DataBaseLogic
 * @Description TODO
 * @Date 2020/1/26 21:02
 * @Created by zengzg
 */
@Component
public class EasyAuthLogic implements OAuthUserInfo<String> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserInfo getUserInfo(UserInfoSearch<String> userInfoSearch) {

        logger.info("------> this is in easy :{} <-------", userInfoSearch.getSearchInfo());

        UserInfo userInfo = new UserInfo();

        // Other Info
        userInfo.setUserid("100000");
        userInfo.setUsername("gang");
        userInfo.setPassword("123456");

        return userInfo;
    }
}
