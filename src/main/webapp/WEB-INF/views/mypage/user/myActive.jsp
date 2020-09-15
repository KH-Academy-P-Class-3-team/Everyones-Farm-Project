<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp"%>

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
	height: 1000px;
}

.row {
	height: 1000px;
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

.sumarry {
	width: 500px;
	height: 150px;
	background-color: white;
	text-align: center;
	margin-left: 100px;
	margin-bottom: 50px;
}

.appliActList {
	margin-bottom: 50px;
	width: 100%;
	height: 350px;
	background-color: white;
	overflow: scroll;
	overflow-x: hidden;
}

.appliHelpList {
	width: 100%;
	height: 350px;
	background-color: white;
	overflow: scroll;
	overflow-x: hidden;
}

.userInform {
	border: 2px solid black;
	width: 100%;
	height: 100%;
}

.userName {
	border-right: 1px solid #ccc;
}

.sessionName {
	color: green;
	font-size: large;
	font-weight: bold;
}

.selfIcon {
	text-align: left;
	border: 1px solid white;
	border-radius: 7px;
	color: white;
	background-color: lime;
	padding: 3px;
	margin-right: 100px;
	margin-bottom: 10px;
}

.bux {
	width: 100%;
}

.worrd {
	font-weight: bold;
	color: lime;
	font-size: large;
}
</style>
<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top: 200px"></div>

<!-- Page Content -->
<div class="container">
	<div class="row">
		<!-- 사이드 네비게이션 -->
		<div class="col-lg-3">
			<h3 class="my-4 text-left">활동 현황</h3>
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
					<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List">1대
						1 문의</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/myActive" style="font-weight: bold;">활동
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
						<a href="/farmapp/mypage/activitylist">체험
							신청내역</a>
					</div>

				</div>
			</c:if>
		</div>
		<c:if test="${userInfo ne null }">
			<div class="col-lg-1">
				<!-- 페이지 요약 -->
				<div class="sumarry">
					<table class="userInform">
						<tr>
							<td class="userImg"></td>
							<td class="userName">
								<!-- 농부세션 확인해서 c:if 추가 -->
								<div>
									<span class="selfIcon">소비자</span>
								</div> <span class="sessionName">${userInfo.userName } </span> 님 안녕하세요
							</td>
							<td class="userActive"><h5>주문현황</h5> <br> ${res }</td>
						</tr>
					</table>

				</div>
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
						</c:if> <c:if test="${list1.IS_APPROVAL eq 1 }">
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
						<c:forEach items="${activeList1}" var="list2">
							<c:if test="${list2.IS_HELP eq 1 }">
								<tr class="table-hover">
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.TITLE }</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.USER_NAME}(${list2.USER_ID })</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.PEOPLE }</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.PHONE }</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											<c:if test="${list2.IS_APPROVAL eq 0 }">
						미승인
						</c:if> <c:if test="${list2.IS_APPROVAL eq 1 }">
						승인
						</c:if>
									</a></td>
								</tr>
							</c:if>
						</c:forEach>
					</table>

				</div>
			</div>
		</c:if>
		<c:if test="${farmerInfo ne null }">
			<div class="col-lg-1">
				<!-- 페이지 요약 -->
				<div class="sumarry">
					<table class="userInform">
						<tr>
							<td class="userImg"></td>
							<td class="userName">
								<!-- 농부세션 확인해서 c:if 추가 -->
								<div>
									<span class="selfIcon">소비자</span>
								</div> <span class="sessionName">${farmerInfo.name } </span> 님 안녕하세요
							</td>
							<td class="userActive"><h5>주문현황</h5> <br> ${res }</td>
						</tr>
					</table>

				</div>
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
											${list1.NAME}</a></td>
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
						</c:if> <c:if test="${list1.IS_APPROVAL eq 1 }">
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
						<c:forEach items="${activeList1}" var="list2">
							<c:if test="${list2.IS_HELP eq 1 }">
								<tr class="table-hover">
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.TITLE }</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.USER_NAME}(${list2.USER_ID })</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.PEOPLE }</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											${list2.PHONE }</a></td>
									<td><a
										href="<%=request.getContextPath()%>/activity/activityDetail.do?activityNo=${list2.ACTIVITY_NO}">
											<c:if test="${list2.IS_APPROVAL eq 0 }">
						미승인
						</c:if> <c:if test="${list2.IS_APPROVAL eq 1 }">
						승인
						</c:if>
									</a></td>
								</tr>
							</c:if>
						</c:forEach>
					</table>

				</div>
			</div>
		</c:if>


	</div>
</div>
<div style="margin-bottom: 200px"></div>




<%@include file="../../include/footer.jsp"%>




