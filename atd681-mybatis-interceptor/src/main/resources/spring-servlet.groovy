import org.springframework.web.servlet.view.InternalResourceViewResolver

beans {

    xmlns context: "http://www.springframework.org/schema/context"
    xmlns mvc: "http://www.springframework.org/schema/mvc"
    xmlns tx: "http://www.springframework.org/schema/tx"

    // 扫描所有控制器
    context.'component-scan'('base-package': "com.atd681.mybatis.interceptor")

    // 注解驱动
    mvc.'annotation-driven'()

    // 配置事务在控制器中
    tx.'annotation-driven'()

    // JSP视图
    viewResolver(InternalResourceViewResolver) {
        prefix = "/WEB-INF"
        suffix = ".jsp"
    }

}
