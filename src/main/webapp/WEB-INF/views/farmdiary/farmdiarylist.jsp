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



</style>


<div id="wrap" style="height: 800px;">

<%@include file="../include/farmdiaryheader.jsp" %>


<div style= "clear: both; margin-top: 200px;" ></div>


<div id="container" style="width: 980px; margin: auto;" >

<div id="aside" style="float: left; text-align: center;">    

    <h4>~~님의 농장일기</h4>
    <hr>
    


	<p>Welcome to my Farm</p>
	
	<br>
	

	<a href="/farmapp/farmintroduce/farmintroduceForm.do">농장 소개</a><br><br>
	<a href="/farmapp/farmdiary/farmdiarylist.do" >농장 일기</a><br><br>
	<a href="#">농장 체험</a><br><br>
	<a href="/farmapp/farmQnA/farmQnAlist.do">QnA</a><br><br>
	<a href="/farmapp/personalproduce/personalproducelist.do">개인 농산물</a>


<hr>
</div>

<div id="contents" style="float: right; width: 600px; margin:auto 0;">
  	   <table class="table table-hover">
       <thead>
           <tr class="success">
               <th style="width: 5%; height:20%;"><span>번호</span></th>
               <th style="width: 30%;"><span>제목</span></th>
               <th style="width: 10%;"><span>등록일</span></th>
               <th style="width: 10%;"><span>조회수</span></th>
           </tr>
       </thead>
       <tbody>
       	<c:forEach items="${list.fdlist}" var="list">
           <tr> 
               <td>${list.farmDiaryNo}</td>
               <td><a href="<%= request.getContextPath() %>/farmdiary/farmdiarydetail.do?farmDiaryNo=${list.farmDiaryNo}">${list.title}</a></td>
               <td><fmt:formatDate value="${list.enrollDate}" pattern="yyyy-MM-dd"/></td>
               <td>${list.hits}</td>
           </tr>
        </c:forEach>
       </tbody>
       </table>

<button class="btn btn-warning" type="button" onclick="location.href='farmdiarywrite.do'" style="float: right;">글쓰기</button>

		
<div style="display: flex;"><!-- section pagination -->

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
 	   	 
 	   	 <a href="<%= request.getContextPath() %>/farmdiary/farmdiarylist.do?cPage=${paging.lastPage}" class="nav last" ><i class="fas fa-angle-double-right"></i></a>
 
</div><!-- // section pagination -->
  	   
</div> 
</div>
</div>



<%@include file="../include/footer.jsp" %>







