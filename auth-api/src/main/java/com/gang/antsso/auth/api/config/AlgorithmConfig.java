package com.gang.antsso.auth.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname AlgorithmConfig
 * @Description TODO
 * @Date 2020/5/31 17:57
 * @Created by zengzg
 */
@Component
public class AlgorithmConfig {


    private static String algorithmKey = "123456";

    //    public static String getAlgorithmKey() {
    //        return algorithmKey;
    //    }
    //
    //    @Value("${ant.sso.algorithm.key:123456}")
    //    public static void setAlgorithmKey(String algorithmKey) {
    //        algorithmKey = algorithmKey;
    //    }


    public static String getAlgorithmKey() {
        return algorithmKey;
    }

    public static void setAlgorithmKey(String algorithmKey) {
        AlgorithmConfig.algorithmKey = algorithmKey;
    }
}
