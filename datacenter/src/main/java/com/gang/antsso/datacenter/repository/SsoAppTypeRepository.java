package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.SsoAppTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname SsoAppTypeRepository
 * @Description TODO
 * @Date 2020/1/27 18:06
 * @Created by zengzg
 */
@Repository
public interface SsoAppTypeRepository extends JpaRepository<SsoAppTypeEntity, String> {
}
