<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ tagliburi ="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="data:image/ico;base64,aWNv">
<title>PAGE_B</title>
</head>
<body>
	PAGE_B, 当前登录用户ID: ${userId}, 用户名: ${userName}
	<br>
	<a href="/logout">登出</a> 
</body>
</html>