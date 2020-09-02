<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/user.css">

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
<div class="farmer">
	<div class="member">농부 회원<br></div>
	<form action="<%=request.getContextPath()%>/farmer/loginimpl.do" method="post">
 	<input type="text" id="farmerId" name="farmerId" placeholder="  id"/><button type="submit" class="login">로그인</button><br>
	<input type="password" id="farmerPw" name="farmerPw" placeholder="  ****"/>
	<input type="button" class="login" value="회원가입" id="tojoin" /><br>
<!-- 	<button type="button" class="login" onclick="toJoin()">회원가입</button><br>  -->
<%-- 	<img alt="facebook" src="<%=request.getContextPath()%>/resources/image/member/facebook.png" class="social"/> --%>
<%-- 	<img alt="kakao" src="<%=request.getContextPath()%>/resources/image/member/kakao.png" class="social"/> --%>
	<input type="button" class="login" value="아이디/비밀번호 찾기" id="finduser" style="width: 200px; float: right; margin-top: 3px;"/>
<!-- 	<button type="button"class="find" style="margin-top: 5px;">아이디/비밀번호 찾기</button> -->
	</form>
</div></div>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#tojoin").click(function(){
		location.href="<%=request.getContextPath()%>/farmer/farmertos.do"
	})
	
	$("#finduser").click(function(){
		location.href="<%=request.getContextPath()%>/farmer/findmember.do"
	})
	
})

</script>
<%@include file="../include/footer.jsp" %>