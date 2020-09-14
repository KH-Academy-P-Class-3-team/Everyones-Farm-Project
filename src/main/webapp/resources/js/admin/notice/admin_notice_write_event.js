/**
 * 	작성 버튼 클릭 이벤트
 *  작성할 때 입력 폼이 비어있는 것 에러 처리
 */
/* 작성 폼에 들어오면 제목에 focus 주기 */
$("input[name='title']").focus()
/* 제목 글자수 제한 */
$("input[name='title']").on("keydown", function(){
// 	console.log("공지사항 제목 글자수제한하기 위한 테스트 출력")
	
	const MAX_TITLE_COUNT = 100
	
	if( $(this).val().length > MAX_TITLE_COUNT ) {
		const str = $(this).val()
		alert("제목은 100자까지만 입력 가능합니다.")
		$(this).val(str.substring(0, MAX_TITLE_COUNT))
	}
})
/* 작성 버튼 클릭시 */
$("#notice-write").on("click", function(){
	/* 제목 비어 있으면 제목에 입력하기 */
	if($("input[name='title']").val() == ''){
		
		alert("제목을 입력해주세요")
		$("input[name='title']").focus()
		
	} else if ( CKEDITOR.instances.noticeContent.getData() == '' ) {
		
		alert("내용을 입력해주세요")
		$(CKEDITOR.instances.noticeContent).focus()
		
	} else {
		
		/* form submit 이벤트 동작 */
		$("#notice-form").submit()
		
	}
})