<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp" %>

<!-- 합쳐지고 최소화된 최px;SS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
.col-lg-5 {
	margin-top: 100px;
	margin-left: 100px;
	width: 700px;
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

.pagination {
	padding-left: 190px;
}
.table{
	border: 1px solid #ccc;
	margin-top : 10px;
}
.write-bottom{
	text-align: right;
}
</style>

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top:200px"></div>

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
					<div class="panel-body" style="font-weight: bold;">
						<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List">1대
							1 문의</a>
					</div>
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/myActive">활동
							신청 현황</a>
					</div>
					<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/deleteId" style="color : #ccc;">회원
						탈퇴</a>
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


			<div class="col-lg-5">
			<div class="write">
					<span><a href="<%=request.getContextPath() %>/mypage/user/mypageO3Write">글쓰기</a></span>
					</div>
				<!-- 리스트 시작-->
				<div class="panel panel-default">

					<!-- Table -->
					<table class="table">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>답변상태</th>
						</tr>
						<c:forEach items="${list.o3List}" var="O3">
							<tr>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${O3.QUESTION_NO }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${O3.TITLE }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${O3.USER_NAME }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">${O3.REG_DATE }</a></td>
								<c:choose>
									<c:when test="${O3.IS_ANSWERED eq 1 }">
										<td><a
											href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">답변
												된 질문</a></td>
									</c:when>
									<c:otherwise>
										<td><a
											href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${O3.QUESTION_NO}">미답변
												질문</a></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</table>
					
					<div class="write-bottom">
					<span><a href="<%=request.getContextPath() %>/mypage/user/mypageO3Write">글쓰기</a></span>
					</div>
					
					<div class="paging">
						<!-- section pagination -->
						<nav>
							<ul class="pagination">
								<c:choose>
									<c:when test="${page.blockStart > 1 }">
										<li><a
											href="<%= request.getContextPath() %>/mypage/user/mypageO3List?cPage=${page.blockStart-1}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="<%= request.getContextPath() %>/mypage/user/mypageO3List?cPage=${page.blockStart}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="${page.blockStart}" end="${page.blockEnd}"
									var="page">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/mypageO3List?cPage=${page}">${page}</a></li>
								</c:forEach>

								<c:choose>
									<c:when test="${page.blockEnd >= page.lastPage }">
										<li><a href="<%= request.getContextPath() %>/mypage/user/mypageO3List?cPage=${page.blockEnd}" aria-label="Next"> <span
												aria-hidden="true">&raquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
									<li><a href="<%= request.getContextPath() %>/mypage/user/mypageO3List?cPage=${page.blockEnd+1}" aria-label="Next"> <span
												aria-hidden="true">&raquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>

						</nav>
					</div>
					
					
				</div>
					
			</div>
		</div>
	</div>

<%@include file="../../include/footer.jsp" %>




