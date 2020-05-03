package com.gang.antsso.logic;

import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserLogic
 * @Description TODO
 * @Date 2020/1/10 14:37
 * @Created by zengzg
 */
@Service
public class AntUserLogic {

    @Autowired
    private UserRepository userRepository;

    public SsoUserEntity get(String uid) {
        return userRepository.getOne(uid);
    }

    public SsoUserEntity getByMobile(String uid) {
        return userRepository.findByUserMobileOrUserEmail(uid);
    }

    public SsoUserEntity getByUsername(String uid) {
        return userRepository.findByUserName(uid);
    }

}
