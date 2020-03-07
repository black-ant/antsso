package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import com.gang.antsso.datacenter.entity.SsoClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname SsoClientRepository
 * @Description TODO
 * @Date 2020/3/7 20:05
 * @Created by zengzg
 */
@Repository
public interface SsoClientRepository extends JpaRepository<SsoClientEntity, String> {


    SsoClientEntity findByClientId(String clientid);
}
