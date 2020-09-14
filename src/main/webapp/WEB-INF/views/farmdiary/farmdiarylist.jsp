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

<<<<<<< HEAD
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

=======

<style type="text/css">

.pagination-wrap {
	margin-top: 30px;
}
/* pagination ul css */
.pagination-wrap .admin__pagination {
	width: 500px;
    display: flex;
    margin: 0 auto;
    justify-content: center;
}
/* pagination ul > li */
.admin__pagination li {
    border: 1px solid #789F6F;
    border-radius: 3px;
    margin-right: 7px;
}
.admin__pagination li:last-child {
	margin: 0;
}
/* pagination ul > li > a */
.admin__pagination li > a {
    width: 35px;
    height: 35px;
    display: flex;
    justify-content: center;
    align-items: center;
	text-decoration: none;
	color: black;
}
/* 현재 선택된 page */
.admin__pagination li.admin__p-active {
	background: #789F6F;
}
li.admin__p-active > a {
	color: white;
}
/* disabled 상태인 page */
.admin__pagination li.admin__p-disabled {
	border: 1px solid #ccc;
	background: #ccc;
}
/* page hover 시 */
.admin__pagination li:hover {
	background: #D1E9CA;
}
.admin__pagination li.admin__p-active:hover {
	background: #789F6F;
}
.admin__pagination li.admin__p-disabled:hover {
	background: #ccc;
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
}

li a:hover {
	background-color: #CD853F;
	color: white;
}

a:link { color: red; text-decoration: none;}
a:visited { color: black; text-decoration: none;}
a:hover { color: blue; text-decoration: underline;}




<<<<<<< HEAD

</style>
=======
<div id="aside" style="float: left; text-align: center;">   


    <h3>${farmerInfo.farmerId }님의 농장일기</h3>

    <hr>
   
	<p>Welcome to my Farm</p>
	
	<br>
	

	<a href="/farmapp/farmintroduce/farmintroduceForm.do?farmerNo=${farmerInfo.farmerNo}">농장 소개</a><br><br>
	<a href="/farmapp/farmdiary/farmdiarylist.do?farmerNo=${farmerInfo.farmerNo}" >농장 일기</a><br><br>
	<a href="#">농장 체험</a><br><br>
	<a href="/farmapp/farmQnA/farmQnAlist.do?farmerNo=${farmerInfo.farmerNo}&farmNo=${farmNo}">QnA</a><br><br>
	<a href="/farmapp/personalproduce/personalproducelist.do?farmerNo=${farmerInfo.farmerNo}">개인 농산물</a>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

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
<<<<<<< HEAD
       	<c:forEach items="${list.fdlist}" var="list">
           <tr>
           	   
               <td class="num">${list.farmDiaryNo}</td>
               <td class="subject"><a href="<%= request.getContextPath() %>/farmdiary/farmdiarydetail.do?farmDiaryNo=${list.farmDiaryNo}">${list.title}</a></td>
               <td class="date">
               	<fmt:formatDate value="${list.enrollDate}" pattern="yyyy-MM-dd"/>
               </td>
=======
       	<c:forEach items="${list}" var="list">
           <tr> 
               <td>${list.farmDiaryNo}</td>
               <td><a href="<%= request.getContextPath() %>/farmdiary/farmdiarydetail.do?farmDiaryNo=${list.farmDiaryNo}&farmNo=${farmNo}">${list.title}</a></td>
               <td><fmt:formatDate value="${list.enrollDate}" pattern="yyyy-MM-dd"/></td>
               <td>${list.hits}</td>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
           </tr>
        </c:forEach>
       </tbody>
       </table>
<<<<<<< HEAD
       
              <div class="paging"><!-- section pagination -->
         <a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do" class="nav first"><i class="fas fa-angle-double-left"></i></a>
=======

<button class="btn btn-success" type="button" onclick="location.href='farmdiarywrite.do'" style="float: right;">글쓰기</button>

		
<div class="pagination-wrap"><!--section pagination -->
<ul class="admin__pagination">
    
         <li><a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?&farmerNo=${farmerInfo.farmerNo}" class="nav first"><i class="fas fa-angle-double-left"></i></a></li>
         
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
        <c:choose>
        	<c:when test="${paging.blockStart > 1 }">
         		<li><a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockStart-1}&farmerNo=${farmerInfo.farmerNo}" class="nav prev"></a></li>
        	</c:when>
        	<c:otherwise>
        		<li><a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockStart}&farmerNo=${farmerInfo.farmerNo}" class="nav prev"><i class="fas fa-angle-left"></i></a></li>
        	</c:otherwise>
        </c:choose>
        <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
         <li><a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${page}&farmerNo=${farmerInfo.farmerNo}" class="admin__p-disabled"><span>${page}</span></a></li>
        </c:forEach> 
        
        <c:choose>
        	<c:when test="${paging.blockEnd+1 > paging.lastPage }">
         		<li><a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockEnd}&farmerNo=${farmerInfo.farmerNo}" class="nav next"><i class="fas fa-angle-right"></i></a></li>
        	</c:when>
        	<c:otherwise>
         		<li><a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.blockEnd+1}&farmerNo=${farmerInfo.farmerNo}" class="nav next"><i class="fas fa-angle-right"></i></a></li>
        	</c:otherwise>
   	   	</c:choose>
<<<<<<< HEAD
 	   	 
 	   	 <a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.lastPage}" class="nav last"><i class="fas fa-angle-double-right"></i></a>
   	   </div><!-- // section pagination -->
       
<div>
	<p>~~님의 농장</p>
=======
 	 
 	   	<li><a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.lastPage}&farmerNo=${farmerInfo.farmerNo}" class="nav last" ><i class="fas fa-angle-double-right"></i></a></li>
 	   	
</ul> 	  
</div><!-- section pagination -->

</div> 
</div>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
</div>

<ul>

<<<<<<< HEAD
	<li><a href="#">농장 소개</a></li>
	<li><a href="#">농장 일기</a></li>
	<li><a href="#">농장 체험</a></li>
	<li><a href="#">QnA</a></li>
	<li><a href="#">개인 농산물</a></li>

</ul>
=======
<%@include file="../include/footer.jsp" %>



>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

<hr>

<button class="btn btn-warning" type="button" onclick="location.href='farmdiarywrite.do'">글쓰기</button>
<button class="btn btn-warning" type="button" onclick="location.href='#">관리하기</button>


</body>
</html>