<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
#kakaomap{  
    width:300px;     
    height:300px; 
    margin:0 auto; 
} 
</style>

<div id="wrap" style="height: 900px;">

<%@include file="../include/farmdiaryheader.jsp"%>


<div style="clear: both; margin-top: 200px;"></div>


<div id="container" style="width: 980px; margin: auto;">

<h3 style="text-align: left;">농장소개</h3>
<hr>

<h4 style="text-align: center;"><b>농장 사진</b></h4>
<div style="padding: 20px; text-align: center;">
	<img src="<%=request.getContextPath() %>/resources/img/farm5.png" width="500px" height="300px">
</div>

<h4 style="text-align: center;"><b>농장 주소</b></h4>
<p style="text-align: center;">서울특별시 강남구 테헤란로 10길 9 그랑프리 빌딩 4F</p>
<div id="kakaomap">
<div id="map" style="width:300px;height:250px;"></div>
</div>

<h4 style="text-align: center;"><b>농장 연락처 : 010-1234-1234</b></h4>


<hr>

<div style="text-align: center;">
<button class="btn btn-success" type="button" onclick="location.href='farmdiarywrite.do'">농장정보 수정</button>
</div>

</div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=14225aab4988e7f3d13f01047e89e344&libraries=services"></script>

<script>
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(37.499059, 127.032912),
		level: 3
	};

	var map = new kakao.maps.Map(container, options);
</script>



<%@include file="../include/footer.jsp"%>







