package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoAppSettingEntity;
import com.gang.antsso.datacenter.entity.SsoConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname SsoAppSettingRepository
 * @Description TODO
 * @Date 2020/1/27 18:05
 * @Created by zengzg
 */
@Repository
public interface SsoAppSettingRepository extends JpaRepository<SsoAppSettingEntity, String> {

    public SsoAppSettingEntity getBySettingTypeCode(String settingType);

}
