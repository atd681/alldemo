package com.atd681.shiro.authz;

// 用户
public class User {

    private Long userId; // 用户ID

    private String username; // 用户名

    private String password; // 密码

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
