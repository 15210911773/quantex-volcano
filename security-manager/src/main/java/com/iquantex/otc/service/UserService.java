package com.iquantex.otc.service;

import java.util.Map;

public interface UserService {

    /**
     * 登录
     * @param loginName
     * @param loginPassword
     * @return
     */
    Map<String, Object> userLogin(String loginName, String loginPassword);

}
