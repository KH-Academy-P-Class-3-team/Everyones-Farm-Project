<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
$(".answertWriteBtn").on("click", function(){
	  var formObj = $("form[name='answerForm']");
	  formObj.attr("action", "/QnA/QnAanswerwrite");
	  formObj.submit();
	});
	
});
</script>

<div id="answer">
	<ol class="answerlist">
		<c:forEach items="${answerlist}" var="answerlist">
			<li>
				<p>
					작성자 : ${answerlist.farmerNo}<br />
					 작성 날짜 :<fmt:formatDate value="${answerlist.regDate}" pattern="yyyy-MM-dd" />
				</p>

				<p>${answerlist.content}</p>
			</li>
		</c:forEach>
	</ol>
</div>

<form name="answerForm" method="post">
	<input type="hidden" id="farmQnaQuestionNo" name="farmQnaQuestionNo"value="${detail.farmQnaQuestionNo}" /> 
	<input type="hidden" id="page"name="page" value="${scri.page}"> 
	<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}">
	<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
	<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}">

	<div>
		<label for="farmerNo">댓글 작성자</label>
		<input type="text" id="farmerNo"name="farmerNo" /> <br> 
		<label for="content">댓글 내용</label
		><input type="text" id="content" name="content" />
	</div>
	<div>
		<button type="button" class="answertWriteBtn">작성</button>
	</div>
</form>

