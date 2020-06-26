package com.gang.antsso.controller.view;

import com.gang.antsso.controller.AbstratController;
import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.repository.SsoAppTypeRepository;
import com.gang.common.lib.to.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname SsoAppTypeController
 * @Description TODO
 * @Date 2020/1/27 18:09
 * @Created by zengzg
 */
@Controller
@RequestMapping("/view/type")
public class SsoAppTypeView extends AbstractView<SsoAppTypeRepository, SsoAppTypeEntity> {

    @GetMapping("test")
    public ModelAndView test(@RequestParam("key") String key) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("type");
        modelAndView.addObject("entity", new SsoAppTypeEntity());
        modelAndView.addObject("datalist", "");
        return modelAndView;
    }

    @Autowired
    public void setRespository(SsoAppTypeRepository ssoAppTypeRepository) {
        this.jpaRepository = ssoAppTypeRepository;
    }

    @Override
    public String getMapping() {
        return "type";
    }
}
