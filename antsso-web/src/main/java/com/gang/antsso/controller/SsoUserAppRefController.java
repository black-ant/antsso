package com.gang.antsso.controller;

import com.gang.antsso.datacenter.entity.UserAppRefEntity;
import com.gang.antsso.datacenter.repository.UserAppRefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SspUserAppRefController
 * @Description TODO
 * @Date 2020/1/27 18:12
 * @Created by zengzg
 */

@RestController
@RequestMapping("/userappref")
public class SsoUserAppRefController extends AbstratController<UserAppRefRepository, UserAppRefEntity> {

    @InitBinder
    @Autowired
    public void setRespository(UserAppRefRepository userAppRefRepository) {
        this.jpaRepository = userAppRefRepository;
    }
}
