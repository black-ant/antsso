package com.gang.antsso.config.entity;

import com.gang.antsso.to.AntSsoSettingTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname WebSecurityConfig
 * @Description 注入方式一 : 通过配置文件配置路径 ,但是该方式个人认为不够优雅
 * @Date 2020/6/7 15:45
 * @Created by zengzg
 */

@Configuration
@ConfigurationProperties(prefix = "ant.sso.auth")
@Component
public class AntSSOWebSecurityConfiguration {

    private List<String> openAuth;

    private List<AntSsoSettingTO> settingList;

    public List<String> getOpenAuth() {
        return openAuth;
    }

    public void setOpenAuth(List<String> openAuth) {
        this.openAuth = openAuth;
    }

    public List<AntSsoSettingTO> getSettingList() {
        return settingList;
    }

    public void setSettingList(List<AntSsoSettingTO> settingList) {
        this.settingList = settingList;
    }
}
