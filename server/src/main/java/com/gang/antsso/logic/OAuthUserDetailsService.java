package com.gang.antsso.logic;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.logic.OAuthUserInfo;
import com.gang.antsso.lib.to.UserInfo;
import com.gang.antsso.password.CommonPasswordService;
import com.gang.antsso.strategy.StrategyInvoke;
import com.gang.antsso.to.OAuthUserDetails;
import com.gang.common.lib.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Classname AuthLogic
 * @Description TODO
 * @Date 2020/1/12 13:08
 * @Created by zengzg
 */
@Component
public class OAuthUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserRolesLogic userRolesLogic;

    @Autowired
    private CommonPasswordService commonPasswordService;

    @Autowired
    private StrategyInvoke strategyInvoke;

    /**
     * spring会将MyUserDetails中的密码与session中的密码比较，否是验证通过
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        logger.info("------> this is load <-------");
        //User对应数据库中的用户表，是最终存储用户和密码的表
        //User user = userService.findByName(userName);
        //if (user == null) {
        //	throw new UsernameNotFoundException("UserName " + userName + " not found");
        //}

        //grantedAuthorities对应数据库中权限的表
        UserInfo userInfo = strategyInvoke.getUserInfo(new UserInfoSearch(userName));

        // GET Roles
        ArrayList<GrantedAuthority> roles = userRolesLogic.getUserRolesByType();

        String password = commonPasswordService.getPassword("");
        logger.info("------> this is opt password :{} <-------", password);

        if (null != userInfo) {
            logger.info("------> this is userInfo :{} <-------", JSONObject.toJSONString(userInfo));
            return new OAuthUserDetails(userInfo, roles);
        } else {
            throw new UsernameNotFoundException("there's no user founded!");
        }
    }


}
