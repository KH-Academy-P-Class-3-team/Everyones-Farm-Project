<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
a { text-decoration:none } 

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
}
</style>

<form action="/farmapp/farmQnA/farmQnAlist.do" method="post">

<%@include file="../include/farmdiaryheader.jsp" %>

<div id="wrap" style="height: 800px;">

<div style= "clear: both; margin-top: 200px;" ></div>

<div id="container" style="width: 980px; margin: auto;" >

<div id="aside" style="float: left; text-align: center;">    
    <h3>QnA</h3>
    <hr>

	<p>Welcome to my Farm</p>
	
	<br>


			<c:choose>
				<c:when test="${empty farmerInfo }">
					<li><a href="/farmapp/farmintroduce/farmintroduceForm.do?farmerNo=${farmerNo}">농장 소개</a></li><br>
					<li><a href="/farmapp/farmdiary/farmdiarylist.do?farmerNo=${farmerNo}">농장 일기</a></li><br>
					<li><a href="/farmapp/farmQnA/farmQnAlist.do?farmerNo=${farmerNo}&farmNo=${farmNo}">QnA</a></li><br>
					<li><a href="/farmapp/personalproduce/personalproducelist.do?farmerNo=${farmerNo}">개인 농산물</a></li><br>
					<li><a href="/farmapp/activity/farmActivityList?farmNo=${farmNo}">농장 체험</a></li>
				</c:when>
				<c:when test="${not empty farmerInfo }">
					<li><a href="/farmapp/farmintroduce/farmintroduceForm.do?farmerNo=${farmerInfo.farmerNo}&farmNo=${farmNo}">농장 소개</a></li><br>
					<li><a href="/farmapp/farmdiary/farmdiarylist.do?farmerNo=${farmerInfo.farmerNo}">농장 일기</a></li><br>
					<li><a href="/farmapp/farmQnA/farmQnAlist.do?farmerNo=${farmerInfo.farmerNo}&farmNo=${farmNo}">QnA</a></li><br>
					<li><a href="/farmapp/personalproduce/personalproducelist.do?farmerNo=${farmerInfo.farmerNo}">개인 농산물</a></li><br>
					<li><a href="/farmapp/activity/farmActivityList?farmNo=${farmNo}">농장 체험</a></li>
				</c:when>
			</c:choose>


<hr>
</div>

<div id="contents" style="float: right; width: 600px; margin:auto 0;">
  	   <table class="table table-hover">
       <thead>
           <tr class="success">
               <th style="width: 10%; height:20%;"><span>번호</span></th>
               <th style="width: 30%;"><span>제목</span></th>
               <th style="width: 10%;"><span>작성자</span></th>
               <th style="width: 10%;"><span>작성일</span></th>
           </tr>
       </thead>
       <tbody>
       	<c:forEach items="${list}" var="list">
           <tr> 
               <td>${list.farmQnaQuestionNo}</td>
               <td><a href="<%= request.getContextPath() %>/farmQnA/farmQnAdetail.do?farmQnaQuestionNo=${list.farmQnaQuestionNo}&farmNo=${farmNo}">${list.title}</a></td>
               <td>${list.farmerNo}번 농업인</td>
               <td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/></td>
           </tr>
        </c:forEach>
       </tbody>
       </table>

<button class="btn btn-success" type="button" onclick="location.href='farmQnAwrite.do?farmerNo=${farmerNo}'" style="float: right;">작성하기</button>
		
<div class="pagination-wrap"><!--section pagination -->
<ul class="admin__pagination">
    
         <li><a href="<%= request.getContextPath() %>/farmQnA/farmQnAlist.do?farmerNo=${farmerInfo.farmerNo}" class="nav first"><i class="fas fa-angle-double-left"></i></a></li>
         
        <c:choose>
        	<c:when test="${paging.blockStart > 1 }">
         		<li><a href="<%= request.getContextPath() %>/farmQnA/farmQnAlist.do?cPage=${paging.blockStart-1}&farmerNo=${farmerInfo.farmerNo}" class="nav prev"></a></li>
        	</c:when>
        	<c:otherwise>
        		<li><a href="<%= request.getContextPath() %>/farmQnA/farmQnAlist.do?cPage=${paging.blockStart}&farmerNo=${farmerInfo.farmerNo}" class="nav prev"><i class="fas fa-angle-left"></i></a></li>
        	</c:otherwise>
        </c:choose>
        <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
         <li><a href="<%= request.getContextPath() %>/farmQnA/farmQnAlist.do?cPage=${page}&farmerNo=${farmerInfo.farmerNo}" class="admin__p-disabled"><span>${page}</span></a></li>
        </c:forEach> 
        
        <c:choose>
        	<c:when test="${paging.blockEnd+1 > paging.lastPage }">
         		<li><a href="<%= request.getContextPath() %>/farmQnA/farmQnAlist.do?cPage=${paging.blockEnd}&farmerNo=${farmerInfo.farmerNo}" class="nav next"><i class="fas fa-angle-right"></i></a></li>
        	</c:when>
        	<c:otherwise>
         		<li><a href="<%= request.getContextPath() %>/farmQnA/farmQnAlist.do?cPage=${paging.blockEnd+1}&farmerNo=${farmerInfo.farmerNo}" class="nav next"><i class="fas fa-angle-right"></i></a></li>
        	</c:otherwise>
   	   	</c:choose>
 	 
 	   	<li><a href="<%= request.getContextPath() %>/farmQnA/farmQnAlist.do?cPage=${paging.lastPage}&farmerNo=${farmerInfo.farmerNo}" class="nav last" ><i class="fas fa-angle-double-right"></i></a></li>
 	   	
</ul> 	  
</div><!-- section pagination -->

  	   

</div> 
</div>
</div>

</form>

<%@include file="../include/footer.jsp" %>