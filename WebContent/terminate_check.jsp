<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 완료</title>
<style>
.color-red{
color:red;
}
</style>
</head>
<body>
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;" >Community Site</a></h1></div>
<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
<p class="align-center">
<br><br>
<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-check-mark-1.png&r=255&g=23&b=23" width="70" height="70">
</p>
<h2 class="align-center">탈퇴가 완료되었습니다.</h2>
<hr width="300">

<table border="0" align=center>
            <tr>
               <td><h4>그동안 이용해주셔서 감사합니다.</h4></td>
            </tr>
         </table>
         <p align="center"><a href="login.jsp">로그인 화면으로 가기</a></p>

         </div>

</body>
</html>
