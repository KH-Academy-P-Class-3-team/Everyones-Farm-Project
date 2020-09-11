<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/farmdiaryheader.jsp" %>

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

<form action="<%= request.getContextPath() %>/diary/diarywrite.do" method="post" enctype="multipart/form-data">
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
        <input type="file" name="files" id="input_img" multiple />
    </div>
<br>    

제목<br>
<input class="form-control" style="width: 200px;" type="text" id="title" name="title"/><br>
<hr>
 <textarea name="content" id="content" rows="100" cols="50">

 </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor 4
                // instance, using default configuration.
                CKEDITOR.replace( 'content' );
              //  CKEDITOR.instances.content.getData();
            </script><br>
<hr>
유튜브 링크 <br>
<input class="form-control" style="width: 250px;" type="text" id="youtubeLink" name="youtubeLink"/><br>


<iframe width="980" height="500" src="https://youtu.be/sOKTJ4RHjUo" frameborder="0" allow="autoplay; encrtpted-media"></iframe><br><br>

<div style="text-align: center;">
<button class="btn btn-warning">등록</button>
</div>

</div>

</form>
<hr>


<%@include file="../include/footer.jsp" %>