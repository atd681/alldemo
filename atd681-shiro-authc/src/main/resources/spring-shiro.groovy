import org.apache.shiro.spring.LifecycleBeanPostProcessor
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager

import com.atd681.shiro.authc.UserRealm;


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
            "/page/n" : "anon", // /page/n不需要登录即可访问
            "/logout_success.jsp" : "anon", // 登出成功页不需要认证
            "/logout" : "logout", // 登出使用logout过滤器
            "/**": "authc" // 其余所有页面需要认证(authc为认证过滤器)
        ]

    }

    // 安全管理器
    securityManager(DefaultWebSecurityManager) {  realm = ref("userRealm")  }

    // 定义Realm
    userRealm(UserRealm)

    // 手动定义Logout过滤器
    // 未定义时Shiro会通过Spring自动加载
    logout(LogoutFilter){
        redirectUrl = "/logout_success.jsp"
    }

}
