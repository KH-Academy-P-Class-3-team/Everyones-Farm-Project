<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach items="${plist }" var="season">

	<div class="row" onclick="javascript:location.href='<%=request.getContextPath()%>/product/productDetail.do?productNo=${season.productNo}'">
	
		<div class="list-image">
		
			<c:forEach items="${file }" var="file">
				<c:if test="${file.postNo eq product.productNo }">
					<img src="<%=request.getContextPath() %>/resources/upload/${file.fileRename }" alt="체험활동 이미지" width="270" height="270">	
				</c:if>
			</c:forEach>
			
		</div>
		
		
		<div class="caption">
			<div class="caption-title"><b>${season.name }</b></div>
			<div class="caption-content"><b>${season.kind }</b></div>
			<div class="caption-content"><b>${season.food }</b></div>
		</div>
		
	
	</div>
	
</c:forEach>


		<!-- section pagination -->
		<div class="paging">
			<div class="paging-in">
				<a href="<%=request.getContextPath()%>/product/seasonSearch.do" class="nav first"></a>
			</div>
			<c:choose>
				<c:when test="${paging.blockStart > 1 }">
					<div class="paging-in pre">
						<a href="<%= request.getContextPath() %>/product/seasonSearch.do?cPage=${paging.blockStart-1}" class="nav prev"></a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="paging-in pre">
						<a href="<%= request.getContextPath() %>/product/seasonSearch.do?cPage=${paging.blockStart}" class="nav prev"></a>
					</div>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
				<div class="paging-in">
					<a href="<%= request.getContextPath() %>/product/seasonSearch.do?cPage=${page}" class="num active">${page}</a>
				</div>
			</c:forEach>

			<c:choose>
				<c:when test="${paging.blockEnd+1 > paging.lastPage }">
					<div class="paging-in nex">
						<a href="<%= request.getContextPath() %>/product/seasonSearch.do?cPage=${paging.blockEnd}" class="nav next"></a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="paging-in nex">
						<a href="<%= request.getContextPath() %>/product/seasonSearch.do?cPage=${paging.blockEnd+1}" class="nav next"></a>
					</div>
				</c:otherwise>
			</c:choose>

			<div class="paging-in">
				<a href="<%= request.getContextPath() %>/product/seasonSearch.do?cPage=${paging.lastPage}" class="nav last"></a>
			</div>
		</div>
		<!-- // section pagination -->
