package com.iquantex.otc.interceptor;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestURI = request.getRequestURI();
        String[] strs = requestURI.split("/");

        String permission = "";
        for(int i = 0; i < strs.length; i++) {
            if(StringUtils.isNotBlank(permission)) {
                permission += ":" + strs[i];
            } else {
                permission += strs[i];
            }
        }

        if(SecurityUtils.getSubject().isPermitted(permission)) {
            return true;
        }

        response.getWriter().write("权限不够");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
