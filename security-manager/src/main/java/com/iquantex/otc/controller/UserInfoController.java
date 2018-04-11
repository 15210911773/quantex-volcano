package com.iquantex.otc.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @RequestMapping("/userList")
    public String userList() {
        if(SecurityUtils.getSubject().hasRole("admin")) {
            return "用户管理";
        }

        return "权限不够";
    }

    @RequestMapping("/userAdd")
    public String userAdd() {
        if(SecurityUtils.getSubject().hasRole("admin1")) {
            return "用户添加";
        }

        return "权限不够";
    }

    @RequestMapping("/userDel")
    public String userDel() {
        return "用户删除";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "你好";
    }

}