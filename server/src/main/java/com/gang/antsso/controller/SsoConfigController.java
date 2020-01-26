package com.gang.antsso.controller;

import com.gang.antsso.datacenter.entity.SsoConfigEntity;
import com.gang.antsso.datacenter.repository.SsoConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SsoConfigController
 * @Description TODO
 * @Date 2020/1/12 12:58
 * @Created by zengzg
 */
@RestController
@RequestMapping("/config")
public class SsoConfigController extends AbstratController<SsoConfigRepository, SsoConfigEntity> {


    @InitBinder
    @Autowired
    public void setRespository(SsoConfigRepository ssoConfigRepository) {
        this.jpaRepository = ssoConfigRepository;
    }
}
