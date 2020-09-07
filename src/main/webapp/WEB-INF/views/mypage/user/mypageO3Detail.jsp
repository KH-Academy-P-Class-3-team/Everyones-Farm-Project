<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp" %>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
.input-group {
	margin-top: 30px;
}

div {
	text-align: center;
}

.col-lg-1 {
	width: 70%;
}

span {
	padding: 0;
}

.input-group {
	width: 400px;
}

label {
	padding-left: 0;
	text-align: left;
}

.btn-warning {
	width: 90px;
	height: 50px;
	margin-top: 30px;
	margin-right: 150px;
}

.media-object {
	margin-left: 70px;
}

.panel-default {
	border: none;
}

.panel-default>.panel-heading {
	background-color: #D1E9CA;
	border: none;
	font-weight: bold;
	font-size: 17px;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
}

.info {
	text-align: left;
}
</style>

<!-- jquery -->﻿
<script type="text/javascript" src="jquery-3.4.1.min.js" ></script>
<!-- ckeditor 4 -->
<link rel="stylesheet" href="/ckeditor/contents.css">
<!-- <script src="https://cdn.ckeditor.com/4.12.1/standard-all/ckeditor.js"></script> -->
<script type="text/javascript" src="/ckeditor/ckeditor.js" ></script>﻿
<script >
CKEDITOR.replace('ckeditor'); // 에디터로 생성
</script >

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top:200px"></div>

	<!-- Page Content -->
<div class="headSpace" style="margin-top:200px;"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h3 class="my-4 text-left">1대 1 문의</h3>
				<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/mypage/user/modify">회원</a>
					</div>
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/modify">회원정보
							수정</a>
					</div>
					<div class="panel-body" style="font-weight: bold;">
						<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List">1대
							1 문의</a>
					</div>
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/myActive">활동
							신청 현황</a>
					</div>
					<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/deleteId" style="color : #ccc;">회원
						탈퇴</a>
				</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/mypage/user/orderList">주문</a>
					</div>
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/basket">장바구니</a>
					</div>
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/orderList">구매
							목록</a>
					</div>
				</div>

			</div>
			<div class="col-lg-1">
				<hr>
				<h2>${one.title}</h2>
				<hr>
				<div class="info">
					<span>게시글번호 : ${one.questionNo} <br></span> <span>등록일
						: ${one.regDate} |</span> <span>작성자 : ${one.userNo}</span>
				</div>
				<hr>
				<div class="content">
					${one.content }
					<hr>
				</div>
				<div class="nearcontent">
					<table class="table">

						
						<tr>
						<td>페이지 이동</td>
						<td>문의 번호</td>
						<td>제목</td>
						<td>작성자 번호</td>
						<td>답변 확인</td>
						</tr>
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">
								<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
								이전 페이지</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.isAnswered }</a></td>
						</tr>
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">
								<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
								다음 페이지</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.isAnswered }</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>






<%@include file="../../include/footer.jsp" %>
