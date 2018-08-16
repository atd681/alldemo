import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager

import com.atd681.shiro.authz.URLAuthorizationFilter
import com.atd681.shiro.authz.UserRealm


beans {

    // Shiro核心配置
    shiroFilter(ShiroFilterFactoryBean) {

        securityManager = ref("securityManager")

        // 登录URL(包括请求登录页和提交登录请求)
        loginUrl = "/login"

        // 默认登录成功后跳转的页面地址
        successUrl = "/index"

        // 配置URL规则
        // 有请求访问时Shiro会根据此规则找到对应的过滤器处理
        filterChainDefinitionMap = [
            "/unauthorized.jsp" : "anon", // 未授权页不需要授权即可访问
            "/logout" : "logout", // 登出使用logout过滤器
            "/login": "authc", // 登录页不配置授权
            "/**": "authc, authz" // 其余所有页面需要认证和授权(authc为认证过滤器, authz为授权过滤器)
        ]

    }

    // 配置自定义过滤器, 名称为authz
    // unauthorizedUrl: 用户无权限时重定向至该页面
    authz(URLAuthorizationFilter) {  unauthorizedUrl = "/unauthorized.jsp" }

    // 安全管理器
    securityManager(DefaultWebSecurityManager) { realm = ref("userRealm") }

    // 定义Realm
    userRealm(UserRealm)

}
