<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>
<!-- admin notice detail css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/notice/admin_notice_detail.css" />

<div class="wrapper">
	<main class="notice-detail__main">
		<div class="notice-detail__table-wrap">
			<table class="notice-detail__table">
				<colgroup>
					<col width="16.6%" />
					<col width="16.6%" />
					<col width="16.6%" />
					<col width="16.6%" />
					<col width="16.6%" />
					<col width="16.6%" />
				</colgroup>
				<tr>
					<td class="table-td__head">공지 번호</td>
					<td>${noticeDetail.noticeNo }</td>
					<td class="table-td__head">작성자</td>
					<td>${noticeDetail.adminId }</td>
					<td class="table-td__head">작성일자</td>
					<td>
					<fmt:formatDate value="${noticeDetail.regDate }" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td class="table-td__head">제목</td>
					<td colspan="5">${noticeDetail.title }</td>
				</tr>
				<tr>
					<td class="table-td__content" colspan="6">${noticeDetail.content }</td>
				</tr>
			</table>
		</div>
		<div class="notice-detail__btn-wrap">
			<span class="btn btn-tolist" id="toList">목록으로</span><span class="btn btn-delete" id="notice-delete" data-noticeno="${noticeDetail.noticeNo }" >삭제</span>
		</div>
	</main>
</div>

<!-- button event  -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/notice/admin_notice_detail_btn_event.js" ></script>

<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>