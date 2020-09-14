<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>게시판</title>
=======
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<%@page import = "common.dto.Farmer"%>
<style>
table {
	border: 1px solid #BDBDBD;
	text-align: center;
	width: 70%;
}
#calendar{
	height : 350px;
}

</style>
<script type="text/javascript">
    var today = new Date(); // 오늘 날짜
    var date = new Date();
 
    function beforem() //이전 달을 today에 값을 저장
    { 
        today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
        build(); //만들기
    }
    
    function nextm()  //다음 달을 today에 저장
    {
        today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
        build();
    }
    
    function build()
    {
        var nMonth = new Date(today.getFullYear(), today.getMonth(), 1); //현재달의 첫째 날
        var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); //현재 달의 마지막 날
        var tbcal = document.getElementById("calendar"); // 테이블 달력을 만들 테이블
        var yearmonth = document.getElementById("yearmonth"); //  년도와 월 출력할곳
        
        yearmonth.innerHTML = today.getFullYear() + "년 "+ (today.getMonth() + 1) + "월"; //년도와 월 출력
        
        if(today.getMonth()+1==12) //  눌렀을 때 월이 넘어가는 곳
        {
            before.innerHTML=(today.getMonth())+"월";
            next.innerHTML="1월";
            
        }
        else if(today.getMonth()+1==1) //  1월 일 때
        {
        before.innerHTML="12월";
        next.innerHTML=(today.getMonth()+2)+"월";
        }
        else //   12월 일 때
        {
            before.innerHTML=(today.getMonth())+"월";
            next.innerHTML=(today.getMonth()+2)+"월";
        }
       
        // 남은 테이블 줄 삭제
        while (tbcal.rows.length > 2) 
        {
            tbcal.deleteRow(tbcal.rows.length - 1);
        }
        var row = null;
        row = tbcal.insertRow();
        var cnt = 0;
 
        // 1일 시작칸 찾기
        for (i = 0; i < nMonth.getDay(); i++) 
        {
        	
            cell = row.insertCell();
            cnt = cnt + 1;
        }
 
        // 달력 출력
        for (i = 1; i <= lastDate.getDate(); i++) // 1일부터 마지막 일까지
        { 
            cell = row.insertCell();
            cell.innerHTML = 
            	'<div id="s" class="day">' + i+'<button id ="bu" type="button" onclick="javascript:testfunction('+i+')">일</button>'        	 + '</div> '
            
            cnt = cnt + 1;
            if (cnt % 7 == 1) {//일요일 계산
                cell.innerHTML = "<font color=#FF9090>" + '<div id="s" class="day">' + i+'<button id ="bu" type="button" onclick="javascript:testfunction('+i+')">일</button>'        	 + '</div> '//일요일에 색
            }
            if (cnt % 7 == 0) { // 1주일이 7일 이므로 토요일 계산
                cell.innerHTML = "<font color=#7ED5E4>" + '<div id="s" class="day">' + i+'<button id ="bu" type="button" onclick="javascript:testfunction('+i+')">일</button>'        	 + '</div> '//토요일에 색
                row = calendar.insertRow();// 줄 추가
            }
            if(today.getFullYear()==date.getFullYear()&&today.getMonth()==date.getMonth()&&i==date.getDate()) 
            {
                cell.bgColor = "#BCF1B1"; //오늘날짜배경색
            }
        }
 
    }
   
</script>


>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
<<<<<<< HEAD
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
.pagenate {margin-left =100px;
	
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
=======
	// 달력 날짜 버튼 ㅠㅠ
	function testfunction(i){
		console.log(i);
		
	}
	
	//달력 날짜눌렀을때 스크립트
	$(function() {
		$('.day').click(
				function() {
					 console.log($(this));
				     console.dir($(this));
				     var yearmonth = document.getElementById('yearmonth').innerHTML;
				     var res = yearmonth.split("년 ")
				     res[1] = parseInt(res[1].slice(0,-1));
				     if(res[1]<10){
				    	 res[1] = '0' + res[1];
				     }
				     
				     var d = parseInt($(this).eq(0).text());
				     
				     if( d<10){
				    	 d = '0'+d 
				     }
				     
				     var date = res[0]+res[1]+d
				     console.log(date)
				     $.ajax({
			             type: "get",
			             url: "/farmapp/mypage/cal?date="+date,
			             dataType : "json",
			             async: false,     //값을 리턴시 해당코드를 추가하여 동기로 변경
			             success: function (data) {
			            	 console.log(data);
			           		 var inner ="";
			           		 if(data.length <= 0){
			           			$('#writeday').html(" ");
			           		 $( '#resview > tbody').empty();
			           		 }
			           		 else{
			           		$('#writeday').html(" ");
			           		$('#writeday').html(getFormatDate(data[0].writeDate));
			           		
			            	 for (i=0; i<data.length; i++){
			            		 console.log(data[i].farmerNo)
				           		 console.log("bbb"+${farmerInfo.farmerNo})
			            		 if(data[i].farmerNo == ${farmerInfo.farmerNo}){
			            		 	inner+="<tr><td scope='col' class='text-center'>"+data[i].dailylogNo+"</td>";
									inner+="<td scope='col' class='text-center'><a href='/farmapp/mypage/dailyLogReadView?dailylogNo="+data[i].dailylogNo+"'>"+data[i].content + "</a></td>";
									inner+="<td scope='col' class='text-center'>"+ data[i].workingAmount + "</td>";
									inner+="<td scope='col' class='text-center'>"+data[i].workingTime+"</td>";
									inner+="<td scope='col' class='text-center'>"+data[i].workingMember+"</td></tr>";
			            		 }
			           		}
			            		 $( '#resview > tbody').empty();
			            		 $('#resview').append(inner);
			           		 }	
			             }, error:function(request,status,error){
			                 console.log(error);
			             }
			             
				     
		         });	
			});
	});
	
	//날짜를 가져오기 위한 함수ㅠㅠ
	function getFormatDate(dt) {
		var date = new Date(dt);
		var month = (1 + date.getMonth()); //M
		month = month >= 10 ? month : '0' + month; //month 두자리로 저장
		var day = date.getDate(); //d
		day = day >= 10 ? day : '0' + day; //day 두자리로 저장
		var year = date.getFullYear(); //yyyy
		return year + '년' + month + '월' + day+'일'; //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
	}
</script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
#bu{
padding: 0;
border: none;
background: none;
}
/* 마이페이지  */
.col-lg-3 {
	margin-top: 80px;
}
/*경계선*/
#border {
	border: groove;
}
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05

/* 내정보 나타내기 */
#mypagesize {
	height: 200px; webkit-fill-available;
	border: groove;
}

.search {
	text-align: center;
}
</style>
<<<<<<< HEAD
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
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
				<section id="container">
					<form role="form" method="get"
						action="/farmapp/mypage/dailyLoglist">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col" class="text-center">글 갯수</th>
									<th scope="col" class="text-center">작업 내용</th>
									<th scope="col" class="text-center">작업량</th>
									<th scope="col" class="text-center">작업 시간</th>
									<th scope="col" class="text-center">작업 인원</th>
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
					</form>
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
				</section>
				<hr>
=======

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<%@include file="../include/header.jsp" %>
<div style="clear: both; margin-top: 170px;"></div>
<!-- Page Content -->
<div class="container">
	<div class="row" style="width: 1200px">
		<div class="col-lg-3" style="margin-left:56px;">
			<h3 class="my-4 text-left">영농 일지</h3>
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
					<a href="/farmapp/mypage/selllist?farmerno=${farmerInfo.farmerNo}" >판매 목록</a>
				</div>
				<div class="panel-body">
					<a href="/farmapp/mypage/dailyLoglist?farmerno=${farmerInfo.farmerNo}"  style="font-weight: bold;">영농 일지</a>
				</div>
				<div class="panel-body">
					<a href="/farmapp/mypage/activitylist?farmerno=${farmerInfo.farmerNo}">체험
						신청내역</a>
				</div>

			</div>
		</div>

		<div id="root" style="width: 800px">
			<div id="mypagesize">
				<body onload="build();">
					<table align="center" id="calendar">
						<tr>
							<td><font size=1%; color="#B3B6B3"><label onclick="beforem()" id="before"></label></font></td>
							<td colspan="5" align="center" id="yearmonth"></td>
							<td><font size=1%; color="#B3B6B3"><label
									onclick="nextm()" id="next"></label></font></td>
						</tr>
						<tr>
							<td align="center"><font color="#FF9090">일</font></td>
							<td align="center">월</td>
							<td align="center">화</td>
							<td align="center">수</td>
							<td align="center">목</td>
							<td align="center">금</td>
							<td align="center"><font color=#7ED5E4>토</font></td>
						</tr>
					</table>

				</body>
			</div>
			<a href="/farmapp/mypage/dailyLogWrite?farmerno=${farmerInfo.farmerNo}"
				class="list-group-item list-group-item-action text-center font-weight-bold">영농 일지 작성하기</a>
			<div id = "writeday"></div>
			<div id="border">
				<form role="form" method="get" action="/farmapp/mypage/dailyLoglist">
					<table id="resview" class="table table-condensed">
						<thead>
							<tr class="success">
								<th scope="col" class="text-center">글 번호</th>
								<th scope="col" class="text-center">작업 내용</th>
								<th scope="col" class="text-center">작업량</th>
								<th scope="col" class="text-center">작업 시간</th>
								<th scope="col" class="text-center">작업 인원</th>
								<th scope="col" class="text-center"></th>
							</tr>
						</thead>

						
							<tr id = result_set>
							</tr>
					</table>
					
					<hr>
				</form>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
			</div>
		</div>

<<<<<<< HEAD
	</div>
</body>
</body>
</html>
=======
</div>

<%@include file="../include/footer.jsp" %>
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
