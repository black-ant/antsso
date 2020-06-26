package com.gang.antsso.controller.view;

import com.gang.antsso.datacenter.entity.SsoGroupEntity;
import com.gang.antsso.datacenter.repository.SsoGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Classname SsoGroupView
 * @Description TODO
 * @Date 2020/3/22 11:35
 * @Created by zengzg
 */
@RestController
@RequestMapping("/view/group")
public class SsoGroupView extends AbstractView<SsoGroupRepository, SsoGroupEntity> {

    @Autowired
    public void setRespository(SsoGroupRepository repository) {
        this.jpaRepository = repository;
    }

    public String getMapping() {
        return "group";
    }
}
