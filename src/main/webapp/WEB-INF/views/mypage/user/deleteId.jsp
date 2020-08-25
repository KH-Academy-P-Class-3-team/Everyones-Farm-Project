<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<style type="text/css">
</style>
</head>
<body>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Welcome to Codevang</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<style type="text/css">
.input-group {
	margin-top: 30px;
}

div {
	text-align: center;
}
.col-lg-1{
	text-align: left;
	width : 50%;
	margin-left: 150px;
}
span{
	padding : 0;
}
.input-group{
	width : 400px;
}
label{
	padding-left: 0;
    text-align: left;
}
.btn-warning{
	width : 90px;
	height : 50px;
	margin-top: 30px;
    margin-right: 150px;
}
.emptyArea{
	height : 200px;
}
.glyphicon-alert{
	color : red;
}
</style>

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<body class="pt-5">
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h3 class="my-4 text-left">회원 정보 수정</h3>
				<hr>
				<div class="panel panel-default">
					<div class="panel-heading">회원</div>
					<div class="panel-body">회원정보 수정</div>
					<div class="panel-body">회원 탈퇴</div>
					<div class="panel-body">1대 1 문의</div>
					<div class="panel-body">활동 신청 현황</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">주문</h3>
					</div>
					<div class="panel-body">구매 목록</div>
					<div class="panel-body">장바구니</div>
				</div>

			</div>
			<div class="col-lg-1">
			<div class="emptyArea"></div>
			
				<h3><span class="glyphicon glyphicon-alert"></span>
				정말로 회원 탈퇴를 하시겠습니까? <br>그럼 비밀번호를 입력해주세요.</h3>
				<div class="ModifyUserInfo">

					<form action="delete/userId" method="post">
						<!-- 			아이디 -->
					
						<!-- 			비밀번호 -->
						<div class="input-group">
							<label for="inputName" class="col-lg-3 control-label">비밀번호</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon glyphicon glyphicon-lock"
									id="sizing-addon1"></span> <input type="password"
									class="form-control" placeholder="비밀번호"
									aria-describedby="sizing-addon1">
							</div>
						</div>
						
						


						<button type="submit" class="btn btn-warning">회원 탈퇴</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>