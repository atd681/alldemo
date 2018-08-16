<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ tagliburi ="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="data:image/ico;base64,aWNv">
<title>PAGE_A</title>
</head>
<body>
	系统菜单:
	
	<!-- 
		该标签根据name值判断当前用户是否有该页面的访问权限
		无权限时不显示该链接(调用subject.isPermitted方法进行验证)
	 -->
	<shiro:hasPermission name="/page/a">
		<a href="/page/a">A</a>
	</shiro:hasPermission>
	<shiro:hasPermission name="/page/b">
		<a href="/page/b">B</a>
	</shiro:hasPermission>
	<shiro:hasPermission name="/page/x">
		<a href="/page/x">X</a>
	</shiro:hasPermission>
	
	
	<br> PAGE_A, 当前登录用户ID: ${userId}, 用户名: ${userName}

	<a href="/logout">登出</a>
</body>
</html>