package com.gang.antsso.controller;

import com.gang.antsso.datacenter.entity.UserRoleRefEntity;
import com.gang.antsso.datacenter.repository.UserRoleRefRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserRoleRefController
 * @Description TODO
 * @Date 2020/1/25 22:27
 * @Created by zengzg
 */
@RestController
@RequestMapping("/roleref")
public class UserRoleRefController extends AbstratController<UserRoleRefRepository, UserRoleRefEntity> {
}
