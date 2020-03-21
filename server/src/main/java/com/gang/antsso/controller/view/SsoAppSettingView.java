package com.gang.antsso.controller.view;

import com.gang.antsso.controller.AbstratController;
import com.gang.antsso.datacenter.entity.SsoAppSettingEntity;
import com.gang.antsso.datacenter.repository.SsoAppSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname SsoAppSettingController
 * @Description TODO
 * @Date 2020/1/27 18:11
 * @Created by zengzg
 */

@Controller
@RequestMapping("/view/setting")
public class SsoAppSettingView extends AbstractView<SsoAppSettingRepository, SsoAppSettingEntity> {

    @Autowired
    public void setRespository(SsoAppSettingRepository ssoAppSettingRepository) {
        this.jpaRepository = ssoAppSettingRepository;
    }

    @Override
    public String getMapping() {
        return "setting";
    }
}
