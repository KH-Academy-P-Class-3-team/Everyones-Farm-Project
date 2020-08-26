<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/find.css">
</head>
<body>
<div class="farmer">
	<div class="member">비밀번호 찾기<br></div>
 	<div class="findmem">
 	<div class="findinput"><span class="inp">아이디</span> <input type="text" id="userid" name="userid" class="find"/></div><br>
	<div class="findinput">이메일 <input type="text" id="useremail" name="useremail" placeholder="  ******@*****.***" class="find"/> </div><br>
	<button class="find">아이디찾기</button>
 	</div>
</div>
</body>
</html>