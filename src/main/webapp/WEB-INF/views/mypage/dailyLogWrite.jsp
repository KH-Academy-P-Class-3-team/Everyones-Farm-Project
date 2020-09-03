<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>영농 일지</title>


<style type="text/css">
#mypagesize {
	height: 300px; webkit-fill-available;
	border: groove;
}
#root {
	width: 800px;
	border: ridge;
	height: 700px;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
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
					정보</a> <a href="/farmapp/mypage/selllist"
					class="list-group-item list-group-item-action text-center font-weight-bold">판매
					목록</a> <a href="/farmapp/mypage/dailyLoglist"
					class="list-group-item list-group-item-action text-center font-weight-bold"
					style="background-color: #D1E9CA;">영농 일지</a> <a
					href="/farmapp/mypage/activitylist"
					class="list-group-item list-group-item-action text-center font-weight-bold">활동
					내역</a>
				</div>
			</div>

			<form role="form" method="post"	action="/farmapp/mypage/dailyLogwrite">
				<div id="root">
					<div>
						<label for="content">내용</label>
						<textarea id="content" name="content"></textarea>
						<br> <label for="title">작업량</label> <input type="text"
							id="workingAmount" name="workingAmount" /><br> <label
							for="title">작업 시간</label> <input type="text" id="workingTime"
							name="workingTime" /><br> <label for="title">작업 인원</label>
						<input type="text" id="workingMember" name="workingMember" /><br>
						<label for="title">작업 날짜</label> <input type="text"
							id="workingDate" name="workingDate" /><br> <label
							for="title">날씨</label> <input type="text" id="weather"
							name="weather" /><br> <label for="title">강수량</label><input
							type="text" id="rain" name="rain" /><br> <label for="title">최고
							온도</label> <input type="text" id="maxTemp" name="maxTemp" /><br> <label
							for="title">최저 온도</label> <input type="text" id="minTemp"
							name="minTemp" /><br>
						<button class="write_btn" type="submit">작성</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@include file="../include/footer.jsp" %>

