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
/* 모두의 농장 주요 기능들을 소개하는 영역 */
/* .info__main .info__main-board { */
/* 	margin-top: 50px; */
/* } */
/* 모두의 농장 주요 기능을 소개하는 영역의 table */
.main-board__desc .desc__boxes{
	width: 100%;
}
.desc__boxes td {
	width: 33.3%;
}
/* 모두의 농장 주요 기능 소개하는 영역의 설명 box들 */
.main-board__desc .desc__box {
    position: relative;
    margin: 0 auto;
    padding: 10px;
 	width: 95%;
    height: 300px;
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
	<div class="info__img-desc">모두의 농장 소개 문구 생각해주세요!</div>
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
			<p>농업인을 직업으로 택한 2040세대들을 위해 자신의 농장 및 농작물을 홍보할 수 있는 공간을 제공합니다.</p>
			<p>농업인들은 자신의 농장에서 생산한 농작물을 판매할 수 있습니다.</p>
			<p>농업인들은 자신의 농장에서 주최하는 체험활동 또는 일손돕기를 등록하여 신청 받을 수 있습니다.</p>
			<p>사이트의 일반 회원들은 자신이 먹을 음식의 생산지를 알 수 있고 농장 체험도 해볼 수 있습니다. </p>
		</div>
	</div>
	<!-- 모두의 농장 주요 게시판 -->
	<div class="info__main-board">
		<!-- 제목 -->
		<p class="main-board__title">모두의 농장의 주요 서비스</p>
		<!-- 설명 -->
		<div class="main-board__desc">
			<table class="desc__boxes">
				<tr>
					<td>
						<div class="desc__box">
							<p class="desc__box-title">개인 농장 홍보</p>
							<p class="desc__box-desc">
							같이 무성할 어머니 오는 차 이름을 보고, 봅니다. 마리아 다 별이 잔디가 하나의 추억과 있습니다. 그리워 별 한 밤을 나의 보고, 하나 하나에 나의 거외다. 계절이 마디씩 그러나 언덕 있습니다. 그리고 아침이 하나 계절이 하나에 피어나듯이 무엇인지 잔디가 듯합니다. 아무 불러 너무나 오는 토끼, 강아지, 아직 거외다. 않은 지나고 하나에 별들을 벌레는 있습니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box">
							<p class="desc__box-title">제철 음식</p>
							<p class="desc__box-desc">
							같이 무성할 어머니 오는 차 이름을 보고, 봅니다. 마리아 다 별이 잔디가 하나의 추억과 있습니다. 그리워 별 한 밤을 나의 보고, 하나 하나에 나의 거외다. 계절이 마디씩 그러나 언덕 있습니다. 그리고 아침이 하나 계절이 하나에 피어나듯이 무엇인지 잔디가 듯합니다. 아무 불러 너무나 오는 토끼, 강아지, 아직 거외다. 않은 지나고 하나에 별들을 벌레는 있습니다.
							</p>
							<a href="#" class="desc__box-btn"><span>더보기</span><i class="far fa-caret-square-right"></i></a>
						</div>
					</td>
					<td>
						<div class="desc__box">
							<p class="desc__box-title">농장 체험 신청</p>
							<p class="desc__box-desc">
							같이 무성할 어머니 오는 차 이름을 보고, 봅니다. 마리아 다 별이 잔디가 하나의 추억과 있습니다. 그리워 별 한 밤을 나의 보고, 하나 하나에 나의 거외다. 계절이 마디씩 그러나 언덕 있습니다. 그리고 아침이 하나 계절이 하나에 피어나듯이 무엇인지 잔디가 듯합니다. 아무 불러 너무나 오는 토끼, 강아지, 아직 거외다. 않은 지나고 하나에 별들을 벌레는 있습니다.
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