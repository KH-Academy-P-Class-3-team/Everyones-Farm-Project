<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/tos.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
    
    $("#nextBtn").click(function(){    
        if($("#use").is(":checked") == false){
            alert("필수 약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
            return;
        }else if($("#user").is(":checked") == false){
            alert("필수 약관에 동의 하셔야 다음 단계로 진행 가능합니다..");
            return;
        }else{
            $("#tos").submit();
        }
    });    

    
    $("#checkall").change(function(){
    	if($("input:checkbox[id='checkall']").prop("checked")){
			$("input[type=checkbox]").prop("checked", true);
		} else{
			$("input[type=checkbox]").prop("checked", false);
		}
    	
	});
    
    $("input[name='chk']").click(function(){
    	if($("input[name='chk']:checked").length==3){
    		$("#checkall").prop("checked", true);
    	} else {
    		$("#checkall").prop("checked", false);
    	}
    });
    
    
    $("#cancel").click(function(){
    	history.back(-1);
    });
    
});




</script>
<div style="clear: both; margin-top: 200px;"></div>
<div class="farmer">
<h2>농부 사용자 회원가입</h2>
<form id="tos" action="<%=request.getContextPath()%>/farmer/farmerjoin.do" method="post">
<input type="checkbox" id="checkall" /> 
<label for="checkall"> <span class="check">이용약관(필수), 개인정보 수집 및 이용(필수), 안내 메일 수신(선택)에 모두 동의합니다</span> </label><br><br>

<input type="checkbox" id="use" name="chk" /> 
<label for="use"><span class="check">이용약관(필수)</span></label><br>
<textarea>필수~</textarea>

<input type="checkbox" id="user" name="chk" /> 
<label for="user"><span class="check">개인정보 수집 및 이용(필수)</span></label><br>
<textarea>필수~</textarea>

<input type="checkbox" id="mail" name="chk" /> 
<label for="mail"><span class="check">안내 메일 수신(선택)</span></label><br><br>

<div style="text-align:center;">
<input type="button" class="find" id="cancel" value="취소" />
<input type="button" class="find" id="nextBtn" value="다음 단계" />
</div>
</form>

</div>

<%@include file="../include/footer.jsp" %>