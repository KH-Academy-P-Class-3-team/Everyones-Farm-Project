<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/join.css">
</head>
<body>
<div class="farmer">
	<div class="member">농부 사용자 회원가입<br><br></div>
	<form method="post" action="">
	아이디 * <br>
 	<input type="text" id="userid" name="userid" /><br>
 	비밀번호 * <br>
 	<input type="password" id="pw" name="pw" placeholder="  6글자 이상 12글자 이하의 영어, 숫자로 작성해주세요"/><br>
 	비밀번호 재확인 * <br>
 	<input type="password" id="pwcheck" name="pwcheck" /><br>
 	이름 * <br>
 	<input type="text" id="name" name="name" /><br>
 	이메일 <br>
 	<input type="text" id="email" name="email" placeholder="         @         " /><br>
 	전화번호 * <br>
 	<input type="text" id="phone" name="phone" placeholder="  ' - '를 제외하고 작성해주세요"/><br>
 	<hr style="margin: 20px; color: #605759;">
 	농장 이름 * <br>
 	<input type="text" id="farmname" name="farmname" /><br>
 	농장 소유주 *<br>
 	<input type="text" id="owner" name="owner" /><br>
 	농장 전화번호 * <br>
 	<input type="text" id="farmphone" name="farmphone" placeholder="  ' - '를 제외하고 작성해주세요"/><br>
 	농장 주소 *<br>
 	<input type="text" id="zonecode" name="zonecode" style="width: 250px;"/><button class="addr" onclick="btn_click('addr');">주소 찾기</button><br>
 	<input type="text" id="firstaddress" name="firstaddress" /><br>
 	<input type="text" id="secondaddress" name="secondaddress" /><br>
 	'모두의 농장' 가입 이유 * (하나 이상 선택해주세요)<br>
 	<div class="why" >
 	<input type="checkbox" name="reason" value="농장 홍보" /> 농장 홍보&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<input type="checkbox" name="reason" value="농작물 판매" /> 농작물 판매<br>
 	<input type="checkbox" name="reason" value="농장 체험 홍보" /> 농장 체험 홍보&nbsp;&nbsp;&nbsp;
 	<input type="checkbox" name="reason" value="직접 입력" />직접 입력(입력해주세요!)
 	</div>
 	<input type="text" name="reason" /><br>
 	농작물(생산품)과 규모 *<br>
 	<input type="text" id="product" name="produce" /><br>
 	농부로써 가장 중요하다고 생각하는 마음가짐 *<br>
 	<input type="text" id="mind" name="mind" /><br>
 	농장 소개(500자 내외) *<br>
 	<textarea rows="10" cols="55" style="margin: 7px 7px 12px 7px; border: 1px solid #789F6F;"></textarea><br>
 	<button class="find" onclick="btn_click('cancel');">취소</button>
	<button class="find" onclick="btn_click('join');">회원 가입</button>
<!-- 	<input type="submit" value="회원 가입" class="find" /> -->
	</form>
</div>
</body>
</html>