<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모두의 농장</title>

<!-- 파비콘 -->
<link rel="icon" type="image/png" href="<%=request.getContextPath() %>/resources/img/favicon.png" />
<!-- fontawesome cdn 링크 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />

<style type="text/css">
* {
	box-sizing: border-box;
}
/* 드래그 시 색상 변경 */
::selection{
	color: white;
	background: #68bb59;
}
</style>
<!-- header css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_header.css" />
<!-- footer css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_footer.css" />

<!-- jQuery cdn -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

</head>
<body>

<!-- header -->
<header class="admin__header">
	<div class="header__top">
		<div class="header__top-wrap">
			<div class="top__logo">
				<a href="<%=request.getContextPath() %>/"><img alt="logo" src="<%=request.getContextPath() %>/resources/img/everyonesfarm_logo.png"
					width="120"></a>
			</div>
			<div class="top__member-desc">
					<!-- 관리자 아이디 들어갈 예정 -->
					<span class="member-desc__name">누구누구님</span><a href="<%=request.getContextPath() %>/user/logout">로그아웃</a>
<%-- 				<c:if test="${not empty adminLogin }"> --%>
<%-- 					<span>누구누구님</span><a href="<%=request.getContextPath() %>/user/logout">로그아웃</a> --%>
<%-- 				</c:if> --%>
			</div>
		</div>
	</div>
	<nav class="header__menu">
		<ul id="amenu__main">
			<li><a href="<%=request.getContextPath() %>/">Home</a></li>
			<li><a href="#">회원관리</a>
				<ul class="menu__sub-member">
					<li><a href="#">일반 회원 관리</a></li>
					<li><a href="#">농업인 회원 관리</a></li>
					<li><a href="#">농업인 회원 신청 관리</a></li>
				</ul>
			</li>
			<li><a href="#">상품관리</a></li>
			<li><a href="#">고객센터</a>
				<ul class="menu__sub-qna">
					<li><a href="#">일반 회원 문의</a></li>
					<li><a href="#">농업인 회원 문의</a></li>
				</ul>
			</li>
			<li><a href="#">공지사항</a></li>
		</ul>
	</nav>
</header>
