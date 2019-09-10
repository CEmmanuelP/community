<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   @font-face { font-family: 'LotteMartHappy'; font-style: normal; font-weight: 400; src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyMedium.woff') format('woff'); } @font-face { font-family: 'LotteMartHappy'; font-style: normal; font-weight: 700; src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff') format('woff'); } .lottemarthappy * { font-family: 'LotteMartHappy', sans-serif; }
</style>
<script>
	function idCheck() {
		
		var id = document.getElementById("id").value
		
		if (!id) 
		{
			alert("아이디를 입력하세요.");
			return false;
		} 
		else if(((id < "0") || (id > "9")) && ((id < "A") || (id > "Z")) && ((id < "a") || (id > "z" ))) 
		{
			alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
			return false;
		} 
		
		idcheck.submit();	
	}
</script>
</head>
<body>
	<div style="text-align:center; font-family:LotteMartHappy; font-size:30px">
      <h1>아이디중복 확인</h1>
      <hr>
      <br>
      <form action="idChk.do" name="idcheck">
         <table border="0" align=center>
            <tr>
               <th align=left>아이디</th>
            </tr>
            <tr>
               <td align=left><input type="text" name="id" id="id" placeholder="ID" style="border-radius:5px; width:90%; height:25px"></td>
            </tr>
         </table>
         <br>
         <table border="0" align=center>
            <tr>
                <td align="center" colspan=2><input type="button" value="아이디확인" style="border-radius:5px;" onclick="idCheck()"></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td align="center" colspan=1><input type="button" value="취소" onclick="location.href='login.jsp'" style="border-radius:5px;"></td>
            </tr>
         </table>
      </form>
     </div>
     
	<c:if test="${sessionScope.idchk == '있음' }">
		<% session.setAttribute("idchk", null); %>
		<script>
			setTimeout(function()
			{
				alert("이미 있음");
			},200);
		</script>
	</c:if>

</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<script>
	function idCheck() {
		
		var id = document.getElementById("id").value
		
		if (!id) 
		{
			alert("아이디를 입력하세요.");
			return false;
		} 
		else if(((id < "0") || (id > "9")) && ((id < "A") || (id > "Z")) && ((id < "a") || (id > "z" ))) 
		{
			alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
			return false;
		} 
		
		idcheck.submit();	
	}
</script>

</head>
<body>
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;">Community Site</a></h1></div>
<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
<p class="align-center">
<br><br>
<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-check-mark-1.png&r=255&g=23&b=23" width="70" height="70">
</p>
<h2 class="align-center">아이디 중복 확인</h2>
<hr width="300">

<form action="idChk.do" name="idcheck">
 <table border="0" align=center>
            <tr>
               <td>아이디<td>
            </tr>
            <tr>
               <td><input type="text" name="id" id="id" placeholder="아이디를 입력하세요" ></td>
            </tr>
         </table>
<br>
<table border="0" align=center>
            <tr>
                <td align="center" colspan=2><input type="button" value="확인" class="btn btn-primary" style="background:#5b98de" onclick="idCheck()"></td>
                <td>&nbsp;</td>
                <td align="center" colspan=1><input type="button" value="취소" onclick="location.href='login.jsp'" class="btn btn-primary" style="background:#5b98de"></td>
            </tr>
         </table>
      </form>
</div>
<c:if test="${sessionScope.idchk == '있음' }">
		<% session.setAttribute("idchk", null); %>
		<script>
			setTimeout(function()
			{
				alert("이미 존재하는 아이디입니다.");
			},200);
		</script>
	</c:if>

</body>
</html>