<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<h2>일반음식</h2>

<style type="text/css">

.center-name h3{

	right: 500px;
	margin-left: 500px;
	
}
.center-name-img {
	float: left;
}



</style>
</head>

<body>

	<div class="center-block row ">
		<div class="center-name">
		<div class="col-sm-6 col-md-4 center-name-img">
			<a href="<%=request.getContextPath()%>/sellfood/detail"
				class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/grape.jpg"
				alt="...">
			</a>
		</div>
		<h3>포도</h3>
		<h3>7000원</h3>
		
		
		<hr>
		
	</div>




	</div>	
</body>
</html>