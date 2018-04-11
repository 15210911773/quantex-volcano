package com.iquantex.otc.service.impl;

import com.iquantex.otc.mapper.UserMapper;
import com.iquantex.otc.model.SysPermission;
import com.iquantex.otc.model.SysRole;
import com.iquantex.otc.model.UserInfo;
import com.iquantex.otc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserInfo findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<SysRole> findRoleListByUser(UserInfo userInfo) {
        return userMapper.findRoleListByUser(userInfo);
    }

    @Override
    public List<SysPermission> findPermissionsByRole(SysRole role) {
        return userMapper.findPermissionsByRole(role);
    }
}
