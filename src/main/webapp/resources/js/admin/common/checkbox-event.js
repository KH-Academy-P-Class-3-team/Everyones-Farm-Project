/**
 * 	체크박스 전체 선택, 체크박스 개별 선택 이벤트
 */
// 체크박스 전체 선택
$(".checkbox_group").on("click", "#check_all", function () {
    $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
});

// 체크박스 개별 선택
$(".checkbox_group").on("click", ".checkbox_normal", function() {
    var is_checked = true;

    $(".checkbox_group .checkbox_normal").each(function(){
        is_checked = is_checked && $(this).is(":checked");
    });

    $("#check_all").prop("checked", is_checked);
});