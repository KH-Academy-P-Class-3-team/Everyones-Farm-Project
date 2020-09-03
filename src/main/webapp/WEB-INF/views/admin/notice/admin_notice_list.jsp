<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>
<!-- include css -->
<!-- admin pagination css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_pagination.css" />

<style type="text/css">
/* main tag */
.notice__main {
	margin: 70px auto;
	width: 900px;
}
/* 공지사항 관리 제목 */
.notice__main .notice__title {
	margin-bottom: 20px;
}
.notice__title .notice__title-text {
    font-size: 20px;
    font-weight: 700;
    opacity: 0.7;
    padding-left: 7px;
    border-left: 3px solid #789F6F;
}
/* 공지사항 목록 테이블 */
.notice__table > .notice__n-table {
	width: 100%;
}
.notice__table .notice__n-table {
	border-top: 1px solid #605759;
    border-bottom: 1px solid #605759;
    border-collapse: collapse;
    text-align: center;
}
/* 테이블 row 행 */
.notice__n-table .n-table__tr-head
, .notice__n-table .n-table__tr-body {
	border-bottom: 1px solid #605759;
}
.notice__n-table .n-table__tr-head {
	background: #789F6F;
    color: white;
}
.notice__n-table .n-table__tr-body {
	cursor: pointer;
}
.notice__n-table .n-table__tr-body:hover {
	background: #D1E9CA;
}
/* 테이블 th, td */
.notice__n-table .n-table__th
, .notice__n-table .n-table__td {
    padding: 14px 7px;
}
.n-table__tr-head .n-table__th:first-child {
	width: 5%;
}
.n-table__tr-head .n-table__th:nth-child(3) {
	width: 50%;
}
.n-table__tr-head .n-table__th:nth-child(2)
, .n-table__tr-head .n-table__th:nth-child(4)
, .n-table__tr-head .n-table__th:last-child {
	width: 15%;
}
/* 제목, 관리자 아이디(작성자) 글자 수 제한 */
.n-table__td .n-table__title-hidden
, .n-table__td .n-table__id-hidden {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.n-table__td .n-table__title-hidden {
    width: 435px;
}
.n-table__td .n-table__id-hidden {
	width: 120px;
}
/* 작성, 삭제 버튼 css */
.notice__main .notice__btns-wrap {
	margin-top: 20px;
	text-align: right;
}
.notice__btns-wrap span {
	display: inline-block;
	width: 125px;
    text-align: center;
    padding: 10px 5px;
    border-radius: 3px;
    font-weight: 700;
    cursor: pointer;
    color: white;
}
/* 삭제 버튼 css */
.notice__btns-wrap .notice__btn-delete {
	background: #B65656;
}
/* 작성버튼 css */
.notice__btns-wrap .notice__btn-write {
	background: #789F6F;
}
</style>


<div class="wrapper">
	<main class="notice__main">
		<div class="notice__title">
			<span class="notice__title-text">공지사항 관리</span>
		</div>
		<!-- 공지사항 목록 -->
		<div class="notice__table">
		<table class="notice__n-table">
			<tr class="n-table__tr-head">
				<th class="n-table__th"><input type="checkbox" name="noticeNo" /></th>
				<th class="n-table__th">공지 번호</th>
				<th class="n-table__th">제목</th>
				<th class="n-table__th">작성자</th>
				<th class="n-table__th">작성일</th>
			</tr>
			<c:choose>
				<%-- nList null 일 때 --%>
				<c:when test="${empty pagingNList }"></c:when>
				<%-- nList null 이 아닐 때 --%>
				<c:when test="${not empty pagingNList }">
					<c:forEach items="${pagingNList }" var="n">
					<tr class="n-table__tr-body">
						<td class="n-table__td"><input type="checkbox" name="noticeNo" /></td>
						<td class="n-table__td">${n.noticeNo }</td>
						<td class="n-table__td"><div class="n-table__title-hidden">${n.title }</div></td>
						<td class="n-table__td"><div class="n-table__id-hidden">${n.adminId }</div></td>
						<td class="n-table__td">
							<fmt:formatDate value="${n.regDate }" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		</div>
		
		<!-- 작성, 삭제 버튼 -->
		<div class="notice__btns-wrap">
			<!-- 작성 버튼 -->
			<span class="notice__btn-write">공지사항 작성</span>
			<!-- 삭제 버튼 -->
			<span class="notice__btn-delete">공지사항 삭제</span>
		</div>
		
		<!-- header include -->
		<%@include file="../include/admin_notice-pagination.jsp" %>
		
	</main>
</div>

<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>