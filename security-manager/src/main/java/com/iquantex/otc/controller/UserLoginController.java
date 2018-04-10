package com.iquantex.otc.controller;

import com.iquantex.otc.service.UserService;
import com.iquantex.web.framework.bean.ResultObj;
import com.iquantex.web.framework.controller.BaseWebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v0/sys")
public class UserLoginController extends BaseWebController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param loginName
     * @param loginPassword
     * @return
     */
    ResultObj userLogin(String loginName, String loginPassword) {
        Map<String, Object> result = userService.userLogin(loginName, loginPassword);

        return successReturn(result);
    }

}
