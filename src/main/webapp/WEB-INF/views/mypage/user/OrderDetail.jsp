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

.col-md-8 {
	width: 100%;
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

.productInfo {
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

#tekbeCompnayList{
	width: 500px;
	height: 30px;
	padding-left: 10px;
	font-size: 18px;
	border-radius: 3px;
}
 #invoiceNumberText {
	width: 380px;
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
}
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
				</div>
			</div>

			<c:if test="${farmerInfo.name eq null} ">
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
						<a href="/farmapp/mypage/activitylist" style="font-weight: bold;">체험
							신청내역</a>
					</div>

				</div>
			</c:if>
		</div>
		<div class="col-lg-8">
			<div class="emptyArea"></div>
			<div class="name">
				<span class="named">주문/배송</span> 상세
			</div>

			<hr>

			<div>
				<span>주문 상품 정보</span>
				<table class="productInfo">
					<tr>
						<td class="thick">상품정보</td>
						<td>${orderDetail.PRODUCT_NAME}/${orderDetail.OPTION_NAME }}
						</td>
					</tr>
				</table>
			</div>

			<div>
				<span>결제 정보</span>
				<table class="tableInfo">
					<tr>
						<td class="short">상품정보</td>
						<td>${orderDetail.OPTION_NAME}</td>
					</tr>
					<tr>
						<td class="short">결제 수량</td>
						<td>${orderDetail.ORDER_AMOUNT}개</td>
					</tr>
					<tr>
						<td class="short">주문일자</td>
						<td>${orderDetail.ORDER_DATE}</td>
					</tr>
					<tr>
						<td class="short">결제 금액</td>
						<td>${orderDetail.PAYMENT_PRICE}</td>
					</tr>
					<tr>
						<td class="short">결제 상태</td>
						<c:if test="${orderDetail.PAYMENT_STATUS eq 1}">
							<td>결제 완료</td>
						</c:if>
						<c:if test="${orderDetail.PAYMENT_STATUS eq 0}">
							<td>결제 미완료</td>
						</c:if>
					</tr>
				</table>
			</div>

			<span>배송정보</span>
			<div class="forShip">
				<table>
					<tr>
						<td><span id="tekbeCompnayName">택배회사명: </span></td>
						<td><select id="tekbeCompnayList" name="tekbeCompnayList"></select></td>
					</tr>
					<tr>
						<td><span id="invoiceNumber">운송장번호: </span></td>
						<td><input type="text" id="invoiceNumberText"
							name="invoiceNumberText">
							<button id="myButton1" class="btn btn-info pull-right">택배
								조회하기</button></td>
					</tr>
				</table>



				<div>
					<table id="myPtag"></table>
				</div>
				<br />
				<div>
					<table id="myPtag2"></table>
				</div>
			</div>

			<div class="nearcontent">
				<table class="table">


					<tr>
						<td>페이지 이동</td>
						<td>주문 번호</td>
						<td>제품</td>
						<td>금액</td>
						<td>결제 상태</td>
					</tr>
					<c:if test="${total.MAX ne orderDetail.ORDER_NO  }">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${up.ORDER_NO}">
									<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
									이전 페이지
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${up.ORDER_NO}">${up.ORDER_NO }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${up.ORDER_NO}">${up.PRODUCT_NAME }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${up.ORDER_NO}">${up.PAYMENT_PRICE }</a></td>
							<c:if test="${up.PAYMENT_STATUS eq 0}">
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${up.ORDER_NO}">미
										결제</a></td>
							</c:if>
							<c:if test="${up.PAYMENT_STATUS eq 1 }">
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${up.ORDER_NO}">결제
										완료</a></td>
							</c:if>
						</tr>
					</c:if>
					<c:if test="${total.MIN ne orderDetail.ORDER_NO  }">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${down.ORDER_NO}">
									<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
									다음 페이지
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${down.ORDER_NO}">${down.ORDER_NO }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${down.ORDER_NO}">${down.PRODUCT_NAME }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${down.ORDER_NO}">${down.PAYMENT_PRICE }</a></td>
							<c:if test="${down.PAYMENT_STATUS eq 0}">
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${down.ORDER_NO}">미
										결제</a></td>
							</c:if>
							<c:if test="${down.PAYMENT_STATUS eq 1 }">
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${down.ORDER_NO}">결제
										완료</a></td>
							</c:if>
						</tr>
					</c:if>
				</table>
			</div>
			<button class="btn btn-warning pull-right" type="button"
				onclick="javascript:location.href='deleteOrder?orderNo=${orderDetail.ORDER_NO}'">삭제</button>
			<button class="btn pull-right" type="button"
				onclick="javascript:location.href='mypageO3List'">뒤로가기</button>
		</div>
	</div>
</div>









<%@include file="../../include/footer.jsp"%>
