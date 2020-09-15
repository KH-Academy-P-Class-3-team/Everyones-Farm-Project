<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp"%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
.input-group {
	margin-top: 30px;
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

.btn {
	width: 90px;
	height: 50px;
	margin-right: 5px;
}
</style>

<!-- jquery -->
﻿

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top: 200px"></div>

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h3 class="my-4 text-left">일대일 문의</h3>
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
					<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List"style="font-weight: bold;">1대
						1 문의</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/myActive">활동
						신청 현황</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/deleteId"
						style="color: #ccc;">회원 탈퇴</a>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">주문</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">장바구니</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/orderList">구매
						목록</a>
				</div>
			</div>
			<c:if test="${farmerInfo ne null }">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/mypage/user/basket">농업인
						</a>
					</div>
					<div class="panel-body">
						<a href="#">내 정보</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/selllist">판매 목록</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/dailyLoglist">영농 일지</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/activitylist" >체험
							신청내역</a>
					</div>
				</div>
			</c:if>
		</div>
		<c:if test="${userInfo ne null }">
		<div class="col-lg-1">
			<hr>
			<h2>${one.title}</h2>
			<hr>
			<div class="info">
				<span>게시글번호 : ${one.questionNo} <br></span> <span>등록일 :
					${one.regDate} |</span> <span>작성자 : ${one.userNo}</span>
			</div>
			<hr>
			<div class="content">${one.content }</div>
			<hr>
			<c:if test="${answer.ANSWERED_NO ne null }">
			<h2>${answer.TITLE}</h2>
			<hr>
			<div class="info">
				<span>게시글번호 : ${answer.ANSWERED_NO} <br></span> <span>등록일 :
					${answer.REG_DATE} |</span> <span>작성자 : ${answer.ADMIN_NO}</span>
			</div>
			<div class="content">${answer.CONTENT }</div>
			<hr>
			</c:if>
			<div class="nearcontent">
				<table class="table">
					<tr>
						<td>페이지 이동</td>
						<td>문의 번호</td>
						<td>제목</td>
						<td>작성자 번호</td>
						<td>답변 확인</td>
					</tr>
					<c:if test="${total.MAX ne one.questionNo }">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">
									<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
									이전 페이지
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.isAnswered }</a></td>
						</tr>
					</c:if>
					<c:if test="${total.MIN ne one.questionNo }">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">
									<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
									다음 페이지
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.isAnswered }</a></td>
						</tr>
					</c:if>
				</table>
			</div>
			<div>
				<button class="btn btn btn-success pull-right" type="button"
					onclick="javascript:location.href='mypageO3List'">뒤로가기</button>
				<c:if test="${userInfo.userNo eq one.userNo }">
					<button class="btn btn-warning pull-right" type="button"
						onclick="javascript:location.href='deleteO3?QUESTION_NO=${one.questionNo}'">삭제</button>
				</c:if>
			</div>
		</div>
		</c:if>
		<c:if test="${farmerInfo ne null }">
		<div class="col-lg-1">
			<hr>
			<h2>${one.title}</h2>
			<hr>
			<div class="info">
				<span>게시글번호 : ${one.questionNo} <br></span> <span>등록일 :
					${one.regDate} |</span> <span>작성자 : ${one.farmerNo}</span>
			</div>
			<hr>
			<div class="content">${one.content }</div>
			<hr>
			<c:if test="${answer.ANSWERED_NO ne null }">
			<h2>${answer.TITLE}</h2>
			<hr>
			<div class="info">
				<span>게시글번호 : ${answer.ANSWERED_NO} <br></span> <span>등록일 :
					${answer.REG_DATE} |</span> <span>작성자 : ${answer.ADMIN_NO}</span>
			</div>
			<div class="content">${answer.CONTENT }</div>
			<hr>
			</c:if>
			<div class="nearcontent">
				<table class="table">
					<tr>
						<td>페이지 이동</td>
						<td>문의 번호</td>
						<td>제목</td>
						<td>작성자 번호</td>
						<td>답변 확인</td>
					</tr>
					<c:if test="${total.MAX ne one.questionNo }">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">
									<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
									이전 페이지
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.isAnswered }</a></td>
						</tr>
					</c:if>
					<c:if test="${total.MIN ne one.questionNo }">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">
									<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
									다음 페이지
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.isAnswered }</a></td>
						</tr>
					</c:if>
				</table>
			</div>
			<div>
				<button class="btn btn btn-success pull-right" type="button"
					onclick="javascript:location.href='mypageO3List'">뒤로가기</button>
				<c:if test="${farmerInfo.farmerNo eq one.farmerNo }">
					<button class="btn btn-warning pull-right" type="button"
						onclick="javascript:location.href='deleteO3?QUESTION_NO=${one.questionNo}'">삭제</button>
				</c:if>
			</div>
		</div>
		</c:if>
	</div>
</div>







<%@include file="../../include/footer.jsp"%>
