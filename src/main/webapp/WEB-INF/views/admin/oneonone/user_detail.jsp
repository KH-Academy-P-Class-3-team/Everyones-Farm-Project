<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>
<!-- oneonone detail css -->
<style type="text/css">
/* main tag css */
.main__oneonone-detail {
	margin: 70px auto;
}
/* table css */
.oneonone-detail__question-table-wrap .oneonone-detail__question-table {
    width: 100%;
	padding: 0;
    border-spacing: 0px;
    border-collapse: collapse;
    border-top: 1px solid #605759;
    border-bottom: 1px solid #605759;
}
/* td css */
.oneonone-detail__question-table td {
	padding: 16px 8px;
}
/* tr css */
.oneonone-detail__question-table .question-table__tr {
    border-top: 1px solid #605759;
    border-bottom: 1px solid #605759;
}
/* content td css */
.question-table__tr .td-content {
	height: 300px;
}
/* td css */
.question-table__tr .question-table__th {
	background: #D1E9CA;
	text-align: center;
}
/* user-info-wrap css */
.td-user .question-table__user-info-wrap {
	display: flex;
	align-items: center;
}
.question-table__user-info-wrap .user-info-wrap__img-wrap {
	margin-right: 10px;
}
.user-info-wrap__img-wrap img {
	border-radius: 10px;
}
/* btn-wrap div */
.main__oneonone-detail .oneonone-detail__btn-wrap {
	margin-top: 30px;
    display: flex;
    justify-content: center;
}
/* button css */
.oneonone-detail__btn-wrap .btn {
	padding: 16px;
    border-radius: 3px;
    font-weight: 700;
    cursor: pointer;
}
.oneonone-detail__btn-wrap .write-btn {
	background: #789F6F;
	margin-right: 10px;
}
.oneonone-detail__btn-wrap .cancel-btn {
	background: #EAE891;
}
</style>


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
		<!-- 버튼 div 영역 -->
		<div class="oneonone-detail__btn-wrap">
			<span class="btn write-btn" id="write">답변하기</span><span class="btn cancel-btn" id="cancel">취소</span>
		</div>
	
	</main>
</div>

<!-- button event javascript -->
<script type="text/javascript">
$("#cancel").on("click", function(){
	
	history.go(-1)
	
})
</script>
<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>