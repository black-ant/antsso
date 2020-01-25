package com.gang.antsso.controller;

import com.gang.antsso.dao.SsoRoleRepository;
import com.gang.antsso.dao.UserRepository;
import com.gang.antsso.entity.SsoRoleEntity;
import com.gang.antsso.entity.SsoUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SsoRoleController
 * @Description TODO
 * @Date 2020/1/25 22:21
 * @Created by zengzg
 */
@RestController
@RequestMapping("/role")
public class SsoRoleController extends AbstratController<SsoRoleRepository, SsoRoleEntity> {

    @InitBinder
    @Autowired
    public void setRespository(SsoRoleRepository ssoRoleRepository) {
        this.jpaRepository = ssoRoleRepository;
    }
}
