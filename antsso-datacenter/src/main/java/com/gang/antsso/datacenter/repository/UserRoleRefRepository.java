package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.UserRoleRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserRoleRefRepository
 * @Description TODO
 * @Date 2020/1/25 22:28
 * @Created by zengzg
 */
@Repository
public interface UserRoleRefRepository extends JpaRepository<UserRoleRefEntity, String> {
}
