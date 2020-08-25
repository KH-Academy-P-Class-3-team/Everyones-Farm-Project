<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/login.css">
</head>
<body>
<div class="farmer">
	<div class="mfarmer">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/man.png" /></div>
	<div class="login">
	<button class="find" onclick="<%=request.getContextPath() %>/user/userlogin.do">아이디 찾기</button><br>
	<button class="find" onclick="">비밀번호 찾기</button>
	</div>
	<div class="wfarmer">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" /></div>
</div>
</body>
</html>