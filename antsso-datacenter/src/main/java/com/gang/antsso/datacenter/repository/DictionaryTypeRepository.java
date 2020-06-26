package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.DictionaryInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Classname DictionaryTypeRepository
 * @Description TODO
 * @Date 2020/6/26 15:00
 * @Created by zengzg
 */
@Component
public interface DictionaryTypeRepository extends JpaRepository<DictionaryInfoEntity, String> {
}
