/**
 *  작성 폼 submit 이벤트
 */
$("#question-write-form").on("submit", function(){
	
	// 제목 입력 안되어 있을 시에
	if( $("input[name='title']").val() == '' ){
		alert("제목을 입력해주세요")
		$("input[name='title']").focus()
		return false
	} else if ( CKEDITOR.instances.oneononeContent.getData() == '' ) { // ckeditor 비어있을 경우
		
		alert("답변 내용을 입력해주세요!")
		// ckeditor focus
		CKEDITOR.instances.oneononeContent.focus()
		return false
	}
})