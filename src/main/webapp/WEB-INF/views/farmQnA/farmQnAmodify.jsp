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

</script>

<form action="<%= request.getContextPath() %>/diary/diarymodify.do" method="post" enctype="multipart/form-data">
<h3>농장 일기 수정</h3>
<hr>

<input type="hidden" name="farmDiaryNo" value="${detail.farmDiaryNo}" />


제목 : <input type="text" id="title" name="title" value="${detail.title}"/><br>

 <textarea name="content" id="content" rows="10" cols="80">
${detail.content}
 </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor 4
                // instance, using default configuration.
                CKEDITOR.replace( 'content' );
              //  CKEDITOR.instances.content.getData();
            </script><br>

<button class="btn btn-warning">수정하기</button>
</div>

</form>
<hr>


<%@include file="../include/footer.jsp" %>