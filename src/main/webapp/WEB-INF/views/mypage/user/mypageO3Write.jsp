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
	width: 50%;
	margin-left: 150px;
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

.ckck {
	width: 800px;
	height: 400px;
}

#p_content {
	width: 100%;
	height: 100%;
}
</style>

<!-- ckeditor 4 -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/ckeditor/contents.css">
<!-- <script src="https://cdn.ckeditor.com/4.12.1/standard-all/ckeditor.js"></script> -->
<script type="text/javascript"
	src="<%=request.getContextPath() %>/resources/ckeditor/ckeditor.js"></script>
﻿

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div class="headSpace" style="margin-top:200px;"></div>
	<!-- Page Content -->
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
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/deleteId">회원
							탈퇴</a>
					</div>
					<div class="panel-body" style="font-weight: bold;">
						<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List">1대
							1 문의</a>
					</div>
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/myActive">활동
							신청 현황</a>
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


				<!-- 에디터 포함 작성  -->
				<div class="container">
					<div class="content" style="width: 70%">

						<div class="row justify-content-md-center">
							<div class="col-sm-9">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<label class="input-group-text">제목</label>
									</div>
									<input type="text" class="form-control">
								</div>
							</div>
						</div>

						<hr>

						<div class="row justify-content-md-center">
							<div class="col_c" style="margin-bottom: 30px">
								<div class="input-group ckck">
									<textarea class="form-control" id="p_content"></textarea>
									<script>
									CKEDITOR.replace('p_content',{
										filebrowserUploadUrl:'<%=request.getContextPath() %>/resources/ckeditor/ckeditor.js'
									}); // 에디터로 생성
									</script>
								</div>
							</div>
						</div>


						<div class="row justify-content-md-center">
							<button type="submit" class="btn btn-outline-secondary"
								style="width: 20%; font-weight: bold">등 록</button>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>







<%@include file="../../include/footer.jsp" %>