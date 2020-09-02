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
		<div style="float: left; margin-left: 81px; margin-top: 26px;"><span class="result"> 이메일을 확인해주세요</span></div>
	<div class="wfarmer" style="float:right">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" class="person"/>
	</div>
	</div>
</div>

<%@include file="../include/footer.jsp" %>