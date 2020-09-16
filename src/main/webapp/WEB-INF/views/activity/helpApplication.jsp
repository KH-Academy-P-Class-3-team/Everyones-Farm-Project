<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/activity/helpApplication.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	/* 폼 전송 시 input 요소 null 검사 */
	$("#frm").on("submit", function( e ) {
	
		if($("input[name='applicantName']").val() == '') {
			
			alert("신청자 이름을 기입하세요.")
			$("input[name='applicantName']").focus();
			return false
			
		}  else if($("input[name='applicantPhone']").val() == '') {
			
			alert("연락처를 기입하세요.")
			$("input[name='applicantPhone']").focus();
			return false
			
		}  else if($("input[name='applicantEmail']").val() == '') {
			
			alert("이메일을 기입하세요.")
			$("input[name='applicantEmail']").focus();
			return false
			
		}  else if($("input[name='people']").val() == '') {
			
			alert("인원 수를 기입하세요.")
			$("input[name='people']").focus();
			return false
			
		}  else if($("input[name='date']").val() == '') {
			
			alert("신청 날짜를 선택하세요.")
			$("input[name='date']").focus();
			return false
			
		} 	
	
// 		e.preventDefault();
	return true
	
	})
	
	/* 인원 input의 max를 신청 가능 인원까지로 설정 */
	var avail = '${activity.availNumber}';
	
	$("input[name=people]").attr("max", avail);
			
	
});
</script>

<div style="margin-top:220px"></div>


<div class="application-form">

	<div class="form-top">
		<div class="top-sub">신청서 작성</div>
		<div class="top-title">${activity.title }</div>
	</div>
	
	<div class="form-content">
	
		<form id="frm" action="<%= request.getContextPath() %>/activity/activityApplication.do" method="post">
		
		<input type="hidden" name="activityNo" value="${activity.activityNo }" > 
			
		<div class="form-group">
			<div class="control-label">신청자(대표자) 이름</div>
			<input type="text" name="applicantName" id="applicantName" placeholder="ex) 홍길동">
		</div>

		<div class="form-group">
			<div class="control-label">연락처</div>
			<input type="text" name="applicantPhone" id="applicantPhone" placeholder="ex) 010-0000-0000"> 
		</div>

		<div class="form-group">
			<div class="control-label">이메일</div>
			<input type="text" name="applicantEmail" id="applicantEmail" placeholder="ex) email@gmail.com"> 
		</div>
	
		<div class="form-group">
			<div class="control-label">인원 <span class="people-text">(최대 ${activity.availNumber }명)</span></div>
			<input type="number" name="people" id="people" min="1">
		</div>

		<div class="form-group">
			<div class="control-label">신청 날짜</div>
			<input type="date" name="date" id="activityDate">
		</div>
		
		
		<div class="button-div">
			<button id="btnBack" type="button" onclick="javascript:history.back();"> ← </button>
			<button id="btnSubmit">신청하기</button>
		</div>
		
		</form>
		
	</div>
	
	
	
</div>


<%@include file="../include/footer.jsp" %>
