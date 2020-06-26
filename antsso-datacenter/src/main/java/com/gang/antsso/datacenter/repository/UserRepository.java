package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserRepository
 * @Description TODO
 * @Date 2020/1/10 14:36
 * @Created by zengzg
 */
@Repository
public interface UserRepository extends JpaRepository<SsoUserEntity, String> {


    @Query("select u from SsoUserEntity u where u.userEmail = ?1 or u.userMobile = ?1")
    SsoUserEntity findByUserMobileOrUserEmail(String mobile);

    SsoUserEntity findByUserName(String username);

}
