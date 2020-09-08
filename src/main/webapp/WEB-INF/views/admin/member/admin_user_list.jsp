<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>

<!-- admin pagination css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_pagination.css" />

<div class="wrapper">
	<main class="member-list__main">
		<div class="member-list__title">
			<span class="member-list__title-text">일반 회원 관리</span>
		</div>
		<!-- 일반 회원 목록 -->
		<div class="member__table">
			<table class="member__m-table checkbox_group">
				<tr class="m-table__tr-head">
					<th class="m-table__th"><input type="checkbox" name="check-master" id="check_all" /></th>
					<th class="m-table__th">아이디</th>
					<th class="m-table__th">이름</th>
					<th class="m-table__th">전화번호</th>
					<th class="m-table__th">이메일</th>
				</tr>
				<c:choose>
					<%-- userList null 일 때 --%>
					<c:when test="${empty userList }">
						<tr>
							<td colspan="5">가입된 회원이 없습니다.</td>
						</tr>
					</c:when>
					<%-- userList null이 아닐 때 --%>
					<c:when test="${not empty userList }">
						<c:forEach items="${userList }" var="u" >
						<tr class="m-table__tr-body">
							<td class="m-table__td"><input type="checkbox" value="${u.userNo }" name="checkNormal" class="checkbox_normal" /></td>
							<td class="m-table__td">${u.userId }</td>
							<td class="m-table__td">${u.userName }</td>
							<td class="m-table__td">${u.phone }</td>
							<td class="m-table__td">${u.email }</td>
						</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
		</div>
		
		<!-- 회원 활동 탈퇴 버튼 -->
		<div class="member-list__btns-wrap">
			<!-- 삭제 버튼 -->
			<span class="member-list__btn-delete" id="member-del-btn">회원 탈퇴</span>
		</div>
		
		<!-- include pagination -->
		<%@include file="./admin_user_list_pagination.jsp" %>
		
	</main>
</div>

<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>