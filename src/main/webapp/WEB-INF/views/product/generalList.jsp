<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product/product_list.css">

<%@include file="../include/header.jsp" %>
<style type="text/css">
.main__footer {
    /* width: 980px; */
    margin: 0 auto;
    padding: 50px 0;
    display: flex;
    flex-direction: column;
    /* margin-top: 50px; */
    background: #605759;
}
</style>
<div style="clear: both; margin-top: 170px;"></div>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	/* 이미지 파일이 없는 체험 활동에 기본 이미지 출력 */
	$(".list-image").each(function() {
		if($(this).find("img").length == 0) {
			$(this).prepend($("<img src='<%=request.getContextPath() %>/resources/image/product/kimchi.jpg' width='270' >"))
		} 
	})
	
	
	/* 활동 검색 버튼 클릭 시 Ajax 함수 */
	$(".btnSearch").click(function() {
		var filter = $('.filter').val();
		var title = $('.title').val();
		
		var url = '<%=request.getContextPath()%>/product/seasonSearch.do';
		var xhr = new XMLHttpRequest();
		
		xhr.open('POST', url);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		
		xhr.send('filter=' + filter + '&title=' + title + '&isSeasonalFood=0');
		xhr.addEventListener('load', function(){
			var data = xhr.response;
			
			if(data == '') {
				alert('검색 실패!');
			} else {
				$('.activity-list').html(data);
				
				/* 이미지 파일이 없는 체험 활동에 기본 이미지 출력 */
				$(".list-image").each(function() {
					if($(this).find("img").length == 0) {
						$(this).prepend($("<img src='<%=request.getContextPath() %>/resources/image/product/kimchi.jpg' width='270' >"))
					} 
				})
			}
		})
	})
	
})
</script>


<div class="general-top">
	<div class="top-title">일반 음식</div>
	<div class="top-sub">General Food</div>
</div>

<div class="activity-content">
	
	<div class="activity-search">
		<select name="filter" class="filter">
			<option value="productname">음식이름</option>
			<option value="kind">음식종류</option>
		</select>
		<input type="text" name="title" class="title">
		<button class="btnSearch">검색</button>
	</div>

	
	<div class="activity-list">
		<c:forEach items="${plist }" var="general">
	
		<div class="row" onclick="javascript:location.href='<%=request.getContextPath()%>/product/productDetail.do?productNo=${general.productNo}'">
		
			<div class="list-image">
			
				<c:forEach items="${fileList }" var="file">
					<c:if test="${file.postNo eq general.productNo }">
						<img src="<%=request.getContextPath() %>/resources/upload/${file.fileRename }" alt="체험활동 이미지" width="270" height="270">	
					</c:if>
				</c:forEach>
				
			</div>
			
			<div class="caption">
				<div class="caption-title"><b>${general.name }</b></div>
				<div class="caption-content"><b>종류: ${general.kind }</b></div>
				<div class="caption-content"><b>이용가능한 음식: ${general.food }</b></div>
			</div>
			
		
		</div>
		
		</c:forEach>
		
		
		<!-- section pagination -->
		<div class="paging">
			<div class="paging-in">
				<a href="<%=request.getContextPath()%>/product/generallist.do" class="nav first"></a>
			</div>
			<c:choose>
				<c:when test="${paging.blockStart > 1 }">
					<div class="paging-in pre">
						<a href="<%= request.getContextPath() %>/product/generallist.do?cPage=${paging.blockStart-1}" class="nav prev"></a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="paging-in pre">
						<a href="<%= request.getContextPath() %>/product/generallist.do?cPage=${paging.blockStart}" class="nav prev"></a>
					</div>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
				<div class="paging-in">
					<a href="<%= request.getContextPath() %>/product/generallist.do?cPage=${page}" class="num active">${page}</a>
				</div>
			</c:forEach>

			<c:choose>
				<c:when test="${paging.blockEnd+1 > paging.lastPage }">
					<div class="paging-in nex">
						<a href="<%= request.getContextPath() %>/product/generallist.do?cPage=${paging.blockEnd}" class="nav next"></a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="paging-in nex">
						<a href="<%= request.getContextPath() %>/product/generallist.do?cPage=${paging.blockEnd+1}" class="nav next"></a>
					</div>
				</c:otherwise>
			</c:choose>

			<div class="paging-in">
				<a href="<%= request.getContextPath() %>/product/generallist.do?cPage=${paging.lastPage}" class="nav last"></a>
			</div>
		</div>
		<!-- // section pagination -->
		
		
	</div>

</div>

<%@include file="../include/footer.jsp" %>