<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../../include/header.jsp"%>


<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
		
	
	$("#btnDelete").click(function(){
		
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
		var map = $checkboxes.map(function(){
			return $(this).val();
		})
		
		var names= map.get().join(",");
		
		console.log($checkboxes);
		console.log("map : "+ map);
		console.log("map -> array : "+map.get());
		console.log("array tostring : " + map.get().join(","));
		
		var $form = $("<form>")
						.attr("action", "<%=request.getContextPath()%>/basket/delete")
						.attr("method", "post")
						.append(
								$("<input>")
									.attr("type", "hidden")
									.attr("name", "names")
									.attr("value", names)
						)
		$(document.body).append($form);
		$form.submit();
		
		})
	$("#btnChecking").click(function(){
		
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
		var map = $checkboxes.map(function(){
			return $(this).val();
		})
		
		var names= map.get().join(",");
		
		console.log($checkboxes);
		console.log("map : "+ map);
		console.log("map -> array : "+map.get());
		console.log("array tostring : " + map.get().join(","));
		
		var $form = $("<form>")
						.attr("action", "<%=request.getContextPath()%>/basket/add")
						.attr("method", "post")
						.append(
								$("<input>")
									.attr("type", "hidden")
									.attr("name", "names")
									.attr("value", names)
						)
		$(document.body).append($form);
		$form.submit();
		
		})
	$("#btnSubPur").click(function(){
		
		var $checkboxes = $("input:checkbox[name='checkPur']:checked");
		
		var map = $checkboxes.map(function(){
			return $(this).val();
		})
		
		var names= map.get().join(",");
		
		console.log($checkboxes);
		console.log("map : "+ map);
		console.log("map -> array : "+map.get());
		console.log("array tostring : " + map.get().join(","));
		
		var $form = $("<form>")
						.attr("action", "<%=request.getContextPath()%>/basket/subPurchase")
						.attr("method", "post")
						.append(
								$("<input>")
									.attr("type", "hidden")
									.attr("name", "names")
									.attr("value", names)
						)
		$(document.body).append($form);
		$form.submit();
		
		})
	$("#btnFarmerChecking").click(function(){
		
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
		var map = $checkboxes.map(function(){
			return $(this).val();
		})
		
		var names= map.get().join(",");
		
		console.log($checkboxes);
		console.log("map : "+ map);
		console.log("map -> array : "+map.get());
		console.log("array tostring : " + map.get().join(","));
		
		var $form = $("<form>")
						.attr("action", "<%=request.getContextPath()%>/basket/farmer/add")
						.attr("method", "post")
						.append(
								$("<input>")
									.attr("type", "hidden")
									.attr("name", "names")
									.attr("value", names)
						)
		$(document.body).append($form);
		$form.submit();
		
		})
	$("#btnFarmerSubPur").click(function(){
		
		var $checkboxes = $("input:checkbox[name='checkPur']:checked");
		
		var map = $checkboxes.map(function(){
			return $(this).val();
		})
		
		var names= map.get().join(",");
		
		console.log($checkboxes);
		console.log("map : "+ map);
		console.log("map -> array : "+map.get());
		console.log("array tostring : " + map.get().join(","));
		
		var $form = $("<form>")
						.attr("action", "<%=request.getContextPath()%>/basket/farmer/subPurchase")
						.attr("method", "post")
						.append(
								$("<input>")
									.attr("type", "hidden")
									.attr("name", "names")
									.attr("value", names)
						)
		$(document.body).append($form);
		$form.submit();
		
		})
	
	
	$("#btnFarmerDelete").click(function(){
		
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
		var map = $checkboxes.map(function(){
			return $(this).val();
		})
		
		var names= map.get().join(",");
		
		console.log($checkboxes);
		console.log("map : "+ map);
		console.log("map -> array : "+map.get());
		console.log("array tostring : " + map.get().join(","));
		
		var $form = $("<form>")
						.attr("action", "<%=request.getContextPath()%>/basket/farmer/delete")
						.attr("method", "post")
						.append(
								$("<input>")
									.attr("type", "hidden")
									.attr("name", "names")
									.attr("value", names)
						)
		$(document.body).append($form);
		$form.submit();
		
	})

	

	
	
	
	$("#buying").click(function(){
var $checkboxes = $("input:checkbox[name='checkPur']:checked");
		
		var map = $checkboxes.map(function(){
			return $(this).val();
		})
var names= map.get().join(",");
 $(function(){
    var IMP = window.IMP; // 생략가능
    
    IMP.init('imp69303763'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    
    var msg;
    
    IMP.request_pay({
        pg : 'kakaopay',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '모두의 농장 농산물 구매',
        amount : '${purchase.cost}' ,
        buyer_email : '${userInfo.email}',
        buyer_name : '${userInfo.userName}',
        buyer_tel : '${userInfo.phone}',
    }, function(rsp) {
        if ( rsp.success ) {
            //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
            jQuery.ajax({
                url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                type: 'POST',
                dataType: 'json',
                data: {
                    imp_uid : rsp.imp_uid
                    //기타 필요한 데이터가 있으면 추가 전달
                }
            }).done(function(data) {
                //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                if ( everythings_fine ) {
                    msg = '결제가 완료되었습니다.';
                    msg += '\n고유ID : ' + rsp.imp_uid;
                    msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                    msg += '\결제 금액 : ' + rsp.paid_amount;
                    msg += '카드 승인번호 : ' + rsp.apply_num;
                    
                    alert(msg);
                } else {
                    //[3] 아직 제대로 결제가 되지 않았습니다.
                    //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                }
            });
            //성공시 이동할 페이지
            location.href='/farmapp/mypage/user/paymentCompleted?names='+names;
        } else {
            msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            //실패시 이동할 페이지
            location.href="basket";
								alert(msg);
							}
						});
 })
	});
});
function checkAll() {
	var $checkboxes = $("input:checkbox[name='checkRow']")
	var check_status = $("#checkAll").is(":checked")
	if (check_status) {
		$checkboxes.each(function() {
			this.checked = true;
		})
	} else {
		$checkboxes.each(function() {
			this.checked = false;
		})
	}
}
function checkAllPur() {
	var $checkboxes = $("input:checkbox[name='checkPur']")
	var check_status = $("#checkAllPur").is(":checked")
	if (check_status) {
		$checkboxes.each(function() {
			this.checked = true;
		})
	} else {
		$checkboxes.each(function() {
			this.checked = false;
		})
	}
}
</script>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/mypage/basket.css" />

<!-- 네비바를 fiexd-top으로 설정했을 때 컨텐츠와 겹치는 문제 방지 -->
<div style="margin-top: 200px"></div>

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h3 class="my-4 text-left">장바구니</h3>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/modify">회원</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/modify">회원정보
						수정</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/mypageO3List">1대
						1 문의</a>
				</div>
				<c:if test="${farmerInfo eq null }">
					<div class="panel-body">
						<a href="<%=request.getContextPath()%>/mypage/user/myActive">활동
							신청 현황</a>
					</div>
				</c:if>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/deleteId"
						style="color: #ccc;">회원 탈퇴</a>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<a href="<%=request.getContextPath()%>/mypage/user/basket">주문</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/basket"
						style="font-weight: bold;">장바구니</a>
				</div>
				<div class="panel-body">
					<a href="<%=request.getContextPath()%>/mypage/user/orderList">구매
						목록</a>
				</div>
			</div>

			<c:if test="${farmerInfo ne null }">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/mypage/user/basket">농업인
						</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/activitylist">내 정보</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/selllist">판매 목록</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/dailyLoglist">영농 일지</a>
					</div>
					<div class="panel-body">
						<a href="/farmapp/mypage/activitylist">체험 신청내역</a>
					</div>

				</div>
			</c:if>
		</div>

		<c:if test="${userInfo ne null }">
			<div id="practice"></div>
			<div class="col-lg-1">
				<!-- 리스트 시작-->

				<!-- Table -->
				<hr>
				<div class="boxName">장바구니</div>
				<table class="table table-hover table-bordered">
					<tr class="active">
						<th><input type="checkbox" id="checkAll"
							onclick="checkAll();"></th>
						<th>상품정보</th>
						<th>옵션</th>
						<th>금액</th>
						<th>전문 배송</th>
					</tr>
					<c:forEach items="${basket.baskets}" var="basket">
						<tr id="realBasket">
							<td><input type="checkbox" name="checkRow" id="checkone"
								value="${basket.BASKET_NO }"></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.NAME }
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.OPTION_NAME }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.PRICE }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.DELIVERY }</a></td>
						</tr>
					</c:forEach>
				</table>

				<div class="paging">
					<!-- section pagination -->
					<nav>
						<ul class="pagination">
							<c:choose>
								<c:when test="${page.blockStart > 1 }">
									<li><a
										<%-- 									href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart-1}" --%>
									aria-label="Previous"
										class="naviBtn"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart}"
										aria-label="Previous" class="naviBtn"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="${page.blockStart}" end="${page.blockEnd}"
								var="page">
								<li><a
									href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page}"
									class="naviBtn">${page}</a></li>
							</c:forEach>

							<c:choose>
								<c:when test="${page.blockEnd >= page.lastPage }">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockEnd}"
										aria-label="Next" class="naviBtn"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockEnd+1}"
										aria-label="Next" class="naviBtn"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
					</nav>
					<div style="height: 50px;">
						<span><button id="btnChecking"
								class="btn pull-right btn-primary">추가하기</button></span> <span><button
								id="btnDelete" class="btn pull-right">삭제하기</button></span>
					</div>
				</div>
				<hr>
				<div class="boxName">결제 대기 목록</div>
				<div>
					<table class="table table-hover table-bordered">
						<tr class="active">
							<th><input type="checkbox" id="checkAllPur"
								onclick="checkAllPur();"></th>
							<th>상품정보</th>
							<th>옵션</th>
							<th>금액</th>
							<th>전문 배송</th>
						</tr>
						<c:forEach items="${purchase.baskets}" var="purchase">
							<tr id="realBasket">
								<td><input type="checkbox" name="checkPur" id="checkone"
									value="${purchase.BASKET_NO }"></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.NAME }
								</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.OPTION_NAME }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.PRICE }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.DELIVERY }</a></td>
							</tr>
						</c:forEach>
					</table>
					<div style="height: 50px;">
						<span><button id="btnSubPur" class="btn pull-right">취소하기</button></span>
					</div>
					<div class="costArea" style="margin-top: 50px;">
						<h3>
							<span>총 결제 금액 : </span> <span id="cost">${purchase.cost} </span>
							<button class="btn btn-primary btn-lg pull-right" id="buying">결제하기</button>
						</h3>
					</div>
					<div></div>
				</div>
			</div>
		</c:if>
		<c:if test="${farmerInfo ne null }">
			<div id="practice"></div>
			<div class="col-lg-1">
				<!-- 리스트 시작-->

				<!-- Table -->
				<hr>
				<div class="boxName">농부 장바구니</div>
				<table class="table table-hover table-bordered">
					<tr class="active">
						<th><input type="checkbox" id="checkAll"
							onclick="checkAll();"></th>
						<th>상품정보</th>
						<th>옵션</th>
						<th>금액</th>
						<th>전문 배송</th>
					</tr>
					<c:forEach items="${basket.baskets}" var="basket">
						<tr id="realBasket">
							<td><input type="checkbox" name="checkRow" id="checkone"
								value="${basket.BASKET_NO }"></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.NAME }
							</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.OPTION_NAME }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.PRICE }</a></td>
							<td><a
								href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${basket.PRODUCT_NO }">${basket.DELIVERY }</a></td>
						</tr>
					</c:forEach>
				</table>

				<div class="paging">
					<!-- section pagination -->
					<nav>
						<ul class="pagination">
							<c:choose>
								<c:when test="${page.blockStart > 1 }">
									<li><a
										<%-- 									href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart-1}" --%>
									aria-label="Previous"
										class="naviBtn"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockStart}"
										aria-label="Previous" class="naviBtn"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>
							<c:forEach begin="${page.blockStart}" end="${page.blockEnd}"
								var="page">
								<li><a
									href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page}"
									class="naviBtn">${page}</a></li>
							</c:forEach>

							<c:choose>
								<c:when test="${page.blockEnd >= page.lastPage }">
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockEnd}"
										aria-label="Next" class="naviBtn"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="<%= request.getContextPath() %>/mypage/user/basket?cPage=${page.blockEnd+1}"
										aria-label="Next" class="naviBtn"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>

						</ul>
					</nav>
					<div style="height: 50px;">
						<span><button id="btnFarmerChecking"
								class="btn pull-right btn-primary">추가하기</button></span> <span><button
								id="btnFarmerDelete" class="btn pull-right">삭제하기</button></span>
					</div>
				</div>
				<hr>
				<div class="boxName">결제 대기 목록</div>
				<div>
					<table class="table table-hover table-bordered">
						<tr class="active">
							<th><input type="checkbox" id="checkAllPur"
								onclick="checkAllPur();"></th>
							<th>상품정보</th>
							<th>옵션</th>
							<th>금액</th>
							<th>전문 배송</th>
						</tr>
						<c:forEach items="${purchase.baskets}" var="purchase">
							<tr id="realBasket">
								<td><input type="checkbox" name="checkPur" id="checkone"
									value="${purchase.BASKET_NO }"></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.NAME }
								</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.OPTION_NAME }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.PRICE }</a></td>
								<td><a
									href="<%= request.getContextPath() %>/mypage/user/OrderDetail?PRODUCT_NO=${purchase.PRODUCT_NO }">${purchase.DELIVERY }</a></td>
							</tr>
						</c:forEach>
					</table>
					<div style="height: 50px;">
						<span><button id="btnFarmerSubPur" class="btn pull-right">취소하기</button></span>
					</div>
					<div class="costArea" style="margin-top: 50px;">
						<h3>
							<span>총 결제 금액 : </span> <span id="cost">${purchase.cost} </span>
							<button class="btn btn-primary btn-lg pull-right" id="buying">결제하기</button>
						</h3>
					</div>
					<div></div>
				</div>
			</div>
		</c:if>
	</div>
</div>






<%@include file="../../include/footer.jsp"%>

