<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/header.jsp" %>

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
<script src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"></script>




<!-- <script src="//code.jquery.com/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript">

var sel_file;

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
<div style="padding: 50px;">
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

 <textarea name="content" id="content" rows="10" cols="80">

 </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor 4
                // instance, using default configuration.
                CKEDITOR.replace( 'content' );
              //  CKEDITOR.instances.content.getData();
            </script><br>

유튜브 링크 : <input type="text" id="youtubeLink" name="youtubeLink"/><br>

<button class="btn btn-warning">등록</button>
</div>

</form>
<hr>


<%@include file="../include/footer.jsp" %>