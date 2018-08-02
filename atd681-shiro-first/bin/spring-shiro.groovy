import org.apache.shiro.spring.LifecycleBeanPostProcessor
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager


beans {

    // Shiro核心配置
    shiroFilter(ShiroFilterFactoryBean) {
        securityManager = ref("securityManager")
        // 配置URL规则
        // 有请求访问时Shiro会根据此规则找到对应的过滤器处理
        filterChainDefinitionMap = [
            "/page/n" : "anon", // /page/n不需要登录即可访问
            "/**": "authc" // 其余所有页面需要认证(authc为认证过滤器)
        ]
    }

    // 安全管理器
    securityManager(DefaultWebSecurityManager)

}
