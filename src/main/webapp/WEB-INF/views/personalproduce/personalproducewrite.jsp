<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/farmdiaryheader.jsp" %>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- ckeditor 사용을 위해 js 파일 연결 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	$("#btnWrite").on("click", function() {

		var thename = $("#name").val()
		var thekind = $("#kind").val()
		var theprice = $("#price").val()
		var theeffect = $("#effect").val()
		var theamount = $("#amount").val()
		var thedelivery = $("#delivery").val()
		var thefood = $("#food").val()	
		var theproductCountry = $("#productCountry").val()	
		var ckeditor = CKEDITOR.instances['content']; 

		if (thename == "") {
			alert("상품이름을 작성해 주세요.");
			form4.name.focus();
		}else if (thekind == "") {
			alert("상품종류를 작성해 주세요. ex). 딸기 1kg");
			form4.kind.focus();
		}else if (theprice == "") {
			alert("상품가격을 작성해 주세요. ex). 10000");
			form4.price.focus();
		}else if (theeffect == "") {
			alert("상품효능을 작성해 주세요. ex). 없음 or 피부에 좋음");
			form4.effect.focus();
		}else if (theamount == "") {
			alert("재고량을 작성해 주세요.");
			form4.amount.focus();
		}else if (thedelivery == "") {
			alert("배송방법을 작성해 주세요.");
			form4.delivery.focus();
		}else if (thefood == "") {
			alert("추천요리를 작성해 주세요. ex). 없음 or 샐러드");
			form4.food.focus();		
		}else if (theproductCountry == "") {
			alert("원산지를 작성해 주세요. ex). 한국");
			form4.productCountry.focus();		
		}else if (ckeditor.getData() == "") {
			alert("내용을 작성해 주세요.");
			form4.ckeditor.focus();
		}else {
			$("#form4").submit();
		}

	})

})
</script>



<form id="form4" action="<%= request.getContextPath() %>/personalproduce/productwrite.do" method="post">


<div style= "clear: both; margin-top: 200px;" ></div>

<div id="container" style="width: 980px; margin: auto;" >

<h3 style="text-align: center;">상품 등록 신청</h3>
<hr>

<input type="hidden" name="farmerNo" value="${farmerInfo.farmerNo }"/>

<table class="table">
       <colgroup>
            <col width="10%">
            <col width="10%">
            <col width="10%">
            <col width="10%">   
            <col width="10%">
            <col width="10%">
            <col width="10%">   
        </colgroup>
        
   <tbody>
		<tr>
			<th class="success">상품이름</th> 
			<td><input class="form-control" style="width: 200px;" type="text" name="name" id="name"></td>
			<th class="success">상품종류</th> 
			<td><input class="form-control" style="width: 200px;" type="text" name="kind" id="kind"></td>
			<th class="success">상품가격</th> 
			<td><input class="form-control" style="width: 200px;" type="text" name="price" id="price"></td>	
		</tr>
		
		<tr>
			<th class="success">상품효능</th>
			<td><input class="form-control" style="width: 200px;" type="text" name="effect" id="effect"></td>
			<th class="success">재고량</th>
			<td><input class="form-control" style="width: 200px;" type="text" name="amount" id="amount"></td>		
			<th class="success">배송방법</th> 
			<td><input class="form-control" style="width: 200px;" type="text" name="delivery" id="delivery"></td>
		</tr>
		
		<tr>
			<th class="success">추천요리</th>
		    <td><input class="form-control" style="width: 200px;" type="text" name="food" id="food"></td>
		<th class="success">제철음식</th> 
			<td><select name="isSeasonalFood">
						<option value="0">일반 음식</option>
						<option value="1">제철 음식</option>
		     </select></td>
			<th class="success">원산지</th>
		    <td><input class="form-control" style="width: 200px;" type="text" name="productCountry" id="productCountry"></td>
			
		</tr>
		
		<tr>		    
			<th class="success">상품품질</th>
			 <td><select name="quality">
					<option value="1">상</option>	
					<option value="2">중</option>	
					<option value="3">하</option>	
			 </select></td>
		     
		<th class="success">유통기한</th> 
			<td><input type="date" name="expirationDate"></td>
			 
		</tr>
		
		<tr>
			<th></th> 
			<td></td>
		    <th></th>
      	    <td></td>
      	  	<th></th>
      	    <td></td>
		</tr>

		
   </tbody>	
</table>
<hr>

 <textarea name="explain" id="content" rows="10" cols="50">
  글 작성시 지우고 작성해주세요. (유튜브 링크 및 이미지 첨부는 툴바에 있습니다.)
 </textarea>
						<script type="text/javascript">
							CKEDITOR.replace( 'content'
											, { filebrowserUploadUrl: '/farmapp/farmdiary/fileupload'
								});
						</script><br>
<hr>
 
<div style="text-align: center;">
<button id="btnWrite" type="button" class="btn btn-success">등록</button>
</div>
</div>

</form>

<%@include file="../include/footer.jsp" %>