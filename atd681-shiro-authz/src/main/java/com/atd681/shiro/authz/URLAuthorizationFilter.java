package com.atd681.shiro.authz;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 自定义基于URL的授权过滤器
 * 通过用户访问的URL,从数据库中查询用户是否有访问该URL的权限
 */
public class URLAuthorizationFilter extends AuthorizationFilter {

    /**
     * 是否允许访问资源
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        // 获取访问的URL
        String requestUrl = WebUtils.toHttp(request).getRequestURI();

        // 判断用户是否有权限访问该URL
        // 调用isPermitted方法时Shiro会通过Realm获取用户拥有的权限集合
        // 并判断URL是否在权限集合中, 如果在权限集合中返回true
        return getSubject(request, response).isPermitted(requestUrl);

    }

}
