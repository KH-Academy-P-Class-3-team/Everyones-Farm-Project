<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product/product_list.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product/product_detail.css">

<%@include file="../include/header.jsp" %>
<style type="text/css">
.main__footer {
    /* width: 980px; */
    margin: 0 auto;
    padding: 50px 0;
    display: flex;
    flex-direction: column;
    /* margin-top: 50px; */
    background: #605759;
}
</style>


<script type="text/javascript">
$(document).ready(function() {
	

	// 뒤로가기 버튼 클릭
	$("#back").click(function() {
		history.back();
	});
	
	
	// 메인화면 버튼 클릭
	$("#main").click(function() {
		location.href = "<%=request.getContextPath() %>/";
	})

	// 구매 버튼 클릭
	$("#buy").click(function() {
		var buy_confirm = confirm("구매하시겠습니까?");
		
		if(buy_confirm == true){
			location.href = '<%=request.getContextPath() %>/product/buy.do';
		} else{
			alert("취소하였습니다");
		}
	})
	
	// 장바구니 버튼 클릭
// 	$("#cart").click(function() {
// 		var cart_confirm = confirm("장바구니에 담으시겠습니까?");
		
// 		if(cart_confirm == true){
<%-- 			location.href = '<%=request.getContextPath() %>/product/cart.do'; --%>
// 		} else{
// 			alert("취소하였습니다");
// 		}
// 	})

// 	$(".plus").click(function(){
// 		this.querySelector('input[type=number]').stepUp();
// 		return false;
// 	})
	
})


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
		
		slides[slideIndex-1].style.display = "block";  
	}
	
	function plusSlides(n) {
		showSlides(slideIndex += n);
	}
	
	function currentSlide(n) {
		showSlides(slideIndex = n);
	}

	


</script>
<div style="clear: both; margin-top: 170px;"></div>

<div class="detail-top">
<!-- 	<div class="top-title">제철 음식</div> -->
<!-- 	<div class="top-sub">Seasonal Food</div> -->
</div>
<div class="activity-content">

<div class="product-title">${data.name }</div>


	<!-- 이미지 슬라이드쇼 영역	 -->
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
			<img src="<%=request.getContextPath() %>/resources/upload/${fileList.fileRename }">	
	
		</div>

		</c:forEach>

<%-- 		<c:if test="${not empty fileList }"> --%>
		<c:if test="${fn:length(fileList) > 1 }">
			<!-- 이미지 이전, 다음 버튼 -->
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
			<a class="next" onclick="plusSlides(1)">&#10095;</a>
		</c:if>
<%-- 		</c:if> --%>
		
	</div>

	<div style="height: 500px;">
	<div class="caption-img">
		<img alt="productimg" src="<%=request.getContextPath() %>/resources/image/product/peach.jpg">
	<div class="caption-main">
	
		<div class="caption-title">상품명</div>
		<div class="caption-content">${data.name }</div>
		<div class="caption-title">가격</div>
		<div class="caption-content">${data.price }</div>
		<form name="tobuy" method="post" action="<%=request.getContextPath()%>/product/cartimpl.do" >
		<input type="hidden" value="${data.productNo }" name="productNo"/>
		<input type="hidden" value="${data.optionNo }" name="optionNo"/>
		<div style="margin-top: 100px;">
		<div class="caption-title">상품 구매하기</div>
		<div class="caption-content">
<!-- 		<input type="number" min="0" max="200" class="count" />개 -->
		
<!-- 		<div class="number-input"> -->
<!-- 	  		<button type="button" onclick="this.querySelector('input[type=number]').stepDown()" ></button> -->
<!-- 	 		 <input min="0" name="count" value="1" type="number" class="quantity"/>개 -->
<!-- 	  		<button type="button" onclick="this.querySelector('input[type=number]').stepUp()" class="plus"></button> -->
<!-- 		</div> -->
		
		<div class="number-input">
		  <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepDown()" ></button>
		  <input class="quantity" min="0" name="count" value="1" type="number">
		  <button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
		</div>
		
		<br><br>
		<div class="cartbtn">
		<input type="button" name="buy" class="cart" value="구매하기" />
<!-- 		<input type="submit" name="tocart" class="cart" value="장바구니"/><br> -->
		<button type="submit" name="cart" class="cart">장바구니</button><br>
		<input type="button" name="ask" id="ask" class="cart" value="판매자 문의하기" style="width: 206px; margin-top: 5px;"/>
		
		</div>	
		</div>
	</div></form>
	

	</div>
	</div>
	</div>
	<br><br>
	<div class="caption">
	<hr>
	<div class="caption-title">소개</div>
	<div class="caption-content">${data.explain }</div>
	<div class="caption-title">효능</div>
	<div class="caption-content">${data.effect }</div>
	<div class="caption-title">할 수 있는 음식</div>
	<div class="caption-content">${data.food }</div>
	<div class="caption-title">원산지</div>
	<div class="caption-content">${data.productCountry }</div>
	<div class="caption-title">배달 방법</div>
	<div class="caption-content">${data.delivery }</div>
	</div>
	<br>
	<div style="text-align: center; margin: 20px;">
		<input type="button" style="margin: 0 30px;" id="back" class="cart" value="뒤로가기"/>
		<input type="button" style="margin: 0 30px;" id="main" class="cart" value="메인화면"/>
	</div>

</div>

<%@include file="../include/footer.jsp" %>