package com.gang.antsso.controller;

import com.gang.antsso.dao.SsoConfigRepository;
import com.gang.antsso.dao.UserRepository;
import com.gang.antsso.entity.SsoConfigEntity;
import com.gang.common.lib.to.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

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
