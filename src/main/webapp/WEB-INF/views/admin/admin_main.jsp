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
	width: 900px;
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
.farm-list__table .farm-table
, .qna-list__table .qna-table {
    width: 100%;
	border-top: 1px solid #605759;
	border-bottom: 1px solid #605759;
	border-collapse: collapse;
}
/* 테이블의 row, 행 */
.farm-table tr
, .qna-table tr {
	border-bottom: 1px solid #605759;
}
.farm-table tr:hover
, .qna-table tr:hover {
	background: #E9F7AB;
	cursor: pointer;
}
.farm-table tr:first-child:hover
, .qna-table tr:first-child:hover {
	background: #D1E9CA;
	cursor: default;
}
/* 테이블의 th, td */
.farm-table th
, .farm-table td
, .qna-table th
, .qna-table td {
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
.farm-table .farm-table__head
, .qna-table .qna-table__head {
    background: #D1E9CA;
}
/* 농업인 입점신청 목록으로 가기 버튼 */
.admin__farm-list .farm-list__btn-wrap
, .admin__qna-list .qna-list__btn-wrap {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
    align-items: center;
}
.farm-list__btn-wrap .farm-list__btn
, .qna-list__btn-wrap .qna-list__btn {
	padding: 7px 14px;
    background: #EAE891;
    border-radius: 3px;
    cursor: pointer;
}
.farm-list__btn-wrap .farm-list__btn:hover
, .qna-list__btn-wrap .qna-list__btn:hover {
	font-weight: 700;
	background: #E2CC6C;
}
/* 문의 목록 테이블 */
.qna-table .qna-table__head th:nth-child(2) {
	width: 40%;
}
.qna-table .qna-table__head th:first-child
, .qna-table .qna-table__head th:last-child
, .qna-table .qna-table__head th:nth-child(3)
, .qna-table .qna-table__head th:nth-child(4) {
	width: 15%;
}
/* 제목이 너무 긴 경우 */
.qna-table__body .qna-table__title-overflow {
	overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 360px;
}
/* 작성자 이름이 긴 경우 */
.qna-table__body .qna-table__name-overflow {
	overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 120px;
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
				<span class="farm-list__btn" id="toFarmerApplication">농업인 회원 신청 관리하러 가기</span>
			</div>
		</div>
		
		<!-- 최근 고객센터 문의 Top10 -->
		<div class="admin__qna-list">
			<div class="qna-list__title">
				<span>최근 고객센터 문의</span>
			</div>
			<!-- 테이블 -->
			<div class="qna-list__table">
			<table class="qna-table">
				<!-- thead -->
				<tr class="qna-table__head">
					<th>문의 번호</th>
					<th>문의 제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>답변 상태</th>
				</tr>
				<!-- tbody -->
				<c:choose>
					<%-- qList가 null이 아닐 때 --%>
					<c:when test="${not empty qList }">
					<c:forEach items="${qList }" var="q">
					<tr class="qna-table__body">
						<td>${q.questionNo }</td>
						<td><div class="qna-table__title-overflow">${q.title }</div></td>
						<c:choose>
							<c:when test="${not empty q.userNo }">
								<td><div class="qna-table__name-overflow">${q.userName }</div></td>
							</c:when>
							<c:when test="${not empty q.farmerNo }">
								<td><div class="qna-table__name-overflow">${q.farmerName }</div></td>
							</c:when>
						</c:choose>
						<td>
						<fmt:formatDate value="${q.regDate }" pattern="yyyy-MM-dd"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${q.isAnswered eq 0 }">
								<c:out value="답변 대기"></c:out>
								</c:when>
								<c:when test="${q.isAnswered eq 1 }">
								<c:out value="답변 완료"></c:out>
								</c:when>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
					</c:when>
					<%-- qList가 null 일 때 --%>
					<c:when test="${empty qList }">
					<tr>
						<td colspan="5">서버에 문제로 인해 문의 조회를 실패했습니다.</td>
					</tr>
					</c:when>
				</c:choose>
			</table>
			</div>
			<div class="qna-list__btn-wrap">
				<!-- 나중에 링크 연결하기 -->
				<span class="qna-list__btn" id="toAdminServiceCenter" >고객센터 관리하러 가기</span>
			</div>
		</div>
	</main>
</div>

<!-- footer include -->
<%@include file="./include/admin_footer.jsp" %>