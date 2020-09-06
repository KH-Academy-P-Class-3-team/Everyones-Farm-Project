<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../include/header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/activity/experienceApplication.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	/* 인원 수를 입력하면 총 결제금액 계산하여 출력 */
	$("#people").on("input", function() {
		
		var price = '${activity.price}';
		var people = $("#people").val();
		
		var total = $(".total").html();
		
		total = price * people;

		// 총 결제금액 숫자 포맷 후 출력
		$(".total").html(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
	})
	
	
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
			
		}  else if($("input[name='activityDate']").val() == '') {
			
			alert("신청 날짜를 선택하세요.")
			$("input[name='activityDate']").focus();
			return false
			
		} 	
	
// 		e.preventDefault();
	return true
	
	})
	
	
	/* 신청 가능 인원이 10 미만일 경우 '단체' 라디오버튼 비활성화 */
	var avail = '${activity.availNumber}';
	
	if(avail < 10) {
		$("input[id=group]").attr("disabled", true);
	}
	
	/* 인원 수 : 개인이면 9명 이하, 단체면 10명 이상 신청 가능 인원 이하 */
	$("input:radio[name=isGroup]").click(function() {
		var avail = '${activity.availNumber}';
		
		if($("input[name=isGroup]:checked").val() == "0") {
		
			$("input[name=people]").attr("min", 1);
			$("input[name=people]").attr("max", 9);
		
		} else if($("input[name=isGroup]:checked").val() == "1") {
			
			$("input[name=people]").attr("min", 10);
			$("input[name=people]").attr("max", avail);
			
		}
	
	})
	
	
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
			<label class="radio"><input type="radio" name="isGroup" id="person" value="0" checked="checked">개인</label>
			<label class="radio"><input type="radio" name="isGroup" id="group" value="1">단체</label>
			<div class="group-text1"> * 단체 기준은 10명 이상입니다.</div>
			<div class="group-text2"> * 단체 신청은 요금이 조금 더 저렴해집니다.</div>
		</div>	
		
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
			<input type="number" name="people" id="people" min="1" max="9">
		</div>

		<div class="form-group">
			<div class="control-label">신청 날짜</div>
			<input type="date" name="date" id="date">
		</div>
		
		<div class="price">
			<span class="red"> * </span> 요금 <span class="price-sub">(인당) </span>
		 	: <fmt:formatNumber value="${activity.price }" pattern="###,###" /> 원
		 </div>
		
		<div class="total-price">
			총 결제금액 &nbsp;<span class="total">0</span> 원
		</div>
		
		
		<div class="button-div">
			<button id="btnBack" type="button" onclick="javascript:history.back();"> ← </button>
			<button id="btnSubmit">신청하기</button>
		</div>
		
		</form>
		
	</div>
	
	
	
</div>


<%@include file="../include/footer.jsp" %>
