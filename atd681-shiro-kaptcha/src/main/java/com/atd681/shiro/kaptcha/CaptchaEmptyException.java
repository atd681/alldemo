package com.atd681.shiro.kaptcha;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 自定义验证码为空异常
 * AuthenticationException为Shiro认证错误的异常,不同错误类型继承该异常即可
 * 
 * @author atd681
 * @since 2018年8月13日
 */
public class CaptchaEmptyException extends AuthenticationException {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 2142849449766969022L;

}
