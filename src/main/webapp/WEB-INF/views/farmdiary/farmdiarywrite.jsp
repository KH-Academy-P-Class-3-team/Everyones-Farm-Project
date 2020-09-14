<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<<<<<<< HEAD
<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
=======

<!-- <script src="//code.jquery.com/jquery-2.2.4.min.js"></script> -->

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<<<<<<< HEAD

<style type="text/css">
        .img_wrap {
            width: 300px;
            margin-top: 50px;
        }
        .img_wrap img {
            max-width: 100%;
        }
 
</style>
    
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
=======

<!-- ckeditor 사용을 위해 js 파일 연결 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>



<html>
<head>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
<script type="text/javascript">
$(document).ready(function() {

	$("#btnWrite").on("click", function() {

<<<<<<< HEAD
$(document).ready(function() {
    $("#input_img").on("change", handleImgFileSelect);
}); 

function handleImgFileSelect(e) {
    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);

    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            return;
        }

        sel_file = f;

        var reader = new FileReader();
        reader.onload = function(e) {
            $("#img").attr("src", e.target.result);
        }
        reader.readAsDataURL(f);
    });
}
</script>

<form action="<%= request.getContextPath() %>/diary/diarywrite.do" method="post">
<h3>농장 일기 작성</h3>
<hr>

    <div>
        <div class="img_wrap">
            <img id="img" />
        </div>
    </div>
    
	<div>
        <p class="title"></p>
        <input type="file" id="input_img" />
    </div>

제목 : <input type="text" id="title" name="title"/><br>

내용 : <textarea id="content" name="content"></textarea><br>

유튜브 링크 : <input type="text" id="youtubeLink" name="youtubeLink"/><br>

<button class="btn btn-warning">등록</button>

</form>
<hr>
</body>
</html>
=======
		const thetitle = $("#title").val()

		if (thetitle == "") {
			alert("제목을 작성해 주세요.");
		} else {
			$("#form1").submit();   
		
		}

	})

})
</script><body>
<form id="form1" action="<%= request.getContextPath() %>/diary/diarywrite.do" method="post" enctype="multipart/form-data">

<%@include file="../include/farmdiaryheader.jsp" %>

<div style= "clear: both; margin-top: 200px;" ></div>

<div id="container" style="width: 980px; margin: auto;" >

<h3 style="text-align: center;">농장 일기 작성</h3>
<hr>

<input type="hidden" name="farmerNo" value="${farmerInfo.farmerNo }"/>

<input class="form-control" style="width: 980px;" type="text" id="title" name="title" placeholder="제목을  입력해 주세요."/><br>
 
<hr>

 <textarea name="content" id="content">
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
<button id="btnWrite" type="button" class="btn btn-success">작성</button>
<button id="btnCancel" type="button" class="btn btn-success">목록</button>
</div>
</div>

</form>
</body>
</head>
</html>

<%@include file="../include/footer.jsp" %>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
