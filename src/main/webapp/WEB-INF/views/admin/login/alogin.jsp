<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin_header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/login/login-form.css" />

<div class="wrapper">
	<!-- login page 꾸미기~ -->
	<main class="login__main">
		<div class="main__title">
			<span class="main__title-span">관리자 로그인</span>
		</div>
		<div class="main__login-form">
			<!-- 로그인 폼 -->
			<form action="<%=request.getContextPath() %>/admin/login" method="post" class="lform" id="login-form">
				<ul class="lform__list">
					<li class="lform__list-item">
					<label for="adminId">아이디</label>
					<input type="text" name="adminId" id="adminId" placeholder="*****" />
					</li>
					<li class="lform__list-item">
					<label for="adminPw">비밀번호</label>
					<input type="password" name="adminPw" id="adminPw" placeholder="*****" />
					</li>
					<li class="lform__list-item">
					<div id="login-btn" class="list-item__login-btn">관리자 로그인</div>
					</li>
				</ul>
			</form>
		</div>
	</main>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/login/admin-login.js"></script>
<%@include file="../include/admin_footer.jsp" %>