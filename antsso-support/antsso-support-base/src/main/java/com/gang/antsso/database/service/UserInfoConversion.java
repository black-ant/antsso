package com.gang.antsso.database.service;

import com.gang.antsso.auth.api.logic.IUserConversion;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import org.springframework.stereotype.Component;

/**
 * @Classname UserInfoConversion
 * @Description TODO
 * @Date 2020/5/31 17:15
 * @Created by zengzg
 */
@Component
public class UserInfoConversion implements IUserConversion<SsoUserEntity, UserInfo> {

    @Override
    public UserInfo conversion(SsoUserEntity source, UserInfo target) {
        if (target == null) {
            target = new UserInfo();
        }
        target.setUsername(source.getUserName());
        target.setPassword(source.getUserPassword());
        target.setUserid(source.getId());
        return target;
    }
}
