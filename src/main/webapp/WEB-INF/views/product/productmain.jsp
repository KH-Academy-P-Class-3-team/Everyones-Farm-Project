<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product/product_main.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<%@include file="../include/header.jsp" %>

<div style="clear: both; margin-top: 200px;"></div>

<div class="all">
<div class="productmain">
	<div style="text-align: center;"><span class="maintitle">먹거리</span></div><br><br>
	
	<div class="season">
		<div style="height: 65px;">
		<span class="title">제철먹거리 TOP4</span>
		<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/product/sweetpotatoes.png" class="producticon"/>
		</div>
		 <c:set var="i" value="0" />
		 <c:set var="j" value="2" />
		 <table>
		 <c:forEach items="${season }" var="list"> 
		 <c:if test="${i%j == 0 }"> 
		 <tr> 
		 </c:if> 
		 <td onclick="javascript:location.href='<%=request.getContextPath()%>/product/productDetail.do?productNo=${list.productNo}'"><img alt="peach" src="<%=request.getContextPath()%>/resources/image/product/peach.jpg" class="productimage"/><br>
				 ${list.name }<br>
				 ${list.kind }</td> 
		 <c:if test="${i%j == j-1 }">
		 </tr> 
		 </c:if> 
		 <c:set var="i" value="${i+1 }" /> 
		 </c:forEach>
		 </table>
		 <br>
		<span id="more1" style="float: right;cursor: pointer;">더보기<img alt="arrow" src="<%=request.getContextPath()%>/resources/image/product/arrow.png" style="height: 1.5em; vertical-align: middle;"/></span>
		<br>
	</div>
	<br>
	<hr>
	<br>
	<div class="season">
		<div style="height: 65px;">
		<span class="title">일반먹거리 TOP4</span>
		<img alt="farmer" src="<%=request.getContextPath()%>/resources/image/product/corn.png" class="producticon"/><br><br><br>
		</div>
		 <c:set var="i" value="0" />
		 <c:set var="j" value="2" />
		 <table>
		 <c:forEach items="${general }" var="glist"> 
		 <c:if test="${i%j == 0 }"> 
		 <tr> 
		 </c:if> 
		 <td onclick="javascript:location.href='<%=request.getContextPath()%>/product/productDetail.do?productNo=${glist.productNo}'"><img alt="peach" src="<%=request.getContextPath()%>/resources/image/product/kimchi.jpg" class="productimage"/><br>
				 ${glist.name }<br>
				 ${glist.kind }</td> 
		 <c:if test="${i%j == j-1 }">
		 </tr> 
		 </c:if> 
		 <c:set var="i" value="${i+1 }" /> 
		 </c:forEach>
		 </table>
		 <br>
		 <span id="more2" style="float: right;cursor: pointer;">더보기<img alt="arrow" src="<%=request.getContextPath()%>/resources/image/product/arrow.png" style="height: 1.5em; vertical-align: middle;"/></span>
		 <br>
	</div>
</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#more1").click(function(){
		location.href="<%=request.getContextPath()%>/product/seasonlist.do"
	})
	
	$("#more2").click(function(){
		location.href="<%=request.getContextPath()%>/product/generallist.do"
	})
	
})
</script>
<%@include file="../include/footer.jsp" %>