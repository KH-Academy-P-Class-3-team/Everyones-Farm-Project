<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- <script src="//code.jquery.com/jquery-2.2.4.min.js"></script> -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
    
</style>

<!-- ckeditor 사용을 위해 js 파일 연결 -->
<script type="text/javascript" src="/farmapp/resources/js/ckeditor/ckeditor.js"></script>




<form action="<%= request.getContextPath() %>/personalproduce/productwrite.do" method="post">

<%@include file="../include/farmdiaryheader.jsp" %>

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
			<td><input class="form-control" style="width: 200px;" type="text" name="name"></td>
			<th class="success">상품종류</th> 
			<td><input class="form-control" style="width: 200px;" type="text" name="kind"></td>
			<th class="success">상품가격</th> 
			<td><input class="form-control" style="width: 200px;" type="text" name="price"></td>	
		</tr>
		
		<tr>
			<th class="success">상품효능</th>
			<td><input class="form-control" style="width: 200px;" type="text" name="effect"></td>
			<th class="success">재고량</th>
			<td><input class="form-control" style="width: 200px;" type="text" name="amount"></td>		
			<th class="success">배송방법</th> 
			<td><input class="form-control" style="width: 200px;" type="text" name="delivery"></td>
		</tr>
		
		<tr>
			<th class="success">추천요리</th>
		    <td><input class="form-control" style="width: 200px;" type="text" name="food"></td>
		<th class="success">제철음식</th> 
			<td><select name="isSeasonalFood">
						<option value="0">일반 음식</option>
						<option value="1">제철 음식</option>
		     </select></td>
			<th class="success">원산지</th>
		    <td><input class="form-control" style="width: 200px;" type="text" name="productCountry"></td>
			
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
<button class="btn btn-success">등록</button>
</div>
</div>

</form>

<%@include file="../include/footer.jsp" %>