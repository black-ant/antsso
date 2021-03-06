package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname SsoRoleRepository
 * @Description TODO
 * @Date 2020/1/25 21:50
 * @Created by zengzg
 */
@Repository
public interface SsoRoleRepository extends JpaRepository<SsoRoleEntity, String> {
}
