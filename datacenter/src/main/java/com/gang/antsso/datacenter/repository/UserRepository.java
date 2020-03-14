package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserRepository
 * @Description TODO
 * @Date 2020/1/10 14:36
 * @Created by zengzg
 */
@Repository
public interface UserRepository extends JpaRepository<SsoUserEntity, String> {

    SsoUserEntity findByUserMobile(String mobile);

}
