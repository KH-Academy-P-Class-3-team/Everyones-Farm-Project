<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>

<style type="text/css">
.wrapper .notice-detail__main {
	margin: 70px auto;
}
/* 테이블 초기화 및 css */
.notice-detail__table-wrap .notice-detail__table {
	padding: 0;
	border-spacing: 0px;
	border-collapse: collapse;
	width: 100%;
}
/* 테이블 tr */
.notice-detail__table-wrap .notice-detail__table
, .notice-detail__table tr {
	border-top: 1px solid #789F6F;
	border-bottom: 1px solid #789F6F;
}
/* 테이블 td */
.notice-detail__table td {
	padding: 14px 10px;
	text-align: center;
}
/* 테이블 내용 부분 */
.notice-detail__table .table-td__content {
	text-align: left;
    height: 350px;
}
/* 테이블 제목 부분 */
.notice-detail__table .table-td__head {
	background: #D1E9CA;
}
/* 테이블 아래 button 들 */
.notice-detail__main .notice-detail__btn-wrap {
	display: flex;
	justify-content: center;
    margin-top: 20px;
}
.notice-detail__btn-wrap .btn {
    background: green;
    padding: 10px 18px;
    border-radius: 3px;
    font-weight: 700;
    cursor: pointer;
}
.notice-detail__btn-wrap span:not(.btn-delete) {
	margin-right: 7px;
}
/* 목록 버튼 */
.notice-detail__btn-wrap .btn-tolist {
	background: #789F6F;
}
/* 삭제 버튼 */
.notice-detail__btn-wrap .btn-delete {
	background: #B65656;
}
</style>

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
<script type="text/javascript">
/* 목록으로 버튼 클릭 이벤트 */
$("#toList").on("click", function(){
	/* 뒤로가기 */
	history.go(-1)
})
/* 삭제 버튼 클릭 이벤트 */
$("#notice-delete").on("click", function(){
	const noticeNo = $(this).data("noticeno")
	/* AJAX 통신 */
	$.ajax({
		type: "POST" /* method type */
		, url: "/farmapp/adminnotice/delete" /* ajax url */
		, data: "noticeNo=" + noticeNo /* ajax 통신 데이터 */
		, dataType: "json" /* 통신하는 데이터 type */
//			, contentType:"application/json;charset=UTF-8"
		, success: function( res ){ /* ajax 통신 성공시 */
			/* res 값이 1이 아닐 때 */
			if(res != 1){
			
				alert("공지사항 삭제가 오류로 인해 진행되지 않았습니다.")
				
			} else { /* res 값이 1일 때 */
				
				alert("공지사항 삭제가 정상적으로 진행됐습니다.")
				// redirect 진행
				$(location).attr("href", "/farmapp/adminnotice/list")
			}
		}
		, error: function(){
			alert("서버통신 오류입니다.")
		}
	})
	
})
</script>

<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>