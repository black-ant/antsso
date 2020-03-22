package com.gang.antsso.controller;

import com.gang.antsso.datacenter.entity.AbstractEntity;
import com.gang.common.lib.to.ResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Classname AbstratController
 * @Description TODO
 * @Date 2020/1/25 21:56
 * @Created by zengzg
 */
public class AbstratController<T extends JpaRepository, D extends AbstractEntity> {

    protected JpaRepository jpaRepository;

    @GetMapping("get/{key}")
    public ResponseModel get(@PathVariable("key") String key) {
        return ResponseModel.commonResponse(jpaRepository.getOne(key));
    }

    @GetMapping("getall")
    public ResponseModel list() {
        return ResponseModel.commonResponse(jpaRepository.findAll());
    }

    @GetMapping("delete")
    public ResponseModel delete(@PathVariable("key") String key) {
        jpaRepository.deleteById(key);
        return ResponseModel.commonResponse(key);
    }

    @PostMapping("insert")
    public ResponseModel insert(@RequestBody D entity) {
        return ResponseModel.commonResponse(jpaRepository.save(entity));
    }

    @PostMapping("update")
    public ResponseModel update(@RequestBody D entity) {
        return ResponseModel.commonResponse(jpaRepository.saveAndFlush(entity));
    }
}
