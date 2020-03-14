package com.gang.antsso.logic;

import com.alibaba.fastjson.JSONObject;
import com.gang.antsso.auth.api.entity.UserInfoSearch;
import com.gang.antsso.auth.api.to.UserInfo;
import com.gang.antsso.auth.api.type.AntAuthType;
import com.gang.antsso.lib.type.AuthType;
import com.gang.antsso.password.CommonPasswordService;
import com.gang.antsso.strategy.StrategyInvoke;
import com.gang.antsso.to.OAuthUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @Classname AuthLogic
 * @Description TODO
 * @Date 2020/1/12 13:08
 * @Created by zengzg
 */
@Component
public class OAuthUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Pattern BCRYPT_PATTERN = Pattern
            .compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

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

        logger.info("------> this is load  :{}<-------", userName);

        //grantedAuthorities对应数据库中权限的表
        //        UserInfo userInfo = strategyInvoke.getUserInfo(new UserInfoSearch(userName).setType(AntAuthType
        //        .EASY));
        UserInfo userInfo = strategyInvoke.getUserInfo(new UserInfoSearch(userName).setType(AntAuthType.VOCDE));

        if (!BCRYPT_PATTERN.matcher(userInfo.getPassword()).matches()) {
            logger.info("------> this password is unlike bcrypt <-------");
            userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        }

        // GET Roles
        ArrayList<GrantedAuthority> roles = userRolesLogic.getUserRolesByType();

        logger.info("------> this is :{} opt password :{} <-------", userInfo.getUsername(),
                userInfo.getPassword());

        if (null != userInfo) {
            logger.info("------> this is userInfo :{} <-------", JSONObject.toJSONString(userInfo));
            return new OAuthUserDetails(userInfo, roles);
        } else {
            throw new UsernameNotFoundException("there's no user founded!");
        }
    }


}
