/**
 * 답변 작성, 목록으로, 작성, 수정, 취소, 답변 삭제 등의 버튼 이벤트
 */
/* 목록으로 가기 버튼 클릭 */
$("#toList").on("click", function(){
	
	// 뒤로가기
	$(location).attr("href", "/farmapp/admin/oneonone/user")
	
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
	const $answerDiv = $(".answer-wrap")
//	console.dir($answerDiv)
//	console.dir($answerDiv.css("display"))
	
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
	
	// answer-form 숨기기
	if( $answerDiv.css("display") == "block" ){
		
		// 숨기기
		$answerDiv.css("display", "none") 
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
// 			console.log(res.isDeleted)
// 			console.log(res.questionNo)
			/* res 값이 1이 아닐 때 */
			if(res.isDeleted != 1){
			
				alert("답변 삭제가 오류로 인해 진행되지 않았습니다.")
				
			} else { /* res 값이 1일 때 */
				
				alert("답변 삭제가 정상적으로 진행됐습니다.")
				// redirect 진행
				$(location).attr("href", "/farmapp/admin/oneonone/user/detail?questionNo=" + res.questionNo)
			}
		}
		, error: function(){
			alert("서버통신 오류입니다.")
		}
	})
	
})