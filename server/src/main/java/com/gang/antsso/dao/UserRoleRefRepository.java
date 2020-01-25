package com.gang.antsso.dao;

import com.gang.antsso.entity.SsoRoleEntity;
import com.gang.antsso.entity.UserRoleRefEntity;
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
