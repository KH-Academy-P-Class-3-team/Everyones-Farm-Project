<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<title>판매 페이지</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->

	
		<div class="container">
			<div class="row" style="width: 1200px">
				<div class="col-lg-3">
					<h3 class="my-4 text-center">농업인 마이페이지</h3>
					<div class="list-group mb-4">
						<a href="#" class="list-group-item list-group-item-action text-center font-weight-bold">내 정보</a> 
						<a href="/farmapp/mypage/selllist" class="list-group-item list-group-item-action text-center font-weight-bold"style= "background-color:#D1E9CA;">판매 목록</a> 
						<a href="/farmapp/mypage/dailyLoglist" class="list-group-item list-group-item-action text-center font-weight-bold">영농 일지</a> 
						<a href="/farmapp/mypage/activitylist" class="list-group-item list-group-item-action text-center font-weight-bold">활동 내역</a>
					</div>
				</div>
				<div id="root" style="width: 800px">
				<div id="mypagesize">
					아이디<input type="text" />
				</div>
				<a href="/farmapp/mypage/selllist" class="list-group-item list-group-item-action text-center font-weight-bold">판매 현황</a>
					
					<div id ="border">
					<form role="form" method="get"	action="/farmapp/mypage/selllist">
						<table class="table table-condensed" style="font-size : medium;">
							<thead>
								<tr class="success">
									<th scope="col" class="text-center">주문 번호</th>
									<th scope="col" class="text-center">상품명</th>
									<th scope="col" class="text-center">주문 수량</th>
									<th scope="col" class="text-center">주문 날짜</th>
									<th scope="col" class="text-center">구매자</th>
									<th scope="col" class="text-center">결제 상태</th>
								</tr>
							</thead>

							<c:forEach items="${list}" var="list">
								<tr>
									<td scope="col" class="text-center"><c:out
											value="${list.orderNo}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.name}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.orderAmount}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.orderDate}" /></td>
									<td scope="col" class="text-center"><c:out
											value="${list.userName}" /></td>
									<td scope="col" class="text-center">
									<c:if test="${list.paymentStatus eq 1 }">
									<button type="button" onclick="bts(this)"    class="btn btn-success" id="Approval" value="${list.orderNo}" >결제 완료</button>
									</c:if>
									<c:if test="${list.paymentStatus eq 0 }">
									<button type="button" onclick="bts(this)" class="btn btn-danger" id="Approval" value="${list.orderNo}" >미입금</button>
 									</c:if>
									</td>
								</tr>
							</c:forEach>
							
						</table>
					<div id="psize">
						<ul>
							<c:if test="${pageMaker.prev}">
								<li><a
									href="selllist${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}" var="idx">
								<li><a href="selllist${pageMaker.makeQuery(idx)}">${idx}</a></li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="selllist${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
							</c:if>
						</ul>
					</div>
				<hr>
				</div>
			</div>
			</form>
		</div>
				
			</div>
			
		</div>

<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	function bts(id){
		var aj =  id.value;
		console.log(aj);
		$.ajax({
             type: "get",
             url: "/farmapp/mypage/selllist2?orderNo="+aj,
             async: false,     //값을 리턴시 해당코드를 추가하여 동기로 변경
             success: function (data) {
                 result = data; 
                 if(result == 1){
                 if(id.innerHTML == '결제 완료'){
                	 alert("미입금 처리 되었습니다.");
                	 location.reload();
                	 id.innerHTML = "미입금"
                 }else if(id.innerHTML == '미입금'){
                	 alert("결제 처리 되었습니다.");
                	 location.reload();
                	 id.innerHTML = "결제 완료"
                 }
                 }
             }
         });	
	}
</script>

