<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/activity/activityForm.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<<<<<<< HEAD
</head>
<body>

<div class="form-top">
	<h1>체험 등록 신청</h1>
	<p>농장에서 체험할 수 있는 다양한 활동을 다른 사람들과 나누어 보세요.</p>
	<p>부족한 일손을 채우는 일이 누군가에게는 경험이 됩니다.</p>
=======

<div style="margin-top:220px"></div>

<div class="form-top">
	<div class="top-title">체험 등록 신청</div>
	<div class="top-sub">농장에서 체험할 수 있는 다양한 활동을 다른 사람들과 나누어 보세요.</div>
	<div class="top-sub">부족한 일손을 채우는 일이 누군가에게는 경험이 됩니다.</div>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
</div>


<div class="form-content">

	
	<div class="activity-form">
	
		<form id="frm" action="<%= request.getContextPath() %>/activity/activityForm.do" method="post" enctype="multipart/form-data">
	
		<div class="form-group">
			<div class="control-label">체험 유형</div>
			<label class="radio"><input type="radio" name="isHelp" id="experience" value="0" checked="checked">농장 체험</label>
			<label class="radio"><input type="radio" name="isHelp" id="help" value="1">일손 돕기</label>
		</div>	
		
		<div class="form-group">
			<div class="control-label"><label for="title">체험명</label></div>
			<input type="text" name="title" id="title">
		</div>

		<div class="form-group">
			<div class="control-label">참여 가능 인원</div>
			<input type="number" name="availNumber" id="availNumber">&nbsp;&nbsp; 
			<label for="availNumber">명</label>
		</div>

		<div class="form-group">
			<div class="control-label price-label">요금</div><span class="price-span">(인당)</span>
			<input type="number" name="price" id="price" placeholder="일손돕기 선택 시 요금은 입력하지 않아도 됩니다.">&nbsp;&nbsp; 
			<label for="price">원</label>
		</div>
	
		<div class="form-group">
			<div class="control-label"><label for="content">체험 내용</label></div>
			<textarea name="content" id="content" placeholder="체험 활동에 대해 간단히 소개해주세요."></textarea>
		</div>

		<div class="form-group">
			<div class="control-label">이미지 업로드</div>
			<input type="file" name="files" id="files" multiple>
			<label class="files" for="files">사진 선택</label>
			<span class="file-text">이미지 크기는 980 x 600 픽셀을 권장합니다</span>
			<div class="file-name"></div>
		</div>
		
		<div class="form-group">
			<div class="control-label">체험 일정</div>
			<table class="schedule">
				<thead>
					<tr>
						<th class="th1">시간</th><th class="th2">내용</th><th class="th3">비고</th>
					</tr>
				</thead>
				<tbody class="tbody">
					<tr>
						<td><input type="text" name="time" placeholder="ex) 11:30 - 12:30" style="border:none;width:98%;font-size:1em;"></td>
						<td><input type="text" name="table-content" placeholder="ex) 점심시간" style="border:none;width:98%;font-size:1em;"></td>
						<td><input type="text" name="etc" placeholder="ex) 도시락 제공" style="border:none;width:98%;font-size:1em;"></td>
					</tr>
				</tbody>
			</table>
			
			<div class="btnAdd"><img src="<%=request.getContextPath() %>/resources/image/activity/plus.png" id="add" onclick="addRow()" alt="일정 추가" width="50" height="50"></div>
		</div>
		
		
			<button class="btnSubmit">체험 등록하기</button>
		
		</form>
		
	</div>
	
	
	
</div>



<script type="text/javascript">
$(document).ready(function() {

/*
 * 폼 전송 시 input 요소 null 검사
 */
$("#frm").on("submit", function( e ) {

	
	if($("input[name='title']").val() == '') {
		
		alert("체험명을 기입하세요.")
		$("input[name='title']").focus();
		return false
		
	}  else if($("input[name='availNumber']").val() == '') {
		
		alert("참여 가능 인원을 기입하세요.")
		$("input[name='availNumber']").focus();
		return false
		
	} else if($("textarea[name='content']").val() == '') {
		
		alert("체험 내용을 작성해주세요.")
		$("input[name='availNumber']").focus();
		return false
		
	} else if($("input[type=radio]:checked").val() == "1") {
		$("input[name=price]").val(0)
	}
	
// 		e.preventDefault();
	return true
	
})


/*
 * 일손돕기 선택 시 요금 입력창 비활성화 
 */
$("input[type=radio]").click(function() {

	if($("input[type=radio]:checked").val() == "1") {
		$("input[name=price]").val("")
		$("input[name=price]").attr("disabled", true);
	} else if($("input[type=radio]:checked").val() == "0") {
		$("input[name=price]").attr("disabled", false);
	}
})


$("#files").change(function(e) {
		
	var files = $("#files")[0].files;
	var div = $(".file-name").html();
	
	div = "";
	
	if(files.length > 1) {
		for(var i=0; i<files.length-1; i++) {
			div += "<div>" + files[i].name + "</div>";
		}
	}
	
	div += files[files.length-1].name;
	
	$(".file-name").html(div);
		
})
	
	
	
})
	
/*
 * 체험 일정 추가 버튼 클릭 시 실행되는 함수
 *	일정 테이블에 행 추가
 *	이전 행 null일 경우 추가되지 않음 
 */
function addRow() {
	var tbody = document.getElementsByClassName('tbody')[0];
	var row = tbody.insertRow(tbody.rows.length);
	
	var len = $("input[name='time']").length
	
	if($("input[name='time']").eq(len-1).val() != "" && $("input[name='table-content']").eq(len-1).val() != ""){
		var time = row.insertCell(0);
		var content = row.insertCell(1);
		var etc = row.insertCell(2);
		
		time.innerHTML = '<input type="text" name="time" placeholder="ex) 11:30 - 12:30" style="border:none;width:95%;font-size:1em;">';
		content.innerHTML = '<input type="text" name="table-content" placeholder="ex) 점심시간" style="border:none;width:95%;font-size:1em;">';
		etc.innerHTML = '<input type="text" name="etc" placeholder="ex) 도시락 제공" style="border:none;width:95%;font-size:1em;">';
	} else {
		alert("일정을 입력해주세요.")
	}
	
}






</script>


</body>
</html>