<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="./include/admin_header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_main.css" />

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