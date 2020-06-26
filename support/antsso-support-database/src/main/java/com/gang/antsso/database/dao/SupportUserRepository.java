package com.gang.antsso.database.dao;

import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserRepository
 * @Description TODO
 * @Date 2020/1/10 14:36
 * @Created by zengzg
 */
@Repository
public class SupportUserRepository {

    @Autowired
    private UserRepository userRepository;

    public SsoUserEntity findByUserMobileOrUserEmail(String mobile) {
        return userRepository.findByUserMobileOrUserEmail(mobile);
    }


    public SsoUserEntity findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

}
