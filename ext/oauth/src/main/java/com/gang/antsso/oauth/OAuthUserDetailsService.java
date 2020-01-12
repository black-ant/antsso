package com.gang.antsso.oauth;

import com.gang.antsso.lib.to.UserInfo;
import com.gang.antsso.oauth.to.OAuthUserDetails;
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
public class OAuthUserDetailsService implements UserDetailsService {


    //@Autowired  //业务服务类
    //private UserService userService;

    private final static Set<UserInfo> users = new HashSet<>();

    static {
        users.add(new UserInfo("1", "test-user1", "123456"));
        users.add(new UserInfo("2", "test-user2", "123456"));
        users.add(new UserInfo("3", "test-user3", "123456"));
        users.add(new UserInfo("4", "test-user4", "123456"));
    }

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
        ArrayList<GrantedAuthority> authRoles = new ArrayList<GrantedAuthority>();
        authRoles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authRoles.add(new SimpleGrantedAuthority("ROLE_USER"));


        Optional<UserInfo> user = users.stream()
                .filter((u) -> u.getUsername().equals(userName))
                .findFirst();

        if (user.isPresent()) {
            return new OAuthUserDetails(user.get(), authRoles);
        } else {
            throw new UsernameNotFoundException("there's no user founded!");
        }


    }


}
