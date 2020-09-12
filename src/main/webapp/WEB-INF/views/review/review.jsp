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

    .info-data-hidden {
        text-overflow: ellipsis;
        overflow: hidden;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        line-height: 1.5em;
        display: -webkit-inline;
    }

    .max-line {
        max-height: 3em;
    }

    .info-data {
        resize: none;
        width: 98%;
        float: left;
        height: auto;
        word-break: break-all;
        white-space: pre-line;
    }

    .hide {
        display: none;
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

    function fnShowReview() {
        var cnt = $('#reviewsCnt').val();
        for (var i = 3; i < cnt; i++) {
            $('#review' + i + '').removeClass('hide');
        }

        $('#btnReviewShow').addClass('hide')
        $('#btnReviewHide').removeClass('hide')


    }

    function fnHideReview() {
        var cnt = $('#reviewsCnt').val();
        for (var i = 3; i < cnt; i++) {
            $('#review' + i + '').addClass('hide');
        }

        $('#btnReviewShow').removeClass('hide')
        $('#btnReviewHide').addClass('hide')

    }

    function fnMoreContent(obj, idx) {
        var id = 'content' + idx;
        $('#' + id + '').removeClass('max-line');
        $(obj).addClass('hide');

        $('#' + id + '').parents("div").children('span[name=btn-hide]').removeClass('hide')
    }

    function fnHideContent(obj, idx) {
        var id = 'content' + idx;
        // document.getElementById(id).innerHTML
        $('#' + id + '').addClass('max-line');
        $(obj).addClass('hide');

        $('#' + id + '').parents("div").children('span[name=btn-open]').removeClass('hide')
    }



</script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="max-width: 70%; margin-left: auto; margin-right: auto">
    <form class="form-horizontal" id="reviewForm" method="post" action="<c:url value='/re/add'/>" enctype="multipart/form-data">
        <input type="hidden" id="reviewsCnt" value="${reviewsCnt}"/>

        <div id="review-title" style="width: 100%">
            <span>상품을 구매하신 분들이 작성한 리뷰입니다.</span>
            <br/>
            <br/>

            <br/>
            <br/>

            <%--별점 선택--%>
            <select id="score" style="color: red; padding-left: 3px; padding-right: 3px">
                <option value="5" selected>★★★★★</option>
                <option value="4">★★★★</option>
                <option value="3">★★★</option>
                <option value="2">★★</option>
                <option value="1">★</option>
            </select>
            <textarea style="margin-top: 15px; width:100%; height:100px; resize: none" id="content"></textarea>

            <%--파일 업로드--%>
            <input type="file" class="form-control1" id="uploadFile" name="uploadFile" style="border:0px solid black;"/>
            <div style="text-align: right">
                <%--구매평 작성 버튼--%>
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

                    <li style="border-bottom: 1px solid lightgray" id="review${status.index}" <c:if test="${ status.index gt 2}"> class="hide" </c:if>>
                        <input type="checkbox" name="checkBox" value="${ review.REVIEW_NO}">
                        <div style="display: table; width: 100%; table-layout: fixed">
                            <div style="display: table-cell; padding-right: 40px; vertical-align: top">
                                <div style="color: red">
                                    <c:forEach begin="1" end="${ review.REVIEW_SCORE}">
                                        ★
                                    </c:forEach>
                                </div>
                                <div class="info-data-hidden max-line" id="content${status.index}">
                                    <span class="info-data">${review.CONTENT}</span>
                                </div>
                                <%--이미지 출력--%>
                                <c:if test="${review.FILE_NAME ne null and review.FILE_NAME ne ''}">
                                    <div style="height: 100px; width: auto">
                                        <img style="height: 100%" src="<%=request.getContextPath()%>/resources/fileUpload/${review.FILE_NAME}"/>
                                    </div>
                                </c:if>
                                <span style="color: dimgray; cursor: pointer" name="btn-open" onclick="fnMoreContent(this, ${status.index})">더보기</span>
                                <span class="hide" style="color: dimgray; cursor: pointer" name="btn-hide" onclick="fnHideContent(this, ${status.index})">감추기</span>

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

                <%--리뷰 더보기(3개 이하일 경우 나오지 않음)--%>
                <c:if test="${ reviewsCnt gt 3}">
                    <div style="padding: 9px; font-size: 15px; font-weight: bold">
                        <span style="color: red; cursor: pointer" name="btn-open" id='btnReviewShow' onclick="fnShowReview()">리뷰 더보기</span>
                        <span style="color: red; cursor: pointer" name="btn-open" id='btnReviewHide' class="hide" onclick="fnHideReview()">리뷰 감추기</span>
                    </div>
                </c:if>
            </ul>
        </div>


        <%--리뷰 삭제 버튼--%>
        <div style="padding-top: 10px">
            <input id="btnDelete" style="background: #389c38;
            border: 0px solid #ada59b !important;
            border-radius: 30px;
            font-size: 12px;
            padding: 10px 25px;
            color: white;" type="button"
                   value="삭제" onclick="checkboxArr()">
        </div>

    </form>
</div>
           


</body>
</html>
