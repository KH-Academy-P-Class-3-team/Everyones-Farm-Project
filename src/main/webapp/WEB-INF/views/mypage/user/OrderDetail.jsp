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

<<<<<<< HEAD
.btn-warning {
=======
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

.named {
	color: lime;
	font-weight: bold;
}

.name {
	font-size: 18px;
}

.tableInfo {
	border: 1px solid #ccc;
	margin: 30px;
	width: 100%;
	text-align: center;
}

.productInfo{
	border: 1px solid #ccc;
	margin: 30px;
	width: 100%;
	text-align: center;
	height: 120px;
}

.productInfo td {
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	padding: 5px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.tableInfo td {
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	padding: 5px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.short {
	width: 200px;
	background-color: #ccc;
}

.thick {
	width: 200px;
	background-color: #ccc;
}

#tekbeCompnayList {
	width: 480px;
	height: 30px;
	padding-left: 10px;
	font-size: 18px;
	border-radius: 3px;
}

#invoiceNumberText {
	width: 480px;
	height: 30px;
	padding-left: 10px;
	font-size: 18px;
	border-radius: 3px;
	margin-right: 20px;
}

#tekbeCompnayName, #invoiceNumber {
	color: black;
	font-weight: bold;
	margin-right: 20px;
	font-size: 18px;
}

td, th {
	text-align: left;
	padding: 8px;
	border-bottom: 1px solid #ccc;
}

.bottom {
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
	width: 90px;
	height: 50px;
	margin-top: 30px;
	margin-right: 150px;
}
<<<<<<< HEAD
.media-object{
	margin-left : 70px;
}
.panel-default{
	border : none;
}
.panel-default>.panel-heading {
    background-color: white;
    border: none;
    font-weight: bold;
    font-size : 17px;
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
=======
</style>

<!-- jquery -->
﻿
<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						var myKey = "2RFJ8884OPdInrHowXukGA"; // sweet tracker에서 발급받은 자신의 키 넣는다.

						// 택배사 목록 조회 company-api
						$
								.ajax({
									type : "GET",
									dataType : "json",
									url : "http://info.sweettracker.co.kr/api/v1/companylist?t_key="
											+ myKey,
									success : function(data) {

										// 방법 1. JSON.parse 이용하기
										var parseData = JSON.parse(JSON
												.stringify(data));
										console.log(parseData.Company); // 그중 Json Array에 접근하기 위해 Array명 Company 입력

										// 방법 2. Json으로 가져온 데이터에 Array로 바로 접근하기
										var CompanyArray = data.Company; // Json Array에 접근하기 위해 Array명 Company 입력
										console.log(CompanyArray);

										var myData = "";
										$
												.each(
														CompanyArray,
														function(key, value) {
															myData += ('<option value='+value.Code+'>'
																	+ 'key:'
																	+ key
																	+ ', Code:'
																	+ value.Code
																	+ ',Name:'
																	+ value.Name + '</option>');
														});
										$("#tekbeCompnayList").html(myData);
									}
								});

						// 배송정보와 배송추적 tracking-api
						$("#myButton1")
								.click(
										function() {
											var t_code = $(
													'#tekbeCompnayList option:selected')
													.attr('value');
											var t_invoice = $(
													'#invoiceNumberText').val();
											$
													.ajax({
														type : "GET",
														dataType : "json",
														url : "http://info.sweettracker.co.kr/api/v1/trackingInfo?t_key="
																+ myKey
																+ "&t_code="
																+ t_code
																+ "&t_invoice="
																+ t_invoice,
														success : function(data) {
															console.log(data);
															var myInvoiceData = "";
															if (data.status == false) {
																myInvoiceData += ('<p>'
																		+ data.msg + '<p>');
															} else {
																myInvoiceData += ('<tr>');
																myInvoiceData += ('<th>'
																		+ "제품정보"
																		+ '</td>');
																myInvoiceData += ('<th>'
																		+ data.itemName + '</td>');
																myInvoiceData += ('</tr>');
															}

															$("#myPtag")
																	.html(
																			myInvoiceData)

															var trackingDetails = data.trackingDetails;

															var myTracking = "";
															var header = "";
															header += ('<tr>');
															header += ('<th>'
																	+ "시간"
																	+ '</th>');
															header += ('<th>'
																	+ "장소"
																	+ '</th>');
															header += ('<th>'
																	+ "유형"
																	+ '</th>');
															header += ('<th>'
																	+ "전화번호"
																	+ '</th>');
															header += ('</tr>');

															$
																	.each(
																			trackingDetails,
																			function(
																					key,
																					value) {
																				myTracking += ('<tr>');
																				myTracking += ('<td>'
																						+ value.timeString + '</td>');
																				myTracking += ('<td>'
																						+ value.where + '</td>');
																				myTracking += ('<td>'
																						+ value.kind + '</td>');
																				myTracking += ('<td>'
																						+ value.telno + '</td>');
																				myTracking += ('</tr>');
																			});

															$("#myPtag2")
																	.html(
																			header
																					+ myTracking);

														}
													});
										});

					});
</script>
<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top: 200px"></div>
<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h3 class="my-4 text-left">영농 일지</h3>
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
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
				</div>

				<div class="panel panel-default">
<<<<<<< HEAD
					<div class="panel-heading">주문</div>
					<div class="panel-body">구매 목록</div>
					<div class="panel-body">장바구니</div>
=======
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
						<a href="/farmapp/mypage/activitylist" style="font-weight: bold;">체험
							신청내역</a>
					</div>

>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
				</div>

			</div>
			<div class="col-lg-1">
				<form action="modfy/userImg" method="post">
					<div class="media">
						<div class="media-left media-middle">
							<a href="#"> <img class="media-object"
								src="<%=request.getContextPath()%>/resources/img/basic.jpg"
								alt="...">
							</a>
						</div>
						<button type="submit" class="btn btn-warning"
							onclick="selectUrl('/modify/confirm')">사진 등록</button>
					</div>
				</form>
				<div class="ModifyUserInfo">

					<form action="modify/userInfo" method="post">
						<!-- 			아이디 -->
						<div class="input-group">
							<label for="inputName" class="col-lg-3 control-label">아이디</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon glyphicon glyphicon-user"
									id="sizing-addon1"></span> <input type="text"
									class="form-control" placeholder="아이디"
									aria-describedby="sizing-addon1" value="${userData.USER_ID}"}>
							</div>
						</div>
						<!-- 			비밀번호 -->
						<div class="input-group">
							<label for="inputName" class="col-lg-3 control-label">비밀번호</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon glyphicon glyphicon-lock"
									id="sizing-addon1"></span> <input type="password"
									class="form-control" placeholder="비밀번호"
									aria-describedby="sizing-addon1" value="${userData.USER_PW} }">
							</div>
						</div>
						<!-- 			이름 -->
						<div class="input-group">
							<label for="inputName" class="col-lg-3 control-label">이름</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon glyphicon glyphicon-user"
									id="sizing-addon1"></span> <input type="text"
									class="form-control" placeholder="이름"
									aria-describedby="sizing-addon1" value="${userData.USER_NAME}"
									readonly>
							</div>
						</div>

						<!-- 			이메일 -->
						<div class="input-group">
							<label for="inputName" class="col-lg-3 control-label">E-Mail</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon glyphicon glyphicon-envelope"
									id="sizing-addon1"></span> <input type="text"
									class="form-control" placeholder="E-Mail"
									aria-describedby="sizing-addon1" value="${userData.EMAIL}">
							</div>
						</div>
						<!-- 			전화번호 -->
						<div class="input-group">
							<label for="inputName" class="col-lg-3 control-label">전화번호</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon glyphicon glyphicon-earphone"
									id="sizing-addon1"></span> <input type="text"
									class="form-control" placeholder="전화번호"
									aria-describedby="sizing-addon1" value="${userData.PHONE}">
							</div>
						</div>
						<!-- 			주소 -->
						<div class="input-group">
							<label for="inputName" class="col-lg-3 control-label">주소</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon glyphicon glyphicon-home"
									id="sizing-addon1"></span> <input type="text"
									class="form-control" placeholder="주소"
									aria-describedby="sizing-addon1"
									value="${userData.FIRST_ADDRESS}">
							</div>
						</div>



						<button type="submit" class="btn btn-warning"
							onclick="selectUrl('/modify/confirm')">등록</button>

					</form>
				</div>
			</div>
<<<<<<< HEAD
=======
			<c:if test="${orderDetail.PRODUCT_NAME}">
			<button class="btn btn-warning pull-right bottom" type="button"
				onclick="javascript:location.href='deleteOrder?orderNo=${orderDetail.ORDER_NO}'">삭제</button>
			</c:if>
			<button class="btn btn-success pull-right bottom" type="button"
				onclick="javascript:location.href='mypageO3List'">뒤로가기</button>
>>>>>>> parent of 99d9b7a... mypageUser Without FarmerSession added
		</div>
	</div>

	<script type="text/javascript">
		function selectUrl(url){
			var root = '<%=request.getContextPath()%>';
			
			document.querySelector('#form-data').action = root + url;
		}
	</script>







</body>
</html>