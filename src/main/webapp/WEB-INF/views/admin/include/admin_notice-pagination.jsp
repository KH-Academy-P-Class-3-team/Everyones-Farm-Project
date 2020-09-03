<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- paging -->
<!-- 추후에 분리 예정 -->
<div class="pagination-wrap">
<ul class="admin__pagination">
	<!-- 첫 페이지로 가기 -->
	<c:if test="${apaging.curPage ne 1 }"><!-- 첫 페이지가 아닐 때 보여줌 -->
		<li><a href="/farmapp/adminnotice/list">&larr;</a></li>
	</c:if>
	
	<!-- 이전 페이징 리스트로 가기 -->
	<c:if test="${apaging.startPage gt apaging.pageCount }">
		<li><a href="/farmapp/adminnotice/list?curPage=${apaging.startPage - apaging.pageCount }">&laquo;</a></li>
	</c:if>

	<c:if test="${apaging.startPage le apaging.pageCount }">
	<li class="admin__p-disabled"><a>&laquo;</a></li>
	</c:if>
	
	<!-- 이전 페이지로 가기 -->
	<c:if test="${apaging.curPage ne 1 }">
		<li><a href="/farmapp/adminnotice/list?curPage=${apaging.curPage - 1 }">&lt;</a></li>
	</c:if>
	
	<!-- 페이징 리스트 -->
	<c:forEach begin="${apaging.startPage }" end="${apaging.endPage }" var="i">
	
	<!-- 보고 있는 페이지번호 강조 (.active) -->
	<c:if test="${apaging.curPage eq i }">
	<li class="admin__p-active">
		<a href="/farmapp/adminnotice/list?curPage=${i }">${i }</a>
	</li>
	</c:if>
	
	<!-- 보고 있는 페이지번호가 아니면 평소 모양으로 보여주기 -->
	<c:if test="${apaging.curPage ne i }">
	<li>
		<a href="/farmapp/adminnotice/list?curPage=${i }">${i }</a>
	</li>
	</c:if>
	</c:forEach>
	
	<!-- 다음 페이지로 가기 -->
	<c:if test="${apaging.curPage ne apaging.totalPage }">
	<li>
		<a href="/farmapp/adminnotice/list?curPage=${apaging.curPage + 1 }">&gt;</a>
	</li>
	</c:if>
	
	<!-- 다음 페이징 리스트로 가기 -->
	<c:if test="${apaging.endPage ne apaging.totalPage }">
	<li>
		<a href="/farmapp/adminnotice/list?curPage=${apaging.startPage + apaging.pageCount }">&raquo;</a>
	</li>
	</c:if>

	<c:if test="${apaging.endPage eq apaging.totalPage }">
	<li class="admin__p-disabled"><a>&raquo;</a></li>
	</c:if>
	
	<!-- 마지막 페이지로 가기 -->
	<c:if test="${apaging.curPage ne apaging.totalPage }"><!-- 끝 페이지가 아닐 때 보여준다 -->
	<li>
		<a href="/farmapp/adminnotice/list?curPage=${apaging.totalPage }">&rarr;</a>
	</li>
	</c:if>
</ul>
</div>