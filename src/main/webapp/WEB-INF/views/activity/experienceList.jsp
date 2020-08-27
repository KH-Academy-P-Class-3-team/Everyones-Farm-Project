<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveryonesFarm</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/activity/experienceList.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	/* 이미지 파일이 없는 체험 활동에 기본 이미지 출력 */
	$(".list-image").each(function() {
		if($(this).find("img").length == 0) {
			$(this).prepend($("<img src='<%=request.getContextPath() %>/resources/image/no-image.png' width='270' height='270'>"))
		} 
	})
	
	
	/* 활동 검색 버튼 클릭 시 Ajax 함수 */
	$(".btnSearch").click(function() {
		var filter = $('.filter').val();
		var title = $('.title').val();
		
		var url = '<%=request.getContextPath()%>/activity/searchActivity.do';
		var xhr = new XMLHttpRequest();
		
		xhr.open('POST', url);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		
		xhr.send('filter=' + filter + '&title=' + title + '&isHelp=0');
		xhr.addEventListener('load', function(){
			var data = xhr.response;
			
			if(data == '') {
				alert('검색 실패!');
			} else {
				$('.activity-list').html(data);
				
				/* 이미지 파일이 없는 체험 활동에 기본 이미지 출력 */
				$(".list-image").each(function() {
					if($(this).find("img").length == 0) {
						$(this).prepend($("<img src='<%=request.getContextPath() %>/resources/image/no-image.png' width='270' height='270'>"))
					} 
				})
			}
		})
	})
	
})
</script>

</head>
<body>

<div class="activity-top">
	<div class="top-title">농장 체험</div>
	<div class="top-sub">Farm Activity</div>
</div>

<div class="activity-content">
	

	<div class="activity-search">
		<select name="filter" class="filter">
			<option value="activityTitle">체험명</option>
			<option value="farmTitle">농장명</option>
		</select>
		<input type="text" name="title" class="title">
		<button class="btnSearch">검색</button>
	</div>

	
	<div class="activity-list">
		<c:forEach items="${activityList }" var="activity">
	
		<div class="row">
		
			<div class="list-image">
			
				<c:forEach items="${fileList }" var="file">
					<c:if test="${file.activityNo eq activity.activityNo }">
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
		
		
		<!-- section pagination -->
		<div class="paging">
			<div class="paging-in">
				<a href="<%=request.getContextPath()%>/activity/experienceList.do" class="nav first"></a>
			</div>
			<c:choose>
				<c:when test="${paging.blockStart > 1 }">
					<div class="paging-in pre">
						<a href="<%= request.getContextPath() %>/activity/experienceList.do?cPage=${paging.blockStart-1}" class="nav prev"></a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="paging-in pre">
						<a href="<%= request.getContextPath() %>/activity/experienceList.do?cPage=${paging.blockStart}" class="nav prev"></a>
					</div>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
				<div class="paging-in">
					<a href="<%= request.getContextPath() %>/activity/experienceList.do?cPage=${page}" class="num active">${page}</a>
				</div>
			</c:forEach>

			<c:choose>
				<c:when test="${paging.blockEnd+1 > paging.lastPage }">
					<div class="paging-in nex">
						<a href="<%= request.getContextPath() %>/activity/experienceList.do?cPage=${paging.blockEnd}" class="nav next"></a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="paging-in nex">
						<a href="<%= request.getContextPath() %>/activity/experienceList.do?cPage=${paging.blockEnd+1}" class="nav next"></a>
					</div>
				</c:otherwise>
			</c:choose>

			<div class="paging-in">
				<a href="<%= request.getContextPath() %>/activity/experienceList.do?cPage=${paging.lastPage}" class="nav last"></a>
			</div>
		</div>
		<!-- // section pagination -->
		
		
	</div>

</div>



</body>
</html>