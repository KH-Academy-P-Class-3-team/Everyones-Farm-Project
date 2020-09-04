<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인농산물: 상품등록</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/personalproduce/productwrite.do" method="post">

<h2>상품 등록 신청</h2>
<hr>

상품 이름 <input type="text" name="name"><br>

상품 가격 <input type="text" name="price"><br>

상품판매 승인여부 <select name="productSas">
			<option value="1">승인</option>
			<option value="0">보류</option>
		 </select><br>

판매량 <input type="text" name="sales"><br>

재고량<input type="text" name="amount"><br>

상세내용<br>
<textarea rows="10" cols="30" name="explain">

</textarea><br>

상품 효능 <input type="text" name="effect"><br>

추천 요리 <input type="text" name="food"><br>

상품 종류 <input type="text" name="kind"><br>

원산지 <input type="text" name="productCountry"><br>

배송 방법 <input type="text" name="delivery"><br>

제철음식 여부 <select name="isSeasonalFood">
			<option value="0">일반 음식</option>
			<option value="1">제철 음식</option>
		 </select>

상품 품질 <select name="quality">
		<option value="1">상</option>	
		<option value="2">중</option>	
		<option value="3">하</option>	
	  </select><br>

<!-- 유통기한 <input type="date" name="expirationDate"><br> -->

<%-- <fmt:formatDate value="yyyy-MM-dd" value=""/> --%>

상품사진 <input type="file"><br>

<button class="btn btn-warning">등록</button>

</form>
</body>
</html>