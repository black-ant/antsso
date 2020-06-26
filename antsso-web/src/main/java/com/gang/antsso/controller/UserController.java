package com.gang.antsso.controller;

import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/1/10 14:37
 * @Created by zengzg
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstratController<UserRepository, SsoUserEntity> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @InitBinder
    @Autowired
    public void setRespository(UserRepository userRepository) {
        this.jpaRepository = userRepository;
    }

}
