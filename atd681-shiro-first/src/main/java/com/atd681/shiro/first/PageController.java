package com.atd681.shiro.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 *
 * @author atd681
 * @since 2018年8月1日
 */
@Controller
public class PageController {

    /**
     * 访问A页面
     * 
     * @author atd681
     * @since 2018年8月1日
     */
    @RequestMapping("/page/a")
    public String toPageA() {
        return "/page_a";
    }

    /**
     * 访问N页面
     * 
     * @author atd681
     * @since 2018年8月1日
     */
    @RequestMapping("/page/n")
    public String toPageN() {
        return "/page_n";
    }

}
