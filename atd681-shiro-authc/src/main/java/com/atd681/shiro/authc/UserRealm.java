package com.atd681.shiro.authc;

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
