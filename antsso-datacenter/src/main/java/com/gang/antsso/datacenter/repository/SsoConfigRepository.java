package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname SsoConfigRepository
 * @Description TODO
 * @Date 2020/1/25 21:50
 * @Created by zengzg
 */
@Repository
public interface SsoConfigRepository extends JpaRepository<SsoConfigEntity, String> {
}
