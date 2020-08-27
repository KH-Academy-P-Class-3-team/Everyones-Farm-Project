<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/join.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<%@include file="../include/header.jsp" %>

<style type="text/css">
.main__footer {
    /* width: 980px; */
    margin: 0 auto;
    padding: 50px 0;
    display: flex;
    flex-direction: column;
    /* margin-top: 50px; */
    background: #605759;
}
</style>

<div style="clear: both; margin-top: 200px;"></div>
<div class="all">
<img alt="farm" src="<%=request.getContextPath()%>/resources/image/member/farm.png" class="userjoinfarmimage"/>
<div class="farmer">
	<div class="member">일반 사용자 회원가입<br><br></div>
	<form method="post" action="<%=request.getContextPath()%>/user/joinemailcheck.do" 
		onsubmit="return validate();">
	<label>아이디 *  </label><button type="button" class="btn_id-check" onclick="xmlIdCheck()">ID 확인</button>&nbsp;&nbsp;&nbsp;<span id="id-check-msg" class="id-check-msg"></span><br>
 	<input type="text" id="userId" name="userId" /><br>
<!--  	<div class="id-check"><span id="id-check-msg" class="id-check-msg"></span></div> -->
 	<label>비밀번호 * </label><br>
 	<input type="password" id="userPw" name="userPw" placeholder="  8글자 이상 15글자 이하의 영어, 숫자, 특수문자로 작성해주세요"/><br>
 	<label>비밀번호 재확인 * </label><br>
 	<input type="password" id="pwcheck" name="pwcheck" /><br>
 	<label>이름 * </label><br>
 	<input type="text" id="userName" name="userName" /><br>
 	<label>이메일 * </label><button type="button" class="btn_id-check" onclick="xmlEmailCheck()" style="width:93px;">이메일 확인</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="email-check-msg" class="email-check-msg"></span><br>
 	<input type="text" id="email" name="email" placeholder="  ex) example@naver.com" /><br>
 	<label>전화번호 * </label><button type="button" class="btn_id-check" onclick="xmlPhoneCheck()" style="width:110px;">전화번호 확인</button>&nbsp;&nbsp;&nbsp;<span id="phone-check-msg" class="phone-check-msg"></span><br>
 	<input type="text" id="phone" name="phone" placeholder="  ' - '를 제외하고 작성해주세요"/><br>
 	<label>주소 </label> <br>
 	<div class="addr_wrap1">
	<input type="text" id="sample6_postcode" name="zoneCode" placeholder="  우편번호" style="width: 200px">
	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" style="width: 100px">
	</div>
 	<input type="text" id="sample6_address" placeholder="  주소" name="firstAddress"><br>
	<input type="text" id="sample6_detailAddress" placeholder="  상세주소" name="secondAddress"><br>
	<input type="text" id="sample6_extraAddress" placeholder="  참고항목"><br>
	<div id="err-addr"></div>
	<div class="btn">
 	<button type="button" class="find" onclick="cancel();" id="cancel">취소</button>
	<button type="submit" class="find">회원 가입</button>
	</div>
<!-- 	<input type="submit" value="회원 가입" class="find" /> -->
	</form>
</div>
</div>

<!-- 주소 api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	var ajaxFlag = false;
	
	function validate() {
        var pass = document.getElementById('userPw');
        var passc = document.getElementById('userPw').value;
        var passch = document.getElementById('pwcheck').value;
        var name = document.getElementById('userName').value;
        var phone = document.getElementById('phone').value;
        var email = document.getElementById('email').value;
        var regExpPw = /(?=.*\d)(?=.*[~`!@#$%\^&*()-+=])(?=.*[a-zA-Z]).{8,15}$/;

        function chk(re, e, msg) {
            if(re.test(e.value)) {                 
                return true;          
          }else{
                alert(msg);
              e.value = "";
              e.focus();
              //기본 이벤트 취소
              return false;
            }
        }

        if(!ajaxFlag){
           alert("아이디 중복검사를 해주세요");
           return false;
        }
        
        // 비밀번호 검사
         // 암호는 영문자와 숫자로 8글자이상  기호문자 한개이상 8글자 이상
        if(!chk(regExpPw, pass,'비밀번호 영어,숫자,특수문자가 하나 이상 포함, 8글자 이상 15글자 이하')){
        	pass.focus();
           return false;
        }
        
        if(passc != passch){
        	alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
        	pass.focus();
        	return false;
        }
        
        if(name == ""){
        	alert("이름을 입력해주세요!")
        	return false;
        }
        
        if(email==""){
        	alert("이메일을 입력해주세요!")
        	return false;
        }

        return true;
    }
	
	function xmlIdCheck(){
		//사용자가 입력한 id값을 가져온다
		var id = document.querySelector('#userId').value;
		var idc = document.getElementById('userId');
		var regExpId = /^[A-Za-z0-9_]{6,15}$/;
		
        function chk(re, e, msg) {
            if(re.test(e.value)) {                 
                return true;          
          }else{
                alert(msg);
              e.value = "";
              e.focus();
              //기본 이벤트 취소
              return false;
            }
        }
		
		if(id ==""){
			alert("아이디를 입력해주세요!")
			return false;
		}
		
        //id 검사
        if(!chk(regExpId, idc, '아이디는 영어,숫자,특수문자 6자 이상 15자 이하')){
        	idc.focus();
        	return false;
        }
		
		//XMLHttpRequest 객체 생성
		var xhr = new XMLHttpRequest();
		//http request message의 시작줄 작성
		xhr.open('POST', '<%=request.getContextPath()%>/user/idcheck.do');
		//http request message의 header 작성
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		//body에 데이터 작성하고 전송
		xhr.send('userId=' +id);
		//ajax통신이 끝나고 (load) 실행할 콜백함수 등록
		xhr.addEventListener('load', function(){
			//response body 있는 데이터를 받아옴
			var data = xhr.response;
			console.dir(data);
			if(data == ''){  
				ajaxFlag = true;
				document.querySelector("#id-check-msg").textContent = '사용가능한 아이디입니다';
			} else{
				ajaxFlag = false;
				document.querySelector("#id-check-msg").textContent = data+ '는 이미 존재하는 아이디입니다';
			}
		})
	}
	
	function xmlEmailCheck(){
		//사용자가 입력한 id값을 가져온다
		var email = document.querySelector('#email').value;
		var emailc = document.getElementById('email');
		var regExpEmail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

        function chk(re, e, msg) {
            if(re.test(e.value)) {                 
                return true;          
          }else{
                alert(msg);
              e.value = "";
              e.focus();
              //기본 이벤트 취소
              return false;
            }
        }
		
		if(email ==""){
			alert("이메일을 입력해주세요!")
			return false;
		}
		
        //id 검사
        if(!chk(regExpEmail, emailc, '이메일 형식이 아닙니다')){
        	emailc.focus();
        	return false;
        }
		
		//XMLHttpRequest 객체 생성
		var xhr = new XMLHttpRequest();
		//http request message의 시작줄 작성
		xhr.open('POST', '<%=request.getContextPath()%>/user/emailcheck.do');
		//http request message의 header 작성
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		//body에 데이터 작성하고 전송
		xhr.send('email=' +email);
		//ajax통신이 끝나고 (load) 실행할 콜백함수 등록
		xhr.addEventListener('load', function(){
			//response body 있는 데이터를 받아옴
			var data = xhr.response;
			console.dir(data);
			if(data == ''){  
				ajaxFlag = true;
				document.querySelector("#email-check-msg").textContent = '사용가능한 이메일입니다';
			} else{
				ajaxFlag = false;
				document.querySelector("#email-check-msg").textContent = '이미 존재하는 이메일입니다';
			}
		})
	}
	
	function xmlPhoneCheck(){
		//사용자가 입력한 id값을 가져온다
		var phone = document.querySelector('#phone').value;
		var phonec = document.getElementById('phone');
		var regExpPhone =  /^[0-9]*$/;

        function chk(re, e, msg) {
            if(re.test(e.value)) {                 
                return true;          
          }else{
                alert(msg);
              e.value = "";
              e.focus();
              //기본 이벤트 취소
              return false;
            }
        }
		
		if(phone ==""){
			alert("전화번호를 입력해주세요!")
			return false;
		}
		
        //id 검사
        if(!chk(regExpPhone, phonec, '전화번호 형식이 아닙니다')){
        	phonec.focus();
        	return false;
        }
		
		//XMLHttpRequest 객체 생성
		var xhr = new XMLHttpRequest();
		//http request message의 시작줄 작성
		xhr.open('POST', '<%=request.getContextPath()%>/user/phonecheck.do');
		//http request message의 header 작성
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		//body에 데이터 작성하고 전송
		xhr.send('phone=' +phone);
		//ajax통신이 끝나고 (load) 실행할 콜백함수 등록
		xhr.addEventListener('load', function(){
			//response body 있는 데이터를 받아옴
			var data = xhr.response;
			console.dir(data);
			if(data == ''){  
				ajaxFlag = true;
				document.querySelector("#phone-check-msg").textContent = '사용가능한 전화번호입니다';
			} else{
				ajaxFlag = false;
				document.querySelector("#phone-check-msg").textContent = '이미 존재하는 전화번호입니다';
			}
		})
	}
	
	$("#cancel").click(function(){
    	history.back(-1);
    });
	
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }

	
</script>
<%@include file="../include/footer.jsp" %>