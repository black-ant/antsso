package com.gang.antsso.core.service;

import com.gang.antsso.datacenter.entity.SsoAppSettingEntity;
import com.gang.antsso.datacenter.repository.SsoAppSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname OAuthSettingService
 * @Description TODO
 * @Date 2020/5/1 15:44
 * @Created by zengzg
 */
@Service
public class OAuthSettingService {

    @Autowired
    private SsoAppSettingRepository settingRepository;

    public SsoAppSettingEntity getSetting(String type) {
        return settingRepository.getBySettingTypeCode(type);
    }
}
