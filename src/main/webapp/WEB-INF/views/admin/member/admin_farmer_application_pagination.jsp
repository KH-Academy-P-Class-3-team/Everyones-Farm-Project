<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- paging -->
<!-- 추후에 분리 예정 -->
<div class="pagination-wrap">
<ul class="admin__pagination">
	<!-- 첫 페이지로 가기 -->
	<c:if test="${apaging.curPage ne 1 }"><!-- 첫 페이지가 아닐 때 보여줌 -->
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<li><a href="/farmapp/adminmember/fapplicationlist">&larr;</a></li>
			</c:when>
			<%-- 검색어가 있을 때--%>
			<c:when test="${not empty apaging.search }">
				<li><a href="/farmapp/adminmember/fapplicationlist?search=${apaging.search }">&larr;</a></li>
			</c:when>
		</c:choose>
	</c:if>
	
	<!-- 이전 페이징 리스트로 가기 -->
	<c:if test="${apaging.startPage gt apaging.pageCount }">
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<li><a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.startPage - apaging.pageCount }">&laquo;</a></li>
			</c:when>
			<%-- 검색어가 있을 때--%>
			<c:when test="${not empty apaging.search }">
				<li><a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.startPage - apaging.pageCount }&search=${apaging.search }">&laquo;</a></li>
			</c:when>
		</c:choose>
	</c:if>

	<c:if test="${apaging.startPage le apaging.pageCount }">
	<li class="admin__p-disabled"><a>&laquo;</a></li>
	</c:if>
	
	<!-- 이전 페이지로 가기 -->
	<c:if test="${apaging.curPage ne 1 }">
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<li><a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.curPage - 1 }">&lt;</a></li>
			</c:when>
			<%-- 검색어가 있을 때--%>
			<c:when test="${not empty apaging.search }">
				<li><a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.curPage - 1 }&search=${apaging.search }">&lt;</a></li>
			</c:when>
		</c:choose>
	</c:if>
	
	<!-- 페이징 리스트 -->
	<c:forEach begin="${apaging.startPage }" end="${apaging.endPage }" var="i">
	
	<!-- 보고 있는 페이지번호 강조 (.active) -->
	<c:if test="${apaging.curPage eq i }">
	<li class="admin__p-active">
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${i }">${i }</a>
			</c:when>
			<%-- 검색어가 있을 때 --%>
			<c:when test="${not empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${i }&search=${apaging.search }">${i }</a>
			</c:when>
		</c:choose>
	</li>
	</c:if>
	
	<!-- 보고 있는 페이지번호가 아니면 평소 모양으로 보여주기 -->
	<c:if test="${apaging.curPage ne i }">
	<li>
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${i }">${i }</a>
			</c:when>
			<%-- 검색어가 있을 때 --%>
			<c:when test="${not empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${i }&search=${apaging.search }">${i }</a>
			</c:when>
		</c:choose>
	</li>
	</c:if>
	</c:forEach>
	
	<!-- 다음 페이지로 가기 -->
	<c:if test="${apaging.curPage ne apaging.totalPage }">
	<li>
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.curPage + 1 }">&gt;</a>
			</c:when>
			<%-- 검색어가 있을 때 --%>
			<c:when test="${not empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.curPage + 1 }&search=${apaging.search }">&gt;</a>
			</c:when>
		</c:choose>
	</li>
	</c:if>
	
	<!-- 다음 페이징 리스트로 가기 -->
	<c:if test="${apaging.endPage ne apaging.totalPage }">
	<li>
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.startPage + apaging.pageCount }">&raquo;</a>
			</c:when>
			<%-- 검색어가 있을 때 --%>
			<c:when test="${not empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.startPage + apaging.pageCount }&search=${apaging.search }">&raquo;</a>
			</c:when>
		</c:choose>
	</li>
	</c:if>

	<c:if test="${apaging.endPage eq apaging.totalPage }">
	<li class="admin__p-disabled"><a>&raquo;</a></li>
	</c:if>
	
	<!-- 마지막 페이지로 가기 -->
	<c:if test="${apaging.curPage ne apaging.totalPage }"><!-- 끝 페이지가 아닐 때 보여준다 -->
	<li>
		<c:choose>
			<%-- 검색어가 없을 때 --%>
			<c:when test="${empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.totalPage }">&rarr;</a>
			</c:when>
			<%-- 검색어가 있을 때 --%>
			<c:when test="${not empty apaging.search }">
				<a href="/farmapp/adminmember/fapplicationlist?curPage=${apaging.totalPage }&search=${apaging.search }">&rarr;</a>
			</c:when>
		</c:choose>
	</li>
	</c:if>
</ul>
</div>