<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- ckeditor 사용을 위해 js 파일 연결 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>



<script type="text/javascript">

$(document).ready(function() {

	$("#btnmodify").on("click", function() {

		var thetitle = $("#title").val()
		var ckeditor = CKEDITOR.instances['content']; 

		if (thetitle == "") {
			alert("제목을 작성해 주세요.");
			form2.title.focus();
		}else if (ckeditor.getData() == "") {
			alert("내용을 작성해 주세요.");
			form2.ckeditor.focus();
		}else {
			$("#form2").submit();
		}

	})

})
	
</script>

<form id="form2" action="<%= request.getContextPath() %>/diary/diarymodify.do" method="post" enctype="multipart/form-data">

<%@include file="../include/farmdiaryheader.jsp" %>

<div style= "clear: both; margin-top: 200px;" ></div>

<div id="container" style="width: 980px; margin: auto;" >

<h3 style="text-align: center;">농장 일기 수정</h3>
<hr>

<input type="hidden" name="farmDiaryNo" value="${detail.farmDiaryNo}" />

<input class="form-control" style="width: 980px;" type="text" id="title" name="title" value="${detail.title}" placeholder="제목을 입력해 주세요."/>
<hr>
 <%-- 유튜브 링크 : <input type="text" id="youtubeLink" name="youtubeLink" value="${detail.youtubeLink}"/><br> --%>
      	  


 <textarea name="content" id="content" rows="10" cols="80">
글 수정시 지우고 작성해주세요. (유튜브 링크 및 이미지 첨부는 툴바에 있습니다.)
${detail.content}
 </textarea>
						<script type="text/javascript">
							CKEDITOR.replace( 'content'
											, { filebrowserUploadUrl: '/farmapp/farmdiary/fileupload'
								});
						</script><br>

<hr>

<div style="text-align: center;">
<button id="btnmodify" type="button" class="btn btn-success">수정하기</button>
</div>
</div>

</form>


<%@include file="../include/footer.jsp" %>