package com.gang.antsso.easy;

import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.logic.IOAuthUserInfo;
import com.gang.antsso.auth.api.to.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Classname DataBaseLogic
 * @Description TODO
 * @Date 2020/1/26 21:02
 * @Created by zengzg
 */
@Component
public class EasyAuthLogic implements IOAuthUserInfo<String> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO<String> userInfoSearchTO) {

        logger.info("------> this is in easy :{} <-------", userInfoSearchTO.getSearchInfo());

        UserInfo userInfo = new UserInfo();

        // Other Info
        userInfo.setUserid("100000");
        userInfo.setUsername("gang");
        userInfo.setPassword("123456");

        return userInfo;
    }


}
