<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach items="${activity }" var="activity">

	<div class="row">
	
		<div class="list-image">
		
			<c:forEach items="${file }" var="file">
				<c:if test="${file.postNo eq activity.activityNo }">
					<img src="<%=request.getContextPath() %>/resources/upload/${file.fileRename }" alt="체험활동 이미지" width="270" height="270">	
				</c:if>
			</c:forEach>
			
		</div>
		
		
		<div class="caption">
			<div class="caption-title"><b>${activity.title }</b></div>
			
		<c:forEach items="${farm }" var="farm">
			<c:if test="${farm.farmNo eq activity.farmNo}">
				<div class="caption-content">농장명 : ${farm.farmName }</div>
				<div class="caption-content">주소 : ${farm.zonecode } ${farm.firstAddress } ${farm.secondAddress }</div>
			</c:if>
		</c:forEach>

		</div>
		
	
	</div>
	
</c:forEach>


