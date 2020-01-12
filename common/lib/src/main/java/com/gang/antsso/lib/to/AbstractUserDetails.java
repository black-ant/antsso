package com.gang.antsso.lib.to;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDetails
 * @Description TODO
 * @Date 2020/1/12 17:50
 * @Created by zengzg
 */

public abstract class AbstractUserDetails<T> {

    public String userid;
    public String username;

    public String password;
    public String token;

    public List<UserRoles> rolesList;

    public abstract List<UserRoles> changeRoles(List<T> t);


}
