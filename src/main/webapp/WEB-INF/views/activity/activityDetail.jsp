<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<% pageContext.setAttribute("replaceChar", "\n"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EveryonesFarm</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/activity/activityDetail.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/activity/Example.Modal.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	// 이미지 파일이 없는 체험 활동에 기본 이미지 출력
// 	$(".slideshow").each(function() {
// 		if($(this).find("img").length == 0) {
<%-- 			$(this).prepend($("<img src='<%=request.getContextPath() %>/resources/image/activity/no-image.png' width='270' height='270'>")) --%>
// 		} 
// 	})
	
	
	// 모달창 인스턴트 생성
	var myModal = new Example.Modal({
	    id: "modal" // 모달창 아이디 지정
	});
	  
	// 전화 예약 모달창 열기
	$("#btnCall").click(function() {
	    myModal.show(); // 모달창 보여주기
	    
	    console.log("btnCall clicked")
	});
	  
	// 모달 창 안에 있는 확인 버튼 클릭 이벤트
	$(".confirm").click(function() {
	    myModal.hide(); // 모달창 감추기
	});
	
	
	// 신청서 예약 버튼 클릭
	$("#btnForm").click(function() {
		location.href = "<%=request.getContextPath() %>/activity/activityApplication.do?activityNo=${data.activityNo}&isHelp=${data.isHelp}";
	});
	
	
	// 체험 삭제 버튼 클릭
	$("#btnDelete").click(function() {
		location.href = "<%=request.getContextPath() %>/activity/activityDelete.do?activityNo=${data.activityNo}";
	})

})

/* 모달창 전화번호 복사 */
function copyText(e) {
	var $temp = $("<input>");
	
	$("body").append($temp);
	$temp.val($(e).text()).select();
	document.execCommand("copy");
	$temp.remove();
	
	alert("복사되었습니다.");
}


/* 이미지 슬라이드 */
var slideIndex = 1;
showSlides(slideIndex);

function showSlides(n) {
	var i;
	var slides = document.getElementsByClassName("slideshow");
// 	var dots = document.getElementsByClassName("dot");

	if (n > slides.length) {
		slideIndex = 1
	}
	
	if (n < 1) {
		slideIndex = slides.length
	}
	
	for (i = 0; i < slides.length; i++) {
 		slides[i].style.display = "none";  
  	}
	
// 	for (i = 0; i < dots.length; i++) {
// 		dots[i].className = dots[i].className.replace(" active", "");
//   	}
	
	slides[slideIndex-1].style.display = "block";  
// 	dots[slideIndex-1].className += " active";
}

function plusSlides(n) {
	showSlides(slideIndex += n);
}

function currentSlide(n) {
	showSlides(slideIndex = n);
}


/* 전화 예약 Modal창 띄우기 */
function openModal(modalname){
	  document.get
	  $("#modal").fadeIn(300);
	  $("."+modalname).fadeIn(300);
}
</script>

</head>
<body>

<div class="activity-content">

	<!-- 조회된 체험 활동 제목 -->
	<div class="top-title">${data.title }</div>
	
	
	<!-- 이미지 슬라이드쇼 영역 -->	
	<div class="slide-container">

		<!-- 이미지 size를 위한 변수 선언 -->
		<c:set var="fileSize" value="${fileList }"/>
	
		<!-- 이미지 리스트 반복 -->
		<c:forEach items="${fileList }" var="file" varStatus="status">

		<!-- 이미지 영역 -->
		<div class="slideshow fade">
			
			<c:if test="${fn:length(fileList) > 1 }">
			<!-- 이미지 인덱스 출력 (현재/전체) -->
			<div class="number-text">${status.count } / ${fn:length(fileSize) }</div>
			</c:if>

			<!-- 출력 이미지 -->
			<img src="<%=request.getContextPath() %>/resources/upload/${file.fileRename }">	
	
		</div>

		<!-- 점 표시 -->
<%-- 		<div class="slide-dot dot-div${status.count }"> --%>
<%-- 			<span class="dot dot${status.count }" onclick="currentSlide(${status.count})"></span>  --%>
<!-- 		</div> -->

		</c:forEach>

<%-- 		<c:if test="${not empty fileList }"> --%>
		<c:if test="${fn:length(fileList) > 1 }">
			<!-- 이미지 이전, 다음 버튼 -->
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
			<a class="next" onclick="plusSlides(1)">&#10095;</a>
		</c:if>
<%-- 		</c:if> --%>
		
	</div>
	
	
	<!-- 체험 활동 정보 -->
	<div class="caption">
		<div class="caption-title">농장명</div>
		<div class="caption-content">${data.farmName }</div>
		
		<div class="caption-title">참여 가능 인원</div>
		<div class="caption-content">${data.availNumber }명</div>
		
		<!-- 농장 체험일 때 요금 출력 -->
		<c:if test="${data.isHelp eq 0 }">
			<!-- 요금 데이터 형식 정의 (###,###) -->
			<div class="caption-title">요금</div><span class="price-span">(인당)</span>
			<div class="caption-content"><fmt:formatNumber value="${data.price }" pattern="###,###" />원</div>
		</c:if>
		
		<div class="caption-title">문의</div>
		<div class="caption-content">${data.phone }</div>
		
		<!-- 체험 내용 출력 (개행 인식) -->
		<div class="caption-title">체험 내용</div>
		<div class="caption-content">${fn:replace(data.content, replaceChar, "<br/>") }</div>
	
	
		<!-- 체험 일정 표(테이블) -->
		<div class="caption-title">체험 일정</div>
		
		<c:if test="${empty schedule }">
			<div class="schedule-empty">일정 내용이 없습니다.</div>
		</c:if>
		
		<c:if test="${not empty schedule }">
		<table class="schedule-table">
			<tr>
				<th class="th1">시간</th><th class="th2">내용</th><th class="th3">비고</th>
			</tr>
			<c:forEach items="${schedule }" var="sc">
			<tr>
				<td>${sc.time }</td>
				<td>${sc.content }</td>
				<td>${sc.etc }</td>
			</tr>
			</c:forEach>
		</table>		
		</c:if>
	
		<div class="caption-title">주소</div>
		
		<div class="caption-content">${data.firstAddress } ${data.secondAddress } (${data.zonecode })</div>
		
		<!-- 지도 표시 -->
		<div id="map"></div>
		
	
	</div>
	
	
	<div id="modal">
		<p class="modal-title">전화 예약</p>
		<p id="phone">${data.phone }</p>
		<button class="btnCopy" onclick="copyText('#phone')">복사</button>
		
		<button class="confirm">확인</button>
	</div>

	<c:if test="${farmerInfo.farmerNo ne data.farmerNo }">
	<div class="button-div">
		<button id="btnCall">전화 예약</button>
		<button id="btnForm">신청서 작성</button>
		<button id="btnBack" onclick="javascript:history.back();">목록으로</button>
	</div>
	</c:if>

	<c:if test="${farmerInfo.farmerNo eq data.farmerNo }">
	<div class="button-div">
		<button id="btnDelete">체험 삭제</button>
		<button id="btnBack" onclick="javascript:history.back();">목록으로</button>
	</div>
	</c:if>
	
</div>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	07a5f0d67c472caeb4a4c2d76b4ba65d&libraries=services"></script>
<script>

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.499059, 127.032912), // 지도의 중심좌표 (kh정보교육원)
        level: 3 // 지도의 확대 레벨
    };  

// 지도 생성   
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체
var geocoder = new kakao.maps.services.Geocoder();

var ad = '${data.firstAddress}' + ' ${data.secondAddress}';
var title= '${data.farmName}';

// 주소로 좌표 검색
geocoder.addressSearch(ad, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 체험활동명
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">' + title + '</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동
        map.setCenter(coords);
    } 
});    
</script>


</body>
</html>