<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/find.css">

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

<div class="findall">
<div class="selectuser">
<button class="classify" id="usergeneral">일반회원</button>
<button class="classify" id="userfarmer" style="margin-left: -6px;">농부회원</button>
<img alt="farm" src="<%=request.getContextPath()%>/resources/image/member/farm.png" class="findfarmimage"/>
</div>

<div class="ffff">

<div id="onon" class="member" style="text-align: center; padding-top: 12px;">
회원 구분을 선택해주세요!
<div style="margin-top: 20px;"><img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/man.png" class="social"/>
<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/member/woman.png" class="social"/></div>
</div>

<div class="user" id="user" style="display:none;">
	<form action="<%=request.getContextPath()%>/user/findinfo.do" method="post">
	<div class="member">일반 아이디 찾기<br></div>
 	<div class="findmem">
 	<div class="none">이름 <input type="text" id="userName" name="userName" class="findinput"/></div><br>
	<div class="none">전화번호 <input type="text" id="phone" name="phone" placeholder="  ***-****-****" class="findinput"/> </div><br>
	<input type="button" value="취소" class="find" id="cancel"/>
	<input type="submit" value="아이디찾기" class="find" id="findid" />
 	</div>
 	</form>
</div>

<div class="farmer" id="farmer" style="display:none;">
	<form action="<%=request.getContextPath()%>/farmer/findinfo.do" method="post">
	<div class="member">농부 아이디 찾기<br></div>
 	<div class="findmem">
 	<div class="none">이름 <input type="text" name="name" class="findinput"/></div><br>
	<div class="none">전화번호 <input type="text" name="phone" placeholder="  ***-****-****" class="findinput"/> </div><br>
	<input type="button" value="취소" class="find" id="cancel"/>
	<input type="submit" value="아이디찾기" class="find" id="findid" />
 	</div>
 	</form>
</div>

</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#cancel").click(function(){
		location.href="<%=request.getContextPath()%>/user/usertos.do"
	})
	
	$("#userfarmer").click(function(){
		if($('#farmer').css('display')=='none'){
			$('#farmer').show();
			$('#user').hide();
			$('#onon').hide();
			
		} else{
			$('#farmer').hide();
			$('#onon').show();
		}
	})
	
	$("#usergeneral").click(function(){
		if($('#user').css('display')=='none'){
			$('#user').show();
			$('#farmer').hide();
			$('#onon').hide();
		} else{
			$('#user').hide();
			$('#onon').show();
		}
	})
	
	
})

</script>

<%@include file="../include/footer.jsp" %>