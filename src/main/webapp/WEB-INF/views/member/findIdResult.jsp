<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/login.css">

<%@include file="../include/header.jsp" %>

<div style="clear: both; margin-top: 200px;"></div>
<div class="farmer">
	<div class="findid">
	<div class="mfarmer">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/man.png" class="person"/>
	</div>
		<div style="float: left; margin-left: 30px; margin-top: 6px; text-align: center; font-size: 1.1em;">회원님의 아이디는<br> <span class="result" style="font-weight: bolder;">${userId.userId } ${farmerId.farmerId } </span> 입니다
		<div class="btn" style="margin-top: 10px;">
			<input type="button" value="메인으로 이동하기" id="tomain"/>
		</div></div>
	<div class="wfarmer" style="float:right">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" class="person"/>
	</div>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/member/js-to-main.js"></script>
<%@include file="../include/footer.jsp" %>