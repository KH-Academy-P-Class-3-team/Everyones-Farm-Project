<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- include header -->
<%@include file="../include/header.jsp" %>
<style type="text/css">
.search__title-wrap .search__title {
    font-size: 20px;
    border-left: 3px solid #789F6F;
    padding-left: 7px;
    font-weight: 700;
    opacity: 0.8;
}
/* 검색창 css */
.search__search-input-wrap {
	display: flex;
/*     justify-content: center; */
    margin-top: 30px;
    margin-bottom: 30px;
}
/* input[type='text'] css 초기화 */
input[type="text"] {
	appearance:none;
	outline: none;
}
input[type="text"]:focus {
	outline: none;
}
/* button css 초기화 */
.search__search-input-wrap button {
	border: none;
    box-shadow: none;
    border-radius: 0;
    padding: 0;
    overflow: visible;
    cursor: pointer;
    outline: none;
}
.search__search-input-wrap button:focus {
	outline: none;
}
/* 검색어 입력 창 css */
.search__search-input-wrap input[type="text"] {
	width: 500px;
    height: 45px;
    padding: 5px;
    border: 1px solid #789F6F;
   	vertical-align: bottom;
}
/* 검색 버튼 css */
.search__search-input-wrap button {
	height: 45px;
    width: 50px;
    background: #789F6F;
    font-weight: 700;
    color: white;
}
/* 검색 결과 타이틀 */
.search__result-wrap .title-wrap {
    margin-bottom: 30px;
}
.title-wrap .title {
    font-size: 18px;
    border-left: 3px solid #789F6F;
    padding-left: 7px;
}
</style>

<!-- menu 의 float 속성 때문에 생성한 div -->
<div style="clear: both; margin-top: 220px;"></div>
<div class="wrapper">
	<!-- main -->
	<main class="search__main">
		<div class="search__title-wrap">
			<span class="search__title">모두의 농장 검색</span>
		</div>
		<!-- 검색창 -->
		<div class="search__search-input-wrap">
			<input type="text" name="search" id="member-search" placeholder="검색어를 입력하세요" /><button id="search-btn">검색</button>
		</div>
		<!-- 검색 결과  -->
		<div class="search__result-wrap">
			<div class="result__food-seasonal">
				<div class="title-wrap">
					<span class="title">제철 먹거리 검색 결과</span>
				</div>
			</div>
			<div class="result__food-general">
				<div class="title-wrap">
					<span class="title">일반 먹거리 검색 결과</span>
				</div>
			</div>
			<div class="result__farm">
				<div class="title-wrap">
					<span class="title">농장 검색 결과</span>
				</div>
			</div>
			<div class="result__activity">
				<div class="title-wrap">
					<span class="title">체험 검색 결과</span>
				</div>
			</div>
		</div>
	</main>
</div>

<!-- 검색 javascript -->
<script type="text/javascript">
function isEmptyWord() {
	alert("검색어를 입력해주세요.")
	$("#member-search").focus()
}
function isNotEmptyWord(word) {
	$(location).attr("href", "/farmapp/search?search=" + word)
}
$("#search-btn").on("click", function(){
	
	const word = $("#member-search").val() 
	/* 검색어가 입력되어 있지 않을 경우에는 이벤트 적용 안되게 */
	if(word == ''){
		
		isEmptyWord()
			
	} else {
		
		isNotEmptyWord( word )
		
	}
})
/* 검색창에서 enter 버튼 누를 시 검색 되게 */
$("#member-search").on("keydown", function(event){
	
	const word = $("#member-search").val() 
	/* Enter key 누를 때 */
	if( event.keyCode == 13 ){
		if(word == ''){
			
			isEmptyWord()
			
		} else {
			
			isNotEmptyWord( word )
			
		}
	}
})
</script>
<!-- include footer -->
<%@include file="../include/footer.jsp" %>