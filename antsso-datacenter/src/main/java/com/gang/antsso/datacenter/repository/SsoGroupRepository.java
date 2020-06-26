package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname SsoGroupRepository
 * @Description TODO
 * @Date 2020/3/22 11:32
 * @Created by zengzg
 */
@Repository
public interface SsoGroupRepository extends JpaRepository<SsoGroupEntity, Integer> {
}
