<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
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



<script>
	// 달력 날짜 버튼 ㅠㅠ

	function testfunction(i){
		console.log(i);
		
	}
	
	$(function() {
		$('.day').click(
				function() {
					 console.log($(this));
				     console.dir($(this));
				     var d = $(this).eq(0).text();
				     console.log(d);
				     var border = $('#border').css("display");
				     if(border == 'none'){
						$('#border').show();				    	 
				     }else if(border == 'block'){
						$('#border').show();				    	 
				     }
				     
				});
	});
	
</script>

<style type="text/css">
#bu{
padding: 0;
border: none;
background: none;
}
.pagenate {
	margin-left: 100px;
}
/* 마이페이지  */
.col-lg-3 {
	margin-top: 80px;
}
/*경계선*/
#border {
	border: groove;
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
	height: webkit-fill-available;
	border: groove;
}

.search {
	text-align: center;
}
.row{
margin-left:-90px;
}
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<%@include file="../include/header.jsp" %>
<!-- menu 의 float 속성 때문에 생성한 div -->
<div style="clear: both; margin-top: 170px;"></div>
<!-- Page Content -->
<div class="container">
	<div class="row" style="width: 1200px">
		<div class="col-lg-3">
			<h3 class="my-4 text-center">농업인 마이페이지</h3>
			<div class="list-group mb-4">
				<a href="#"
					class="list-group-item list-group-item-action text-center font-weight-bold">내
					정보</a> <a href="/farmapp/mypage/selllist?farmerno=${farmerInfo.farmerNo}"
					class="list-group-item list-group-item-action text-center font-weight-bold">판매
					목록</a> 
					<a href="/farmapp/mypage/dailyLoglist?farmerno=${farmerInfo.farmerNo}"
					class="list-group-item list-group-item-action text-center font-weight-bold"
					style="background-color: #D1E9CA;">영농 일지</a> <a
					href="/farmapp/mypage/activitylist?farmerno=${farmerInfo.farmerNo}"
					class="list-group-item list-group-item-action text-center font-weight-bold">활동
					내역</a>
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
			<a href="/farmapp/mypage/dailyLoglist?farmerno=${farmerInfo.farmerNo}"
				class="list-group-item list-group-item-action text-center font-weight-bold" style="background-color : yellow;">영농
				일지 리스트 돌아가기</a>

			<div id="border" >
				<form role="form" name="readForm" method="post" action="/farmapp/mypage/dailyLoglist">
				<div id="root">
					<div>
						<label for="content">내용</label><textarea id="content" name="content"><c:out value="${read.content}"/></textarea><br> 
						<label for="title">작업량</label> <input type="text" id="workingAmount" name="workingAmount" value="${read.workingAmount}"/><br>
						<label	for="title">작업 시간</label> <input type="text" id="workingTime" name="workingTime" value="${read.workingTime}"/><br> 
						<label for="title">작업 인원</label><input type="text" id="workingMember" name="workingMember" value="${read.workingMember}"/><br>
						<label for="title">작업 날짜</label> <input type="text" 	id="workingDate" name="workingDate" value="${read.workingDate}"/><br>
						<label for="title">날씨</label> <input type="text" id="weather" name="weather" value="${read.weather}"/><br> 
						<label for="title">강수량</label><input type="text" id="rain" name="rain" value="${read.rain}"/><br> 
						<label for="title">최고 온도</label> <input type="text" id="maxTemp" name="maxTemp" value="${read.maxTemp}"/><br> 
						<label for="title">최저 온도</label> <input type="text" id="minTemp" name="minTemp" value="${read.minTemp}"/><br>
					</div>
				</div>
					
					
					<hr>
				</form>
				
			</div>

		</div>
	</div>

</div>


<%@include file="../include/footer.jsp" %>