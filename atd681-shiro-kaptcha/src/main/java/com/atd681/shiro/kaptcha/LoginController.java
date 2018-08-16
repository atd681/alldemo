package com.atd681.shiro.kaptcha;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 *
 * @author atd681
 * @since 2018年8月3日
 */
@Controller
public class LoginController {

    /**
     * 获取验证码
     * 
     * @author atd681
     * @since 2018年8月13日
     */
    @GetMapping("/kaptcha/get")
    @ResponseBody
    public String getKaptcha(HttpSession session) {
        // Kaptcha生成验证后保存SESSION中的KEY为KAPTCHA_SESSION_KEY
        return (String) session.getAttribute("KAPTCHA_SESSION_KEY");
    }

    /**
     * 访问A页面
     * 
     * @author atd681
     * @since 2018年8月3日
     */
    @GetMapping("/login")
    public String toLogin() {
        return "/login";
    }

    /**
     * 处理登录请求
     * 
     * @return
     *
     * @author atd681
     * @since 2018年8月3日
     */
    @PostMapping("/login")
    public String loginFail() {
        return "/login";
    }

}
