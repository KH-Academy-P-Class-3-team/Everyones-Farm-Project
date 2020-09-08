<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style type="text/css"> 
a { text-decoration:none } 
</style>

<body>

<div id="wrap" style="height: 800px;">

<%@include file="../include/farmdiaryheader.jsp" %>

<div style= "clear: both; margin-top: 200px;" ></div>


<div id="container" style="width: 980px; margin: auto;" >

<div id="aside" style="float: left; text-align: center;">    
    <h3>개인 농산물</h3>
    <hr>

	<p>~~님의 농장</p>


<ul>

	<li><a href="/farmapp/farmintroduce/farmintroduceForm.do">농장 소개</a></li>
	<li><a href="/farmapp/farmdiary/farmdiarylist.do">농장 일기</a></li>
	<li><a href="#">농장 체험</a></li>
	<li><a href="/farmapp/farmQnA/farmQnAlist.do">QnA</a></li>
	<li><a href="/farmapp/personalproduce/personalproducelist.do">개인 농산물</a></li>

</ul>

<hr>
</div>

<div id="contents" style="float: right; width: 600px; margin:auto 0;">
  	   <table class="list_notice">
       <thead>
           <tr>
               <th style="width: 10%; height:20%;"><span>번호</span></th>
               <th style="width: 30%;"><span>상품명</span></th>
               <th style="width: 10%;"><span>등록일</span></th>
           </tr>
       </thead>
       <tbody>
       	<c:forEach items="${list.fdlist}" var="list">
           <tr>
           	   
<%--                <td class="num">${list.farmDiaryNo}</td> --%>
<%--                <td class="subject"><a href="<%= request.getContextPath() %>/farmdiary/farmdiarydetail.do?farmDiaryNo=${list.farmDiaryNo}">${list.title}</a></td> --%>
<%--                <td>${list.name}</td> --%>
<!--                <td class="date"> -->
<%--                	<fmt:formatDate value="${list.enrollDate}" pattern="yyyy-MM-dd"/> --%>
               </td>
           </tr>
        </c:forEach>
       </tbody>
       </table>


		
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
  	   


<button class="btn btn-warning" type="button" onclick="location.href='personalproducewrite.do'" style="float: right;">추가하기</button>
</div> 
</div>
</div>

</body>

<%@include file="../include/footer.jsp" %>