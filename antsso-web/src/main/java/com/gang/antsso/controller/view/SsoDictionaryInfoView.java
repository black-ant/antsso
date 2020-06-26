package com.gang.antsso.controller.view;

import com.gang.antsso.datacenter.entity.DictionaryInfoEntity;
import com.gang.antsso.datacenter.repository.DictionaryInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname SsoDictionaryView
 * @Description TODO
 * @Date 2020/6/26 15:04
 * @Created by zengzg
 */
@Controller
@RequestMapping("/view/dictionary")
public class SsoDictionaryInfoView extends AbstractView<DictionaryInfoRepository, DictionaryInfoEntity> {

    @Override
    public String getMapping() {
        return "dictionary";
    }
}
