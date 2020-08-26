<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp" %>

<style type="text/css">
.margin-top200 {
	margin-top: 200px;
}

/* table css */
.notice__main .notice__table {
	width: 900px;
    margin: 0 auto;
	border-collapse: collapse;
	border-top: 1px solid #605759;
	border-bottom: 1px solid #605759;
}

/* tr background */
.notice__table .notice__bg-lightgreen {
	background: #D1E9CA;
}

.notice__table .notice__table-td {
	padding: 10px 5px;
}

</style>

<div class="margin-top200"></div>
<div class="wrapper">
	<main class="notice__main">
		<table class="notice__table">
			<tr class="notice__bg-lightgreen">
				<td class="notice__table-td">${latestNotice.title }</td>
				<td class="notice__table-td"><i class="fas fa-chevron-down"></i></td>
			</tr>
		</table>
	</main>
</div>

<%@include file="../include/footer.jsp" %>