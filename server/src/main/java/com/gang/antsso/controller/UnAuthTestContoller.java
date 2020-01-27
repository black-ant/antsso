package com.gang.antsso.controller;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.datacenter.entity.SsoAppSettingEntity;
import com.gang.common.lib.to.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/1/27 21:45
 * @Created by zengzg
 */
@RequestMapping("/unauth")
@RestController
public class UnAuthTestContoller {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("test")
    public ResponseModel<String> unauth() {
        logger.info("------> this is in unauth <-------");
        return ResponseModel.commonResponse("this is ok");
    }

    @GetMapping("module")
    public ModelAndView module() {
        logger.info("------> this is in unauth <-------");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/test");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "gang");
        jsonObject.put("age", 11);
        jsonObject.put("desc", "gang is good");

        SsoAppSettingEntity ssoAppSettingEntity = new SsoAppSettingEntity("1111", jsonObject.toJSONString(), "test",
                "test");

        modelAndView.addObject("setting", ssoAppSettingEntity);

        return modelAndView;
    }
}
