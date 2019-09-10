
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인</title>
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
<h2 class="align-center">아이디 확인</h2>
<hr width="300">

<table border="0" align=center>
            <tr>
               <td>회원님의 아이디는 <b class="color-red">${sessionScope.id }</b>입니다.</td>
            </tr>
            <% session.invalidate(); %>
         </table>
         <br>
         <table border="0" align=center>
            <tr>
                <td align="center" colspan=2><input type="button" value="비밀번호 찾기" class="btn btn-primary" style="background:#5b98de" onclick="location.href='find_Pw.jsp'"></td>
                <td>&nbsp;</td>
                <td align="center" colspan=1><input type="button" value="로그인하기" class="btn btn-primary" style="background:#5b98de" onclick="location.href='login.jsp'"></td>
            </tr>
         </table>
         </div>

</body>
</html>
