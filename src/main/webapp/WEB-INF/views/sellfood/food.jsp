<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<h2>일반음식</h2>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>

<style type="text/css">
.center-block {
  display: block;
  margin-left: 200px;
  margin-right: 300px;
  margin-bottom: 100px;
}

#padding_line{
background-color: darkgrey;
}




</style>


</head>
<body>
	<div class="center-block row ">
		<div class="col-sm-6 col-md-4">
			<a href="<%=request.getContextPath()%>/sellfood/detail" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/grape.jpg"
				alt="...">
				
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/herbs.jpg"
				alt="...">
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/beef.jpg"
				alt="...">
			</a>
		</div>
	</div>
	
	<div class="row center-block">
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/chopsticks.jpg"
				alt="...">
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/banana.jpg"
				alt="...">
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/melon.jpg"
				alt="...">
			</a>
		</div>
	</div>
	
	
	<!-- 가운데 선 긋기 -->
	<div id="padding_line" style="width:100%; min-height:1px; height:10px; ">
	</div>
	
	<h2>제철음식</h2>
	
	<!-- 가운데 선 밑에 여백 주기 -->
	<div doz_type="grid" doz_grid="12" class="col-dz col-dz-12"><div doz_type="widget" id="w201912014044b6c998adf"><div class="_widget_data " data-widget-name="여백" data-widget-type="padding" data-widget-anim="none" data-widget-anim-duration="0.7" data-widget-anim-delay="0" data-widget-parent-is-mobile="N"><div class="widget padding" data-height="20" style="margin-top:px; margin-bottom:px;">
	<div id="padding_w201912014044b6c998adf" style="width:100%; min-height:1px; height:35px; "></div>
	</div>
	</div></div></div>
	
	<div class="center-block row ">
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/strawberry.jpg"
				alt="...">
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/orientalmelon.jpg"
				alt="...">
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/tomato.jpg"
				alt="...">
			</a>
		</div>
	</div>
	
	<div class="row center-block">
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/pear.jpg"
				alt="...">
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/plum.jpg"
				alt="...">
			</a>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<a href="#" class="thumbnail"> <img
				src="<%=request.getContextPath()%>/resources/img/kiwi.jpg"
				alt="...">
			</a>
		</div>
	</div>
	

	
</body>
</html>