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
			<span class="member-list__title-text">농업인 회원 관리</span>
		</div>
		<!-- 농업인 회원 목록 -->
		<div class="member__table">
			<table class="member__m-table checkbox_group">
				<tr class="m-table__tr-head">
					<th class="m-table__th"><input type="checkbox" name="check-master" id="check_all" class="member-chk" /></th>
					<th class="m-table__th">아이디</th>
					<th class="m-table__th">이름</th>
					<th class="m-table__th">전화번호</th>
					<th class="m-table__th">이메일</th>
					<th class="m-table__th">탈퇴여부</th>
					<th class="m-table__th">농장 페이지</th>
				</tr>
				<c:choose>
					<%-- userList null 일 때 --%>
					<c:when test="${empty farmerList }">
						<tr>
							<td colspan="7">조회된 농업인 회원이 없습니다.</td>
						</tr>
					</c:when>
					<%-- userList null이 아닐 때 --%>
					<c:when test="${not empty farmerList }">
						<c:forEach items="${farmerList }" var="f" >
						<tr class="m-table__tr-body">
							<td class="m-table__td"><input type="checkbox" value="${f.farmerNo }" name="checkNormal" class="checkbox_normal member-chk" /></td>
							<td class="m-table__td">${f.farmerId }</td>
							<td class="m-table__td">${f.name }</td>
							<td class="m-table__td">${f.phone }</td>
							<td class="m-table__td">${f.email }</td>
							<td class="m-table__td">
								<c:choose>
									<c:when test="${f.isLeave eq 0 }">
									<c:out value="활동중"></c:out>
									</c:when>
									<c:when test="${f.isLeave eq 1 }">
									<c:out value="탈퇴"></c:out>
									</c:when>
								</c:choose>
							</td>
							<td class="m-table__td">농장페이지 url</td>
						</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div>
		
		<!-- 버튼 div -->
		<div class="member-list__btns-wrap">
			<!-- 회원 탈퇴 취소 버튼 -->
			<span class="member-list__btn-del-cancel btn" id="member-del-cancel">회원 탈퇴 취소</span>
			<!-- 삭제 버튼 -->
			<span class="member-list__btn-delete btn" id="member-del-btn">회원 탈퇴</span>
		</div>
		
		<!-- 검색창 -->
		<div class="member-list__search-wrap">
			<input type="text" name="search" id="member-search" placeholder="검색어를 입력하세요" /><button id="search-btn">검색</button>
		</div>
		
		<!-- include pagination -->
		<%@include file="./admin_farmer_list_pagination.jsp" %>
		
	</main>
</div>
<!-- 회원 탈퇴 관련 이벤트 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/member/admin_farmer_delete_event.js"></script>
<!-- 검색 이벤트 javascript -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/member/admin_farmer_search_event.js" ></script>
<!-- checkbox 에 대한 javascript -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/common/checkbox-event.js"></script>
<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>