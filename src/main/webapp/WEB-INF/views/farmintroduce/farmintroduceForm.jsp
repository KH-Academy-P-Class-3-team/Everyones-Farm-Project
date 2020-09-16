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



</div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=14225aab4988e7f3d13f01047e89e344&libraries=services"></script>

<script>
// 	var container = document.getElementById('map');
// 	var options = {
// 		center: new kakao.maps.LatLng(37.499059, 127.032912),
// 		level: 3
// 	};

// 	var map = new kakao.maps.Map(container, options);
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	}; 

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('서울특별시 강남구 테헤란로 10길 9 그랑프리 빌딩', function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {

	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리농장</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	}); 
</script>



<%@include file="../include/footer.jsp"%>







