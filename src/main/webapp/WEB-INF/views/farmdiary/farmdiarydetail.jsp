<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<style type="text/css">

#d1{
	padding: 300px;
}

#footer{
	height: 100px;
	clear: both;
}

</style>


<%@include file="../include/header.jsp" %>

<form action="/farmapp/farmdiary/farmdiarydetail.do" method="post">

       <div id="d1">
      
      	  <span name="farmdiaryNo" value="${detail.farmDiaryNo}">게시글번호 : ${detail.farmDiaryNo}</span><br>
      	  <span>제목 : ${detail.title}</span><br>
      	  <span>작성자 : ${detail.name}</span><br>
      	  작성일 : <fmt:formatDate value="${detail.enrollDate}" pattern="yyyy-MM-dd"/>
      	  <span>조회수 : ${detail.hit}</span><br>
      	  내용<br>
      	  ${detail.content}<br>
      	  
      	  ${detail.youtubeLink}
      </div>

</form>

<div id="footer">
<%@include file="../include/footer.jsp" %>
</div>
