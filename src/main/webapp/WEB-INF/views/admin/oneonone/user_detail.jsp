<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>
<!-- ckeditor js 파일 삽입 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>

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
.oneonone-detail__btn-wrap .btn
, .write-form-wrap__btn-wrap .btn {
	padding: 16px;
    border-radius: 3px;
    font-weight: 700;
    cursor: pointer;
}
/* 답변하기, 작성, 답변수정 버튼 */
.oneonone-detail__btn-wrap .write-btn
, .write-form-wrap__btn-wrap .write-question
, .oneonone-detail__btn-wrap .update-btn 
, .write-form-wrap__btn-wrap .update-question {
	background: #789F6F;
	margin-right: 10px;
}
/* 목록으로, 취소 버튼 */
.oneonone-detail__btn-wrap .list-btn
, .write-form-wrap__btn-wrap .cancel-question  {
	background: #EAE891;
}
/* 답변 삭제 버튼 */
.oneonone-detail__btn-wrap .delete-btn {
	background: #952F2F;
	margin-right: 10px;
}
/* 작성 폼 css */
.main__oneonone-detail .oneonone-detail__write-form-wrap {
	margin-top: 30px;
}
/* input, textarea width */
.oneonone-detail__write-form-wrap input
, .oneonone-detail__write-form-wrap textarea {
	width: 100%;
}
/* input css */
.oneonone-detail__write-form-wrap input {
	appearance: none;
}
.oneonone-detail__write-form-wrap input[type="text"] {
	height: 50px;
    border: 2px solid #789F6F;
    padding: 7px 14px;
    margin-bottom: 30px;
}
.oneonone-detail__write-form-wrap input[type="text"]:focus {
	outline: none;
	border: 2px solid #605759;
}
/* 작성폼 숨겨놓기 */
.main__oneonone-detail .oneonone-detail__write-form-wrap {
 	display: none;
}
/* 작성폼 버튼 div */
.oneonone-detail__write-form-wrap .write-form-wrap__btn-wrap {
	display: flex;
    justify-content: center;
    margin-top: 30px;
}
/* answer wrap css */
.main__oneonone-detail .answer-wrap {
	margin-top: 30px;
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
		
		<!-- 답변이 있을 때, 없을 때 -->
		<c:choose>
			<c:when test="${empty answer }">
			<%@include file="./question_write.jsp" %>
			</c:when>
			<c:when test="${not empty answer }">
			<%@include file="./question_update.jsp" %>
			</c:when>		
		</c:choose>
		
	
	</main>
</div>

<!-- button event javascript -->
<script type="text/javascript">
/* 목록으로 가기 버튼 클릭 */
$("#toList").on("click", function(){
	
	// 뒤로가기
	history.go(-1)
	
})
/* 답변하기 버튼 클릭 이벤트 - 답변하기 클릭시  작성 폼 보여주기 */
$("#toWrite").on("click", function(){
	
	const $writeFormDiv = $(".oneonone-detail__write-form-wrap")
	
	const $btnDiv = $(".oneonone-detail__btn-wrap")
	
	// 작성폼이 보인다
	// 작성폼 영역이 none 일 때
	if( $writeFormDiv.css("display") == 'none' ){
		
		$writeFormDiv.css("display", "block")
		// 제목 input focus
		$("#title").focus()
		
	}

	// 답변하기 버튼의 div 영역을 숨긴다
	if( $btnDiv.css("display") == 'flex' ){
		
		$btnDiv.css("display", "none")
		
	}
})
/* 답변하기 클릭 후 나타나는취소 버튼 클릭 이벤트 */
$("#cancel-write").on("click", function(){
	
	const $writeFormDiv = $(".oneonone-detail__write-form-wrap")
	
	const $btnDiv = $(".oneonone-detail__btn-wrap")
	
	// 작성 폼 사라지게 하기
	if( $writeFormDiv.css("display") == 'block' ) {
		
		$writeFormDiv.css("display", "none")
		
	}
	
	// 답변하기 버튼의 div 영역을 보이게 한다.
	if( $btnDiv.css("display") == 'none' ){
		
		$btnDiv.css("display", "flex")
		
	}
})
/* 답변하기 클릭 후 나타나는 작성 버튼 클릭 이벤트 */
$("#write").on("click", function(){
	
	if( $("input[name='title']").val() == '') {
		
		alert("답변 제목을 입력해주세요!")
		// 제목 input focus
		$("#title").focus()
		
	} else if ( CKEDITOR.instances.oneononeContent.getData() == '' ) {
		
		alert("답변 내용을 입력해주세요!")
		// ckeditor focus
		CKEDITOR.instances.oneononeContent.focus()
		
	} else {
		
		$("#question-write-form").submit()
		
	}
	
})
/* 답변 수정 버튼 클릭 이벤트 - 수정 폼 보여주기 */
$("#toUpdate").on("click", function(){
	
	const $updateFormDiv = $(".update-form-wrap")
// 	console.dir($updateFormDiv)
	const $btnDiv = $(".oneonone-detail__btn-wrap")
// 	console.dir($btnDiv)
	
	// 수정 폼이 보인다
	// 수정 폼 영역이 none 일 때
	if( $updateFormDiv.css("display") == 'none' ) {
		// 수정 폼 보이게
		$updateFormDiv.css("display", "block")
		// 제목 input focus
		$("#title").focus()
		
	}

	// 답변 수정, 답변 삭제, 목록으로 버튼 영역 숨기기
	if( $btnDiv.css("display") == 'flex' ) {
		
		// 숨기기
		$btnDiv.css("display", "none")
		
	}
	
})
/* 답변수정 클릭 후 나타나는 수정 버튼 클릭 이벤트 */
$("#update").on("click", function(){
	
	if( $("input[name='title']").val() == '') {
		
		alert("답변 제목을 입력해주세요!")
		// 제목 input focus
		$("#title").focus()
		
	} else if ( CKEDITOR.instances.oneononeContent.getData() == '' ) {
		
		alert("답변 내용을 입력해주세요!")
		// ckeditor focus
		CKEDITOR.instances.oneononeContent.focus()
		
	} else {
		
		$("#question-update-form").submit()
		
	}
	
})
/* 답변 삭제 버튼 클릭 이벤트 */
$("#delete-answer").on("click", function(){
	
	const answeredNo = $(this).data("answeredno")
	const questionNo = $(this).data("questionno")
	console.log(questionNo)
	
	/* AJAX 통신 */
	$.ajax({
		type: "POST" /* method type */
		, url: "/farmapp/admin/oneonone/user/delete" /* ajax url */
		, data: "answeredNo=" + answeredNo + "&questionNo=" + questionNo /* ajax 통신 데이터 */
		, dataType: "json" /* 통신하는 데이터 type */
		, success: function( res ){ /* ajax 통신 성공시 */
			/* res 값이 1이 아닐 때 */
			if(res != 1){
			
				alert("답변 삭제가 오류로 인해 진행되지 않았습니다.")
				
			} else { /* res 값이 1일 때 */
				
				alert("답변 삭제가 정상적으로 진행됐습니다.")
				// redirect 진행
// 				$(location).attr("href", "/farmapp/admin/oneonone/user/detail?questionNo="?)
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