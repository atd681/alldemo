package com.atd681.springsession;

import javax.servlet.http.HttpServletRequest;
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
     * 获取部署项目的Tomcat端口号
     * 
     * @author atd681
     * @since 2018年8月9日
     */
    @RequestMapping("/port/get")
    @ResponseBody
    public String getPort(HttpServletRequest request) {
        return String.valueOf(request.getLocalPort());
    }

    /**
     * 获取部署项目的SESSION ID
     * 
     * @author atd681
     * @since 2018年8月9日
     */
    @RequestMapping("/sessionid/get")
    @ResponseBody
    public String getSessionId(HttpServletRequest request) {
        int port = request.getLocalPort(); // 端口
        String sessionId = request.getSession().getId(); // SESSION ID
        return "port: " + port + ", session id: " + sessionId;
    }

}
