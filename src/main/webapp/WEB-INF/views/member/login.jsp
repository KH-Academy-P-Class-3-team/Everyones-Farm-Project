<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/login.css">

<%@include file="../include/header.jsp" %>

<style type="text/css">
.main__footer {
    /* width: 980px; */
    margin: 0 auto;
    padding: 50px 0;
    display: flex;
    flex-direction: column;
    /* margin-top: 50px; */
    background: #605759;
}
</style>

<div style="clear: both; margin-top: 200px;"></div>

<main class="login-wrap">
<div class="alllogin">
	<img alt="farm" src="<%=request.getContextPath()%>/resources/image/member/farm.png" class="farmimage"/>
	<div class="farmer">
		<div class="mfarmer">
		<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/man.png" class="social"/></div>
		<div class="login">
		<button class="userlogin" onclick="location.href='<%=request.getContextPath() %>/user/userlogin.do'">일반 사용자 로그인</button><br>
		<button class="userlogin" onclick="location.href='<%=request.getContextPath() %>/farmer/farmerlogin.do'">농부 사용자 로그인</button>
		</div>
		<div class="wfarmer">
		<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" class="social"/></div>
	</div>
</div>
</main>
<%@include file="../include/footer.jsp" %>