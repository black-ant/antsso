package com.gang.antsso.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/1/12 15:28
 * @Created by zengzg
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping("getOrder")
    public Object getOrder() {
        return "order";
    }
}
