package com.gang.antsso.lib.to;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDetails
 * @Description TODO
 * @Date 2020/1/12 17:50
 * @Created by zengzg
 */

public abstract class AbstractUserDetails<T> extends UserInfo {

    public List<UserRoles> rolesList;

    public abstract List<UserRoles> changeRoles(List<T> t);


}
