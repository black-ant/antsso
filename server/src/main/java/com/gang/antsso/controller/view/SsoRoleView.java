package com.gang.antsso.controller.view;

import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.entity.SsoRoleEntity;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.SsoAppTypeRepository;
import com.gang.antsso.datacenter.repository.SsoRoleRepository;
import com.gang.antsso.datacenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname SsoRoleView
 * @Description TODO
 * @Date 2020/3/22 11:38
 * @Created by zengzg
 */
@Controller
@RequestMapping("/view/role")
public class SsoRoleView extends AbstractView<SsoRoleRepository, SsoRoleEntity> {

    @Autowired
    public void setRespository(SsoRoleRepository repository) {
        this.jpaRepository = repository;
    }

    @Override
    public String getMapping() {
        return "role";
    }
}
