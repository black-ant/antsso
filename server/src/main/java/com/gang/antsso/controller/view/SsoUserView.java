package com.gang.antsso.controller.view;

import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.entity.SsoUserEntity;
import com.gang.antsso.datacenter.repository.SsoAppTypeRepository;
import com.gang.antsso.datacenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname SsoUserView
 * @Description TODO
 * @Date 2020/3/22 11:21
 * @Created by zengzg
 */
@Controller
@RequestMapping("/view/user")
public class SsoUserView extends AbstractView<UserRepository, SsoUserEntity> {

    @Autowired
    public void setRespository(UserRepository repository) {
        this.jpaRepository = repository;
    }

    @Override
    public String getMapping() {
        return "user";
    }
}
