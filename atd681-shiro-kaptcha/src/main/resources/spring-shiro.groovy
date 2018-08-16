import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager

import com.atd681.shiro.kaptcha.CaptchaFormAuthenticationFilter
import com.atd681.shiro.kaptcha.UserRealm


beans {

    // Shiro核心配置
    shiroFilter(ShiroFilterFactoryBean) {

        securityManager = ref("securityManager")

        // 登录URL(包括请求登录页和提交登录请求)
        loginUrl = "/login"

        // 默认登录成功后跳转的页面地址
        successUrl = "/login_success.jsp"

        // 配置URL规则
        // 有请求访问时Shiro会根据此规则找到对应的过滤器处理
        filterChainDefinitionMap = [
            "/kaptcha" : "anon", // 验证码不需要登录即可访问
            "/kaptcha/get" : "anon", // 获取验证码不需要登录即可访问
            "/login_success.jsp" : "anon", // 登录成功页不需要认证
            "/**": "authc" // 其余所有页面需要认证(使用自定义的authc为过滤器)
        ]

    }

    // 使用自定义的表单认证过滤器
    // 该过滤器中重写了Shiro的创建Token方法(增加了验证码)
    // 未定义名为authc的过滤器时会使用Shiro自带的,已定义则使用自定义的过滤器
    authc(CaptchaFormAuthenticationFilter)
    
    // 登出过滤器
    logout(LogoutFilter){
        redirectUrl = "/login"
    }

    // 安全管理器
    securityManager(DefaultWebSecurityManager) { realm = ref("userRealm") }

    // 定义Realm
    userRealm(UserRealm)


}
