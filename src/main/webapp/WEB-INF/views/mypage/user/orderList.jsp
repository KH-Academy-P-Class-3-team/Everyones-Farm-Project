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
	text-align: left;
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

.table {
	width: 100%;
}

.col-lg-1 {
	margin-top: 100px;
	margin-left: 100px;
	width: 700px;
}
</style>

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top: 200px"></div>

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h3 class="my-4 text-left">구매 목록</h3>
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
					<a href="<%=request.getContextPath()%>/mypage/user/orderList"
						style="font-weight: bold;">구매 목록</a>
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
						<a href="/farmapp/mypage/activitylist">체험 신청내역</a>
					</div>

				</div>
			</c:if>
		</div>
		<c:if test="${userInfo ne null }">
			<div class="col-lg-1">
				<!-- 리스트 시작-->

				<!-- Table -->
				<table class="table table-hover table-bordered">
					<tr class="active">
						<th>상품정보</th>
						<th>금액</th>
						<th>판매자/문의</th>
						<th>결제 상태</th>
						<th>배송 현황</th>
					</tr>
					<c:forEach items="${order.orders }" var="order">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.NAME }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.PAYMENT_PRICE }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.SELLER }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.PAYMENT_STATUS }</a></td>
							<td>배송현황</td>
						</tr>
					</c:forEach>
				</table>


				<div class="paging">
					<!-- section pagination -->
					<nav>
						<ul class="pagination">
							<c:choose>
								<c:when test="${page.blockStart > 1 }">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockStart-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockStart}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="${page.blockStart}" end="${page.blockEnd}"
								var="page">
								<li><a
									href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page}">${page}</a></li>
							</c:forEach>

							<c:choose>
								<c:when test="${page.blockEnd >= page.lastPage }">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockEnd}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockEnd+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
					</nav>
				</div>
			</div>
		</c:if>
		<c:if test="${farmerInfo ne null }">
			<div class="col-lg-1">
				<!-- 리스트 시작-->

				<!-- Table -->
				<table class="table table-hover table-bordered">
					<tr class="active">
						<th>상품정보</th>
						<th>금액</th>
						<th>주문 일자</th>
						<th>결제 상태</th>
						<th>배송 현황</th>
					</tr>
					<c:forEach items="${order.orders }" var="order">
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.NAME }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.PAYMENT_PRICE }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.ORDER_DATE }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?orderNo=${order.ORDER_NO}">${order.PAYMENT_STATUS }</a></td>
							<td>배송현황</td>
						</tr>
					</c:forEach>
				</table>


				<div class="paging">
					<!-- section pagination -->
					<nav>
						<ul class="pagination">
							<c:choose>
								<c:when test="${page.blockStart > 1 }">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockStart-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockStart}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="${page.blockStart}" end="${page.blockEnd}"
								var="page">
								<li><a
									href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page}">${page}</a></li>
							</c:forEach>

							<c:choose>
								<c:when test="${page.blockEnd >= page.lastPage }">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockEnd}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/orderList?cPage=${page.blockEnd+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
					</nav>
				</div>
			</div>
		</c:if>
	</div>
</div>



<%@include file="../../include/footer.jsp"%>






