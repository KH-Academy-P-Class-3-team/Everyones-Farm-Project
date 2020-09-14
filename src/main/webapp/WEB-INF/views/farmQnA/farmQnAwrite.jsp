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

	$("#btnWrite").on("click", function() {

		var thetitle = $("#title").val()
		var ckeditor = CKEDITOR.instances['content']; 

		if (thetitle == "") {
			alert("제목을 작성해 주세요.");
			form3.title.focus();
		}else if (ckeditor.getData() == "") {
			alert("내용을 작성해 주세요.");
			form3.ckeditor.focus();
		}else {
			$("#form3").submit();
		}

	})

})
</script>

<form id="form3" action="<%= request.getContextPath() %>/QnA/QnAwrite.do" method="post">

<%@include file="../include/farmdiaryheader.jsp" %>

<div style= "clear: both; margin-top: 200px;" ></div>

<div id="container" style="width: 980px; margin: auto;" >

<h3 style="text-align: center;">QnA 작성</h3>
<hr>

<input type="hidden" name="farmerNo" value="${farmerInfo.farmerNo }"/>

<input class="form-control" style="width: 980px;" type="text" id="title" name="title" placeholder="제목을 입력해 주세요."/>   
<hr>	
    	     
<!-- 제목<br> -->
<!-- <input class="form-control" style="width: 200px;" type="text" id="title" name="title"/><br> -->
 <textarea name="content" id="content" rows="10" cols="50">
  글 작성시 지우고 작성해주세요. (유튜브 링크 및 이미지 첨부는 툴바에 있습니다.)
 </textarea>
						<script type="text/javascript">
							CKEDITOR.replace( 'content'
											, { filebrowserUploadUrl: '/farmapp/farmdiary/fileupload'
								});
						</script><br>
<hr>
<!-- 유튜브 링크 <br> -->
<!-- <input class="form-control" style="width: 250px;" type="text" id="youtubeLink" name="youtubeLink"/><br> -->

<!-- <iframe width="980" height="500" src="https://youtu.be/sOKTJ4RHjUo" frameborder="0" allow="autoplay; encrtpted-media"></iframe><br><br> -->

<div style="text-align: center;">
<button id="btnWrite" type="button" class="btn btn-success">등록</button>
</div>
</div>
</form>



<%@include file="../include/footer.jsp" %>