<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/find.css">

<%@include file="../include/header.jsp" %>
<div style="clear: both; margin-top: 200px;"></div>


<div class="pwchange">
	<form action="<%=request.getContextPath()%>/farmer/pwchange.do" method="post" onsubmit="return validate();">
	<div class="member">${farmerPw.name }님, 비밀번호 변경하기<br></div><br>
 	<div class="findmem">
 	<label>비밀번호 * </label><br>
 	<input type="password" class="change" id="farmerPw" name="farmerPw" placeholder="  8글자 이상 15글자 이하의 영어, 숫자, 특수문자로 작성해주세요"/><br>
 	<label>비밀번호 재확인 * </label><br>
 	<input type="password" class="change" id="pwcheck" name="pwcheck" /><br>
	<div style="margin-left: 20px;"><input type="button" value="취소" class="chpw" id="cancel"/>
	<input type="hidden" value=${farmerPw.farmerId } name="farmerId"/>
	<input type="hidden" value=${farmerPw.email } name="email"/>
	<input type="submit" value="비밀번호변경" class="chpw" id="findpw" />
 	</div>
 	</div>
 	</form>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#cancel").click(function(){
		location.href="<%=request.getContextPath()%>/farmer/farmerlogin.do"
	})
	
	
})

function validate() {
        var pass = document.getElementById('farmerPw');
        var passc = document.getElementById('farmerPw').value;
        var passch = document.getElementById('pwcheck').value;
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
        
        return true;
    }

</script>

<%@include file="../include/footer.jsp" %>