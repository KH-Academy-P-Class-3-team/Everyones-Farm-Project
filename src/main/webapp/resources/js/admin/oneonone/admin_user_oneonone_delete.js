/**
 * 
 */
/* 답변 삭제 버튼 클릭 이벤트 */
$("#delete-answer").on("click", function(){
	
	const answeredNo = $(this).data("answeredno")
	const questionNo = $(this).data("questionno")
	console.log(questionNo)
	
	/* AJAX 통신 */
	$.ajax({
		type: "POST" /* method type */
		, url: "/farmapp/admin/oneonone/delete" /* ajax url */
		, data: "answeredNo=" + answeredNo + "&questionNo=" + questionNo + "&deleteCode=1" /* ajax 통신 데이터 */
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