package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.UserAppRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserAppRefRepository
 * @Description TODO
 * @Date 2020/1/27 18:08
 * @Created by zengzg
 */
@Repository
public interface UserAppRefRepository extends JpaRepository<UserAppRefEntity, String> {
}

