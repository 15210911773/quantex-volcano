package com.iquantex.otc.config;

import com.google.common.collect.Maps;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        logger.info("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        //注意过滤器配置顺序 不能颠倒
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        filterChainDefinitionMap.put("/logout", "logout");
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/unauth");
        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index");

        return shiroFilterFactoryBean;
    }

}
