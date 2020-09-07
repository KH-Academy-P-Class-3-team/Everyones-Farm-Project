<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp" %>

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
.named{
	color : lime;
	font-weight: bold;
}
.name{
	font-size: 18px;
}
</style>

<!-- jquery -->﻿
<script type="text/javascript" src="jquery-3.4.1.min.js" ></script>
<!-- ckeditor 4 -->
<link rel="stylesheet" href="/ckeditor/contents.css">
<!-- <script src="https://cdn.ckeditor.com/4.12.1/standard-all/ckeditor.js"></script> -->
<script type="text/javascript" src="/ckeditor/ckeditor.js" ></script>﻿
<script >
CKEDITOR.replace('ckeditor'); // 에디터로 생성
</script >

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top:200px"></div>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-md-8">
			<div class="name"><span class="named">주문/배송</span> 상세</div>
			
			<hr>
			
			<div> 주문 상품 정보</div>
			
			<table>
			<tr>
			<td>상품정보</td>
			<td>${orderDetail.PRODUCT_NAME} /${orderDetail.OPTION_NAME } } </td>
			</tr>
			</table>
				
			<div> 결제 정보</div>
			
			<table>
			<tr>
			<td>상품정보</td>
			<td>${orderDetail.OPTION_NAME}</td>
			</tr>
			<tr>
			<td>결제 수량</td>
			<td>${orderDetail.ORDER_AMOUNT} 개 </td>
			</tr>
			<tr>
			<td>주문일자</td>
			<td>${orderDetail.ORDER_DATE} </td>
			</tr>
			<tr>
			<td>결제 금액</td>
			<td>${orderDetail.PAYMENT_PRICE}</td>
			</tr>
			<tr>
			<td>결제 상태</td>
			<c:if test="${orderDetail.PAYMENT_STATUS eq 1}">
			<td>결제 완료</td>
			</c:if>
			<c:if test="${orderDetail.PAYMENT_STATUS eq 0}">
			<td>결제 미완료</td>
			</c:if>
			</tr>
			</table>
			
			<table>
			<tr>
			<td>우편번호</td>
			<td>${orderDetail.ZONECODE}</td>
			</tr>
			<tr>
			<td>상세주소</td>
			<td>${orderDetail.FIRST_ADDRESS}${orderDetail.SECOND_ADDRESS}</td>
			</tr>
			</table>
				<div class="nearcontent">
					<table class="table">

						
						<tr>
						<td>페이지 이동</td>
						<td>문의 번호</td>
						<td>제목</td>
						<td>작성자 번호</td>
						<td>답변 확인</td>
						</tr>
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">
								<span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
								이전 페이지</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${up.questionNo}">${up.isAnswered }</a></td>
						</tr>
						<c:if test="${empty up.questionNo}">
						</c:if>
						<tr>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">
								<span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>
								다음 페이지</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.questionNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.title }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.userNo }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/mypageO3Detail?QUESTION_NO=${down.questionNo}">${down.isAnswered }</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>








<%@include file="../../include/footer.jsp" %>
