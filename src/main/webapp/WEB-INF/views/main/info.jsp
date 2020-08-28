<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp" %>
<style type="text/css">
/* 소개 페이지 가장 처음 등장하는 img */
.info__img-wrap {
	position: relative;
	width: 100%;
	height: 500px;
}
/* img */
.info__img-wrap .info__img-img {
	width: 100%;
    height: 100%;
    object-fit: cover;
}
/* img 를 덮는 div */
.info__img-wrap .info__img-cover{
	position: absolute;
	top: 0;
	width: 100%;
	height: 100%;
	background: black;
    opacity: 0.5;
}
/* img 위에 글씨 */
.info__img-wrap .info__img-desc {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
	font-size: 30px;
	font-weight: 700;
	color: white;
    display: flex;
    justify-content: center;
    align-items: center;
}
/* 모두의 농장 글씨 크기 키우기 */
.info__img-desc .img-desc__size40{
	font-size: 40px;
}
/* 소개 페이지 main 태그 */
.info__main {
/* 	margin-top: 200px; */
}
/* p 태그 초기화 */
.info__main p {
	margin: 0;
}
/* 사이트가 존재하는 이유에 대해 설명하는 공간 */
.info__main .info__basic-introduction
, .info__main .info__main-board
, .info__main .info__farmer-induction
, .info__main .info__contact-us {
	margin-top: 50px;
    padding-bottom: 50px;
	border-bottom: 3px solid #789F6F;
}
/* 사이트 존재 이유 title */
/* 모두의 농장 주요 서비스 title */
.info__basic-introduction .basic-introduction__title
, .info__main-board .main-board__title
, .info__farmer-induction .farmer-induction__title
, .info__contact-us .contact-us__title  {
	font-size: 28px;
    font-weight: 700;
    margin-bottom: 20px;
}
/* 사이트 존재 이유 desc */
.info__basic-introduction .basic-introduction__desc {
	padding: 0 10px;
}
/* 존재이유 p 태그들 */
.basic-introduction__desc p {
	margin-bottom: 15px;
}
.basic-introduction__desc p:last-child {
	margin-bottom: 0;
}
/* 모두의 농장이 존재하는 이유 중요 표시 */
.basic-introduction__desc .desc__deco-size20{
	font-size: 20px;
    font-weight: 700;
}
.basic-introduction__desc .desc__deco-y-color {
	color: #E2CC6C;
}
.basic-introduction__desc .desc__deco-g-color {
	color: #789F6F;
}
/* 모두의 농장 농업인 회원을 위한 서비스 의 title style */
.info__main-board .main-board__title-wrap {
	margin-bottom: 30px;
}
.main-board__title-wrap .main-board__title-deco-mark{
	font-size: 30px;
    font-weight: 700;
    color: #789F6F;
}
/* 모두의 농장 주요 기능을 소개하는 영역의 table */
.main-board__desc .desc__boxes{
	width: 100%;
}
.desc__boxes td {
	width: 33.3%;
}
/* box 위에 이미지 */
.desc__boxes .desc__box-img {
	display: flex;
    justify-content: center;
}
.desc__box-img img {
	width: 90%;
}
/* 모두의 농장 주요 기능 소개하는 영역의 설명 box들 */
.main-board__desc .desc__box {
    position: relative;
    margin: 0 auto;
    padding: 10px;
 	width: 95%;
    height: 200px;
    background: #D1E9CA;
    border-radius: 5px;
}
/* desc__box 안에 title */
.desc__box .desc__box-title {
	margin-bottom: 30px;
    font-size: 20px;
    font-weight: 700;
    opacity: 0.7;
}
/* desc__box 안에 더보기 버튼 */
.desc__box .desc__box-btn {
	position: absolute;
    bottom: 10px;
    right: 20px;
    font-size: 18px;
    color: black;
    text-decoration: none;
}
.desc__box .desc__box-btn span {
	margin-right: 7px;
}
</style>

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
							<img alt="먹거리 판매" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">먹거리 판매</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원들이 재배한 먹거리 상품을 사이트에서 판매할 수 있는 공간을 제공합니다. 이 먹거리들은 모두 모두의 농장에서 심사를 거친 상품들입니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="먹거리 판매" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">농장 체험</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원의 농장에서 시행하는 체험 및 일손돕기를 사이트에 등록하여 관리할 수 있습니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="먹거리 판매" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">영농일지</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원들의 영농작업 현황을 기록하는 문서인 영농일지 프로그램을 제공합니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
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
							<img alt="먹거리 판매" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">먹거리 판매</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원들이 재배한 먹거리 상품을 사이트에서 판매할 수 있는 공간을 제공합니다. 이 먹거리들은 모두 모두의 농장에서 심사를 거친 상품들입니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="먹거리 판매" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">농장 체험</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원의 농장에서 시행하는 체험 및 일손돕기를 사이트에 등록하여 관리할 수 있습니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box-img">
							<img alt="먹거리 판매" src="<%=request.getContextPath() %>/resources/image/info/carrot.jpg">
						</div>
						<div class="desc__box">
							<p class="desc__box-title">영농일지</p>
							<p class="desc__box-desc">
							모두의 농장은 농업인 회원들의 영농작업 현황을 기록하는 문서인 영농일지 프로그램을 제공합니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
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
		<p>채울 예정~</p>
	</div>
	<!-- 모두의 농장 회사 위치 소개 -->
	<div class="info__contact-us">
		<!-- 제목 -->
		<p class="contact-us__title">CONTACT US</p>
		<p>채울 예정~</p>
	</div>
	</main>

</div>


<%@include file="../include/footer.jsp" %>