package com.gang.antsso.strategy;

import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.repository.SsoAppTypeRepository;
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

    public UserInfo getUserInfo(UserInfoSearch userInfoSearch) {
        return dataBaseStrategy.getUserInfo(userInfoSearch);
    }

}
