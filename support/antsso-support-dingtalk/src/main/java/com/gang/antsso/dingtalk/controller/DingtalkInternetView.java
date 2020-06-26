package com.gang.antsso.dingtalk.controller;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.auth.api.to.InternetRequestTO;
import com.gang.antsso.auth.api.to.OAuthExtSettingTO;
import com.gang.antsso.auth.api.type.InternetType;
import com.gang.antsso.core.service.OAuthSettingService;
import com.gang.antsso.datacenter.entity.SsoAppSettingEntity;
import com.gang.antsso.dingtalk.service.DingTalkAuthServiceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname InternetView
 * @Description TODO
 * @Date 2020/5/1 12:20
 * @Created by zengzg
 */
@Controller
@RequestMapping("/dingtalk/internet")
public class DingtalkInternetView {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DingTalkAuthServiceHandler dingTalkAuthService;

    @Autowired
    private OAuthSettingService oAuthSettingService;

    @GetMapping("test")
    public ModelAndView internetTest() {
        logger.info("------> this is in test <-------");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/auth/qrcode");
        return modelAndView;
    }

    /**
     * 获取第三方二维码
     *
     * @param type
     * @return
     */
    @GetMapping("/unauth/qrcode/{type}")
    public ModelAndView getQRCodePic(@PathVariable("type") String type) {
        logger.info("this is getAll");

        ModelAndView modelAndView = new ModelAndView();

        SsoAppSettingEntity settingEntity = oAuthSettingService.getSetting(type);
        modelAndView.addObject("setting", settingEntity);
        modelAndView.setViewName("/auth/qrcode");

        return modelAndView;
    }

    @GetMapping("/unauth/user/{type}")
    public ModelAndView getUserInfo(@PathVariable("type") String type, HttpServletRequest servletRequest) {

        logger.info("------> servletRequest :{} <-------", servletRequest.getRequestURI());
        logger.info("------> type is :{} <-------", type);
        logger.info("------> servletRequest :{} <-------", JSONObject.toJSONString(servletRequest.getParameterMap()));

        try {
            InternetRequestTO requestTO = new InternetRequestTO();
            OAuthExtSettingTO oAuthExtSettingTO = OAuthExtSettingTO.getInstance("DINGTALK", getDingSetting());
            oAuthExtSettingTO.addExtMap("code", servletRequest.getParameterMap().get("code")[0]);

            requestTO.setoAuthExtSettingTO(oAuthExtSettingTO);
            requestTO.setType(InternetType.RQ_CODE);

            dingTalkAuthService.execute(requestTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDingSetting() {
        JSONObject setting = new JSONObject();
        setting.put("appId", "dingoams2oq4puhmcv6n6u");
        setting.put("appSecret", "j5LbpQihEDnBQ7BS-wtGFmYtO26GKkW0UiNV1iS_SkBjfxXEMhu_ERFERXd2gpTi");
        return setting.toJSONString();
    }

}
