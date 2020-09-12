<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 버튼 div 영역 -->
<div class="oneonone-detail__btn-wrap">
	<span class="btn write-btn" id="toWrite">답변하기</span><span class="btn list-btn" id="toList">목록으로</span>
</div>

<!-- 작성 폼 div 영역 숨겨놓기 -->
<div class="oneonone-detail__write-form-wrap">
	<c:choose>
		<c:when test="${not empty question.userId }">
			<form action="<%=request.getContextPath() %>/admin/oneonone/write?writeCode=1&questionNo=${question.questionNo }" method="post" id="question-write-form">
		</c:when>
		<c:when test="${not empty question.farmerId }">
			<form action="<%=request.getContextPath() %>/admin/oneonone/write?writeCode=2&questionNo=${question.questionNo }" method="post" id="question-write-form">
		</c:when>
	</c:choose>
<%-- 	<form action="<%=request.getContextPath() %>/admin/oneonone/write?questionNo=${question.questionNo }" method="post" id="question-write-form"> --%>
		<ul>
			<li>
				<input type="text" placeholder="답변 제목" name="title" id="title" />
			</li>
			<li class="ckeditor-wrap">
				<textarea name="content" id="oneononeContent"></textarea>
				<script type="text/javascript">
					CKEDITOR.replace( 'oneononeContent'
									, { filebrowserUploadUrl: '/farmapp/common/imageupload?boardNo=6&postNo=' + ${question.questionNo}
									, placeholder: '답변 내용'
									, wordcount: {
										// Whether or not you want to show the Paragraphs Count
									    showParagraphs: true,

									    // Whether or not you want to show the Word Count
									    showWordCount: true,

									    // Whether or not you want to show the Char Count
									    showCharCount: true,

									    // Whether or not you want to count Spaces as Chars
									    countSpacesAsChars: false,

									    // Whether or not to include Html chars in the Char Count
									    countHTML: false,
									    
									    // Maximum allowed Word Count, -1 is default for unlimited
									    maxWordCount: -1,

									    // Maximum allowed Char Count, -1 is default for unlimited
									    maxCharCount: 1000,

									    // Add filter to add or remove element before counting (see CKEDITOR.htmlParser.filter), Default value : null (no filter)
									    filter: new CKEDITOR.htmlParser.filter({
									        elements: {
									            div: function( element ) {
									                if(element.attributes.class == 'mediaembed') {
									                    return false;
									                }
									            }
									        }
									    })
									}
						});
				</script>
			</li>
		</ul>
	</form>
	<!-- 작성, 취소 버튼 -->
	<div class="write-form-wrap__btn-wrap">
		<span class="btn write-question" id="write">작성</span><span class="btn cancel-question" id="cancel-write">취소</span>			
	</div>		
</div>