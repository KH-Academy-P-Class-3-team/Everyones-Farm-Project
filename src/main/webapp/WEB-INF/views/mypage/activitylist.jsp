<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<title>Welcome to Codevang</title>

<style type="text/css">
.pagenate {margin-left :100px;
	
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

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<body class="pt-5">
	<!-- Page Content -->
	<div class="container">
		<div class="row" style="width: 1200px">
			<div class="col-lg-3">
				<h3 class="my-4 text-center">농업인 마이페이지</h3>
				<div class="list-group mb-4">
					<a
						class="list-group-item list-group-item-info text-center font-weight-bold">내
						정보</a> <a href="#"
						class="list-group-item list-group-item-action text-center font-weight-bold">판매
						목록</a> <a href="#"
						class="list-group-item list-group-item-action text-center font-weight-bold">영농
						일지</a> <a href="#"
						class="list-group-item list-group-item-action text-center font-weight-bold">활동
						내역</a>
				</div>
			</div>


			<div id="root" style="width: 800px">
				<div id="mypagesize">
					아이디<input type="text" />
				</div>
				<div>농장 체험 신청 목록</div>
				<section id="container">
					<form role="form" method="get"
						action="/farmapp/mypage/activitylist">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col" class="text-center">신청 번호</th>
									<th scope="col" class="text-center">체험 명</th>
									<th scope="col" class="text-center">신청자</th>
									<th scope="col" class="text-center">인원</th>
									<th scope="col" class="text-center">체험 날짜</th>
									<th scope="col" class="text-center">승인</th>
								</tr>
							</thead>

							<c:forEach items="${list}" var="list">
								<tr>
									<td scope="col" class="text-center"><c:out
											value="${list.APPLICATION_NO}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.title}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.APPLICANT_NAME}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.people}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.activityDate}" /></td>
									<td scope="col" class="text-center">
								
								
									<button type="button" onclick="bts(this)" id="Approval" value="${list.APPLICATION_NO}" >승인</button>
 
									</td>
								</tr>

							</c:forEach>

						</table>
					</form>
					<div id="psize">
						<ul>
							<c:if test="${pageMaker.prev}">
								<li><a
									href="activitylist${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}" var="idx">
								<li><a href="activitylist${pageMaker.makeQuery(idx)}">${idx}</a></li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="activitylist${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</section>
				<hr>

			</div>
		</div>
	</div>
</body>

<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	function bts(id){
		var aj =  id.value;
		console.log(aj);
		$.ajax({
             type: "get",
             url: "/farmapp/mypage/activitylist2?applicationNo="+aj,
             async: false,     //값을 리턴시 해당코드를 추가하여 동기로 변경
             success: function (data) {
                 result = data; 
                 if(result == 1){
                 if(id.innerHTML == '승인'){
                	 id.innerHTML = "미승인"
                 }else if(id.innerHTML == '미승인'){
                	 id.innerHTML = "승인"
                 }
                 }
             }
         });	
	}
</script>
