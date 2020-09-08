<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/resources/calendar/js/cal.css" rel="stylesheet"
   type="text/css" media="all" />
<script type="text/javascript"
   src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 캘린더 JS -->
<script type="text/javascript">

   var calendars = {};
   
   $(document).ready(function() {
      
        var thisMonth = moment().format('YYYY-MM');
        var $modal = document.querySelector("#calModal");//일정상세보기모달
        var $modal2 = document.querySelector("#caladdModal");//일정추가모달
        var $modal3 = document.querySelector("#calModifyModal");//일정수정모달
        
        var sharePnum = document.getElementById("selectedCal");
       
        
        
        $(".calmodify").click(function() {
           console.log("일정 편집버튼")
            /* $modal2.classList.toggle("show-modal");  */
       });
        
         $(".caladd").click(function() {
            console.log("일정추가버튼")
            $modal.classList.toggle("show-modal");
            
       }); 
         $(".close-button3").click(function() {
            console.log("일정 추가 엑스버튼")
             $modal2.classList.toggle("show-modal"); 
           });
         $(".close-button4").click(function() {
             console.log("일정 상세 엑스버튼")
              $modal.classList.toggle("show-modal"); 
            });
         
         //일정 수정 모달 
         $(".calModify").click(function() {
            console.log("일정수정버튼")
            $modal3.classList.toggle("show-modal");
            $modal.classList.toggle("show-modal"); 
       }); 
         //수정 엑스버튼
          $(".close").click(function() {
             console.log("일정 수정 엑스버튼")
              $modal.classList.toggle("show-modal");
            
            });

        var eventArray = [
          { startDate: thisMonth + '-10', endDate: thisMonth + '-14', title: 'Multi-Day Event' },
          { startDate: thisMonth + '-21', endDate: thisMonth + '-23', title: 'Another Multi-Day Event' }
        ];
      
        calendars.clndr1 = $('.cal1').clndr({
             events: eventArray,
             
             clickEvents: {
               click: function(target) {                
               /*  sharePnum.value = target.date._i; */
                selectDay(target);
                $modal.classList.toggle("show-modal");    
               }
             },
             multiDayEvents: {
               startDate: 'startDate',
               endDate: 'endDate'
             },
             showAdjacentMonths: true,
             adjacentDaysChangeMonth: false
           });
   
   function selectDay(target){
       
       console.log("여기는들어오나");
       console.log(target.date._i);
       $.ajax({
          type : "POST"
          , url : "/cafe/schedule/selectDay" 
          , data : {selectedDay : target.date._i }
          , dataType: "json"
          ,traditional : true
          ,contentType : "application/x-www-form-urlencoded; charset=UTF-8"
          , success : function(schedule){
                               
             //location.reload(); 새로고침이야 이건
          }
          , error: function() {
             console.log('AJAX fail')
          }
          
       })
    }
   
   });
</script>


<!----Calender -------->
<script src="<%=request.getContextPath() %>/resources/calendar/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/calendar/js/jquery.openCarousel.js"></script>
<script src="<%=request.getContextPath() %>/resources/calendar/js/moment-2.2.1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/calendar/js/clndr.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/calendar/js/site.js" type="text/javascript"></script>

<!----End Calender -------->

</head>
<body>

<div class="content">
	<div class="cal1"></div>
</div>
<button class="caladd">일정추가</button>
<div id="calModal" class="dmodal">
<div class="calModal-content">
   <span class="close">&times;</span>
   <div class="calModaltitle">날짜 입력 받음</div>
   <div class="calModalinput">
      <input type="text" id="selectedCal" />
      <button class="btn-type2">복사</button>
   </div>
</div>
</div>

</body>
</html>
