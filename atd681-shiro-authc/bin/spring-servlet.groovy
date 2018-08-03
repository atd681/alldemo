import org.springframework.web.servlet.view.InternalResourceViewResolver

beans
{

    xmlns context: "http://www.springframework.org/schema/context"
    xmlns mvc: "http://www.springframework.org/schema/mvc"

    // 扫描所有控制器
    context.'component-scan'('base-package': "com.atd681.shiro.authc")

    // 注解驱动
    mvc.'annotation-driven'()

    // JSP视图
    viewResolver(InternalResourceViewResolver) {
        prefix = "/WEB-INF"
        suffix = ".jsp"
    }

}
