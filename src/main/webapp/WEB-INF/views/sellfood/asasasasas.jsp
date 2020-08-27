<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%-- <%@include file="../common/header.jsp" %> --%>
<%-- <jsp:include page="../common/header.jsp" /> --%>
<%-- <jsp:include page="<%=request.getContextPath()%>/WEB-INF/views/common/header.jsp" /> --%>
<%-- <%@include file="../views/common/header.jsp" %> --%>

<!-- 해당 페이지에만 적용되는 Script -->
<!-- <script type="text/javascript"> -->

<!-- </script> -->

<!-- 해당 페이지에만 적용되는 Style -->
<style type="text/css">
/* @media ( max-width : auto) { */
/* 	.container { */

/* 	} */
/* } */

/* .container { */
/* 	margin-top: 60px; */
/* } */

/* form { */
/* 	width: 1050px; */
/* 	margin: 0 auto; */
/* 	margin-top: 100px; */
/* } */

/* .rowin { */
/* 	margin: 0 10px 40px; */
/* } */

/* /* 아이콘들 부모 div */
*
/
/* .col-xs-12 { */
/* 	text-align: center; */
/* 	padding-top: 50px; */
/* 	margin-top: 20px; */
/* 	margin-bottom: 40px; */
/* } */

/* /* 아이콘들 */
 
*
/
/* .recipeIcon { */
/* 	margin-right: 100px; */
/* } */

/* /* 제일 첫번째 아이콘 */
 
*
/
/* .firstIcon { */
/* 	margin-left: 50px; */
/* } */

/* /* 레시피 조회 div */
 
*
/
/* .recipeDiv { */
/* 	width: 1050px; */
/* 	margin: 0 auto; */
/* 	/*  	border: 1px solid #ccc; */
 
*
/
/* 	padding-top1: 30px; */
/* 	/*     padding-bottom: 30px; */
 
*
/
/* 	padding-left: 50px; */
/* 	padding-right: 50px; */
/* 	/*     position: relative; */
 
*
/
/* } */

/* /* 드롭다운 메뉴 */
 
*
/
/* #dropdownMenu { */
/* 	position: absolute; */
/* 	right: 16.5%; */
/* 	top: 13%; */
/* } */

/* /* 사진 밑에 텍스트 */
 
*
/
/* .caption { */
/* 	/* 	margin-top: -5px; */
 
*
/

/* } */

/* /* 프사 */
 
*
/
/* .profileImg { */
/* 	position: relative; */
/* 	z-index: 999; */
/* 	top: -50px; */
/* 	margin: 0 auto; */
/* 	border-radius: 70%; */
/* 	overflow: hidden; */
/* 	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 */
/* 		rgba(0, 0, 0, 0.19); */
/* } */

/* .dropdownOuter { */
/* 	width: 900px; */
/* 	/* border: 1px solid red; */
 
*
/
/* 	margin: 0 auto; */
/* 	text-align: end; */
/* } */

/* /* 콤보박스 스타일 설정 */
 
*
/
/* .selectbox { */
/* 	position: relative; */
/* 	width: 200px; /* 너비설정 */
 
*
/
/* 	border: 1px solid #999; /* 테두리 설정 */
 
*
/
/* 	z-index: 1; */
/* } */

/* /* 가상 선택자를 활용 화살표 대체 */
 
*
/
/* .selectbox:before { */
/* 	content: ""; */
/* 	position: absolute; */
/* 	top: 50%; */
/* 	right: 15px; */
/* 	width: 0; */
/* 	height: 0; */
/* 	margin-top: -1px; */
/* 	border-left: 5px solid transparent; */
/* 	border-right: 5px solid transparent; */
/* 	border-top: 5px solid #333; */
/* } */

/* .selectbox label { */
/* 	position: absolute; */
/* 	top: 1px; /* 위치정렬 */
 
*
/
/* 	left: 5px; /* 위치정렬 */
 
*
/
/* 	padding: .8em .5em; /* select의 여백 크기 만큼 */
 
*
/
/* 	color: #999; */
/* 	z-index: -1; /* IE8에서 label이 위치한 곳이 클릭되지 않는 것 해결 */
 
*
/
/* } */

/* .selectbox select { */
/* 	width: 100%; */
/* 	height: auto; /* 높이 초기화 */
 
*
/
/* 	line-height: normal; /* line-height 초기화 */
 
*
/
/* 	font-family: inherit; /* 폰트 상속 */
 
*
/
/* 	padding: .8em .5em; /* 여백과 높이 결정 */
 
*
/
/* 	border: 0; */
/* 	opacity: 0; /* 숨기기 */
 
*
/
/* 	filter: alpha(opacity = 0); /* IE8 숨기기 */
 
*
/
/* 	-webkit-appearance: none; /* 네이티브 외형 감추기 */
 
*
/
/* 	-moz-appearance: none; */
/* 	appearance: none; */
/* } */

/* .selectboxOuter { */
/* 	width: 900px; */
/* 	/* 	border: 1px solid red; */
 
*
/
/* 	margin: 0 auto; */
/* 	/* 	text-align: end; */
 
*
/
/* 	text-align: -webkit-right; */
/* } */

/* .clickNameText, .productCntText { */
/* 	font-weight: bolder; */
/* 	color: white; */
/* 	background-color: #BFE195; */


}

</style>

<!-- <div class="container" style="width: 1200px;"> -->
<!-- 	<div class="iconClass" style="width: 1200px;"> -->
<!-- 		<div class="row" style="width: 1200px;"> -->
<!-- 			<div class="col-xs-12"> -->
<!-- 				<a href="/product/list" class="productIcon firstIcon"><img -->
<%-- 					src="<%=request.getContextPath()%>/resources/img/watermelon.jpg" --%>
<!-- 					width="80" alt="..." class="img-circle"></a> <a -->
<!-- 					href="/product/list?category=1" class="productIcon"><img -->
<!-- 					src="/img/watermelon.jpg" width="80" alt="..." class="img-circle"></a> -->
<!-- 				<a href="/product/list?category=2" class="productIcon"><img -->
<!-- 					src="/img/watermelon.jpg" width="80" alt="..." class="img-circle"></a> -->
<!-- 				<a href="/product/list?category=3" class="productIcon"><img -->
<!-- 					src="/img/watermelon.jpg" width="80" alt="..." class="img-circle"></a> -->
<!-- 				<a href="/product/list?category=4" class="productIcon"><img -->
<!-- 					src="/img/watermelon.jpg" width="80" alt="..." class="img-circle"></a> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 부트스트랩 썸네일 div -->
</head>
<body>
	<div class="row">
		<div class="col-xs-6 col-md-3">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/watermelon.jpg"
				alt="...">
			</a>
		</div>
		<div class="col-xs-6 col-md-3">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/watermelon.jpg"
				alt="...">
			</a>
		</div>
	</div>



	<!-- 		<div class="selectboxOuter"> -->
	<!-- 			<div class="selectbox"> -->
	<!-- 				<label for="select">별점순</label> <select id="select"> -->
	<!-- 					<option selected>별점순</option> -->
	<!-- 					<option>최신순</option> -->
	<!-- 				</select> -->
	<!-- 			</div> -->
	<!-- 		</div> -->

<%-- 

	<div style="padding: 15px;">
		<c:if test="${paging.totalCount > 0 }">
			<h2 style="text-align: center;">
				<c:if test="${empty paging.category && empty paging.search }">
					<label class="clickNameText">전체</label>
				</c:if>
				<c:if test="${paging.category == 1 && empty paging.search }">
					<!-- 						<label class="clickNameText">고기요리</label> -->
				</c:if>
				<c:if test="${paging.category == 2 && empty paging.search }">
					<!-- 						<label class="clickNameText">면요리</label> -->
				</c:if>
				<c:if test="${paging.category == 3 && empty paging.search }">
					<!-- 						<label class="clickNameText">국/탕/찌개요리</label> -->
				</c:if>
				<c:if test="${paging.category == 4 && empty paging.search }">
					<!-- 						<label class="clickNameText">생선요리</label> -->
				</c:if>
				<c:if test="${empty paging.category && not empty paging.search }">
					<label class="clickNameText">${paging.search }</label>
				</c:if>
				<!-- 					ㄽㅍ가 -->
				<label class="productCntText">${paging.totalCount }</label>개 있습니다

			</h2>
		</c:if>
	</div>

	<div class="productDiv">
		<div class="row">
			<form class="form">
				<div class="list">

					<c:choose>
						<c:when test="${not empty productList}">
							<c:forEach items="${productList }" var="product">
								<!-- 시작 -->
								<div class="rowin"
									style="text-align: center; float: left; width: 200;">
									<div class="thumbnail" style="height: 385px;">
										<a href="/recipe/detail?recipeno=${recipe.recipeNo }"
											class="thumbnail" style="height: 200px; width: 200px;"> <img
											style="height: 190px; width: auto;"
											src="/upload_cooking/${recipe.recipeMainImg }" alt="...">
										</a> <img alt="Brand" src="/profile/${recipe.profileImg }"
											class="profileImg" style="width: 53px; height: 53px;">

										<div class="explain" style="width: 200px; margin-top: -40px;">

											<div class="exDiv" style="height: 100px;">
												<p style="text-align: center;">${recipe.nick }</p>
												<!-- 작성자 닉네임 -->
												<div style="height: 48px;">
													<p style="text-align: center;">${recipe.recipeTitle }</p>
													<!-- 글제목 -->
												</div>
												<p style="text-align: center;">
													<b>${recipe.recipeFood }</b>
													<!-- 음식명 -->
												</p>
											</div>

											<div class="btnDiv"
												style="text-align: center; margin-top: 15px;">
												<button type="button" class="btn btn-default btn-xs">
													<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
													${recipe.recipeTime }
													<!-- 조리시간 -->
												</button>
												<button type="button" class="btn btn-default btn-xs">
													<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
													${scoreMap.get(recipe.recipeNo) }점
													<!-- 별점 -->
												</button>
											</div>
										</div>
									</div>
								</div>
								<!-- 여기까지 -->
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div
								style="text-align: center; margin-top: 200px; margin-bottom: 200px; width: 880px;">
								<h1>검색 결과가 없습니다</h1>
							</div>
						</c:otherwise>

					</c:choose>

				</div>

			</form>
		</div>
	</div>
			--%>


<%-- 	<c:import url="/views/common/paging.jsp" /> --%>
	<br>
<%-- 	<jsp:include page="../common/footer.jsp" /> --%>
<%-- 	<jsp:include page="<%=request.getContextPath() %>/WEB-INF/views/common/footer.jsp" /> --%>