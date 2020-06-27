package com.gang.antsso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Classname JPAConfig
 * @Description TODO
 * @Date 2020/6/27 14:39
 * @Created by zengzg
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.gang.antsso"})
public class JPAConfig {
}
