package com.gang.antsso.logic.auth.provide;

import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.auth.api.type.AntAuthType;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.logic.auth.manager.StrategyInvoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname BaseAuthenticationProvider
 * @Description TODO
 * @Date 2020/5/3 19:58
 * @Created by zengzg
 */
@Component
public class BaseAuthenticationProvider {

    @Autowired
    private StrategyInvoke strategyInvoke;

    public UserInfo checkUserInfo(String account, String passCode, AntAuthType authType) {

        UserInfoSearchTO<String> searchTO = new UserInfoSearchTO();
        searchTO.setType(authType);
        searchTO.setSearchInfo(account);
        searchTO.addCheckInfo(account, passCode);
        return strategyInvoke.chechUserInfo(searchTO);
    }

}
