<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script>

 function saveId() {
    
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var key = getCookie("key");
    $("#userId").val(key); 
     
    if($("#userId").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("key");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#userId").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
        }
    });
}
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}


</script>

 <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/custom.css">
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
<meta name="viewport" content="width=device-width, 
initial-scale-1" charset="UTF-8">
<style>
body{font-family: Arial, Helvetica, sans=serif;}
form{border: 0px solid #f1f1f1;}

input[type=text], input[type=password]{
width:100%;
padding:12px 20px;
margin: 8px 0;
display: inline-block;
border: 1px solid #ccc;
box-sizing:border-box;
}   

button{
background-color: #5b98de;
color: white;
padding: 14px 20px;
margin:8px 0;
border: none;
cursor:pointer;
width: 100%;


}
button:hover{
opacity:0.9
}

.cancelbutton{
width: 100%;
padding:11px 19px;
background-color:#f44336;

}

.imgcontainer{
text-align: center;
margin: 24px 0 12px 0;

}

/* img.user{
width:25%;

}
 */
.container{
padding: 16px;
}
.registerbutton{
width:100%;
padding:11px 19px;
background-color:#1aa149;

}

.cancelbutton{
width:100T;

}

.photo2 {
    width: 150px; 
    height: 150px;
    object-fit: cover;
    object-position: top;
    border-radius: 30%;
}
  .shadow{
            width:170px;
            height:170px;
            margin:3px auto;
           
        }
         
        .shadow img:hover{
            cursor:pointer;
            -webkit-transform:scale(1.2); /*  크롬 */
            -moz-transform:scale(1.2); /* FireFox */
            -o-transform:scale(1.2); /* Opera */
            transform:scale(1.2);
            transition: transform .35s;
            -o-transition: transform .35s;
            -moz-transition: transform .35s;
            -webkit-transition: transform .35s;
        }

</style>
<title>Login</title>
</head>
<body onload="saveId();">

<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header"><h1>Community Site</a></h1></div>
<div id="menubar"></div>
<form action="login.do">
<div id="content">
<div class="container">
<div class="imgcontainer">
<br>
<img src="img/human.png" alt="User" class="user" width="150px" height="150px">
</div>


<label for="id"><b>ID</b></label>
<input type="text" placeholder="아이디를 입력하세요" id="userId" name="ID" required>

<label for="pw"><b>비밀번호</b></label>
<input type="password" placeholder="비밀번호를 입력하세요" name="pw" required>

<button type="submit">로그인</button>
<!-- <button type="button" class="registerbutton" onclick="location.href='memberChk.jsp'">회원가입</button>
<button type="button" onclick="location.href='find_Id.jsp'">아이디찾기</button>
<button type="button" onclick="location.href='find_Pw.jsp'">비밀번호 찾기</button>
<button type="button" class="cancelbutton">닫기</button> -->
<div style="background-color:f1f1f1">
<label>
<input type="checkbox" checked="checked" id="idSaveCheck" name="remember">
ID 기억하기
</label> 
<br><br><br><br>
</div>
</div>
<p align="center"><a href="memberChk.jsp">회원 가입</a>	|	<a href="find_Id.jsp">아이디 찾기</a>	|	<a href="find_Pw.jsp">비밀번호 찾기</a></p>
</div>
</form>
	<c:if test="${sessionScope.loginchk == '틀림' }">
		<% session.setAttribute("loginchk", null); %>
		<script>
			setTimeout(function()
			{
				alert("ID,PW를 확인해주세요.");
			},200);
		</script>
	</c:if>

</body>
</html>