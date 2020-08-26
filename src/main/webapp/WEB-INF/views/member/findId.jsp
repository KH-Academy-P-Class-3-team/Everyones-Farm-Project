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
	<div class="member">아이디 찾기<br></div>
 	<div class="findmem">
 	<div class="findinput"><span class="inp">이름</span> <input type="text" id="username" name="username" class="find"/></div><br>
	<div class="findinput">전화번호 <input type="text" id="userphone" name="userphone" placeholder="  ***-****-****" class="find"/> </div><br>
	<button class="find">아이디찾기</button>
 	</div>
</div>
</body>
</html>