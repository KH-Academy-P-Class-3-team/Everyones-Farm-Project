<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp" %>

<style type="text/css">
.margin-top200 {
	margin-top: 200px;
}
/* 공지사항, 자주묻는질문 페이지에 리스트를 감싸는 영역 */
.notice__main .notice__rows {
	width: 900px;
    margin: 0 auto;
}
.notice__rows .notice__row {
    border-top: 1px solid #605759;
}
.notice__row .nrow__title-wrap
, .frequently__row .frow__title-wrap {
     position: relative;
     background: #D1E9CA;
     padding: 14px 7px;
     border-bottom: 1px solid #605759;
     display: flex;
     align-items: center;
     cursor: pointer;
}
/* 제목에 hover 이벤트 발생 시 */
.notice__row .nrow__title-wrap:hover
, .frequently__row .frow__title-wrap:hover {
	background: #E9F7AB;
}
.notice__row .nrow__title {
	margin-left: 25px;
}
.nrow__title-wrap .nrow__icon
, .frow__title-wrap .frow__icon {
	position: absolute;
	right: 25px;
}
.notice__row .nrow__content
, .frequently__row .frow__content {
	padding: 20px 30px;
	display: none;
	border-bottom: 1px solid #605759;
}
/* 자주 묻는 질문  */
.frequently__row .frow__title-wrap {
	background: white;
}
/* 자주 묻는 질문 번호 */
.frow__title-wrap .frow__no {
	margin: 0 25px;
}
/* 자주 묻는 질문 내용 */
.frow__content p {
	margin: 0;
}
.frow__content .content__para {
	margin-bottom: 15px;
}
.frow__content .content__para:last-child {
	margin: 0;
}
/* 내용 꾸미기 */
.content__para .content__g-emphasize {
	font-size: 20px;
	font-weight: 700;
	color: #789F6F;
}
.content__para .content__r-emphasize {
	font-size: 20px;
	font-weight: 700;
	color: #9E1C21;
}
/* 내용 꾸미기 - 소제목 */
.content__para .content__s-g-title{
    border-left: 3px solid #789F6F;
    padding-left: 7px;
    color: #789F6F;
    font-weight: 700;
    font-size: 20px;
}
.content__para .content__r-g-title{
    border-left: 3px solid #9E1C21;
    padding-left: 7px;
    color: #9E1C21;
    font-weight: 700;
    font-size: 20px;
}
</style>

<div class="margin-top200"></div>
<div class="wrapper">
	<main class="notice__main">
		
		<!-- 공지사항과 자주묻는 질문들을 보여줌 -->
		<div class="notice__rows">
			<!-- 공지사항 -->
			<div class="notice__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="nrow__title-wrap" data-nno="${latestNotice.noticeNo }">
					<span class="nrow__title">${latestNotice.title }</span>
					<i class="fas fa-chevron-down nrow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="nrow__content" data-nno="${latestNotice.noticeNo }">${latestNotice.content }</div>
			</div>
			<!-- 자주묻는질문들 -->
			<!-- 질문 15 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="15">
					<span class="frow__no">15</span>
					<span class="frow__title">제철 먹거리와 일상 먹거리의 차이는 무엇인가요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="15">
					<p class="content__para">제철 먹거리는 말 그대로 <span class="content__g-emphasize">제철에 먹을 수 있는 농작물들에 대한 먹거리</span>들을 판매하는 곳입니다.</p>
					<p class="content__para">일상 먹거리는 말 그대로 제철이 아니어도 먹을 수 있는 농작물들에 대한 먹거리들을 판매하는 곳입니다.</p>
				</div>
			</div>
			<!-- 질문 14 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="14">
					<span class="frow__no">14</span>
					<span class="frow__title">배송조회는 어떻게 하나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="14">
					<p class="content__para">로그인 후 <span class="content__g-emphasize">[마이페이지] -> [구매 목록] -> [배송 조회]</span> 에서 가능합니다.</p>
				</div>
			</div>
			<!-- 질문 13 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="13">
					<span class="frow__no">13</span>
					<span class="frow__title">결제 방법은 어떤 것이 있나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="13">
					<p class="content__para">1. 무통장 입금</p>
					<p class="content__para">2. 카카오 페이</p>
				</div>
			</div>
			<!-- 질문 12 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="12">
					<span class="frow__no">12</span>
					<span class="frow__title">대량 주문은 어떻게 하나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="12">
					<p class="content__para">대량 주문은 해당 상품의 판매 담당자에게 문의하시면 됩니다.</p>
					<p class="content__para"><span class="content__g-emphasize">판매 상품 클릭 -> [상품 문의]</span> 또는 <span class="content__g-emphasize">판매 담당자 문의 연락처로 문의</span>하시면 됩니다.</p>
				</div>
			</div>
			<!-- 질문 11 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="11">
					<span class="frow__no">11</span>
					<span class="frow__title">상품이 잘 못 배송됐습니다.</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="11">
					<p class="content__para">잘못 배송된 상품 사진을 찍어 해당 상품 상세 페이지의 <span class="content__g-emphasize">[상품 문의]로 글을 작성</span>해주시면</p>
					<p class="content__para">해당 상품 판매 담당자가 교환, 환불, 수거 등의 방법으로 조치해 드립니다.</p><br>
					
					<p class="content__para"><span class="content__s-g-title">상품 문의 ( 평일 10시 ~ 17시 )</span></p>
					<p class="content__para">상품에 대한 상세 페이지에서 [상품 문의] 에서 문의해 주시면 됩니다.</p>
					<p class="content__para">빠른 시일 내로 문의에 대한 답변을 드리겠습니다.</p><br>

					<p class="content__para"><span class="content__s-g-title">이메일 문의 (24 시간 접수)</span></p>
					<p class="content__para">everyonesFarm@gamil.com / 운영시간에 순차적으로 답변드립니다.</p><br>

					<p class="content__para"><span class="content__s-g-title">전화 문의( 평일 10시 ~ 17시 )</span></p>
					<p class="content__para">010-0309-7005, 또는 판매 담당자의 연락처</p><br>
				</div>
			</div>
			<!-- 질문 10 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="10">
					<span class="frow__no">10</span>
					<span class="frow__title">취소, 교환, 반품 을 하고 싶은데 어떻게 해야 하나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="10">
					<p class="content__para"><span class="content__r-g-title">교환 환불 방법 규정안내</span></p><br>

					<p class="content__para">상품에 하자가 있으신가요?</p>
					<p class="content__para">아래와 같은 간단한 방법을 따라 주신다면 신속하게 처리 해드리겠습니다.</p><br>
					
					<p class="content__para">1. 상품 이상이 있는 사진을 찍습니다.</p>
					<p class="content__para">2. 상품 문의글에 사진과 함께 글을 남깁니다.</p>
					<p class="content__para">3. 접수 후 해당 상품 판매 담당자가 문제를 해결해드립니다.</p><br>

					<p class="content__para"><span class="content__s-g-title">교환 환불 안내</span></p><br>
	
					<p class="content__para">신선 식품의 경우 단순 변심에 의한 취소는 상품의 특성상 어려울 수 있습니다.</p>
					<p class="content__para">상품의 경우 발송 전까지는 취소가 가능합니다.</p><br>

					<p class="content__para"><span class="content__g-emphasize">- 상품 이상</span></p>
					<p class="content__para"> 수령 후 2일 이내, 상품 이상이 확인 가능한 사진을 보내주시면 이상 정도에 따라 조치해 드립니다.</p><br>

					<p class="content__para"><span class="content__g-emphasize">- 부분 이상의 경우</span></p>
					<p class="content__para"> 문제가 생긴 만큼 부분 환불해드립니다.</p><br>

					<p class="content__para"><span class="content__g-emphasize">- 전체 이상의 경우</span></p>
					<p class="content__para"> 100% 환불 혹은 재발송해드립니다.</p><br>
					
					<p class="content__para"><span class="content__r-g-title">교환 환불 요청 방법</span></p><br>
					<p class="content__para">상품 문의글로 수령 후 2일 이내 상품 사진과 함께 접수해주세요.</p><br>
					
					<p class="content__para"><span class="content__s-g-title">상품 문의 ( 평일 10시 ~ 17시 )</span></p>
					<p class="content__para">상품에 대한 상세 페이지에서 [상품 문의] 에서 문의해 주시면 됩니다.</p>
					<p class="content__para">해당 문의글은 관리자와 상품 판매 담당자 모두 확인할 수 있고 빠른 시일 내로 문의에 대한 답변을 드리겠습니다.</p><br>
					
					<p class="content__para"><span class="content__s-g-title">이메일 문의 (24 시간 접수)</span></p>
					<p class="content__para">everyonesFarm@gmail.com / 운영시간에 순차적으로 답변드립니다.</p><br>

					<p class="content__para"><span class="content__s-g-title">전화 문의( 평일 10시 ~ 17시 )</span></p>
					<p class="content__para">010-0309-7005, 또는 판매 담당자의 연락처</p><br>

					<p class="content__para"><span class="content__r-g-title">교환 환불이 불가능한 경우</span></p>
					<p class="content__para">- 신선식품 수령 후 단순 변심에 의한 요청인 경우</p>
					<p class="content__para">- 고객의 책임 사유로 상품 등이 손실 또는 훼손 된 경우</p><br>
				</div>
			</div>
			<!-- 질문 9 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="9">
					<span class="frow__no">9</span>
					<span class="frow__title">상품 문의는 어떻게 하나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="9">
					<p class="content__para">로그인 후 <span class="content__g-emphasize">[먹거리] - [제철 먹거리] 또는 [일반 먹거리]</span> 로 이동 후</p>
					<p class="content__para"><span class="content__g-emphasize">문의할 상품을 클릭 -> [상품 문의] 클릭 -> [문의 작성하기]</span>에서 문의 하시면 됩니다.</p>
				</div>
			</div>
			<!-- 질문 8 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="8">
					<span class="frow__no">8</span>
					<span class="frow__title">작성한 체험 신청서는 어디서 볼 수 있나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="8">
					<p class="content__para">로그인 후 <span class="content__g-emphasize">[마이페이지] - [활동 신청 현황]</span> 에서 확인하실 수 있습니다.</p>
				</div>
			</div>
			<!-- 질문 7 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="7">
					<span class="frow__no">7</span>
					<span class="frow__title">농장 체험 및 일손 돕기는 어디서 신청할 수 있나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="7">
					<p class="content__para">로그인 후 <span class="content__g-emphasize">[체험] -> [농장 체험] 또는 [일손 돕기]</span> 로 이동합니다.</p>
					<p class="content__para">마음에 드는 체험(또는 일손 돕기)를 클릭합니다.</p>
					<p class="content__para"><span class="content__g-emphasize">[신청서 작성]</span> 을 클릭하여 신청서를 작성한 후 담당자에게 승인 요청을 기다립니다.</p>
					<p class="content__para">체험 담당자에게 <span class="content__g-emphasize">신청이 승인되면</span> 해당 체험(또는 일손 돕기)를 할 수 있습니다.</p>
					<p class="content__para">좀 더 자세한 <span class="content__r-emphasize">문의는 해당 체험(또는 일손 돕기) 담당자에게 문의하시면 됩니다.</span></p><br>
					<p class="content__para"><span class="content__s-g-title">문의 방법</span></p>
					<p class="content__para">농장 체험(또는 일손 돕기) 상세 페이지에서 담당자 문의 연락처를 통해 문의하시면 됩니다.</p>
				</div>
			</div>
			<!-- 질문 6 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="6">
					<span class="frow__no">6</span>
					<span class="frow__title">영농일지는 어디서 작성할 수 있나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="6">
					<p class="content__para">로그인 후 <span class="content__g-emphasize">[마이페이지] -> [영농일지]</span> 에서 작성 가능합니다.</p>
				</div>
			</div>
			<!-- 질문 5 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="5">
					<span class="frow__no">5</span>
					<span class="frow__title">농사펀드의 농업인 회원이 되려면 (입점하기 위해서는) 어떻게 해야 하나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="5">
					<p class="content__para">사이트 오른쪽 상단에 <span class="content__g-emphasize">[회원가입] -> [농업인 회원가입]</span> 으로 가능합니다.</p>
					<p class="content__para">회원분의 개인 정보와 농장의 개인 정보를 입력하면 <span class="content__g-emphasize">'모두의 농장'의 심사 기준</span>을 거친 후 회원이 됩니다.</p>
				</div>
			</div>
			<!-- 질문 4 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="4">
					<span class="frow__no">4</span>
					<span class="frow__title">아이디와 비밀번호가 생각나지 않습니다. 찾는 방법이 어떻게 되나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="4">
					<p class="content__para">사이트 오른쪽 상단에 <span class="content__g-emphasize">[로그인] -> [아이디 찾기] 혹은 [비밀번호 찾기]</span> 로 가능합니다.</p>
				</div>
			</div>
			<!-- 질문 3 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="3">
					<span class="frow__no">3</span>
					<span class="frow__title">회원 정보를 변경하려면 어떻게 해야 하나요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="3">
					<p class="content__para">로그인 후 <span class="content__g-emphasize">[마이페이지] -> [회원정보수정]</span> 에서 가능합니다.</p>
				</div>
			</div>
			<!-- 질문 2 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="2">
					<span class="frow__no">2</span>
					<span class="frow__title">회원 탈퇴 후 재가입이 가능한가요?</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="2">
					<p class="content__para">가입시 작성한 개인 정보들은 모두 삭제됩니다. 작성하신 리뷰는 삭제되지 않습니다.</p>
					<p class="content__para">탈퇴 후 재가입을 원하신다면 가능합니다. <span class="content__r-emphasize">단, 같은 계정으로는 가입이 불가합니다.</span></p>
				</div>
			</div>
			<!-- 질문 1 -->
			<div class="frequently__row">
				<!-- 제목 과 더보기 아이콘 -->
				<div class="frow__title-wrap" data-fno="1">
					<span class="frow__no">1</span>
					<span class="frow__title">회원 탈퇴를 하고 싶어요.</span>
					<i class="fas fa-chevron-down frow__icon"></i>
				</div>
				<!-- 내용 -->
				<div class="frow__content" data-fno="1">
					<p class="content__para">로그인 후 <span class="content__g-emphasize">[마이페이지] -> [회원 탈퇴]</span> 에서 가능합니다.</p>
					<p class="content__para"><span class="content__r-emphasize">신중히 결정</span>한 후 탈퇴를 진행해주세요.</p>
				</div>
			</div>
		</div>
	</main>
</div>

<!-- title 클릭 시 보였다 안보였다 하기 -->
<script type="text/javascript">
/* div 속성중 data-nno를 가지고 있는 태그들의 click event */
/* 공지사항 부분 click event */
$("div[data-nno]").on("click", function(){

	/* 선택받은 질문의 내용이 보이는 상태일 때 */
	if($(this).next().css("display") == 'block'){
		
		/* 선택받은 질문 가리기 */
		$(this).next().css("display", "none")
		
// 		console.dir($(this).eq(0).children("i").get(0).classList.value)
		
		/* 아래로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-down nrow__icon"
		
	} else if ($(this).next().css("display") == 'none') { /* 선택받은 질문의 내용이 보이는 상태일 때 */
		
		/* 선택받은 질문 보이게 하기 */
		$(this).next().css("display", "block")
		
		/* 위로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-up nrow__icon"
	}
	
})
/* div 속성중 data-fno를 가지고 있는 태그들의 click event */
/* 자주묻는질문 부분 click event */
$("div[data-fno]").on("click", function(){

	/* 선택받은 질문의 내용이 보이는 상태일 때 */
	if($(this).next().css("display") == 'block'){
		
		/* 선택받은 질문 가리기 */
		$(this).next().css("display", "none")
		
		/* 아래로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-down frow__icon"
		
	} else if ($(this).next().css("display") == 'none') { /* 선택받은 질문의 내용이 보이는 상태일 때 */
		
		/* 선택받은 질문 보이게 하기 */
		$(this).next().css("display", "block")
		
		/* 위로 향하는 화살표 아이콘으로 바꾸기 */
		$(this).eq(0).children("i").get(0).classList.value = "fas fa-chevron-up frow__icon"
	}
	
})

</script>
<%@include file="../include/footer.jsp" %>