package com.gang.antsso.strategy;

import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.to.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname StrategyInvole
 * @Description TODO
 * @Date 2020/2/23 14:38
 * @Created by zengzg
 */
@Component
public class StrategyInvoke {

    @Autowired
    private DataBaseStrategy dataBaseStrategy;

    public UserInfo getUserInfo(UserInfoSearchTO userInfoSearchTO) {
        return dataBaseStrategy.searchUserInfo(userInfoSearchTO);
    }

}
