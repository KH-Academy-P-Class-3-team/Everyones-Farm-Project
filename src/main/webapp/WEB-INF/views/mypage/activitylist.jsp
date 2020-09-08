<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>판매 목록</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
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
	margin-left: 350px;
}

/* 내정보 나타내기 */
#mypagesize {
	height: 200px; webkit-fill-available;
	border: groove;
}

.search {
	text-align: center;
}
.sumarry {
   width: 500px;
   height: 150px;
   background-color: white;
   text-align: center;
   margin-left: 100px;
}
.userInform {
   border: 2px solid black;
   width: 100%;
   height: 100%;
}
.userName {
   border-right: 1px solid #ccc;
}

.sessionName {
   color: green;
   font-size: large;
   font-weight: bold;
}


.selfIcon {
   text-align: left;
   border: 1px solid white;
   border-radius: 7px;
   color: white;
   background-color: lime;
   padding: 3px;
   margin-right: 100px;
   margin-bottom: 10px;
}
.panel-default {
   border: none;
}

.panel-default>.panel-heading {
   background-color: #D1E9CA;
   border: none;
   font-weight: bold;
   font-size: 17px;
}

a {
   text-decoration: none;
   color: black;
}

a:hover {
   text-decoration: none;
}
</style>

	
<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<!-- Page Content -->
<%@include file="../include/header.jsp" %>
<div style="clear: both; margin-top: 170px;"></div>
<div class="container">
	<div class="row" style="width: 1200px">
		<div class="col-lg-3">
			<h3 class="my-4 text-left">체험 신청내역</h3>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/modify">회원</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/modify">회원정보
						수정</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List">1대
						1 문의</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/myActive">활동
						신청 현황</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/deleteId"
						style="color: #ccc;">회원 탈퇴</a>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">주문</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">장바구니</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/orderList">구매
						목록</a>
				</div>
			</div>


			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">농업인
					</a>
				</div>
				<div class="panel-body">
					<a href="#">내 정보</a>
				</div>
				<div class="panel-body">
					<a href="/farmapp/mypage/selllist">판매 목록</a>
				</div>
				<div class="panel-body">
					<a href="/farmapp/mypage/dailyLoglist">영농 일지</a>
				</div>
				<div class="panel-body">
					<a href="/farmapp/mypage/activitylist"   style="font-weight: bold;">체험
						신청내역</a>
				</div>

			</div>
		</div>
		
			<div id="root" style="width: 800px; margin-left:55px;">
				<div class="sumarry">
				<table class="userInform">
					<tr>
						<td class="userImg">사진</td>
						<td class="userName">
							<!-- 농부세션 확인해서 c:if 추가 -->
							<div>
								<span class="selfIcon">농업인</span>
							</div> <span class="sessionName">${farmerInfo.name } </span> 님 안녕하세요
						</td>
						<td class="userActive"><h5>주문현황</h5> <br> ${res }</td>
					</tr>
				</table>

			</div>
			<div id="color" >
				<a id="showActive"
					class="list-group-item list-group-item-action text-center font-weight-bold" style="background-color : yellow;">농장
					체험 신청 목록</a>
			</div>
			<div id="color2">
				<button id="showActive2"
					class="list-group-item list-group-item-action text-center font-weight-bold">일손
					체험 신청 목록</button>
			</div>
			
			
			<!-- 농장 체험 -->
			<div id="border" style="display:">
				<form role="form" method="get" action="/farmapp/mypage/activitylist">
					<table class="table table-condensed">
						<thead>
							<tr class="success">
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
								<td scope="col" class="text-center"><c:if
										test="${list.isApproval eq 1 }">
										<button style="width:70px;" type="button" onclick="bts(this)"
											class="btn btn-success" id="Approval"
											value="${list.APPLICATION_NO}">승인</button>
									</c:if> <c:if test="${list.isApproval eq 0 }">
										<button type="button" onclick="bts(this)"
											class="btn btn-danger" id="noApproval"
											value="${list.APPLICATION_NO}">미승인</button>
									</c:if></td>
							</tr>

						</c:forEach>
					</table>
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
				</form>
				<hr>
			</div>



			<!-- 일손 체험 리스트 -->
			<div id="border2" style="display: none;">
				<form role="form" method="get" action="/farmapp/mypage/activitylist">
					<table class="table table-condensed">
						<thead>
							
							<tr class="success">
								<th scope="col" class="text-center">신청 번호</th>
								<th scope="col" class="text-center">체험 명</th>
								<th scope="col" class="text-center">신청자</th>
								<th scope="col" class="text-center">인원</th>
								<th scope="col" class="text-center">체험 날짜</th>
								<th scope="col" class="text-center">승인</th>
							</tr>
						</thead>

						<c:forEach items="${list3}" var="list3">
							<tr>
								<td scope="col" class="text-center"><c:out
										value="${list3.APPLICATION_NO}" /></td>
								<td scope="col" class="text-center"><c:out
										value="${list3.title}" /></td>
								<td scope="col" class="text-center"><c:out
										value="${list3.APPLICANT_NAME}" /></td>
								<td scope="col" class="text-center"><c:out
										value="${list3.people}" /></td>
								<td scope="col" class="text-center"><c:out
										value="${list3.activityDate}" /></td>
								<td scope="col" class="text-center"><c:if
										test="${list3.isApproval eq 1 }">
										<button style="width:70px;" type="button" onclick="bts(this)"
											class="btn btn-success" id="Approval"
											value="${list3.APPLICATION_NO}">승인</button>
									</c:if> <c:if test="${list3.isApproval eq 0 }">
										<button type="button" onclick="bts(this)"
											class="btn btn-danger" id="noApproval"
											value="${list3.APPLICATION_NO}">미승인</button>
									</c:if></td>
							</tr>

						</c:forEach>
					</table>
					<div id="psize">
						<ul>
							<c:if test="${pageMaker3.prev}">
								<li><a
									href="activitylist${pageMaker3.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
							</c:if>

							<c:forEach begin="${pageMaker3.startPage}"
								end="${pageMaker3.endPage}" var="idx">
								<li><a href="activitylist${pageMaker3.makeQuery(idx)}">${idx}</a></li>
							</c:forEach>

							<c:if test="${pageMaker3.next && pageMaker3.endPage > 0}">
								<li><a
									href="activitylist${pageMaker3.makeQuery(pageMaker3.endPage + 1)}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</form>
				<hr>
			</div>
		</div>
</div>
</div>
<%@include file="../include/footer.jsp" %>
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	function bts(id){
		// border 는 농장 체험 리스트 값
		var border = $('#border').css("display");
		// showActive 농장 체험 버튼 값
		var showActive = $('#showActive').css("display");
		// border2 는 일손 체험 리스트 값
		var border2 = $('#border2').css("display");
		// showActive2 일손체험 버튼 값
		var showActive2 = $('#showActive2').css("display");
		var aj =  id.value;
		console.log(aj);
		$.ajax({
             type: "get",
             url: "/farmapp/mypage/activitylist2?applicationNo="+aj,
             async: false,     //값을 리턴시 해당코드를 추가하여 동기로 변경
             success: function (data) {
                 result = data;
                 if(result == 1){
//                	 location.reload();
                 if(id.innerHTML == '승인'){
//                 	 location.reload();
//                 	 $('#border').show()
                	 alert("미승인 처리 되었습니다.");
                	 id.innerHTML = "미승인"
               		 id.style.backgroundColor= 'rgb(255,0,0)';
                	 

//                 	 $('#border.show()').load(location.href+'#border.show()');
                 }else if(id.innerHTML == '미승인'){
                	 alert("승인 처리 되었습니다.");
                	 id.innerHTML = "승인"
               		 id.style.backgroundColor= 'rgb(0,255,0)';
                	 id.style.width = '70px';
//                 	 $('#border.show()').load(location.href+'#border.show()');
//                 	 $('#showActive').load(location.href+'#showActive');
//                 		 $('#border').show(700);
                 }
                 }
             }
         });	
	}
	
       
</script>


<script type="text/javascript">

// 내코드
	$(function(){
		
		$('#showActive').click(function(){
			// border 는 농장 체험 리스트 값
			var border = $('#border').css("display");
			// showActive 농장 체험 버튼 값
			var showActive = $('#showActive').css("display");
			// border2 는 일손 체험 리스트 값
			var border2 = $('#border2').css("display");
			// showActive2 일손체험 버튼 값
			var showActive2 = $('#showActive2').css("display");
			console.log(border);
			console.log(showActive);
			console.log(border2);
			console.log(showActive2);
		
			// 농장 체험 버튼을 눌렀을 때
			if(showActive=="block"){
				$('#border').show(200);
				$("#showActive").css("background-color", "yellow");
				$('#showActive2').hide(200);
			}
			if(border == "block"){
				$('#border').hide(700);
				$("#showActive").css("background-color", "");
				$('#showActive2').show(200);
			}
		});
	})
	
	$(function(){
		
			// 일손 체험 버튼을 눌렀을 때
		$('#showActive2').click(function(){
			// border 는 농장 체험 리스트 값
			var border = $('#border').css("display");
			// showActive 농장 체험 버튼 값
			var showActive = $('#showActive').css("display");
			// border2 는 일손 체험 리스트 값
			var border2 = $('#border2').css("display");
			// showActive2 일손체험 버튼 값
			var showActive2 = $('#showActive2').css("display");
			console.log(border);
			console.log(showActive);
			console.log(border2);
			console.log(showActive2);
		
			if(showActive2=="block"){
				$('#border2').show(200);
				$("#showActive2").css("background-color", "yellow");
				$('#showActive').hide(200);
				$('#border').hide(200);
			}
			if(border2 == "block"){
				$('#border2').hide(200);
				$("#showActive2").css("background-color", "");
				$('#showActive').show(200);
				$("#showActive").css("background-color","");
			}
		});
	});
	
	//형 코드
	
// 	$("#showActive").click(function() {
// 	console.log("농장 신청 활동 내역");
// 	var border =	$("#border").css("display");
// 	var test2 =	$("#border2").css("display");
// 	console.log("리스트"+border);
// 	if(test!="none"){
// 		$("#border").css("display","none");
// 			$("#showActive").css("background-color", "")
// 	}
// 	 if(border =="none"){
// 		if(test2 !="none"){
// 		$("#border2").css("display","none");
// 		$("#border").css("display","");
// 			$("#showActive").css("background-color", "yellow")
// 		}else{
// 		$("#border").css("display","");
// 			$("#showActive").css("background-color", "yellow")
// 		}
// 	}
// 	})
// })

// 	$(document).ready(function(){

// 	$("#showActive2").click(function() {
// 	console.log("농장 신청 활동 내역");
// 	var test =	$("#border2").css("display");
// 	var test2 =	$("#border").css("display");
// 	console.log(test);
// 	if(test!="none"){
		
// 		$("#border2").css("display","none");
// 			$("#showActive2").css("background-color", "")
// 	}else if(test == "none"){
// 		if(test2 !="none"){
// 			$("#border").css("display","none");
// 			$("#border2").css("display","");
// 			$("#showActive2").css("background-color", "yellow")
// 			}else{
// 			$("#border2").css("display","");
// 			$("#showActive2").css("background-color", "yellow")
// 			}
// 	}
// 	})
// })

// 	var border = document.querySelector('#border');
// 	var showActive = document.getElementById('#showActive');
// 	showActive.click(function(){
// 		border.style.diplay = "";

		
</script>
