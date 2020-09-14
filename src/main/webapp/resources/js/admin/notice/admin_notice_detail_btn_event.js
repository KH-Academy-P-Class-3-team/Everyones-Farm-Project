/**
 *  admin notice detail 페이지 button event
 */
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