<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/login.css">

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
<div class="all" style="padding-bottom: 95px;">
<div class="farmer">
	<div class="findid">
	<div class="mfarmer">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/man.png" class="person"/>
	</div>
		<div style="float: left; margin-left: 30px; margin-top: 6px; font-size: 1.1em;">
			관리자에게 전송하였습니다.<br>
			가입 승인을 기다려주세요!
		<div class="btn" style="margin-top: 10px;">
			<input type="button" value="메인으로 이동하기" id="tomain"/>
		</div>
		</div>
	<div class="wfarmer" style="float:right">
	<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" class="person"/>
	</div>
	</div>
<%-- <img alt="tree" src="<%=request.getContextPath()%>/resources/image/member/tree.png" height="400px"/> --%>
</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#tomain").click(function(){
		location.href="<%=request.getContextPath()%>/"
	})

	
})

</script>

<%@include file="../include/footer.jsp" %>