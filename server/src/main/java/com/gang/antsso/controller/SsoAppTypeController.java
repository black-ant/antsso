package com.gang.antsso.controller;

import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.repository.SsoAppTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SsoAppTypeController
 * @Description TODO
 * @Date 2020/1/27 18:09
 * @Created by zengzg
 */
@RestController
@RequestMapping("/type")
public class SsoAppTypeController extends AbstratController<SsoAppTypeRepository, SsoAppTypeEntity> {

    @InitBinder
    @Autowired
    public void setRespository(SsoAppTypeRepository ssoAppTypeRepository) {
        this.jpaRepository = ssoAppTypeRepository;
    }

}
