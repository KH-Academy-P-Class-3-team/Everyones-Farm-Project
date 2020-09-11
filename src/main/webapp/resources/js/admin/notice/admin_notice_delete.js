/**
 * admin notice 삭제 이벤트
 */
$("#notice-del-btn").on("click", function(){

	const checkCnt = $("input[name='checkNormal']:checked").length
	const chkArr = new Array();
	$("input[name='checkNormal']:checked").each(function() {
		/* 체크박스가 체크된 행의 value 값 */
		chkArr.push($(this).val())
	})
	
	/* 체크된 체크박스가 없을 때! */
	if( checkCnt == 0 ){
		alert("선택된 공지사항이 없습니다.")
	} else { /* 체크된 체크박스가 있을 때! */
		
		/* AJAX 통신 */
		$.ajax({
			type: "POST" /* method type */
			, url: "/farmapp/adminnotice/delete" /* ajax url */
			, data: "noticeNo=" + chkArr + "&checkCnt=" + checkCnt /* ajax 통신 데이터 */
			, dataType: "json" /* 통신하는 데이터 type */
// 			, contentType:"application/json;charset=UTF-8"
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
		
	}
	
})