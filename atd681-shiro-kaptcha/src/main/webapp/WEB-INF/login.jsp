<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="data:image/ico;base64,aWNv">
<title>登录页</title>
</head>
<body>
	
	<!-- 有登录错误信息时,根据异常显示对应的提示信息 -->
	<c:if test="${shiroLoginFailure != null}">
		<c:if test="${shiroLoginFailure == 'org.apache.shiro.authc.UnknownAccountException'}">用户不存在</c:if>
		<c:if test="${shiroLoginFailure == 'org.apache.shiro.authc.IncorrectCredentialsException'}">密码不正确</c:if>
		<!-- 验证码异常 -->
		<!-- 在登录的Realm中验证码校验错误时会抛出相关异常 -->
		<c:if test="${shiroLoginFailure == 'com.atd681.shiro.kaptcha.CaptchaEmptyException'}">验证码为空</c:if>
		<c:if test="${shiroLoginFailure == 'com.atd681.shiro.kaptcha.CaptchaErrorException'}">验证码不正确</c:if>
	</c:if>
	<!-- 无登录错误时 -->
	<c:if test="${shiroLoginFailure == null}">你访问的页面需要先进行登录</c:if>
	
	<form action="/login" method="post">
		<input type="text" name="username" placeholder="用户名" value="" />
		<input type="password" name="password" placeholder="密码" value="" />
		<!-- 增加验证码输入框 -->
		<input type="text" name="captchaCode" placeholder="验证码" value="" />
		<input type="submit" value="立即登录" />
	</form>
	<!-- 验证码 -->
	<!-- 请求地址为在Web.xml中配置的Kaptcha内置的Servlet-->
	<!-- Kaptcha Servlet生成验证码保存至SESSION并将图片返回 -->
	<img src="/kaptcha" />
	
</body>
</html>