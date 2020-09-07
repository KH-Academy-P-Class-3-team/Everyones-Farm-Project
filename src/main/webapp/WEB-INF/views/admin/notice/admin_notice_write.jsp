<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>

<style type="text/css">
.notice-write__main {
	margin: 70px auto;
	width: 900px;
}
/* 공지사항 작성 제목 */
.notice-write__main .notice-write__title {
	margin-bottom: 20px;
}

.notice-write__title .notice-write__title-text {
	font-size: 20px;
	font-weight: 700;
	opacity: 0.7;
	padding-left: 7px;
	border-left: 3px solid #789F6F;
}
/* 공지사항 작성 폼 */
.notice-write__main .notice-write__form-wrap {
	margin-bottom: 20px;
}
/* input[type=text] css 초기화 */
input[type="text"] {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	outline: none;
}
/* 공지사항 제목 */
.form-wrap__list .list__input-title {
    width: 100%;
    height: 45px;
    padding: 7px 14px;
    border: 2px solid #789F6F;
    border-radius: 3px;
    margin-bottom: 20px;
}
/* 공지사항 textarea */
.form-wrap__list .list__textarea {
    width: 100%;
    height: 350px;
    padding: 7px 14px;
    border-radius: 3px;
    border: 2px solid #789F6F;
    outline: none;
}
.form-wrap__list .list__textarea:focus
, .form-wrap__list .list__input-title:focus {
    border: 2px solid #605759;
}
/* 공지사항 버튼 */
.notice-write__main .notice-write__btn-wrap{
	display: flex;
    justify-content: center;
}
.notice-write__btn-wrap .btn {
    background: #E2CC6C;
    padding: 10px 20px;
    border-radius: 3px;
    display: inline-block;
    font-weight: 700;
    cursor: pointer;
}
.notice-write__btn-wrap .btn:hover{
	background: #D1E9CA;
}
/* 취소버튼 */
.notice-write__btn-wrap .cancel-btn {
	margin-left: 7px;
}
</style>
<!-- ckeditor js 파일 삽입 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>

<div class="wrapper">
	
	<main class="notice-write__main">
		<div class="notice-write__title">
			<span class="notice-write__title-text">공지사항 작성</span>
		</div>
		<!-- 공지사항 작성 폼 -->
		<div class="notice-write__form-wrap">
			<form action="<%=request.getContextPath() %>/adminnotice/write" method="post"
			class="form-wrap__form" id="notice-form">
				<ul class="form-wrap__list">
					<li>
						<input type="text" placeholder="제목" name="title" class="list__input-title" />
					</li>
					<li>
						<textarea name="content" placeholder="내용 입력" class="list__textarea" id="noticeContent" >This is my textarea to be replaced wit CKEditor 4.</textarea>
						<script type="text/javascript">
							CKEDITOR.replace( 'noticeContent'
											, { filebrowserUploadUrl: '/farmapp/adminnotice/fileupload'
								});
						</script>
					</li>
				</ul>
			</form>
		</div>
		<!-- 공지사항 작성, 취소 버튼 -->
		<div class="notice-write__btn-wrap">
			<span class="btn write-btn" id="notice-write">작성</span><span class="btn cancel-btn" id="cancel">취소</span>
		</div>
	</main>

</div>

<!-- 작성 버튼 클릭시 이벤트 -->
<script type="text/javascript">
$("#notice-write").on("click", function(){
	/* form submit 이벤트 동작 */
	$("#notice-form").submit()
})
</script>
<!-- 취소 버튼 클릭시 목록으로 돌아가기 -->
<script type="text/javascript">
$("#cancel").on("click", function(){
	
	$(location).attr("href", "/farmapp/adminnotice/list")
	
})
</script>

<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>