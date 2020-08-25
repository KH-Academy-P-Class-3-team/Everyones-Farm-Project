<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/user.css">

<%@include file="../include/header.jsp" %>

<div style="clear: both; margin-top: 200px;"></div>

<div class="farmer">
	<div class="member">일반 회원<br></div>
	<form action="<%=request.getContextPath()%>/user/loginimpl.do" method="post">
 	<input type="text" id="userId" name="userId" placeholder="  id"/><button type="submit" class="login">로그인</button><br>
	<input type="password" id="userPw" name="userPw" placeholder="  ****"/><button type="button" class="login" onclick="toJoin()">회원가입</button><br> 
	<img alt="facebook" src="<%=request.getContextPath()%>/resources/image/member/facebook.png"/>
	<img alt="kakao" src="<%=request.getContextPath()%>/resources/image/member/kakao.png"/>
	<button type="button"class="find" style="margin-top: 5px;">아이디/비밀번호 찾기</button>
	</form>
</div>

<script type="text/javascript">

function toJoin() {
	$(location).attr("href", "./usertos.do")
}

</script>
<%@include file="../include/footer.jsp" %>