package com.atd681.shiro.kaptcha;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

// 自定义查询用户信息的Realm
public class UserRealm extends AuthenticatingRealm {

    // 获取用户信息的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 在自定义的认证过滤器中将验证码保存至KaptchaCodeToken中
        // 此处的Token就是认证过滤器中实例化的Token,可以直接强制转换
        CaptchaToken captchaToken = (CaptchaToken) token;

        // 获取用户在登录页面输入的验证码
        String loginCaptcha = captchaToken.getCaptchaCode();

        // 验证码未输入
        if (loginCaptcha == null || "".equals(loginCaptcha)) {
            // 抛出自定义异常(继承AuthenticationException), Shiro会捕获AuthenticationException异常
            // 发现该异常时认为登录失败,执行登录失败逻辑,登录失败页中可以判断如果是CaptchaEmptyException时为验证码为空
            throw new CaptchaEmptyException();
        }

        // 获取SESSION中的验证码
        // Kaptcha在生成验证码时会将验证码放入SESSION中
        // 默认KEY为KAPTCHA_SESSION_KEY, 可以在Web.xml中配置
        String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute("KAPTCHA_SESSION_KEY");

        // 比较登录输入的验证码和SESSION保存的验证码是否一致
        if (!loginCaptcha.equals(sessionCaptcha)) {
            // 抛出自定义异常(继承AuthenticationException), Shiro会捕获AuthenticationException异常
            // 发现该异常时认为登录失败,执行登录失败逻辑,登录失败页中可以判断如果是CaptchaEmptyException时为验证码错误
            throw new CaptchaErrorException();
        }

        // -----------------------------------------------------------------
        // 以下是atd681-shiro-authc中的登录逻辑
        // -----------------------------------------------------------------

        // 登录用户名
        // Shiro会将提交登录传入的用户名和密码封装到UsernamePasswordToken中
        String username = ((UsernamePasswordToken) token).getUsername();

        // 根据用户名从数据库或其他存储中查询用户信息
        // 模拟数据库查询, 返回用户信息
        User dbUser = getUser(username);

        // 用户不存在,当返回null时Shiro会认为用信息不存在
        if (dbUser == null) {
            return null;
        }

        // 将查询到用户信息返回给Shiro
        // 参数1: Shiro会将该参数作为当前登录用户的信息保存,随时可取
        // 参数2: 当前用户的密码,Shiro使用该参数和提交登录传递的密码进行判断
        // 参数3: Realm名称,暂不处理
        return new SimpleAuthenticationInfo(dbUser, dbUser.getPassword(), "");
    }

    // 模拟根据用户名在数据库查询用户信息
    private User getUser(String username) {
        // 使用"atd681"作为登录密码才能查到信息
        if (!"atd681".equals(username)) {
            return null;
        }

        User dbUser = new User();
        dbUser.setUserId(1L);
        dbUser.setUsername(username);
        dbUser.setPassword("123");

        return dbUser;
    }

}
