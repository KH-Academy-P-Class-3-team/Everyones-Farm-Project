<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<style type="text/css">
.input-group {
	margin-top: 30px;
}

.col-lg-1 {
	width: 700px;
	height : 1000px;
}

.row{
	background-color: #ccc;
	height: 1000px; 
}
.panel-default{
	background-color: #ccc;
	border : none;
}
.panel-default>.panel-heading {
    background-color: #ccc;
    border: none;
    font-weight: bold;
    font-size : 17px;
}
.sumarry{
	width : 500px;
	height : 150px;
	background-color: white;
	text-align: center;
	margin-left: 100px;
}
.appliActList{
	margin-top : 50px;
	width : 100%;
	height : 300px;
	background-color: white;
	text-align: center;
}
<<<<<<< HEAD
.appliHelpList{
	margin-top : 50px;
	width : 100%;
	height : 300px;
=======


.appliHelpList {
	width: 100%;
	height: 350px;
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	background-color: white;
	text-align: center;
}
</style>
<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<body class="pt-5">
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<!-- 사이드 네비게이션 -->
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
					<div class="panel-heading">주문</div>
					<div class="panel-body">구매 목록</div>
					<div class="panel-body">장바구니</div>
				</div>

			</div>
<<<<<<< HEAD
			
			<div class="col-lg-1">
			
			<!-- 페이지 요약 -->	
				<div class="sumarry">
				<h1>안녕</h1>
				</div>
			
			<!-- 페이지 첫 AJAX 체험 농장 리스트 -->	
				<div class="appliActList">
				
				<h1>안녕</h1>
				</div>
				
			<!-- 페이지 두번째 AJAX 일손돕기 리스트 -->	
				<div class="appliHelpList">
				<h1>안녕</h1>
				
				</div>
			
=======

			<!-- 페이지 첫 AJAX 체험 농장 리스트 -->
			<span class="worrd">체험 농장</span> 신청 현황
			<div class="appliActList">
				<table class="table bux table-hover">
					<tr class="active">
						<td>체험명</td>
						<td>고객명(아이디)</td>
						<td>인원</td>
						<td>문의</td>
						<td>현황</td>
						<td>체험일자</td>
					</tr>
					<c:forEach items="${activeList1 }" var="list1">
						<c:if test="${list1.IS_HELP eq 0 }">
							<tr>
								<td><a
									href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list1.ACTIVITY_NO}">
										${list1.TITLE }</a></td>
								<td><a
									href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list1.ACTIVITY_NO}">
										${list1.USER_NAME}(${list1.USER_ID })</a></td>
								<td><a
									href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list1.ACTIVITY_NO}">
										${list1.PEOPLE }</a></td>
								<td><a
									href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list1.ACTIVITY_NO}">
										${list1.PHONE }</a></td>
								<td><a
									href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list1.ACTIVITY_NO}">
										<c:if test="${list1.IS_APPROVAL eq 0 }">
						미승인
						</c:if>
						 <c:if test="${list1.IS_APPROVAL eq 1 }">
						승인
						</c:if>
								</a></td>
								<td><a
									href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list1.ACTIVITY_NO}">
										${list1.ACTIVITY_DATE }</a></td>
							</tr>
						</c:if>
					</c:forEach>

				</table>
			</div>

			<!-- 페이지 두번째 AJAX 일손돕기 리스트 -->
			<span class="worrd">일손돕기</span>신청 현황
			<div class="appliHelpList">
				<table class="table bux">
					<tr class="active">
						<td>체험명</td>
						<td>고객명(아이디)</td>
						<td>인원</td>
						<td>문의</td>
						<td>현황</td>
					</tr>
					<c:forEach items="${activeList2}" var="list2">
						<c:if test="${list2.IS_HELP eq 1 }">
							<tr class="table-hover">
								<td>${list2.TITLE }</td>
								<td>${list2.USER_NAME}(${list2.USER_ID })</td>
								<td>${list2.PEOPLE }</td>
								<td>${list2.PHONE }</td>
								<td><c:if test="${list2.IS_APPROVAL eq 0 }">
						미승인
						</c:if> <c:if test="${list2.IS_APPROVAL eq 1 }">
						승인
						</c:if></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>

>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
			</div>
			
			
			
		</div>
	</div>







</body>
</html>