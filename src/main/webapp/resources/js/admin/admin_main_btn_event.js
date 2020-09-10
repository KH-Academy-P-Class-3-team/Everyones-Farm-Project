/**
 * 관지라 메인 페이지 버튼 이벤트 
 */
// 농업인 회원 신청 관리하러 가기 버튼 클릭 이벤트
$("#toFarmerApplication").on("click", function(){
	
	$(location).attr("href", "/farmapp/adminmember/fapplicationlist")
	
})
$("#").on("click", function(){
	
	$(location).attr("href", "/farmapp/admin/oneonone/user")
	
})