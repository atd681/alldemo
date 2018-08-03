package com.atd681.shiro.authc;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 *
 * @author atd681
 * @since 2018年8月3日
 */
@Controller
public class PageController {

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

    /**
     * 访问A页面
     * 
     * @author atd681
     * @since 2018年8月3日
     */
    @RequestMapping("/index")
    public String toIndex() {
        return "/index";
    }

    /**
     * 访问A页面
     * 
     * @author atd681
     * @since 2018年8月3日
     */
    @RequestMapping("/page/a")
    public String toPageA(ModelMap map) {
        // Shiro提供的获取当前登录用户信息的静态方法
        // 用户信息对象为在Realm中保存的对象
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 获取用户ID,用户名
        map.put("userId", user.getUserId());
        map.put("userName", user.getUsername());

        return "/page_a";
    }

    /**
     * 访问N页面
     * 
     * @author atd681
     * @since 2018年8月3日
     */
    @RequestMapping("/page/n")
    public String toPageN() {
        return "/page_n";
    }

}
