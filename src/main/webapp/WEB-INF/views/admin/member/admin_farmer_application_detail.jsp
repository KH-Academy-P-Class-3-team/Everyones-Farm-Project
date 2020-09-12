<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/member/admin_member_detail.css" />

<div class="wrapper">
	<main class="member-detail__main">
		<!-- 농장 입점 신청서 제목 -->
		<div class="member-detail__title-wrap">
			<span class="member-detail__text">농장 입점 신청서</span>
		</div>
		<!-- 농부 정보 -->
		<div class="member-detail__farmer-info">
			<div class="farmer-info__title-wrap">
				<span class="farmer-info__title">농장 입점 신청자(농업인 정보)</span>
			</div>
			<table class="farmer-info__table">
			<colgroup>
				<col width="30%" />
				<col width="70%" />
			</colgroup>
			<tr class="farmer-info__tr">
				<td class="farmer-info__td th-style">농업인 ID</td>
				<td class="farmer-info__td">${fApplication.farmerId }</td>
			</tr>
			<tr class="farmer-info__tr">
				<td class="farmer-info__td th-style">농업인 NAME</td>
				<td class="farmer-info__td">${fApplication.farmerName }</td>
			</tr>
			<tr class="farmer-info__tr">
				<td class="farmer-info__td th-style">농업인 EMAIL</td>
				<td class="farmer-info__td">${fApplication.farmerEmail }</td>
			</tr>
			<tr class="farmer-info__tr">
				<td class="farmer-info__td th-style">농업인 PHONE</td>
				<td class="farmer-info__td">${fApplication.farmerPhone }</td>
			</tr>
			<tr class="farmer-info__tr">
				<td class="farmer-info__td th-style">농업인 승인상태</td>
				<td class="farmer-info__td">
					<c:choose>
						<c:when test="${fApplication.farmerIsConfirm eq 1 }">입점 승인</c:when>
						<c:when test="${fApplication.farmerIsConfirm ne 1 }">입점 보류</c:when>
					</c:choose>
				</td>
			</tr>
			</table>
		</div>
		<!-- 농장 정보 -->
		<div class="member-detail__farm-info">
			<div class="member-detail__farmer-info">
				<div class="farmer-info__title-wrap">
					<span class="farmer-info__title">농장 정보</span>
				</div>
				<table class="farmer-info__table">
				<colgroup>
					<col width="30%" />
					<col width="70%" />
				</colgroup>
				<tr class="farmer-info__tr">
					<td class="farmer-info__td th-style">농장 NAME</td>
					<td class="farmer-info__td">${fApplication.farmName }</td>
				</tr>
				<tr class="farmer-info__tr">
					<td class="farmer-info__td th-style">농장 우편 번호</td>
					<td class="farmer-info__td">${fApplication.farmZoneCode }</td>
				</tr>
				<tr class="farmer-info__tr">
					<td class="farmer-info__td th-style">농장 FIRST ADDRESS</td>
					<td class="farmer-info__td">${fApplication.farmFirstAddress }</td>
				</tr>
				<tr class="farmer-info__tr">
					<td class="farmer-info__td th-style">농장 SECOND ADDRESS</td>
					<td class="farmer-info__td">${fApplication.farmSecondAddress }</td>
				</tr>
				<tr class="farmer-info__tr">
					<td class="farmer-info__td th-style">농장 가입 이유</td>
					<td class="farmer-info__td">${fApplication.farmReason }</td>
				</tr>
				<tr class="farmer-info__tr">
					<td colspan="2" class="farmer-info__td th-style">농장에서 생산되는 농작물과 농장 규모</td>
				</tr>
				<tr class="farmer-info__tr">
					<td colspan="2" class="farmer-info__td td-content-style">${fApplication.farmSell }</td>
				</tr>
				<tr class="farmer-info__tr">
					<td colspan="2" class="farmer-info__td th-style">농업인으로써 가장 중요하다고 생각하는 마음가짐</td>
				</tr>
				<tr class="farmer-info__tr">
					<td colspan="2" class="farmer-info__td td-content-style">${fApplication.farmMind }</td>
				</tr>
				<tr class="farmer-info__tr">
					<td colspan="2" class="farmer-info__td th-style">농장 소개</td>
				</tr>
				<tr class="farmer-info__tr">
					<td colspan="2" class="farmer-info__td td-content-style">${fApplication.farmIntroduce }</td>
				</tr>
				</table>
			</div>
		</div>
		<!-- 농장 입점 신청 승인, 보류 버튼 -->
		<div class="member-detail__btn-wrap">
			<c:choose>
				<c:when test="${fApplication.farmerIsConfirm eq 1 }">
					<span class="btn hold-btn" id="hold-farm" data-farmerNo="${fApplication.farmerNo }">입점 보류</span><span class="btn list-btn" id="toList">목록으로</span>		
				</c:when>
				<c:when test="${fApplication.farmerIsConfirm ne 1 }">
					<span class="btn approve-btn" id="approve-farm" data-farmerNo="${fApplication.farmerNo }">입점 승인</span><span class="btn list-btn" id="toList">목록으로</span>		
				</c:when>
			</c:choose>
		</div>
	</main>
</div>

<!-- 버튼 이벤트 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/member/admin_farmer_application_approve_event.js"></script>
<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>