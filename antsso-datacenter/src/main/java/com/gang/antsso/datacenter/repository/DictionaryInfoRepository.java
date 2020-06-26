package com.gang.antsso.datacenter.repository;

import com.gang.antsso.datacenter.entity.DictionaryInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Classname DictionaryInfoRepository
 * @Description TODO
 * @Date 2020/6/26 14:59
 * @Created by zengzg
 */
@Component
public interface DictionaryInfoRepository extends JpaRepository<DictionaryInfoEntity, String> {

}
