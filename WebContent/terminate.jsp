<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>

</head>
<body>
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;" >Community Site</a></h1></div>
<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
<p class="align-center">
<br><br>
<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-x-mark-7.png&r=255&g=13&b=13" width="70" height="70">
</p>
<h2 class="align-center">회원 탈퇴</h2>
<hr width="300">
<form action="terminate.do">
<table align="center">
<tr>
<td>비밀번호&nbsp;</td><td><input type="password" name="pw"></td>
</tr>
</table>
<br>
<div class="align-center">
<input type="submit" class="btn btn-primary" style="background:#5b98de" value="탈퇴">&nbsp;<input type="button" class="btn btn-primary" style="background:#5b98de" value="취소" onclick="location.href='mypage.do?id=${sessionScope.id}'" style="border-radius:5px;">
<br><br>
<a href="mypage.do?id=${sessionScope.id}">뒤로 가기</a>
</div>
<input type="hidden" name="id" value="${sessionScope.id }">
</form>
</div>


   <c:if test="${sessionScope.terminatechk == '틀림' }">
      <% session.setAttribute("terminatechk", null); %>
      <script>
         setTimeout(function()
         {
            alert("비밀번호를 올바르게 입력해주세요");
         },200);
      </script>
   </c:if>

</body>
</html>