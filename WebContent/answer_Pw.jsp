<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   @font-face { font-family: 'LotteMartHappy'; font-style: normal; font-weight: 400; src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyMedium.woff') format('woff'); } @font-face { font-family: 'LotteMartHappy'; font-style: normal; font-weight: 700; src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff') format('woff'); } .lottemarthappy * { font-family: 'LotteMartHappy', sans-serif; }
</style>
</head>
<body>

	<div style="text-align:center; font-family:LotteMartHappy; font-size:30px">
      <h1>비밀번호찾기</h1>
      <hr>
      <br>
         <table border="0" align=center>
            <tr>
               <th align=left>회원님의 비밀번호는</th>
            </tr>
            <tr>
               <td align=left><input type="text" name="id" value=${sessionScope.pw } style="border-radius:5px; width:90%; height:25px" readonly></td>
            </tr>
            <tr>
               <th align=left>입니다.</th>
            </tr>
            <% session.invalidate(); %>
         </table>
         <br>
         <table border="0" align=center>
            <tr>
                <td align="center" colspan=1><input type="button" value="로그인하기" onclick="location.href='login.jsp'" style="border-radius:5px;"></td>
            </tr>
         </table>
     </div>

</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<style>
.color-red{
color:red;
}
</style>
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
<h2 class="align-center">비밀번호 확인</h2>
<hr width="300">

<table border="0" align=center>
            <tr>
               <td>회원님의 아이디는 <b class="color-red">${sessionScope.pw }</b>입니다.</td>
            </tr>
            <% session.invalidate(); %>
         </table>
         <br>
         <table border="0" align=center>
            <tr>
                <td align="center" colspan=1><input class="btn btn-primary" type="button" value="로그인하기" class="btn btn-primary" style="background:#5b98de" onclick="location.href='login.jsp'"></td>
            </tr>
         </table>
         </div>

</body>
</html>