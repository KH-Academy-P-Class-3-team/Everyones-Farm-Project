/**
 * 공지사항 & 자주 묻는 질문 이벤트 
 */
/* div 속성중 data-nno를 가지고 있는 태그들의 click event */
/* 공지사항 부분 click event */
$("div[data-nno]").on("click", function(){

	/* 선택받은 질문의 내용이 보이는 상태일 때 */
	if($(this).next().css("display") == 'block'){
		
		/* 선택받은 질문 가리기 */
		$(this).next().css("display", "none")
		
// 		console.dir($(this).eq(0).children("i").get(0).classList.value)
		
		/* 아래로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-down nrow__icon"
		
	} else if ($(this).next().css("display") == 'none') { /* 선택받은 질문의 내용이 보이는 상태일 때 */
		
		/* 선택받은 질문 보이게 하기 */
		$(this).next().css("display", "block")
		
		/* 위로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-up nrow__icon"
	}
	
})
/* div 속성중 data-fno를 가지고 있는 태그들의 click event */
/* 자주묻는질문 부분 click event */
$("div[data-fno]").on("click", function(){

	/* 선택받은 질문의 내용이 보이는 상태일 때 */
	if($(this).next().css("display") == 'block'){
		
		/* 선택받은 질문 가리기 */
		$(this).next().css("display", "none")
		
		/* 아래로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-down frow__icon"
		
	} else if ($(this).next().css("display") == 'none') { /* 선택받은 질문의 내용이 보이는 상태일 때 */
		
		/* 선택받은 질문 보이게 하기 */
		$(this).next().css("display", "block")
		
		/* 위로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-up frow__icon"
	}
	
})