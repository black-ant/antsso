package com.gang.antsso.auth.api.to;

import java.util.List;

/**
 * @Classname UserDetails
 * @Description TODO
 * @Date 2020/1/12 17:50
 * @Created by zengzg
 */

public abstract class AbstractUserDetails<T> extends UserInfo {

    public List<UserRolesTO> rolesList;

    public abstract List<UserRolesTO> changeRoles(List<T> t);


}
