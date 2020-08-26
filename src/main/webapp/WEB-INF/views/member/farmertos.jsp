<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용약관</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/tos.css">
</head>
<body>
<h2>농부 사용자 회원가입</h2>
<div class="farmer">
<input type="checkbox" id="chk" name="checkall"/> 
<label for="chk"> <span class="check">이용약관(필수), 개인정보 수집 및 이용(필수), 안내 메일 수신(선택)에 모두 동의합니다</span> </label><br><br>

<input type="checkbox" id="use" value="use" name="check" /> 
<label for="use"><span class="check">이용약관(필수)</span></label><br>
<textarea>필수~</textarea>

<input type="checkbox" id="user" value="user" name="check"/> 
<label for="user"><span class="check">개인정보 수집 및 이용(필수)</span></label><br>
<textarea>필수~</textarea>

<input type="checkbox" id="mail" value="mail" name="check"/> 
<label for="mail"><span class="check">안내 메일 수신(선택)</span></label><br><br>

<div style="text-align:center;">
<button class="find" onclick="">취소</button>
<button class="find" onclick="">회원 가입</button>
</div>

</div>
</body>
</html>