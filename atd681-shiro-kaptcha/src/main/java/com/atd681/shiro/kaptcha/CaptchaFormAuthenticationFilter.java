package com.atd681.shiro.kaptcha;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 自定义认证过滤器
 *
 * @author zbq
 * @since 2018年8月13日
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 构造Token,重写Shiro构造Token的方法,增加验证码
     * 
     * @param username 用户名
     * @param password 密码
     * @param request 请求
     * @param response 响应
     * @return 带验证码的Token
     * 
     * @see org.apache.shiro.web.filter.authc.AuthenticatingFilter#createToken(java.lang.String, java.lang.String,
     *      javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     * 
     * @author atd681
     * @since 2018年8月13日
     */
    @Override
    protected AuthenticationToken createToken(String username, String password, ServletRequest request, ServletResponse response) {
        // 获取登录请求中用户输入的验证码
        String captchaCode = request.getParameter("captchaCode");
        // 返回带验证码的Token,Token会被传入Realm, 在Realm中可以取得验证码
        return new CaptchaToken(username, password, captchaCode);
    }

}
