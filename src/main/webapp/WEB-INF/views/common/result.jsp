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
<script type="text/javascript">
	function init(){
		<c:if test="${alertMsg != null}">
			alert("<c:out value='${alertMsg}'/>");
		</c:if>
		<c:if test="${url != null}">
			location.href="<c:out value='${url}'/>";
		</c:if>
		<c:if test="${confirmMsg != null}">
			confirmMsg = confirm("${confirmMsg}");
			if(confirmMsg == true){
				location.href ="<c:out value='${confirmUrl}'/>";
			} else{
				location.href ="<c:out value='${confirmBackUrl}'/>";
			}
		</c:if>
	}
	
	init();
</script>

</body>
</html>