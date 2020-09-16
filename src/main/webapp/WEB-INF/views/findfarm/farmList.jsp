<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../include/header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/findfarm/farmList.css" />
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	/* 이미지 파일이 없는 농장에 기본 이미지 출력 */
	$(".list-image").each(function() {
		if($(this).find("img").length == 0) {
			$(this).prepend($("<img src='<%=request.getContextPath() %>/resources/image/activity/farm_no_img.jpg' width='270' height='270'>"))
		} 
	})
	
	/* 엔터 누르면 검색 버튼 클릭 이벤트 발생 */
	$("#item").keypress(function(event) {
		if(event.which == 13) {
			$(".btnSearch").click();
			return false;
		}
	})
	
})
</script>

                                                      
<div style="margin-top:170px"></div>

<div class="search-form">
	<div class="form-top">농장 검색</div>
	<div class="form-sub">지역별 농장을 직접 검색하여 찾아보세요. <br>농장 내 체험과 다양한 상품들을 구경하실 수 있습니다.</div>

	<form action="<%=request.getContextPath() %>/findfarm/farmList" method="post" class="frm">
		<div class="city-filter">
				<select id="city1" name="city1" onchange="categoryChange(this)" class="select-city">
					<option value="">시/도</option>
					<option value='서울'>서울특별시</option>
					<option value='인천'>인천광역시</option>
					<option value='대전'>대전광역시</option>
					<option value='광주'>광주광역시</option>
					<option value='대구'>대구광역시</option>
					<option value='울산'>울산광역시</option>
					<option value='부산'>부산광역시</option>
					<option value='경기'>경기도</option>
					<option value='강원'>강원도</option>
					<option value='충북'>충청북도</option>
					<option value='충남'>충청남도</option>
					<option value='전북'>전라북도</option>
					<option value='전남'>전라남도</option>
					<option value='경북'>경상북도</option>
					<option value='경남'>경상남도</option>
					<option value='제주특별자치도'>제주도</option>
				</select>
				<select id="city2" name="city2" class="select-city">
					<option value="">시/군/구</option>
				</select>
		</div>
<br>
		<div class="search-filter">
			<select id="filter" name="filter">
				<option value="farmName">농장명</option>
				<option value="farmerName">농부 이름</option>
			</select>

			<input type="text" id="item" name="item">
			<button class="btnSearch"><img alt="검색" src="<%=request.getContextPath() %>/resources/image/findfarm/search_icon.png" width="27"></button>
		</div>
	</form>		
</div>


<div class="findfarm-content">

<div class="farm-list">

	<c:forEach items="${farmList }" var="farm">
	
<%-- 		${farm.farmNo } --%>
		<div class="row" onclick="javascript:location.href='/farmapp/farmintroduce/farmintroduceForm.do?farmerNo=${farm.farmerNo}'">
		
			<div class="list-image">
			
				<c:forEach items="${fileList }" var="file">
					<c:if test="${file.postNo eq farm.farmNo }">
						<img src="<%=request.getContextPath() %>/resources/upload/${file.fileRename }" alt="농장 이미지">	
					</c:if>
				</c:forEach>
				
			</div>
			
			<div class="caption">
				<div class="caption-title">${farm.farmName}</div>
					<div class="caption-content farmer-name">${farm.farmerName} 농부</div>
				<div class="caption-content farm-address">${farm.firstAddress } ${farm.secondAddress } (${farm.zonecode })</div>
			</div>
			
		
		</div>
		
	</c:forEach>


	<!-- section pagination -->
	<c:choose>
		<c:when test="${sc.city1 eq null && sc.city2 eq null && sc.filter eq null && sc.item eq null}">
			<div class="paging">
				<div class="paging-in">
					<a href="<%=request.getContextPath()%>/findfarm/farmList" class="nav first"></a>
				</div>
				<c:choose>
					<c:when test="${paging.currentPage eq 1 }">
						<div class="paging-in pre">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage}" class="nav prev"></a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="paging-in pre">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage-1}" class="nav prev"></a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
					<div class="paging-in">
						<c:choose>
							<c:when test="${page eq paging.currentPage }">
								<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${page}" class="num active green">${page}</a>
							</c:when>
							<c:otherwise>
								<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${page}" class="num active">${page}</a>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
		
				<c:choose>
					<c:when test="${paging.currentPage eq paging.lastPage }">
						<div class="paging-in nex">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage}" class="nav next"></a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="paging-in nex">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage+1}" class="nav next"></a>
						</div>
					</c:otherwise>
				</c:choose>
		
				<div class="paging-in">
					<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.lastPage}" class="nav last"></a>
				</div>
			</div>
		</c:when>


		<c:otherwise>
			<div class="paging">
				<div class="paging-in">
					<a href="<%=request.getContextPath()%>/findfarm/farmList?city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="nav first"></a>
				</div>
				<c:choose>
					<c:when test="${paging.currentPage eq 1 }">
						<div class="paging-in pre">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage}&city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="nav prev"></a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="paging-in pre">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage-1}&city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="nav prev"></a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
					<div class="paging-in">
						<c:choose>
							<c:when test="${page eq paging.currentPage }">
								<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${page}&city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="num active green">${page}</a>
							</c:when>
							<c:otherwise>
								<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${page}&city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="num active">${page}</a>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
		
				<c:choose>
					<c:when test="${paging.currentPage eq paging.lastPage }">
						<div class="paging-in nex">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage}&city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="nav next"></a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="paging-in nex">
							<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.currentPage+1}&city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="nav next"></a>
						</div>
					</c:otherwise>
				</c:choose>
		
				<div class="paging-in">
					<a href="<%= request.getContextPath() %>/findfarm/farmList?cPage=${paging.lastPage}&city1=${sc.city1}&city2=${sc.city2}&filter=${sc.filter}&item=${sc.item}" class="nav last"></a>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<!-- // section pagination -->


</div>




</div>


<script>

function categoryChange(e) {
	   
	var target = document.getElementById("city2");

	for(y in e) {
		if(e.value == "서울") { var d = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"] }
		else if (e.value == "인천") { var d = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"] }
		else if (e.value == "대전") { var d = ["대덕구","동구","서구","유성구","중구"] }
		else if (e.value == "광주") { var d = ["광산구","남구","동구","북구","서구"] }
		else if (e.value == "대구") { var d = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"] }
		else if (e.value == "울산") { var d = ["남구","동구","북구","중구","울주군"] }
		else if (e.value == "부산") { var d = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"] }
		else if (e.value == "경기") { var d = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"] }
		else if (e.value == "강원") { var d = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"] }
		else if (e.value == "충북") { var d = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"] }
		else if (e.value == "충남") { var d = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"] }
		else if (e.value == "전북") { var d = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"] }
		else if (e.value == "전남") { var d = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"] }
		else if (e.value == "경북") { var d = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"] }
		else if (e.value == "경남") { var d = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"] }
		else if (e.value == "제주특별자치도") { var d = ["서귀포시","제주시","남제주군","북제주군"] }
	}

	target.options.length = 1;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML += d[x];
		target.appendChild(opt);
	}	
}

</script>


<%@include file="../include/footer.jsp" %>
