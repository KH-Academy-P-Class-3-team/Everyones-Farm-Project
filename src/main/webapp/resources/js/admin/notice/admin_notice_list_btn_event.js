/**
 *	admin notice list 페이지에 button 이벤트 
 */
//공지번호, 제목 클릭시 상세조회 페이지로 넘어가기
$(".toNDetail").on("click", function(){
	const noticeNo = $(this).data("noticeno")
	$(location).attr("href", "/farmapp/adminnotice/detail?noticeNo=" + noticeNo)
})
//작성 버튼에 대한 javascript
$("#notice-write-btn").on("click", function(){
	
	$(location).attr("href", "/farmapp/adminnotice/write")
	
})
// 취소버튼 클릭시
$("#cancel").on("click", function(){
	
	$(location).attr("href", "/farmapp/adminnotice/list")
	
})