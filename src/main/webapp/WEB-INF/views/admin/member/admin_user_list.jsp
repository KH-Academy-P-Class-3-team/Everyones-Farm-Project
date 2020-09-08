<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>

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
					<th class="m-table__th">가입날짜</th>
				</tr>
				<c:choose>
					<%-- userList null 일 때 --%>
					<c:when test="${empty userList }">
						<tr>
							<td colspan="6">가입된 회원이 없습니다.</td>
						</tr>
					</c:when>
					<%-- userList null이 아닐 때 --%>
					<c:when test="">
					
					</c:when>
				</c:choose>
				<tr>
				<td>${apaging }</td>
				<td>${userList }</td>
				</tr>
			</table>
		</div>
	</main>
</div>

<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>