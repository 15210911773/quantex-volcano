package com.iquantex.otc.service;

import com.iquantex.otc.model.SysPermission;
import com.iquantex.otc.model.SysRole;
import com.iquantex.otc.model.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

    List<SysRole> findRoleListByUser(UserInfo userInfo);

    List<SysPermission> findPermissionsByRole(SysRole role);
}
