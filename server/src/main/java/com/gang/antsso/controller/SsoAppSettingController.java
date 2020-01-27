package com.gang.antsso.controller;

import com.gang.antsso.datacenter.entity.SsoAppSettingEntity;
import com.gang.antsso.datacenter.repository.SsoAppSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SsoAppSettingController
 * @Description TODO
 * @Date 2020/1/27 18:11
 * @Created by zengzg
 */

@RestController
@RequestMapping("/setting")
public class SsoAppSettingController extends AbstratController<SsoAppSettingRepository, SsoAppSettingEntity> {

    @InitBinder
    @Autowired
    public void setRespository(SsoAppSettingRepository ssoAppSettingRepository) {
        this.jpaRepository = ssoAppSettingRepository;
    }
}
