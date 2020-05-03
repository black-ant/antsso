package com.gang.antsso.dingtalk.service;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.auth.api.logic.IOAuthServiceHandler;
import com.gang.antsso.auth.api.to.InternetRequestTO;
import com.gang.antsso.auth.api.to.InternetResponseTO;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.to.UserInfoSearchTO;
import com.gang.antsso.dingtalk.config.DingtalkProperties;
import com.gang.antsso.dingtalk.entity.DingInternetSetting;
import com.gang.common.lib.utils.HttpClientUtils;
import com.gang.common.lib.utils.TemplateResolve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Classname DingTalkAuthServiceHandler
 * @Description TODO
 * @Date 2020/5/1 22:46
 * @Created by zengzg
 */
@Component
public class DingTalkAuthServiceHandler implements IOAuthServiceHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public InternetResponseTO execute(InternetRequestTO request) {

        String responseInfo = "";

        try {
            switch (request.getType()) {
                case RQ_CODE:
                    responseInfo = executeRqCode(request);
                    break;
                default:
                    logger.warn("Nothing execute : DingTalk ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("E----> error :{} -- content :{}", e.getClass(), e.getMessage());
        }

        InternetResponseTO response = new InternetResponseTO();
        response.setResponseMsg(responseInfo);
        return response;
    }

    @Override
    public UserInfo searchUserInfo(UserInfoSearchTO userInfoSearchTO) {
        return null;
    }

    @Override
    public UserInfo checkUserInfo(UserInfoSearchTO userInfoSearchTO) {
        return null;
    }


    /**
     * 处理钉钉二维码登录逻辑
     *
     * @param request
     * @return
     */
    public String executeRqCode(InternetRequestTO request) throws Exception {

        logger.info("------> run start <-------");

        DingInternetSetting setting = JSONObject.parseObject(request.backSettingBody(), DingInternetSetting.class);
        String tiemstamp = String.valueOf(getTimestamp(new Date()));

        // Step 1 : 生成 URL 请求地址
        JSONObject urlParam = new JSONObject();
        urlParam.put("AppId", setting.getAppId());
        urlParam.put("Timestamp", tiemstamp);
        urlParam.put("Signature", getSignature(setting.getAppSecret(), tiemstamp));
        String url = TemplateResolve.jexlResolve(DingtalkProperties.RQCODE_URL, urlParam.toJSONString());

        // Step 2 : 生成 Request Body
        JSONObject codeBody = new JSONObject();
        codeBody.put("tmp_auth_code", request.getoAuthExtSettingTO().getExtMap().get("code"));

        String back = HttpClientUtils.sendHttpPost(url, codeBody.toJSONString());
        logger.info("------> back is :{} <-------", back);
        return back;
    }

    /**
     * 生成 Signature 值
     *
     * @param appSecret
     * @return
     * @throws Exception
     */
    public String getSignature(String appSecret, String tiemstamp) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(appSecret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signatureBytes = mac.doFinal(tiemstamp.getBytes("UTF-8"));
        String signature = new String(Base64Utils.encode(signatureBytes));
        String urlEncodeSignature = urlEncode(signature, "UTF-8");
        logger.info("------> urlEncodeSignature is :{} <-------", urlEncodeSignature);
        return urlEncodeSignature;
    }


    /**
     * 获取毫秒时间戳
     *
     * @param date
     * @return
     */
    public static Long getTimestamp(Date date) {
        if (null == date) {
            return (long) 0;
        }
        String timestamp = String.valueOf(date.getTime());
        return Long.valueOf(timestamp);
    }


    /**
     * 转码
     *
     * @param value
     * @param encoding
     * @return
     */
    public static String urlEncode(String value, String encoding) {
        if (value == null) {
            return "";
        }
        try {
            String encoded = URLEncoder.encode(value, encoding);
            return encoded.replace("+", "%20").replace("*", "%2A")
                    .replace("~", "%7E").replace("/", "%2F");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("FailedToEncodeUri", e);
        }
    }
}
