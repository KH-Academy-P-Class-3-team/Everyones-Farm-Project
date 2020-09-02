<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="./include/admin_header.jsp" %>
<style type="text/css">
.main__admin {
	margin: 60px 0;
}
/* 최근 농장 입점신청 목록 */
.main__admin .admin__farm-list
, .main__admin .admin__qna-list {
	width: 700px;
}
.main__admin .admin__farm-list {
    margin: 0 auto 50px;
}
.main__admin .admin__qna-list {
	margin: 0 auto;
}
/* 최근 농장 입점신청 목록 - 제목 */
.admin__farm-list .farm-list__title
, .admin__qna-list .qna-list__title {
	margin-bottom: 20px;
}
.admin__farm-list .farm-list__title > span
, .admin__qna-list .qna-list__title > span {
	padding-left: 7px;
    border-left: 3px solid #789F6F;
    font-size: 20px;
    font-weight: 700;
    opacity: 0.7;
}
/* 최근 농장 입점신청 목록 - 테이블 */
.farm-list__table .farm-table {
    width: 100%;
	border-top: 1px solid #605759;
	border-bottom: 1px solid #605759;
	border-collapse: collapse;
}
/* 테이블의 row, 행 */
.farm-table tr {
	border-bottom: 1px solid #605759;
}
.farm-table tr:hover {
	background: #E9F7AB;
	cursor: pointer;
}
.farm-table tr:first-child:hover {
	background: #D1E9CA;
	cursor: default;
}
/* 테이블의 th, td */
.farm-table th
, .farm-table td {
	padding: 14px 7px;
	text-align: center;
}
/* th width 크기 */
.farm-table .farm-table__head th:first-child {
	width: 15%;
}
.farm-table .farm-table__head th:nth-child(2)
, .farm-table .farm-table__head th:last-child {
	width: 25%;
}
.farm-table .farm-table__head th:nth-child(3) {
	width: 35%;
}
/* table 에 thead */
.farm-table .farm-table__head {
    background: #D1E9CA;
}
/* 농업인 입점신청 목록으로 가기 버튼 */
.admin__farm-list .farm-list__btn-wrap {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
    align-items: center;
}
.farm-list__btn-wrap .farm-list__btn {
	padding: 7px 14px;
    background: #EAE891;
    border-radius: 3px;
    cursor: pointer;
}
.farm-list__btn-wrap .farm-list__btn:hover {
	font-weight: 700;
	background: #E2CC6C;
}
</style>

<div class="wrapper">
	<main class="main__admin">
		<!-- 최근 농장 신청 목록 Top5 -->
		<div class="admin__farm-list">
			<div class="farm-list__title">
				<span>최근 농장 입점신청 목록</span>
			</div>
			<div class="farm-list__table">
			<table class="farm-table">
			<!-- thead -->
			<tr class="farm-table__head">
				<th>신청 번호</th>
				<th>농장 이름</th>
				<th>신청자 이름(아이디)</th>
				<th>신청 날짜</th>
			</tr>
			<c:choose>
				<%-- jstl 사용시 jstl comment 사용! 안그러면 error 발생 --%>
				<%-- fList가 null 일 때 --%>
				<c:when test="${empty fList }">
					<tr>
						<td colspan="4">최근 농장 입점신청이 없습니다.</td>
					</tr>
				</c:when>
				<%-- fList가 null 이 아닐 때 --%>
				<c:when test="${not empty fList }">
					<c:forEach items="${fList }" var="f" >
						<tr>
							<td>${f.fno }</td>
							<td>${f.farmName }</td>
							<td>${f.farmerName }(${f.farmerId }) 님</td>
							<td>
							<fmt:formatDate value="${f.applicationDate }" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
			
			</table>
			</div>
			<div class="farm-list__btn-wrap">
				<!-- 나중에 링크 연결하기 -->
				<span class="farm-list__btn" id="toFarmerApplicationList">농업인 회원 신청 관리하러 가기</span>
			</div>
		</div>
		
		<!-- 최근 고객센터 문의 Top10 -->
		<div class="admin__qna-list">
			<div class="qna-list__title">
				<span>최근 고객센터 문의</span>
			</div>
		</div>
	</main>
</div>

<!-- footer include -->
<%@include file="./include/admin_footer.jsp" %>