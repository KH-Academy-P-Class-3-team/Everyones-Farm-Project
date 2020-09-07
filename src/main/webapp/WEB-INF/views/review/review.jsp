<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="../common/header.jsp" %>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


<style>

    li {
        list-style: none;
        padding-bottom: 1px;
        padding-top: 1px;
    }
</style>
<script>

    $(function () {
        $("#insertReview").on('click', function (e) {
            alert('test')
            var userInput = prompt("리뷰를 입력해주세요" + "");
            alert(userInput + "님 환영합니다.");
        });

        $("#btnWrite").on('click', function (e) {

                var formData = new FormData();
                var files = $('#uploadFile')[0].files;

                formData.append('content', $('#content').val());
                formData.append('reviewScore', $('#score').val());

                for (var i = 0; i < files.length; i++) {
                    formData.append('uploadFiles', files[i]);
                }
                $.ajax({
                    url: '<%=request.getContextPath()%>/review/write',
                    data: formData,
                    type: 'post',
                    dataType: 'text',
                    processData: false,
                    contentType: false,
                    success: function (result) {
                        window.location.reload();
                    },
                    error: function (e) {
                        alert('작성에 실패하였습니다.')
                        console.log(e)
                    }
                })
            }
        );

        $("#btnDelete").on('click', function (e) {
            var checkArr = new Array();
            $("input[name='checkBox']:checked").each(function (i) {
                checkArr.push($(this).val());
            })

            if (checkArr.length < 1) {
                alert('삭제할 항목을 선택해 주십시오');
                return;
            }

            if (!confirm("정말 삭제 하시겠습니까?")) {
                return;
            }

            $.ajax({
                url: '<%=request.getContextPath()%>/review/delete',
                type: 'post'
                , dataType: 'text'
                , data: {
                    checkArr: checkArr
                },
                success: function (result) {
                    window.location.reload();
                },
                error: function (e) {
                    alert('삭제에 실패하였습니다.')
                    console.log(e)
                }
            });
        });


    });


</script>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form class="form-horizontal" id="reviewForm" method="post" action="<c:url value='/re/add'/>" enctype="multipart/form-data">

    <div id="review-title" style="width: 100%">
        <span>상품을 구매하신 분들이 작성한 리뷰입니다.</span>
        <br/>
        <br/>

        <%--        <input style="background: #389c38;--%>
        <%--        border: 0px solid #ada59b !important;--%>
        <%--        border-radius: 30px;--%>
        <%--        font-size: 12px;--%>
        <%--        padding: 10px 25px;--%>
        <%--        color: white;"--%>
        <%--               type="button" value="구매평 작성" id="insertReview">--%>
        <br/>
        <br/>

        <select id="score" style="color: red; padding-left: 3px; padding-right: 3px">
            <option value="5" selected>★★★★★</option>
            <option value="2">★★</option>
            <option value="4">★★★★</option>
            <option value="3">★★★</option>
            <option value="1">★</option>
        </select>
        <textarea style="margin-top: 15px; width:100%; height:100px; resize: none" id="content"></textarea>

        <input type="file" class="form-control1" id="uploadFile" name="uploadFile" style="border:0px solid black;"/>
        <div style="text-align: right">

            <input id="btnWrite" style="background: #389c38;
            border: 0px solid #ada59b !important;
            border-radius: 30px;
            font-size: 12px;
            padding: 10px 25px;
            color: white;" type="button" value="구매평 작성">
        </div>
    </div>


    <div style="border-top: 2px solid black; margin-top: 15px">
        <ul>

            <c:forEach var="review" items="${reviews}" varStatus="status">

                <li style="border-bottom: 1px solid lightgray">
                    <input type="checkbox" name="checkBox" value="${ review.REVIEW_NO}">
                    <div style="display: table; width: 100%; table-layout: fixed">
                        <div style="display: table-cell; padding-right: 40px; vertical-align: top">
                            <div style="color: red">
                                <c:forEach begin="1" end="${ review.REVIEW_SCORE}">
                                    ★
                                </c:forEach>
                            </div>
                                <%--                    <br />--%>
                            <div>
                                <span>${ review.CONTENT}</span>
                            </div>
                            <div style="height: 100px; width: auto">
                                <c:if test="${review.FILE_NAME ne null and review.FILE_NAME ne ''}">
                                    <img style="height: 100%" src="<%=request.getContextPath()%>/resources/fileUpload/${review.FILE_NAME}"/>
                                </c:if>
                            </div>

                        </div>
                        <div style="display: table-cell; color: dimgray; width: 200px; vertical-align: top">
                            <c:choose>
                                <c:when test="${ review.FARMER_NO ne null and review.FARMER_NO ne ''}">
                                    <span>${ review.FARMER_NAME}</span>
                                </c:when>
                                <c:otherwise>
                                    <span>${ review.USER_NAME}</span>
                                </c:otherwise>
                            </c:choose>
                            <br/>
                            <span>${ review.REG_DATE}</span>
                        </div>
                    </div>
                </li>

            </c:forEach>
        </ul>
    </div>

    <input id="btnDelete" style="background: #389c38;
            border: 0px solid #ada59b !important;
            border-radius: 30px;
            font-size: 12px;
            padding: 10px 25px;
            color: white;" type="button"
           value="삭제" onclick="checkboxArr()">

</form>

</body>
</html>
