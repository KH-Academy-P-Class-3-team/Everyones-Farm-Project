<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>

<!-- admin user list css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/member/admin_user_list.css" />
<!-- admin pagination css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_pagination.css" />
<!-- 검색창 css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_search_input.css" />

<div class="wrapper">
	<main class="member-list__main">
		<div class="member-list__title">
			<span class="member-list__title-text">농장 입점 신청 관리</span>
		</div>
		<!-- 농장 입점 신청 목록 -->
		<div class="member__table">
			<table class="member__m-table checkbox_group">
				<tr class="m-table__tr-head">
					<th class="m-table__th"><input type="checkbox" name="check-master" id="check_all" class="member-chk" /></th>
					<th class="m-table__th">농장명</th>
					<th class="m-table__th">신청자 이름(아이디)</th>
					<th class="m-table__th">신청 날짜</th>
					<th class="m-table__th">승인 상태</th>
				</tr>
				<c:choose>
					<%-- userList null 일 때 --%>
					<c:when test="${empty farmApplicationList }">
						<tr>
							<td colspan="5">최근 입점 신청을 한 농장이 없습니다.</td>
						</tr>
					</c:when>
					<%-- userList null이 아닐 때 --%>
					<c:when test="${not empty farmApplicationList }">
						<c:forEach items="${farmApplicationList }" var="fa" >
						<tr class="m-table__tr-body">
							<td class="m-table__td"><input type="checkbox" value="${fa.farmerNo }" name="checkNormal" class="checkbox_normal member-chk" /></td>
							<td class="m-table__td">${fa.farmName }</td>
							<td class="m-table__td">${fa.name }(${fa.farmerId })</td>
							<td class="m-table__td">
								<fmt:formatDate value="${fa.applicationDate }" pattern="yyyy-MM-dd"/>
							</td>
							<td class="m-table__td">
								<c:choose>
									<c:when test="${fa.isConfirm eq 1 }">
										입점 승인
									</c:when>
									<c:when test="${fa.isConfirm ne 1 }">
										입점 보류
									</c:when>
								</c:choose>
							</td>
						</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div>
		
		<!-- 버튼 div -->
		<div class="member-list__btns-wrap">
			<!-- 농장 입점 보류 버튼 -->
			<span class="member-list__btn-hold btn" id="hold-farm">입점 보류</span>
			<!-- 농장 입점 수락 버튼 -->
			<span class="member-list__btn-accept btn" id="accept-farm">입점 수락</span>
		</div>
		
		<!-- 검색창 -->
		<div class="member-list__search-wrap">
			<input type="text" name="search" id="member-search" placeholder="검색어를 입력하세요" /><button id="search-btn">검색</button>
		</div>
		
		<!-- include pagination -->
		<%@include file="./admin_farmer_application_pagination.jsp" %>
		
	</main>
</div>
<!-- 버튼 이벤트 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/member/admin_farmer_application_approve_event.js"></script>
<!-- 신청서 검색 이벤트 js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/member/admin_farmer_application_search_event.js"></script>
<!-- checkbox 에 대한 javascript -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/common/checkbox-event.js"></script>
<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>