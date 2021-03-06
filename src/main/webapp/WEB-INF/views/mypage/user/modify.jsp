<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp"%>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mypage/modify.css" />
<style type="text/css">
ul {
	margin-bottom: 0px;
}
</style>

<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
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
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("first_addr").value = extraAddr;

						} else {
							document.getElementById("first_addr").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("first_addr").value = addr;
						// 커서를 상세주소 필드로 이동한다.

						onclose('COMPLETE_CLOSE');

					}
				}).open();

	}

	function onclose() {
		new daum.Postcode({
			onclose : function(state) {
				//state는 우편번호 찾기 화면이 어떻게 닫혔는지에 대한 상태 변수 이며, 상세 설명은 아래 목록에서 확인하실 수 있습니다.
				if (state === 'FORCE_CLOSE') {
					//사용자가 브라우저 닫기 버튼을 통해 팝업창을 닫았을 경우, 실행될 코드를 작성하는 부분입니다.

				} else if (state === 'COMPLETE_CLOSE') {
					document.getElementById("second_addr").focus();
				}
			}
		});
	}
</script>




<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top: 200px"></div>
<!-- Page Content -->
<div class="container">
	<div class="row">
	
		<div class="col-lg-3">
			<h3 class="my-4 text-left">회원 정보 수정</h3>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/modify"
						style="font-weight: bold;">회원</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/modify">회원정보
						수정</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List">1대
						1 문의</a>
				</div>
				<c:if test="${farmerInfo eq null }">
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/myActive">활동
						신청 현황</a>
				</div>
				</c:if>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/deleteId"
						style="color: #ccc;">회원 탈퇴</a>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">주문</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">장바구니</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/orderList">구매
						목록</a>
				</div>
			</div>
			<c:if test="${userInfo.userNo eq null }">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/mypage/user/basket">농업인
						</a>
					</div>
					<div class="panel-body">
						<a href="#">내 정보</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/selllist">판매 목록</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/dailyLoglist">영농 일지</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/activitylist">체험 신청내역</a>
					</div>

				</div>
			</c:if>
		</div>
		<c:if test="${userInfo.userNo ne null }">
		<div class="col-lg-1">
			<form method="post"
				action="<%=request.getContextPath()%>/modify/profile"
				enctype="multipart/form-data">
				<div class="media">
					<div class="preview" id="preview">
						<c:if test="${profile eq null }">
							<img
								src="<%=request.getContextPath()%>/resources/image/mypage/no_one.jpg"
								class="img-circle" id="oldone">
						</c:if>
						<c:if test="${profile.userNo eq userInfo.userNo }">
							<img
								src="<%=request.getContextPath() %>/resources/image/mypage/${profile.fileRename}"
								class="img-circle" id="oldone" name="upload">
						</c:if>
					</div>
					<input type="file" id="upload" name="upload" multiple /> <label
						class="files" for="files">사진 선택</label> <span class="file-text">이미지
						크기는 980 x 600 픽셀을 권장합니다</span>
				</div>
				<button type="submit" class="btn btn-warning center-block">사진변경</button>
			</form>
			<form method="post"
				action="<%=request.getContextPath()%>/modify/userInfo"
				onsubmit="return validate();" enctype="multipart/form-data">
				<div class="ModifyUserInfo">
					<!-- 			아이디 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">아이디</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-user"
								id="sizing-addon1"></span> <input type="text"
								class="form-control" placeholder="아이디" name="userId"
								aria-describedby="sizing-addon1" value="${userData.userId}"
								readonly>
						</div>
					</div>
					<!-- 			비밀번호 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">비밀번호</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-lock"
								id="sizing-addon1"></span> <input type="password"
								class="form-control" placeholder="비밀번호" name="userPw"
								id="userPw" aria-describedby="sizing-addon1">
						</div>
					</div>
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">비밀번호
							확인</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-lock"
								id="sizing-addon1"></span> <input type="password"
								class="form-control" placeholder="비밀번호" name="pwcheck"
								id="pwcheck" aria-describedby="sizing-addon1">
						</div>
					</div>
					<!-- 			이름 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">이름</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-user"
								id="sizing-addon1"></span> <input type="text"
								class="form-control" placeholder="이름" name="userName"
								aria-describedby="sizing-addon1" value="${userData.userName}"
								readonly>
						</div>
					</div>

					<!-- 			이메일 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">E-Mail</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-envelope"
								id="sizing-addon1"></span> <input type="email"
								class="form-control" placeholder="E-Mail" name="email"
								id="email" aria-describedby="sizing-addon1"
								value="${userData.email}"> <span
								class="input-group-addon" id="sizing-addon1"><input
								type="button" onclick="xmlEmailCheck()" value="이메일 확인"
								class="half-size back-pink float-right focus form-inlines"></span>
						</div>
						<div id="email-check-msg"></div>
					</div>
					<!-- 			전화번호 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">전화번호</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-earphone"
								id="sizing-addon1"></span> <input type="text"
								class="form-control" id="phone" placeholder="전화번호" name="phone"
								aria-describedby="sizing-addon1" value="${userData.phone}">
							<span class="input-group-addon" id="sizing-addon1"><input
								type="button" onclick="xmlPhoneCheck()" value="번호 중복 검사"
								class="half-size back-pink float-right focus form-inlines"></span>
						</div>
						<div id="phone-check-msg"></div>
					</div>


					<!-- 주소 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">우편번호</label>
						<div class=" input-group-lg col-xs-2 input-group">
							<span class="input-group-addon glyphicon glyphicon-home"
								id="sizing-addon1"></span> <input type="text" name="zoneCode"
								id="sample6_postcode" class="form-control"
								value="${userData.zoneCode }"> <span
								class="input-group-addon" id="sizing-addon1"><input
								type="button" onclick="sample6_execDaumPostcode()" value="우편번호"
								class="half-size back-pink float-right focus form-inlines"></span>
						</div>
					</div>
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">주소</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-home"
								id="sizing-addon1"></span> <input type="text" id="first_addr"
								name="firstAddress"
								class="half-size float-left focus form-control"
								value="${userData.firstAddress}">
						</div>
					</div>
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">상세주소</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-home"
								id="sizing-addon1"></span> <input type="text" id="secondAddress"
								name="secondAddress"
								class="half-size float-left focus form-control"
								value="${userData.secondAddress}">
						</div>
					</div>



					<button type="submit" class="btn btn-warning center-block"
						id="duple" onclick="return validate();">등록</button>
				</div>
			</form>
		</div>
		</c:if>
		<c:if test="${userInfo.userNo eq null }">
		<div class="col-lg-1">
			<form method="post"
				action="<%=request.getContextPath()%>/modify/farmerProfile"
				enctype="multipart/form-data">
				<div class="media">
					<div class="preview" id="preview">
						<c:if test="${profile eq null }">
							<img
								src="<%=request.getContextPath()%>/resources/image/mypage/no_one.jpg"
								class="img-circle" id="oldone">
						</c:if>
						<c:if test="${profile.farmerNo eq farmerData.farmerNo }">
							<img
								src="<%=request.getContextPath() %>/resources/image/mypage/${profile.fileRename}"
								class="img-circle" id="oldone" name="upload">
						</c:if>
					</div>
					<input type="file" id="upload" name="upload" multiple /> <label
						class="files" for="files">사진 선택</label> <span class="file-text">이미지
						크기는 980 x 600 픽셀을 권장합니다</span>
				</div>
				<button type="submit" class="btn btn-warning center-block">사진변경</button>
			</form>
			<form method="post"
				action="<%=request.getContextPath()%>/modify/farmerInfo"
				onsubmit="return validate();" enctype="multipart/form-data">
				<div class="ModifyUserInfo">
					<!-- 			아이디 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">아이디</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-user"
								id="sizing-addon1"></span> <input type="text"
								class="form-control" placeholder="아이디" name="farmerId"
								aria-describedby="sizing-addon1" value="${farmerData.farmerId}"
								readonly>
						</div>
					</div>
					<!-- 			비밀번호 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">비밀번호</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-lock"
								id="sizing-addon1"></span> <input type="password"
								class="form-control" placeholder="비밀번호" name="farmerPw"
								id="userPw" aria-describedby="sizing-addon1">
						</div>
					</div>
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">비밀번호
							확인</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-lock"
								id="sizing-addon1"></span> <input type="password"
								class="form-control" placeholder="비밀번호" name="pwcheck"
								id="pwcheck" aria-describedby="sizing-addon1">
						</div>
					</div>
					<!-- 			이름 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">이름</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-user"
								id="sizing-addon1"></span> <input type="text"
								class="form-control" placeholder="이름" name="name"
								aria-describedby="sizing-addon1" value="${farmerData.name}"
								readonly>
						</div>
					</div>

					<!-- 			이메일 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">E-Mail</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-envelope"
								id="sizing-addon1"></span> <input type="email"
								class="form-control" placeholder="E-Mail" name="email"
								id="email" aria-describedby="sizing-addon1"
								value="${farmerData.email}"> <span
								class="input-group-addon" id="sizing-addon1"><input
								type="button" onclick="xmlEmailCheckFarmer()" value="이메일 확인"
								class="half-size back-pink float-right focus form-inlines"></span>
						</div>
						<div id="email-check-msg"></div>
					</div>
					<!-- 			전화번호 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">전화번호</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-earphone"
								id="sizing-addon1"></span> <input type="text"
								class="form-control" id="phone" placeholder="전화번호" name="phone"
								aria-describedby="sizing-addon1" value="${farmerData.phone}">
							<span class="input-group-addon" id="sizing-addon1"><input
								type="button" onclick="xmlPhoneCheckFarmer()" value="번호 중복 검사"
								class="half-size back-pink float-right focus form-inlines"></span>
						</div>
						<div id="phone-check-msg"></div>
					</div>


					<!-- 주소 -->
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">우편번호</label>
						<div class=" input-group-lg col-xs-2 input-group">
							<span class="input-group-addon glyphicon glyphicon-home"
								id="sizing-addon1"></span> <input type="text" name="zonecode"
								id="sample6_postcode" class="form-control"
								value="${farmerData.zonecode }"> <span
								class="input-group-addon" id="sizing-addon1"><input
								type="button" onclick="sample6_execDaumPostcode()" value="우편번호"
								class="half-size back-pink float-right focus form-inlines"></span>
						</div>
					</div>
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">주소</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-home"
								id="sizing-addon1"></span> <input type="text" id="first_addr"
								name="firstAddress"
								class="half-size float-left focus form-control"
								value="${farmerData.firstAddress}">
						</div>
					</div>
					<div class="input-group">
						<label for="inputName" class="col-lg-3 control-label">상세주소</label>
						<div class="input-group input-group-lg">
							<span class="input-group-addon glyphicon glyphicon-home"
								id="sizing-addon1"></span> <input type="text" id="secondAddress"
								name="secondAddress"
								class="half-size float-left focus form-control"
								value="${farmerData.secondAddress}">
						</div>
					</div>



					<button type="submit" class="btn btn-warning center-block"
						id="duple" onclick="return validate();">등록</button>
				</div>
			</form>
		</div>
		</c:if>
	</div>
</div>








<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#upload")
								.change(
										function(e) {

											var files = e.target.files;
											var reader = new FileReader();

											reader.onload = function(ev) {
												$("#oldone").css('display', 'none');
												var p = $("#preview").html();

												p += "<div class='pre'><img src='"+ev.target.result+"' width='200px' height='200px' class='img-circle'/></div>"
												$("#preview").html(p);

											}

											reader.readAsDataURL(files[0])

										})
					})
</script>

<script type="text/javascript">
	var ajaxFlag = false;
	
	function validate() {
        var pass = document.getElementById('userPw');
        var passc = document.getElementById('userPw').value;
        var passch = document.getElementById('pwcheck').value;
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
           alert("중복검사를 모두 해주세요!");
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
        
        
        if(email==""){
        	alert("이메일을 입력해주세요!")
        	return false;
        }

        if(phone==""){
        	alert("전화번호를 입력해주세요!")
        	return false;
        }

        return true;
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
		xhr.open('POST', '<%=request.getContextPath()%>/modify/emailcheck');
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
				document.querySelector("#email-check-msg").style.color='black';
			} else{
				ajaxFlag = false;
				document.querySelector("#email-check-msg").textContent = '이미 존재하는 이메일입니다';
				document.querySelector("#email-check-msg").style.color='red';
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
		xhr.open('POST', '<%=request.getContextPath()%>/modify/phonecheck');
		//http request message의 header 작성
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		//body에 데이터 작성하고 전송
		xhr.send('phone=' + phone);
		//ajax통신이 끝나고 (load) 실행할 콜백함수 등록
		xhr
				.addEventListener(
						'load',
						function() {
							//response body 있는 데이터를 받아옴
							var data = xhr.response;
							console.dir(data);
							if (data == '') {
								ajaxFlag = true;
								document.querySelector("#phone-check-msg").textContent = '사용가능한 전화번호입니다';
								document.querySelector("#phone-check-msg").style.color = 'black';
							} else {
								ajaxFlag = false;
								document.querySelector("#phone-check-msg").textContent = '이미 존재하는 전화번호입니다';
								document.querySelector("#phone-check-msg").style.color = 'red';
							}
						})
	}
	function xmlEmailCheckFarmer(){
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
		xhr.open('POST', '<%=request.getContextPath()%>/modify/farmerEmailcheck');
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
				document.querySelector("#email-check-msg").style.color='black';
			} else{
				ajaxFlag = false;
				document.querySelector("#email-check-msg").textContent = '이미 존재하는 이메일입니다';
				document.querySelector("#email-check-msg").style.color='red';
			}
		})
	}
	
	function xmlPhoneCheckFarmer(){
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
		xhr.open('POST', '<%=request.getContextPath()%>/modify/farmerPhonecheck');
		//http request message의 header 작성
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		//body에 데이터 작성하고 전송
		xhr.send('phone=' + phone);
		//ajax통신이 끝나고 (load) 실행할 콜백함수 등록
		xhr
				.addEventListener(
						'load',
						function() {
							//response body 있는 데이터를 받아옴
							var data = xhr.response;
							console.dir(data);
							if (data == '') {
								ajaxFlag = true;
								document.querySelector("#phone-check-msg").textContent = '사용가능한 전화번호입니다';
								document.querySelector("#phone-check-msg").style.color = 'black';
							} else {
								ajaxFlag = false;
								document.querySelector("#phone-check-msg").textContent = '이미 존재하는 전화번호입니다';
								document.querySelector("#phone-check-msg").style.color = 'red';
							}
						})
	}
</script>


<%@include file="../../include/footer.jsp"%>