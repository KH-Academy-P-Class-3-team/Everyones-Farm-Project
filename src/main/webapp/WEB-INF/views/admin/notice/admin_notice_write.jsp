<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/notice/admin_notice_write.css" />

<!-- ckeditor js 파일 삽입 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>

<div class="wrapper">
	
	<main class="notice-write__main">
		<div class="notice-write__title">
			<span class="notice-write__title-text">공지사항 작성</span>
		</div>
		<!-- 공지사항 작성 폼 -->
		<div class="notice-write__form-wrap">
			<form action="<%=request.getContextPath() %>/adminnotice/write?noticeNo=${postNo}" method="post"
			class="form-wrap__form" id="notice-form">
				<ul class="form-wrap__list">
					<li>
						<input type="text" placeholder="제목" name="title" class="list__input-title" />
					</li>
					<li>
						<textarea name="content" class="list__textarea" id="noticeContent">글씨를 지우고 내용을 입력해주세요.</textarea>
						<script type="text/javascript">
							CKEDITOR.replace( 'noticeContent'
											, { filebrowserUploadUrl: '/farmapp/common/imageupload?boardNo=7&postNo=' + ${postNo}
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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/notice/admin_notice_write_event.js" ></script>
<!-- 취소 버튼 클릭시 목록으로 돌아가기 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/notice/admin_notice_list_btn_event.js"></script>
<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>