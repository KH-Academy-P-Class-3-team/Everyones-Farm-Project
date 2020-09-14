/**
 * 농업인 회원가입 하러가기 버튼 클릭 이벤트 
 */
$("#toJoin").on("click", function(){
	
	// 회원가입 페이지로 이동
	$(location).attr("href", "/farmapp/farmer/farmertos.do")
})