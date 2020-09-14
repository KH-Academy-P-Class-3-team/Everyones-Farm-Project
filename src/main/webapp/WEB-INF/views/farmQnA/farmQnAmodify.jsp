<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</script>

<form action="<%= request.getContextPath() %>/QnA/QnAmodify.do" method="post" enctype="multipart/form-data">

<%@include file="../include/farmdiaryheader.jsp" %>

<div style= "clear: both; margin-top: 200px;" ></div>

<div id="container" style="width: 980px; margin: auto;" >

<h3 style="text-align: center;">QnA 수정</h3>
<hr>

<input type="hidden" name="farmQnaQuestionNo" value="${detail.farmQnaQuestionNo}" />


<input type="text" class="form-control" style="width: 980px;" id="title" name="title" value="${detail.title}" placeholder="제목을 입력해 주세요."/><br>
<hr>

 <textarea name="content" id="content" rows="10" cols="80" placeholder="">
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