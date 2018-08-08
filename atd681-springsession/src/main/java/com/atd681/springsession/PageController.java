package com.atd681.springsession;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 *
 * @author atd681
 * @since 2018年8月7日
 */
@Controller
public class PageController {

    /**
     * Session中设置值
     * 
     * @author atd681
     * @since 2018年8月1日
     */
    @RequestMapping("/value/set")
    @ResponseBody
    public String setSession(HttpSession session) {
        session.setAttribute("username", "dahuangfeng~~~");
        return "success";
    }

    /**
     * 从SESSION中取值
     * 
     * @author atd681
     * @since 2018年8月1日
     */
    @RequestMapping("/value/get")
    @ResponseBody
    public String getSessionValue(HttpSession session, ModelMap data) {
        return "SESSION_ID: " + session.getId() + " ----- USERNAME: " + session.getAttribute("username");
    }

}
