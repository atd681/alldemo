package com.atd681.shiro.kaptcha;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 扩展Shiro登录表单Token,增加验证码字段
 *
 * @author atd681
 * @since 2018年8月13日
 */
public class CaptchaToken extends UsernamePasswordToken {

    // 序列化ID
    private static final long serialVersionUID = -2804050723838289739L;

    // 验证码
    private String captchaCode;

    /**
     * 构造函数
     *
     * @param username 用户名
     * @param password 密码
     * @param kaptchaCode 验证码
     *
     * @author atd681
     * @since 2018年8月13日
     */
    public CaptchaToken(String username, String password, String captchaCode) {
        // 父类UsernamePasswordToken的构造函数,后两个参数暂不需要, 不设置
        super(username, password, false, "");
        this.captchaCode = captchaCode;
    }

    /**
     * 获取验证码
     * 
     * @return 验证码
     *
     * @author zbq
     * @since 2018年8月13日
     */
    public String getCaptchaCode() {
        return captchaCode;
    }

}
