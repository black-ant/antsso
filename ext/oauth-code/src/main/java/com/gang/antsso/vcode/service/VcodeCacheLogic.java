package com.gang.antsso.vcode.service;

import com.gang.common.cache.common.CacheInvoke;
import com.gang.common.lib.utils.AntRandomUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname VcodeCacheLogic
 * @Description TODO
 * @Date 2020/5/2 15:42
 * @Created by zengzg
 */
@Component
public class VcodeCacheLogic {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 默认保持五分钟
     */
    public static final Integer TIMES = 300;
    public static final Integer CODE_LENGTH = 4;

    public static final String PREFIX = "VCODE";

    @Autowired
    private CacheInvoke cacheInvoke;

    public String saveCode(String saltKey, String settingKey) {
        String cacheName = PREFIX + ":" + getKeyHash(saltKey);
        String code = AntRandomUtils.getRandom(CODE_LENGTH);

        cacheInvoke.set(cacheName, code);
        logger.info("------> saveCode Success {}<-------", code);
        return code;
    }

    public String getCode(String saltKey) {
        String cacheName = PREFIX + ":" + getKeyHash(saltKey);
        return String.valueOf(cacheInvoke.get(cacheName));
    }

    /**
     * 获取 HashKey
     *
     * @return
     */
    public static String getKeyHash(String hashKey) {

        int hash = 0;
        for (int i = 0; i < hashKey.length(); i++) {
            hash ^= (hash << 5) + (int) hashKey.charAt(i) + (hash >> 2);
        }
        return String.valueOf(hash & 0x7FFFFFFF);
    }


}
