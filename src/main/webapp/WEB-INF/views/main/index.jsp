<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp" %>

<!-- menu 의 float 속성 때문에 생성한 div -->
<div style="clear: both; margin-top: 170px;"></div>
<div class="header__bottom">
	<div id="sliderbox">
		<ul id="slider">
			<li><img src="<%=request.getContextPath() %>/resources/img/farm1.jpg" /></li>
			<li><img src="<%=request.getContextPath() %>/resources/img/farm2.jpg" /></li>
			<li><img src="<%=request.getContextPath() %>/resources/img/farm3.jpg" /></li>
			<li><img src="<%=request.getContextPath() %>/resources/img/farm4.jpg" /></li>
			<li><img src="<%=request.getContextPath() %>/resources/img/farm5.jpg"/></li>
		</ul>
	</div>
	
	<!-- 이미지 슬라이드 list를 알려주는 점들 -->
	<div class="slider-dots-wrap">
	<div id="slider-dots">
		<c:forEach var="i" begin="0" end="4">
			<div class="dot" data-idx=${i + 1 }></div>
		</c:forEach>
	</div>
	</div>
</div>


<div class="wrapper">
	<!-- main -->
	<main class="main__main">
	
		<!-- 제철먹거리 -->
		<div class="main__food">
			<div class="food__top">
				<div class="food__top-title">제철 먹거리</div>
				<div class="food__top-more"><span>더보기</span><a href="#"><i class="fas fa-chevron-right"></i></a></div>
			</div>
			<div class="food__bottom">
				<c:forEach var="i" begin="1" end="3">
					<div class="food__bottom-wrap">
						<a href="#">
							<img class="bottom-wrap__food-img" alt="food" src="<%=request.getContextPath() %>/resources/img/main_cherry1.jpg" 
							width="300" height="250" /><div class="bottom-wrap__food-desc">먹거리 이름</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>	
		
		<!-- 이달의 농장 -->
		<div class="main__farm">
			<div class="farm__top">
				<div class="farm__top-line"></div>
				<div class="farm__top-title">
					<div class="farm__top-titlebox">이달의 농장</div>
				</div>
			</div>
			<div class="farm__bottom">
			<c:forEach items="${farmlist }" var="farmitem" >
					<div class="food__bottom-wrap">
						<a href="#"><!-- 이 링크는 농장 페이지 링크 넣어야 함! -->
							<img class="bottom-wrap__farm-img" alt="food" src="<%=request.getContextPath() %>/resources/img/main_farm.jpg"
							width="300" height="250" />
							<div class="bottom-wrap__farm-desc">${farmitem.farmName }</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>	
		<!-- 이 부분은 파일이 있을 경우 생각했던 것! 다시 한 번 생각해보기 -->
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${empty farmitem.farmFileNo }"> --%>
<%-- 				<img class="bottom-wrap__farm-img" alt="food" src="<%=request.getContextPath() %>/resources/img/main_farm.jpg" --%>
<!-- 				width="300" height="250" /> -->
				
<%-- 			</c:when> --%>
<%-- 			<c:when test="${not empty farmitem.farmFileNo }"> --%>
<!-- 				여기는 추후에 생각해보기 아직 file data가 없음...! -->
<%-- 				<img class="bottom-wrap__farm-img" alt="food" src="<%=request.getContextPath() %>/resources/img/test-dog.jpg" --%>
<!-- 				width="300" height="250" /> -->
<%-- 			</c:when> --%>
<%-- 		</c:choose> --%>
		
		
		<!-- 농업소식 -->
		<div class="main__farmnews">
			<div class="farmnews__top">
				<div class="farmnews__top-title">농업 소식</div>
				<div class="farmnews__top-more"><span>더보기</span><a href="#"><i class="fas fa-chevron-right"></i></a></div>
			</div>
			<div class="farmnews__bottom">
				<table>
					<tr>
						<th>제목</th>
						<th>등록일</th>
					</tr>
					<c:forEach var="i" begin="0" end="4">
						<tr>
							<td>농업 소식 제목</td>
							<td>2020-08-20</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>	
	</main>
	
</div>
<%@include file="../include/footer.jsp" %>
