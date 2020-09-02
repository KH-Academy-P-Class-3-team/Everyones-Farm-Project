<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/login.css">

<%@include file="../include/header.jsp" %>

<div style="clear: both; margin-top: 200px;"></div>
<div class="farmer">
	<div class="findm">
	<div class="mfarmer">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/man.png" class="person"/></div>
	<div class="login">
	<input type="button" class="find" id="findid" value="아이디 찾기"/><br>
	<input type="button" class="find" id="findpw" value="비밀번호 찾기"/>
<%-- 	<button class="find" onclick="<%=request.getContextPath() %>/user/userlogin.do">아이디 찾기</button><br> --%>
<!-- 	<button class="find" onclick="">비밀번호 찾기</button> -->
	</div>
	<div class="wfarmer">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" class="person"/></div>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#findid").click(function(){
		location.href="<%=request.getContextPath()%>/user/findid.do"
	})
	
	$("#findpw").click(function(){
		location.href="<%=request.getContextPath()%>/user/findpw.do"
	})
	
})

</script>

<%@include file="../include/footer.jsp" %>