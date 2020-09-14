<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header include -->
<%@include file="../include/admin_header.jsp" %>
<!-- admin pagination css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/admin_pagination.css" />
<!-- product list css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/product/admin_product_list.css" />

<div class="wrapper">
	<main class="product__main">
		<div class="product__title">
			<span class="product__title-text">판매상품 관리</span>
		</div>
		
		<!-- 판매 상품 목록 -->
		<div class="product__table">
		<table class="product__p-table checkbox_group">
			<colgroup>
				<col width="10%" />
				<col width="30%" />
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
			</colgroup>
			<tr class="p-table__tr-head">
				<th class="p-table__th"><input type="checkbox" name="check-master" id="check_all" /></th>
				<th class="p-table__th">상품 이름</th>
				<th class="p-table__th">상품 종류</th>
				<th class="p-table__th">제철/일반</th>
				<th class="p-table__th">판매승인</th>
				<th class="p-table__th">판매자</th>
			</tr>
			<c:choose>
				<%-- nList null 일 때 --%>
				<c:when test="${empty productList }">
					<tr>
						<td colspan="6">등록된 공지사항이 없습니다...</td>
					</tr>
				</c:when>
				<%-- nList null 이 아닐 때 --%>
				<c:when test="${not empty productList }">
					<c:forEach items="${productList }" var="p">
					<tr class="p-table__tr-body">
						<td class="p-table__td"><input type="checkbox" value="${p.productNo }" name="checkNormal" class="checkbox_normal" /></td>
						<td class="p-table__td"><div class="p-table__name-hidden">${p.name }</div></td>
						<td class="p-table__td"><div class="p-table__kind-hidden">${p.kind }</div></td>
						<td class="p-table__td">
							<c:choose>
								<c:when test="${p.isSeasonalFood eq 0 }">
									<c:out value="일반 먹거리"></c:out>
								</c:when>
								<c:when test="${p.isSeasonalFood eq 1 }">
									<c:out value="제철 먹거리"></c:out>
								</c:when>
							</c:choose>
						</td>
						<td class="p-table__td">
							<c:choose>
								<c:when test="${p.productSas eq 1 }">
									<c:out value="승인 완료"></c:out>
								</c:when>
								<c:when test="${p.productSas eq 0 }">
									<c:out value="승인 대기"></c:out>
								</c:when>
							</c:choose>
						</td>
						<td class="p-table__td">
							<div class="p-table__id-hidden">
							<c:out value="${p.farmerId }"></c:out>
							</div>
						</td>
					</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
		</div>
		
		<!-- 판매 승인, 보류 버튼 -->
		<div class="product__btns-wrap">
			<span class="btn approveBtn" id="product-approve">판매 승인</span><span class="btn holdBtn" id="product-hold">판매 보류</span>
		</div>
		
		<!-- 검색창 -->
		<div class="product-list__search-wrap">
			<input type="text" name="search" id="member-search" placeholder="검색어를 입력하세요" /><button id="search-btn">검색</button>
		</div>
	
		<!-- paging include -->
		<%@include file="./product_pagination.jsp" %>		
		
	</main>
</div>

<!-- button click event -->
<script type="text/javascript">
//입점 보류 버튼 클릭 이벤트
$("#product-hold").on("click", function(){
	
	const checkCnt = $("input[name='checkNormal']:checked").length
	const chkArr = new Array();
	$("input[name='checkNormal']:checked").each(function() {
		/* 체크박스가 체크된 행의 value 값 */
		chkArr.push($(this).val())
	})
	
	/* 체크된 체크박스가 없을 때! */
	if( checkCnt == 0 ){
		alert("선택된 회원이 없습니다.")
	} else { /* 체크된 체크박스가 있을 때! */
		
		/* AJAX 통신 */
		$.ajax({
			type: "POST" /* method type */
			, url: "/farmapp/admin/product/hold" /* ajax url */
			, data: "productNo=" + chkArr + "&checkCnt=" + checkCnt /* ajax 통신 데이터 */
			, dataType: "json" /* 통신하는 데이터 type */
// 			, contentType:"application/json;charset=UTF-8"
			, success: function( res ){ /* ajax 통신 성공시 */
				/* res 값이 1이 아닐 때 */
				if(res != 1){
				
					alert("입점 보류가 오류로 인해 진행되지 않았습니다.")
					
				} else { /* res 값이 1일 때 */
					
					alert("입점 보류가 정상적으로 진행됐습니다.")
					// redirect 진행
// 					$(location).attr("href", "/farmapp/adminmember/fapplicationlist")
					//reoload
					location.reload()
				}
			}
			, error: function(){
				alert("서버통신 오류입니다.")
			}
		})
	}
})
// 입점 수락 버튼 클릭 이벤트
$("#product-approve").on("click", function(){
	
	const checkCnt = $("input[name='checkNormal']:checked").length
	const chkArr = new Array();
	$("input[name='checkNormal']:checked").each(function() {
		/* 체크박스가 체크된 행의 value 값 */
		chkArr.push($(this).val())
	})
	
	/* 체크된 체크박스가 없을 때! */
	if( checkCnt == 0 ){
		alert("선택된 회원이 없습니다.")
	} else { /* 체크된 체크박스가 있을 때! */
		
		/* AJAX 통신 */
		$.ajax({
			type: "POST" /* method type */
			, url: "/farmapp/admin/product/approve" /* ajax url */
			, data: "productNo=" + chkArr + "&checkCnt=" + checkCnt /* ajax 통신 데이터 */
			, dataType: "json" /* 통신하는 데이터 type */
// 			, contentType:"application/json;charset=UTF-8"
			, success: function( res ){ /* ajax 통신 성공시 */
				/* res 값이 1이 아닐 때 */
				if(res != 1){
				
					alert("입점 수락이 오류로 인해 진행되지 않았습니다.")
					
				} else { /* res 값이 1일 때 */
					
					alert("입점 수락이 정상적으로 진행됐습니다.")
					// redirect 진행
// 					$(location).attr("href", "/farmapp/adminmember/fapplicationlist")
					// reload 진행
					location.reload()
				}
			}
			, error: function(){
				alert("서버통신 오류입니다.")
			}
		})
	}
})
</script>
<!-- 검색 이벤트 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/product/admin_product_search.js"></script>
<!-- checkbox 에 대한 javascript -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/common/checkbox-event.js"></script>
<!-- footer include -->
<%@include file="../include/admin_footer.jsp" %>