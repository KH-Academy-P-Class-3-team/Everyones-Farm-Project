<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 답변 보여주기 --%>
<div class="oneonone-detail__question-table-wrap answer-wrap">
	<table class="oneonone-detail__question-table">
		<tr class="question-table__tr">
			<td class="question-table__th">답변 제목</td>
			<td class="question-table__td" colspan="3">${answer.title }</td>
		</tr>
		<tr class="question-table__tr">
			<td class="question-table__th">문의자</td>
			<td class="question-table__td td-user">
				<div class="question-table__user-info-wrap">
					<div class="user-info-wrap__user-id">
						<span>${answer.adminId }</span>
					</div>
				</div>
			</td>
			<td class="question-table__th">작성일</td>
			<td class="question-table__td td-user"><fmt:formatDate
					value="${question.regDate }" pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr class="question-table__tr">
			<td colspan="4" class="question-table__th">내용</td>
		</tr>
		<tr class="question-table__tr">
			<td class="question-table__td td-content" colspan="4">
				${answer.content }</td>
		</tr>
	</table>
</div>
<%-- 수정 버튼, 삭제 버튼, 목록으로 버튼 보여주기 --%>
<!-- 버튼 div 영역 -->
<div class="oneonone-detail__btn-wrap">
	<span class="btn update-btn" id="toUpdate">답변 수정</span><span class="btn delete-btn" id="delete-answer" data-questionNo="${answer.questionNo }" data-answeredNo="${answer.answeredNo }">답변 삭제</span><span class="btn list-btn" id="toList">목록으로</span>
</div>

<%-- 수정 폼 보여주기 --%>
<!-- 작성 폼 div 영역 숨겨놓기 -->
<div class="oneonone-detail__write-form-wrap update-form-wrap">
	<form action="<%=request.getContextPath() %>/admin/oneonone/user/update?answeredNo=${answer.answeredNo }&questionNo=${answer.questionNo }" method="post" id="question-update-form">
		<ul>
			<li>
				<input type="text" name="title" id="title" value="${answer.title }" />
			</li>
			<li class="ckeditor-wrap">
				<textarea name="content" id="oneononeContent">${answer.content }</textarea>
				<script type="text/javascript">
					CKEDITOR.replace( 'oneononeContent'
									, { filebrowserUploadUrl: '/farmapp/common/imageupload?boardNo=6&postNo=' + ${answer.questionNo}
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
		<span class="btn update-question" id="update">수정</span><span class="btn cancel-question" id="cancel-write">취소</span>			
	</div>		
</div>