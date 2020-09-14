<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/farmapp/farmdiary/farmdiarydetail.do" method="post">

     <div class="tit_notice">
          <h4 class="reset">${detail.farmDiaryNo}</h4>
      </div>
      <div class="info" >
      	  <span name="farmdiaryNo" value="${detail.farmDiaryNo}">게시글번호 : ${detail.farmDiaryNo}</span>
          <span>등록일 : ${detail.enrollDate}</span>
          <span>작성자 : ${detail.farmerNo}</span>
      </div>

</form>
</body>
</html>