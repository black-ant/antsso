//package com.gang.antsso.wechat;
//
//import com.gang.antsso.wechat.service.WechatService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
///**
// * @Classname DingTalkTest
// * @Description TODO
// * @Date 2020/6/26 18:56
// * @Created by zengzg
// */
//@SpringBootTest(classes = {WechatTest.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@SpringBootApplication(scanBasePackages = {"com.gang.antsso"})
//public class WechatTest {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    public static void main(String[] args) {
//        SpringApplication.run(WechatTest.class, args);
//    }
//
//    @Autowired
//    private WechatService dingTalkService;
//
//    @Test
//    public void test() {
//        logger.info("------> this is in dingtalk <-------");
//        dingTalkService.requestToken("", "");
//    }
//}
