//package com.gang.antsso.dingtalk;
//
//import com.gang.antsso.dingtalk.service.DingTalkService;
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
//@SpringBootTest(classes = {DingTalkTest.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@SpringBootApplication(scanBasePackages = {"com.gang.antsso"})
//public class DingTalkTest {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    public static void main(String[] args) {
//        SpringApplication.run(DingTalkTest.class, args);
//    }
//
//    @Autowired
//    private DingTalkService dingTalkService;
//
//    @Test
//    public void test() {
//        logger.info("------> this is in dingtalk <-------");
//        dingTalkService.requestToken("", "");
//    }
//}
