<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="UTF-8">
<title>게시판</title>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#searchBtn').click(
				function() {
					self.location = "list" + '${pageMaker.makeQuery(1)}'
							+ "&searchType="
							+ $("select option:selected").val() + "&keyword="
							+ encodeURIComponent($('#keywordInput').val());
				});
	});
</script>

<style type="text/css">
.pagenate {margin-left :100px;
	
}
/* 마이페이지  */
.col-lg-3{
	margin-top : 80px;
}
/*경계선*/
#border{
 border : groove;
}
/* 페이지 1~10 까지의 수 */
li {
	list-style: none;
	float: left;
	padding: 6px;
}

/* 페이지 사이즈 */
#psize {
	margin-left: 223px;
}

/* 내정보 나타내기 */
#mypagesize {
	height: 200px; webkit-fill-available;
	border: groove;
}

.search {
	text-align: center;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- Page Content -->
	<div class="container">
		<div class="row" style="width: 1200px">
			<div class="col-lg-3">
				<h3 class="my-4 text-center">농업인 마이페이지</h3>
				<div class="list-group mb-4">

					<a href="#" class="list-group-item list-group-item-action text-center font-weight-bold">내 정보</a> 
					<a href="/farmapp/mypage/selllist" class="list-group-item list-group-item-action text-center font-weight-bold">판매 목록</a> 
					<a href="/farmapp/mypage/dailyLoglist" class="list-group-item list-group-item-action text-center font-weight-bold"style= "background-color:#D1E9CA;">영농 일지</a> 
					<a href="/farmapp/mypage/activitylist" class="list-group-item list-group-item-action text-center font-weight-bold">활동 내역</a>

				</div>
			</div>


			<div id="root" style="width: 800px">
				<div id="mypagesize">
					아이디<input type="text" />
				</div>

				<a href="/farmapp/mypage/dailyLoglist" class="list-group-item list-group-item-action text-center font-weight-bold">영농 일지 목록</a>
					
					<div id ="border">
					<form role="form" method="get"	action="/farmapp/mypage/dailyLoglist">
						<table class="table table-condensed">
								<thead>
								<tr class="success">
									<th scope="col" class="text-center">글 갯수</th>
									<th scope="col" class="text-center">작업 내용</th>
									<th scope="col" class="text-center">작업량</th>
									<th scope="col" class="text-center">작업 시간</th>
									<th scope="col" class="text-center">작업 인원</th>

									<th scope="col" class="text-center"></th>
								</tr>
							</thead>

							<c:forEach items="${list}" var="list">
								<tr>
									<td scope="col" class="text-center"><c:out
											value="${list.diaryNo}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.content}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.workingAmount}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.workingTime}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.workingMember}" /></td>
									<td scope="col" class="text-center"><fmt:formatDate
											value="${list.workingDate}" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>
						</table>
					<div id="psize">
						<ul>
							<c:if test="${pageMaker.prev}">
								<li><a
									href="dailyLoglist${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}" var="idx">
								<li><a href="dailyLoglist${pageMaker.makeQuery(idx)}">${idx}</a></li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="dailyLoglist${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
							</c:if>
						</ul>
					</div>

				<hr>
			</form>
				</div>
				
			</div>
		</div>

	</div>
