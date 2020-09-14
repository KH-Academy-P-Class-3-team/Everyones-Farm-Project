<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp"%>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
.input-group {
	margin-top: 30px;
}


.col-lg-1 {
	width: 50%;
	margin-left: 150px;
}

span {
	padding: 0;
}

.input-group {
	width: 400px;
}

label {
	padding-left: 0;
	text-align: left;
}

.btn-warning {
	width: 90px;
	height: 50px;
}

.media-object {
	margin-left: 70px;
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

.ckck {
	width: 800px;
	height: 400px;
}

#o3space {
	width: 100%;;
	height: 100%;
}
#ckEditsub{
	width: 90px;
	height: 50px;
	margin-right: 5px;
}
</style>

<!-- ckeditor js 파일 삽입 -->
<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>
	
﻿<script type="text/javascript">
$(document).ready(function(){
	$("#ckEditsub").on("click", function(){
		/* 제목 비어 있으면 제목에 입력하기 */
		if($("input[name='title']").val() == ''){
			
			alert("제목을 입력해주세요")
			$("input[name='title']").focus()
			
		} else if ( CKEDITOR.instances.O3Write.getData() == '' ) {
			
			alert("내용을 입력해주세요")
			$(CKEDITOR.instances.O3Write).focus()
			
		} else {
			
			/* form submit 이벤트 동작 */
			$("#write-form").submit()
			
		}
	})
})
</script>

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top: 200px"></div>

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h3 class="my-4 text-left">1대1 문의</h3>
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
					<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List" style="font-weight: bold;">1대
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

			<c:if test="${farmerInfo.name eq null} ">
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
						<a href="/farmapp/mypage/activitylist" style="font-weight: bold;">체험
							신청내역</a>
					</div>

				</div>
			</c:if>
		</div>
		<div class="col-lg-1">


			<!-- 에디터 포함 작성  -->
			<div class="container">
				<div class="content" style="width: 70%">



					<!-- 공지사항 작성 폼 -->
					<div class="oneonone-write__form-wrap">
						<form action="<%=request.getContextPath()%>/mypage/user/write"
							method="post" class="form-wrap__form" id="write-form">
							<ul class="form-wrap__list">
								<li>
								<div>
								<label class="control-label" for="inputSuccess4">제목 :</label>
								<input type="text" placeholder="제목" name="title"id="title"aria-describedby="inputSuccess4Status"
									class="form-control" style="margin-bottom: 10px;" />
								</div>
									</li>
								<li id="o3space"><textarea name="content" class="list__textarea"
										id="O3Write">글씨를 지우고 내용을 입력해주세요.</textarea> <script
										type="text/javascript">
											CKEDITOR
													.replace(
															'O3Write',
															{
																filebrowserUploadUrl : '/farmapp/mypage/user/fileupload'
															});
										</script></li>
							</ul>

						</form>
								<button type="button" class="btn btn-success pull-right" id="ckEditsub">등 록</button>
								<button class="btn btn-warning pull-right"onclick='javascript:history.back();'id="ckEditsub" >뒤로 가기</button>
					</div>
				</div>
			</div>


		</div>


	</div>
</div>






<%@include file="../../include/footer.jsp"%>
