package com.gang.antsso.auth.api.entity;

import com.gang.antsso.auth.api.type.OAuthSearchType;
import lombok.Data;

import java.util.List;

/**
 * @Classname SearchItem
 * @Description TODO
 * @Date 2020/2/23 14:34
 * @Created by zengzg
 */
@Data
public class SearchItem {

    private OAuthSearchType oAuthSearchType;

    private String key;

    private String type;

    private List<SearchItem> searchItems;
}
