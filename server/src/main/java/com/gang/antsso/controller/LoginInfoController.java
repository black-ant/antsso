package com.gang.antsso.controller;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.datacenter.entity.SsoAppSettingEntity;
import com.gang.antsso.datacenter.repository.SsoAppSettingRepository;
import com.gang.common.lib.to.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname LoginInfoController
 * @Description TODO
 * @Date 2020/1/27 20:58
 * @Created by zengzg
 */
@RequestMapping("/unauth/login")
@RestController
public class LoginInfoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SsoAppSettingRepository ssoAppSettingRepository;

    @GetMapping("/workwechat")
    public ModelAndView module() {
        logger.info("------> this is in unauth <-------");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/oauth/workwechatlogin");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "gang");
        jsonObject.put("age", 11);
        jsonObject.put("desc", "gang is good");

        SsoAppSettingEntity ssoAppSettingEntity = new SsoAppSettingEntity("1111", jsonObject.toJSONString(), "test",
                "test");

        modelAndView.addObject("setting", ssoAppSettingEntity);

        return modelAndView;
    }

    @GetMapping("/get/{type}")
    public ResponseModel<String> getLoginInfo(@PathVariable("type") String type) {
        SsoAppSettingEntity ssoAppSettingEntity = ssoAppSettingRepository.getBySettingTypeCode(type);
        return ResponseModel.commonResponse(JSONObject.toJSONString(ssoAppSettingEntity));
    }
}
