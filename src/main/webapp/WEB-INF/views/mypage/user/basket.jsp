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

.btn-warning {
	width: 90px;
	height: 50px;
	margin-top: 30px;
	margin-right: 150px;
}
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
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">주문</div>
					<div class="panel-body">구매 목록</div>
					<div class="panel-body">장바구니</div>
				</div>
<<<<<<< HEAD
=======
			</c:if>
		</div>

		<div id="practice"></div>
		<div class="col-lg-1">
			<!-- 리스트 시작-->

			<!-- Table -->
			<hr>
			<div class="boxName">장바구니</div>
			<table class="table table-hover table-bordered">
				<tr class="active">
					<th><input type="checkbox" id="checkAll" onclick="checkAll();">
					</th>
					<th>상품정보</th>
					<th>옵션</th>
					<th>금액</th>
					<th>전문 배송</th>
				</tr>
				<c:forEach items="${basket.baskets}" var="basket">
					<tr id="realBasket">
						<td><input type="checkbox" name="checkRow" id="checkone"
							value="${basket.BASKET_NO }"></td>
						<td><a
							href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.NAME }
						</a></td>
						<td><a
							href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.OPTION_NAME }</a></td>
						<td><a
							href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.PRICE }</a></td>
						<td><a
							href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.DELIVERY }</a></td>
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
									<%-- 									href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart-1}" --%>
									aria-label="Previous"
									class="naviBtn"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart}"
									aria-label="Previous" class="naviBtn"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach begin="${page.blockStart}" end="${page.blockEnd}"
							var="page">
							<li><a
								href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page}"
								class="naviBtn">${page}</a></li>
						</c:forEach>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

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
		</div>
	</div>

	<script type="text/javascript">
		function selectUrl(url){
			var root = '<%=request.getContextPath()%>';
			
			document.querySelector('#form-data').action = root + url;
		}
	</script>







</body>
</html>l>