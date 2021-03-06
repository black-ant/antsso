package com.gang.antsso.controller.view;

import com.gang.antsso.datacenter.entity.AbstractAntSsoEntity;
import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.common.lib.utils.ReflectionUtils;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname AbstractView
 * @Description TODO
 * @Date 2020/3/21 19:39
 * @Created by zengzg
 */
public abstract class AbstractView<T extends JpaRepository, D extends AbstractAntSsoEntity> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected JpaRepository jpaRepository;

    @Autowired
    private ReflectionUtils reflectionUtils;

    @GetMapping("get/{key}")
    public ModelAndView getSsoConfigEntity(@PathVariable("key") String key) {
        ModelAndView modelAndView = getModelAndView("");
        if (key.equals("null")) {
            modelAndView.addObject("data", reflectionUtils.reloadByParadigm(this.getClass(), 1));
        } else {
            modelAndView.addObject("data", jpaRepository.getOne(key));
        }

        modelAndView.addObject("entity", new SsoAppTypeEntity());
        return modelAndView;
    }

    @GetMapping("list")
    public ModelAndView getAll() {
        logger.info("this is getAll");
        ModelAndView modelAndView = getModelAndView("list");
        modelAndView.addObject("datalist", jpaRepository.findAll());
        return modelAndView;
    }

    @GetMapping("delete")
    public ModelAndView delete(@PathVariable("key") String key) {
        ModelAndView modelAndView = getModelAndView("");
        jpaRepository.deleteById(key);
        modelAndView.addObject("key", key);
        return modelAndView;
    }

    @PostMapping("insert")
    public ModelAndView insert(@ModelAttribute("entity") D entity) {
        ModelAndView modelAndView = getModelAndView("");
        modelAndView.addObject("key", jpaRepository.save(entity));
        return modelAndView;
    }

    @PostMapping("update")
    public ModelAndView update(@ModelAttribute("entity") D entity) {
        ModelAndView modelAndView = getModelAndView("");
        modelAndView.addObject("data", jpaRepository.saveAndFlush(entity));
        return modelAndView;
    }

    public ModelAndView getModelAndView(String suffix) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getMapping() + suffix);
        return modelAndView;
    }

    public abstract String getMapping();

    //    public abstract Class<D> backClass();
}
