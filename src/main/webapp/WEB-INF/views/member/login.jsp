<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/login.css">

<%@include file="../include/header.jsp" %>



<div style="clear: both; margin-top: 200px;"></div>

<main class="login-wrap">
	<div class="farmer">
		<div class="mfarmer">
		<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/man.png" class="social"/></div>
		<div class="login">
		<button class="userlogin" onclick="location.href='<%=request.getContextPath() %>/user/userlogin.do'">일반 사용자 로그인</button><br>
		<button class="userlogin" onclick="">농부 사용자 로그인</button>
		</div>
		<div class="wfarmer">
		<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" class="social"/></div>
	</div>
</main>
<%@include file="../include/footer.jsp" %>