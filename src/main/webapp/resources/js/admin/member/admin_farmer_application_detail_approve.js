/**
 * 상세 조회 페이지에서 입점 신청 승인, 보류 이벤트, 목록으로 가기 이벤트
 */
//입점 보류 버튼 클릭 이벤트
$("#hold-farm").on("click", function(){
	
	const farmerNo = $(this).data("farmerno")
// 	console.log(farmerNo)
	
	/* AJAX 통신 */
	$.ajax({
		type: "POST" /* method type */
		, url: "/farmapp/adminmember/putfapplicationonhold" /* ajax url */
		, data: "farmerNo=" + farmerNo /* ajax 통신 데이터 */
		, dataType: "json" /* 통신하는 데이터 type */
		, success: function( res ){ /* ajax 통신 성공시 */
			/* res 값이 1이 아닐 때 */
			if(res != 1){
			
				alert("입점 보류가 오류로 인해 진행되지 않았습니다.")
				
			} else { /* res 값이 1일 때 */
				
				alert("입점 보류가 정상적으로 진행됐습니다.")
				//reoload
				location.reload()
			}
		}
		, error: function(){
			alert("서버통신 오류입니다.")
		}
	})
})
// 입점 수락 버튼 클릭 이벤트
$("#approve-farm").on("click", function(){
	
	const farmerNo = $(this).data("farmerno")
// 	console.log(farmerNo)
		
	/* AJAX 통신 */
	$.ajax({
		type: "POST" /* method type */
		, url: "/farmapp/adminmember/approvefapplication" /* ajax url */
		, data: "farmerNo=" + farmerNo /* ajax 통신 데이터 */
		, dataType: "json" /* 통신하는 데이터 type */
		, success: function( res ){ /* ajax 통신 성공시 */
			/* res 값이 1이 아닐 때 */
			if(res != 1){
			
				alert("입점 수락이 오류로 인해 진행되지 않았습니다.")
				
			} else { /* res 값이 1일 때 */
				
				alert("입점 수락이 정상적으로 진행됐습니다.")
				// reload
				location.reload()
			}
		}
		, error: function(){
			alert("서버통신 오류입니다.")
		}
	})
})
/* 목록으로 가기 버튼 */
$("#toList").on("click", function(){
	// 뒤로가기 할 생각임
	history.go(-1)
})