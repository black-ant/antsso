package com.gang.antsso.oauth;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.logic.OAuthUserInfo;
import com.gang.antsso.lib.to.UserInfo;
import com.gang.antsso.oauth.to.OAuthUserDetails;
import com.gang.common.lib.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @Classname AuthLogic
 * @Description TODO
 * @Date 2020/1/12 13:08
 * @Created by zengzg
 */
@Component
public class OAuthUserDetailsService implements UserDetailsService, OAuthUserInfo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReflectionUtils reflectionUtils;

    /**
     * spring会将MyUserDetails中的密码与session中的密码比较，否是验证通过
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //User对应数据库中的用户表，是最终存储用户和密码的表
        //User user = userService.findByName(userName);
        //if (user == null) {
        //	throw new UsernameNotFoundException("UserName " + userName + " not found");
        //}

        //grantedAuthorities对应数据库中权限的表
        UserInfo userInfo = getUserInfo(new UserInfoSearch(userName));

        ArrayList<GrantedAuthority> authRoles = new ArrayList<GrantedAuthority>();
        authRoles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authRoles.add(new SimpleGrantedAuthority("ROLE_USER"));


        if (null != userInfo) {
            logger.info("------> this is userInfo :{} <-------", JSONObject.toJSONString(userInfo));
            return new OAuthUserDetails(userInfo, authRoles);
        } else {
            throw new UsernameNotFoundException("there's no user founded!");
        }
    }


    @Override
    public UserInfo getUserInfo(UserInfoSearch userInfoSearch) {
        try {

            userInfoSearch.setLogicClass("com.gang.antsso.easy.DataBaseLogic");

            OAuthUserInfo oAuthUserInfo = reflectionUtils.springClassLoad(userInfoSearch.getLogicClass());

            return oAuthUserInfo.getUserInfo(userInfoSearch);

        } catch (Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }
        return null;

    }
}
