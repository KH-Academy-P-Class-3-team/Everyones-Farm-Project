<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- <script src="//code.jquery.com/jquery-2.2.4.min.js"></script> -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
        .img_wrap {
            width: 300px;
            margin-top: 50px;
        }
        .img_wrap img {
            max-width: 100%;
        }
 
</style>

<!-- ckeditor 사용을 위해 js 파일 연결 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>




<!-- <script src="//code.jquery.com/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript">

// var sel_file;

// $(document).ready(function() {
//     $("#input_img").on("change", handleImgFileSelect);
// }); 

// function handleImgFileSelect(e) {
//     var files = e.target.files;
//     var filesArr = Array.prototype.slice.call(files);

//     filesArr.forEach(function(f) {
//         if(!f.type.match("image.*")) {
//             alert("확장자는 이미지 확장자만 가능합니다.");
//             return;
//         }

//         sel_file = f;

//         var reader = new FileReader();
//         reader.onload = function(e) {
//             $("#img").attr("src", e.target.result);
//         }
//         reader.readAsDataURL(f);
//     });
// }
	
</script>

<form action="<%= request.getContextPath() %>/diary/diarymodify.do" method="post" enctype="multipart/form-data">

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
<button class="btn btn-success">수정하기</button>
</div>
</div>

</form>


<%@include file="../include/footer.jsp" %>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
