<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member/user.css">

<%@include file="../include/header.jsp" %>
<style type="text/css">
.main__footer {
    /* width: 980px; */
    margin: 0 auto;
    padding: 50px 0;
    display: flex;
    flex-direction: column;
    /* margin-top: 50px; */
    background: #605759;
}
</style>

<div style="clear: both; margin-top: 200px;"></div>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v8.0&appId=4878753255471737&autoLogAppEvents=1" nonce="A5Wo6Rj2"></script>

<div class="all">
<div class="farmer">
	<div class="member">일반 회원<br></div>
	<form action="<%=request.getContextPath()%>/user/loginimpl.do" method="post">
 	<input type="text" id="userId" name="userId" placeholder="  id"/><button type="submit" class="login">로그인</button><br>
	<input type="password" id="userPw" name="userPw" placeholder="  ****"/>
	<input type="button" class="login" value="회원가입" id="tojoin" /><br>
<!-- 	<div class="fb-login-button" data-size="large" data-button-type="login_with" data-layout="default" data-auto-logout-link="true" data-use-continue-as="true" data-width="" onlogin="fbLogin();"></div> -->
	<img id="facebook" alt="facebook" src="<%=request.getContextPath()%>/resources/image/member/facebook.png" class="social" />
	<img alt="kakao" src="<%=request.getContextPath()%>/resources/image/member/kakao.png" class="social" id="kakao"/>
	<input type="button" class="login" value="아이디/비밀번호 찾기" id="finduser" style="width: 200px; float: right; margin-top: 3px;"/>
<!-- 	<button type="button"class="find" style="margin-top: 5px;">아이디/비밀번호 찾기</button> -->
	</form>
</div></div>

            <div id="access_token"></div>
            <div id="user_id"></div>
            <div id="name"></div>
            <div id="email"></div>
            <div id="gender"></div>
            <div id="birthday"></div>
            <div id="id"></div>            
            

<script type="text/javascript">

$(document).ready(function(){
	
	$("#tojoin").click(function(){
		location.href="<%=request.getContextPath()%>/user/usertos.do"
	})
	
	$("#finduser").click(function(){
		location.href="<%=request.getContextPath()%>/user/findmember.do"
	})
	
	$("#kakao").click(function(){
		location.href="https://kauth.kakao.com/oauth/authorize?client_id=9e026a9e81698d2522ecd927296dfadd&redirect_uri=http://localhost:8012/farmapp/user/kakaologin.do&response_type=code"		
	})
	
})

function getUserData() {
    /* FB.api('/me', function(response) {
        document.getElementById('response').innerHTML = 'Hello ' + response.name;
        console.log(response);
    }); */
    FB.api('/me', {fields: 'name,email,id'}, function(response) {
        
        var facebookname = response.name;
        var access_token = response.access_token;
        var id = response.id;
        window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/farmapp/user/facebooklogin.do?id="+id);
 
    });
}
  
window.fbAsyncInit = function() {
    //SDK loaded, initialize it
    FB.init({
        appId      : '4878753255471737', //페이스북 개발자 홈페이지에서 앱 id를 확인해서 복사, 붙여넣기 해야한다.
        cookie     : true,  // enable cookies to allow the server to access
                // the session
        xfbml      : true,  // parse social plugins on this page
        version    : 'v8.0' // use graph api version 2.8 //페이스북 개발자 홈페이지에서 버전을 확인해서 작성해야 한다.
    });
  
    //check user session and refresh it
    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {
            //user is authorized
            //document.getElementById('loginBtn').style.display = 'none';
            getUserData();
            
        
            
        } else {
            //user is not authorized
        }
    });
};
  
//load the JavaScript SDK
(function(d, s, id){
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.com/ko_KR/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
  
//add event listener to login button, //버튼을 클릭하면 실행되는 함수
document.getElementById('facebook').addEventListener('click', function() {
    //do the login
    FB.login(function(response) {
        if (response.authResponse) {
            access_token = response.authResponse.accessToken; //get access token
            user_id = response.authResponse.userID; //get FB UID
            console.log('access_token = '+access_token);
            console.log('user_id = '+user_id);
            //user just authorized your app
            //document.getElementById('loginBtn').style.display = 'none';
            getUserData();
        }
    }, {scope: 'email,public_profile,user_birthday',
        return_scopes: true});
}, false);
 
 
</script>
<%@include file="../include/footer.jsp" %>