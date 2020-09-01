/**
 * 관리자 로그인 입력 폼에 빈칸일때, 정규식에 맞지 않을 때, 관리자 로그인 버튼(div 영역으로 만듬)을 클릭 했을 때의 이벤트
 */

/* id input 에 포커스 */
$("input[type='text']").focus()

/* 로그인 버튼 클릭시 */
$("#login-btn").on("click", function(){

	/* submit 이벤트 발생 */
	$("#login-form").submit()

})
/* 아이디 입력 폼에서 */
$("#adminId").on("keydown", function( e ){
	/* Enter = 13 */
	if(e.keyCode == 13){
		$("#login-form").submit()
	}
})
/* 비밀번호 입력 폼에서 */
$("#adminPw").on("keydown", function( e ){
	/* Enter = 13 */
	if(e.keyCode == 13){
		$("#login-form").submit()
	}
})
/* form submit event */
$("#login-form").on("submit", function(){
	/* 아이디와 비밀번호 정규식 */
	const idRegEx = /^[A-Za-z][A-Za-z0-9]{5,20}$/
	const pwRegEx = /^[A-Za-z0-9]{6,12}$/
	
	/* 1. 아이디 input 이 비어있는 지 확인 */
	if( $("#adminId").val() == '' ){
	
		alert('아이디를 입력해주세요.')
	
		/* 아이디 input focus */	
		$("#adminId").focus()
		
		/* submit 이벤트 발생 저지 */
		return false
		
	} else if ($("#adminId").val() != '' && !idRegEx.test( $("#adminId").val() )){ /* 2. 아이디 input 비어 있지 않고 아이디 정규식이 맞지 않을 때 */
		
		alert("관리자 아이디는 영어대소문자로 시작하며, 영어대소문자와 숫자로 이루어진 6자 이상 20자 이하만 가능합니다.")
		
		/* 아이디 input focus */
		$("#adminId").val("")
		$("#adminId").focus()
		
		/* submit 이벤트 발생 저지 */
		return false
		
	} else if( $("#adminPw").val() == '' ){/* 3. 비밀번호 input 이 비어있는 지 확인 */
		
		alert('비밀번호를 입력해주세요.')
		
		/* 비밀번호 input focus */	
		$("#adminPw").focus()
		
		/* submit 이벤트 발생 저지 */
		return false
		
	} else { /* 4. 아이디와 비밀번 호 모두 비어있지 않을 경우(입력되어 있을 경우!) */
		
		if( !pwRegEx.test( $("#adminPw").val() ) ) { /* 5. 비밀번호 정규식 확인 */
			
			alert("관리자 비밀번호는 영어대소문자와 숫자로 이루어진 6자 이상 20자 이하만 가능합니다.")
			
			/* 비밀번호 input focus */	
			$("#adminPw").val("")
			$("#adminPw").focus()
			
			/* submit 이벤트 발생 저지 */
			return false
		}
	}
		
	return true
})