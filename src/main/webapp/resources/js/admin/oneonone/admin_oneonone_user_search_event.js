/**
 * 일반회원 1대1 문의 검색 이벤트 
 */
function isEmptyWord() {
	alert("검색어를 입력해주세요.")
	$("#member-search").focus()
}
function isNotEmptyWord(word) {
	$(location).attr("href", "/farmapp/admin/oneonone/user?search=" + word)
}
$("#search-btn").on("click", function(){
	
	const word = $("#member-search").val() 
	/* 검색어가 입력되어 있지 않을 경우에는 이벤트 적용 안되게 */
	if(word == ''){
		
		isEmptyWord()
			
	} else {
		
		isNotEmptyWord( word )
		
	}
})
/* 검색창에서 enter 버튼 누를 시 검색 되게 */
$("#member-search").on("keydown", function(event){
	
	const word = $("#member-search").val() 
	/* Enter key 누를 때 */
	if( event.keyCode == 13 ){
		if(word == ''){
			
			isEmptyWord()
			
		} else {
			
			isNotEmptyWord( word )
			
		}
	}
})