<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/info/info.css" />

<!-- menu 의 float 속성 때문에 생성한 div -->
<div style="clear: both; margin-top: 170px;"></div>
<!-- 소개 페이지 가장 먼저 등장하는 img -->
<div class="info__img-wrap">
	<img alt="소개이미지" src="<%=request.getContextPath() %>/resources/image/info/info1.jpg" class="info__img-img" />
	<div class="info__img-cover"></div>
	<div class="info__img-desc">
		<span class="img-desc__size40">"모두의 농장"</span><span>에 어서오세요!</span>
	</div>
</div>

<div class="wrapper">

	<main class="info__main">
	<!-- 모두의 농장 기본 소개 -->
	<div class="info__basic-introduction">
		<!-- 추후에 오른쪽 하단에 이미지를 추가할 수 있으면 할 예정~ -->
		<!-- 제목 -->
		<p class="basic-introduction__title">모두의 농장이 존재하는 이유</p>
		<!-- 설명 -->
		<div class="basic-introduction__desc">
			<p>농업을 직업으로 선택한 청년농, 창업농들이 가장 필요로 하는 지원은 무엇일까요?</p>
			<p class="desc__deco-y-color desc__deco-size20">첫 번째, 정착 지원금 등 자본금 지원</p>
			<p class="desc__deco-y-color desc__deco-size20">두 번째, 판로 개척 지원</p>
			<p>위의 두 지원을 가장 필요로 한다고 합니다.</p>
			<p class="desc__deco-g-color desc__deco-size20">모두의 농장에서는 두 번째, 판로 개척 지원을 제공하여 농업인 회원들에게 도움이 되고자 합니다.</p>
		</div>
	</div>
	<!-- 농업인 회원을 위한 서비스 -->
	<div class="info__main-board">
		<!-- 제목 -->
		<p class="main-board__title-wrap">
		<span class="main-board__title">모두의 농장이</span><span class="main-board__title-deco-mark"> 농업인 회원</span><span class="main-board__title">을 위해</span>
		<p>
		<!-- 설명 -->
		<div class="main-board__desc">
			<table class="desc__boxes">
				<tr>
					<td>
						<div class="desc__box-img">
							<img alt="당근" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">먹거리 판매</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원들이 재배한 먹거리 상품을 사이트에서 판매할 수 있는 공간을 제공합니다. 이 먹거리들은 모두 모두의 농장에서 심사를 거친 상품들입니다.
							</p>
							<a href="<%=request.getContextPath() %>/product/main.do" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="당근" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">농장 체험</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원의 농장에서 시행하는 체험 및 일손돕기를 사이트에 등록하여 관리할 수 있습니다.
							</p>
							<a href="<%=request.getContextPath() %>/activity/activityList?isHelp=0" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="당근" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">영농일지</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원들의 영농작업 현황을 기록하는 문서인 영농일지 프로그램을 제공합니다.
							</p>
							<a href="<%=request.getContextPath() %>/farmer/farmerlogin.do" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 일반 회원을 위한 서비스 -->
	<div class="info__main-board">
		<!-- 제목 -->
		<p class="main-board__title-wrap">
		<span class="main-board__title">모두의 농장이</span><span class="main-board__title-deco-mark"> 일반 회원</span><span class="main-board__title">을 위해</span>
		<p>
		<!-- 설명 -->
		<div class="main-board__desc">
			<table class="desc__boxes">
				<tr>
					<td>
						<div class="desc__box-img">
							<img alt="과일" src="<%=request.getContextPath() %>/resources/image/info/fruit-row.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">먹거리 구매</p>
							<p class="desc__box-desc">
							모두의 농장은 심사를 거친 농업인 회원들이 재배한 농작물들을 판매하고 있습니다. 일반 회원 분들은 안심하고 신선하고 맛있는 먹거리를 구매할 수 있습니다.
							</p>
							<a href="<%=request.getContextPath() %>/product/main.do" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="과일" src="<%=request.getContextPath() %>/resources/image/info/fruit-row.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">농장 체험</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원이 등록한 농장 체험 목록을 제공합니다. 일반 회원들은 체험 목록을 보고 해당 농장에 문의하고 신청할 수 있습니다.
							</p>
							<a href="<%=request.getContextPath() %>/activity/activityList?isHelp=0" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="과일" src="<%=request.getContextPath() %>/resources/image/info/fruit-row.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">일손 돕기</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원이 등록한 일손 돕기 목록을 제공합니다. 일반 회원들은 농촌 봉사활동을 하고 싶을 시에 일손 돕기 목록을 보고 신청할 수 있습니다.
							</p>
							<a href="<%=request.getContextPath() %>/activity/activityList?isHelp=1" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- 모두의 농장 농업인 회원 신청 유도 부분 -->
	<div class="info__farmer-induction">
		<!-- 제목 -->
		<p class="farmer-induction__title">개인 농장 홍보 페이지를 만들고 싶으신가요?</p>
		<div class="farmer-induction__desc">
			<p>농업인 회원가입을 눌러 폼에 개인 정보 및 농장 정보를 입력하면 모두의 농장의 심사 기준에 따라 회원가입이 승인됩니다.</p>
			<p>농업인 회원이 되면 개인 농장 페이지를 받게 됩니다.</p>
			<p>개인 농장 페이지에서는 다음과 같은 서비스를 제공합니다.</p>
			<p class="desc__deco-y-color desc__deco-size20">첫 번째, 농장 및 농작물 소개</p>
			<p class="desc__deco-y-color desc__deco-size20">두 번째, 농작물 판매 등록 및 관리</p>
			<p class="desc__deco-y-color desc__deco-size20">세 번째, 농장 체험 및 일손 돕기 등록 및 관리</p>
			<p>농업인들을 위한 사이트를 만들고자 하는 <span class="desc__deco-g-color desc__deco-size20">모두의 농장</span>은 <span class="desc__deco-g-color desc__deco-size20">함께할 농업인 회원분들을 기다리고 있습니다.</span></p>
		</div>
		<div class="farmer-induction__img-wrap">
			<img alt="farmHouse" src="<%=request.getContextPath() %>/resources/image/info/farm_house.jpg" />
			<div class="farmer-induction__join-btn" id="toJoin">농업인 회원가입 하기</div>
		</div>
	</div>
	<!-- 모두의 농장 회사 위치 소개 -->
	<div class="info__contact-us">
		<!-- 제목 -->
		<p class="contact-us__title">CONTACT US</p>
		<div id="map" class="contact-us__map"></div>
		<div class="contact-us__desc">
			<p class="desc__p-tag"><i class="fas fa-map-marked-alt"></i>서울특별시 강남구 테헤란로 10길 9 그랑프리 빌딩</p>
			<p class="desc__p-tag"><i class="fas fa-phone"></i> 010-0309-0705</p>
			<p class="desc__p-tag"><i class="far fa-envelope"></i> everyonesfarm@naver.com</p>
		</div>
	</div>
	</main>
</div>


<!-- 농업인 회원가입 하기 버튼 클릭 이벤트 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/info/join_btn_event.js"></script>
<!-- Kakao Map API 적용 JavaScript -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=dfb9958d8c21639dffa141c87ba51341&libraries=services"></script>
<script>
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
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});  
	
	
</script>
<%@include file="../include/footer.jsp" %>