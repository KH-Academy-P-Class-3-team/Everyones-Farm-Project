<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>농부 회원 로그인</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/user.css">
</head>
<body>
<div class="farmer">
	<div class="member">농부 회원<br></div>
 	<input type="text" id="userid" name="userid" placeholder="  id"/><button class="login">로그인</button><br>
	<input type="password" id="userpw" name="userpw" placeholder="  ****"/><button class="login">회원가입</button><br> 
	<button class="find">아이디/비밀번호 찾기</button>
</div>
</body>
</html>