<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>

<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 150px;
}

li a {
	display: block;
	color: black;
	background-color: #81c147;

}

li a:hover {
	background-color: #CD853F;
	color: white;
}

a:link { color: red; text-decoration: none;}
a:visited { color: black; text-decoration: none;}
a:hover { color: blue; text-decoration: underline;}





</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>~~님의 농장일기</h3>
<hr>


  	   <table class="list_notice">
       <caption></caption>
       <thead>
           <tr>
               <th style="width: 10%; height:20%;"><span>번호</span></th>
               <th style="width: 50%;"><span>제목</span></th>
               <th style="width: 10%;"><span>등록일</span></th>
           </tr>
       </thead>
       <tbody>
       	<c:forEach items="${list.fdlist}" var="list">
           <tr>
           	   
               <td class="num">${list.farmDiaryNo}</td>
               <td class="subject"><a href="<%= request.getContextPath() %>/farmdiary/farmdiarydetail.do?farmDiaryNo=${list.farmDiaryNo}">${list.title}</a></td>
               <td class="date">
               	<fmt:formatDate value="${list.enrollDate}" pattern="yyyy-MM-dd"/>
               </td>
           </tr>
        </c:forEach>
       </tbody>
       </table>
       
              <div class="paging"><!-- section pagination -->
         <a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do" class="nav first"><i class="fas fa-angle-double-left"></i></a>
        <c:choose>
        	<c:when test="${paging.blockStart > 1 }">
         		<a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockStart-1}" class="nav prev"><i class="fas fa-angle-left"></i></a>
        	</c:when>
        	<c:otherwise>
        		<a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockStart}" class="nav prev"><i class="fas fa-angle-left"></i></a>
        	</c:otherwise>
        </c:choose>
        <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
         <a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${page}" class="num active"><span>${page}</span></a>
        </c:forEach> 
        
        <c:choose>
        	<c:when test="${paging.blockEnd+1 > paging.lastPage }">
         		<a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockEnd}" class="nav next"><i class="fas fa-angle-right"></i></a>
        	</c:when>
        	<c:otherwise>
         		<a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockEnd+1}" class="nav next"><i class="fas fa-angle-right"></i></a>
        	</c:otherwise>
   	   	</c:choose>
 	   	 
 	   	 <a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.lastPage}" class="nav last"><i class="fas fa-angle-double-right"></i></a>
   	   </div><!-- // section pagination -->
       
<div>
	<p>~~님의 농장</p>
</div>

<ul>

	<li><a href="#">농장 소개</a></li>
	<li><a href="#">농장 일기</a></li>
	<li><a href="#">농장 체험</a></li>
	<li><a href="#">QnA</a></li>
	<li><a href="#">개인 농산물</a></li>

</ul>

<hr>

<button class="btn btn-warning" type="button" onclick="location.href='farmdiarywrite.do'">글쓰기</button>
<button class="btn btn-warning" type="button" onclick="location.href='#">관리하기</button>


</body>
</html>