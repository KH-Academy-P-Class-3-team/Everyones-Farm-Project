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
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	
<script type="text/javascript">
$(document).ready(function(){
	
		
	$("#btnChecking").click(function(){
	var $checkboxes = $("input:checkbox[name='checkRow']:checked");
	
	var num=0; 
	var map = $checkboxes.map(function(){
		return num += Number($(this).val());
	})
	
	$("#cost").text(num);
	})
	
})
	function checkAll() {
		var $checkboxes = $("input:checkbox[name='checkRow']")
		var check_status = $("#checkAll").is(":checked")
		if (check_status) {
			$checkboxes.each(function() {
				this.checked = true;
			})
		} else {
			$checkboxes.each(function() {
				this.checked = false;
			})
		}
	}
	
	
	
</script>
	
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
.col-lg-1 {
    margin-top: 100px;
    margin-left: 100px;
    width: 700px;
}
	
</style>

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<body class="pt-5">
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<h3 class="my-4 text-left">장바구니</h3>
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
					<div class="panel-body">
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
					<div class="panel-body" style="font-weight: bold;">
						<a href="<%=request.getContextPath()%>/mypage/user/basket">장바구니</a>
					</div>
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/orderList">구매
							목록</a>
					</div>
				</div>

			</div>
			<div class="col-lg-1">
				<!-- 리스트 시작-->

					<!-- Table -->
					<table class="table table-hover table-bordered">
						<tr class="active">
							<th><input type="checkbox" id="checkAll"
							onclick="checkAll();" > </th>
							<th>상품정보</th>
							<th>옵션</th>
							<th>금액</th>
							<th>전문 배송</th>
						</tr>
						<c:forEach items="${basket.baskets}" var="basket">
							<tr>
								<td><input type="checkbox" name="checkRow" value="${basket.PRICE }"></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${basket.NAME } </a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${basket.OPTION_NAME }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${basket.PRICE }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${basket.DELIVERY }</a></td>
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
											href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart-1}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="${page.blockStart}" end="${page.blockEnd}"
									var="page">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page}">${page}</a></li>
								</c:forEach>

								<c:choose>
									<c:when test="${page.blockEnd >= page.lastPage }">
										<li><a
											href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockEnd}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockEnd+1}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>

							</ul>
						</nav>
						<button id="btnChecking" class="btn pull-right">확인</button>
					</div>
					<hr>
					<div class="costArea">
					<h3><span>총 결제 금액 : </span> <span id="cost"></span> </h3>
					</div>
					


			</div>
		</div>
	</div>







</body>
</html>