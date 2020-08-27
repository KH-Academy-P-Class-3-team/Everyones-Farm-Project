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
<!-- header, footer, main css 파일 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main_header.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main_main.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main_modal.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main_footer.css" />

<style type="text/css">
* {
	box-sizing: border-box;
}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/image-slider.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/main-weather.js"></script>
</head>
<body>

<!-- header -->
<header class="main__header">
	<div class="header__top">
		<div class="header__top-wrap">
			<div class="top__weather js-weather"></div>
			<div class="top__logo">
				<a href="<%=request.getContextPath() %>/"><img alt="logo" src="<%=request.getContextPath() %>/resources/img/everyonesfarm_logo.png"
					width="150"></a>
			</div>
			<div class="top__member-desc">
				<!-- 로그인 시 에는 추후에 추가 예정 -->
				<c:choose>
					<c:when test="${not empty loginUser }">
						<a href="<%=request.getContextPath() %>/user/logout">로그아웃</a><a href="#">마이페이지</a><a href="#"><i class="fas fa-shopping-cart"></i></a><a href="#"><i class="fas fa-search"></i></a>
					</c:when>
					<c:when test="${empty loginUser }">
						<a href="<%=request.getContextPath() %>/user/login.do">로그인</a><a href="<%=request.getContextPath() %>/user/usertos.do">회원가입</a><a href="#"><i class="fas fa-search"></i></a>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
	<nav class="header__menu">
		<ul id="menu__main">
			<li><a href="<%=request.getContextPath() %>/info">소개</a></li>
			<li><a href="#">먹거리</a>
				<ul class="menu__sub-food">
					<li><a href="#">제철 먹거리</a></li>
					<li><a href="#">일반 먹거리</a></li>
				</ul>
			</li>
			<li><a href="#">농장구경</a></li>
			<li><a href="#">체험</a>
				<ul class="menu__sub-activity">
					<li><a href="#">농장 체험</a></li>
					<li><a href="#">일손 돕기</a></li>
				</ul>
			</li>
			<li><a href="#">농업소식</a></li>
		</ul>
	</nav>
</header>
