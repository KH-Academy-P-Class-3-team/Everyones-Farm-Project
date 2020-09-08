<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

#d1{
	padding: 300px;
}

#footer{
	height: 100px;
	clear: both;
}

</style>


<%@include file="../include/farmdiaryheader.jsp" %>

<form action="<%= request.getContextPath() %>/farmQnA/farmQnAdelete.do" method="post">
<div id="d1">
    <h3>QnA</h3>
    <hr>
 <table class="table">
        <colgroup>
            <col width="10%">
            <col width="20%">
            <col width="5%">
            <col width="20%">
        </colgroup>
    <tbody>
   	
    	<tr>
      	  <th class="success">제목</th>
      	  <td>${detail.title}</td>
      	  <th class="success">조회수</th>
      	  <td>${detail.hits}</td>
      	</tr>
      	
      	<tr>
      	  <th class="success">작성자</th>
      	  <td>${detail.name}</td>
      	  <th class="success">작성일</th>
      	  <td><fmt:formatDate value="${detail.regDate}" pattern="yyyy-MM-dd"/></td>
      	</tr>
      	<tr>
      	  <th></th>
      	  <td></td>
      	  <th></th>
      	  <td></td>
      	</tr>
      	<tr>
      	  <th></th>
      	  <td></td>
      	  <th></th>
      	  <td></td>
      	</tr>
   
    </tbody>
</table>
     	<div style="height: 300px;"> 	  
     	<hr>
 		 ${detail.content}
 		 
 		 <hr>
 		<button class="btn btn-success pull-right" style="margin-left:1%;" type="button" onclick="location.href='farmQnAdelete.do?farmQnaQuestionNo=${detail.farmQnaQuestionNo}'">삭제</button>
	    <button class="btn btn-success pull-right" style="margin-left:1%;" type="button" onclick="location.href='farmdiarymodify.do?farmDiaryNo=${detail.farmDiaryNo}'">수정</button>
      	</div>


<br>
	  
      
</div>   
</form>
      

<%@include file="../include/footer.jsp" %>