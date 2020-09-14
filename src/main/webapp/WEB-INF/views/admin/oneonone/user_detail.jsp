<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>
<!-- ckeditor js 파일 삽입 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>
<!-- oneonone detail css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/oneonone/admin_oneonone_detail.css" />

<div class="wrapper">
	<main class="main__oneonone-detail">
		<div class="oneonone-detail__question-table-wrap">
			<table class="oneonone-detail__question-table">
				<tr class="question-table__tr">
					<td class="question-table__th">문의 제목</td>
					<td class="question-table__td" colspan="3">${question.title }</td>
				</tr>
				<tr class="question-table__tr">
					<td class="question-table__th">
						문의자
					</td>
					<td class="question-table__td td-user">
						<div class="question-table__user-info-wrap">
							<c:choose>
								<c:when test="${empty question.fileRename }">
								<div class="user-info-wrap__img-wrap">
									<img alt="profile" src="<%=request.getContextPath() %>/resources/image/mypage/default_profile.png" width="70" height="70">
								</div>
								</c:when>
								<c:when test="${not empty question.fileRename }">
								<div class="user-info-wrap__img-wrap">
									<img alt="profile" src="<%=request.getContextPath() %>/resources/image/mypage/${question.fileRename }" width="70" height="70">
								</div>
								</c:when>
							</c:choose>
							<div class="user-info-wrap__user-id">
								<span>${question.userId }</span>
							</div>
						</div>
					</td>
					<td class="question-table__th">
						작성일
					</td>
					<td  class="question-table__td td-user">
						<fmt:formatDate value="${question.regDate }"/>
					</td>
				</tr>
				<tr class="question-table__tr">
					<td colspan="4" class="question-table__th">내용</td>
				</tr>
				<tr class="question-table__tr">
					<td class="question-table__td td-content" colspan="4">
						${question.content }
					</td>
				</tr>
			</table>		
		</div>
		
		<!-- 답변이 있을 때, 없을 때 -->
		<c:choose>
			<%-- 답변이 없을 때 - 답변 작성 버튼과 목록으로 버튼 보여줌 --%>
			<c:when test="${empty answer }">
			<%@include file="./question_write.jsp" %>
			</c:when>
			<%-- 답변이 있을 때 - 답변 수정 버튼, 답변 삭제, 목록으로 버튼 보여줌 --%>
			<c:when test="${not empty answer }">
			<%@include file="./question_update.jsp" %>
			</c:when>		
		</c:choose>
		
	
	</main>
</div>
<!-- form 태그 submit -->
 <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/oneonone/admin_oneonone_form_submit_event.js"></script>
<!-- button event javascript -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/oneonone/admin_oneonone_detail_btn_event.js"></script>
<!-- delete button click event -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/oneonone/admin_user_oneonone_delete.js" ></script>
<!-- toList button click event -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/oneonone/admin_user_oneonone_to_list.js"></script>

<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>