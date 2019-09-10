<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script>
function btn(){
   if(chpw.pw.value != chpw.pwc.value)
   {
      alert("비밀번호가 일치하지 않습니다");
      return false;
   }
   else
   {
      alert('비밀번호가 변경되었습니다');
      chpw.submit();
   }
}
</script>
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
<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-user-5.png&r=0&g=0&b=0" width="70" height="70">
</p>
<h2 class="align-center">비밀번호 변경</h2>
<hr width="300">

<form action="change_passward.do?id=${sessionScope.id }pw=?${sessionScope.pw}" name="chpw">
<table align="center">

<tr>
<td>비밀번호 변경&nbsp;</td><td><input type="password" name="pw"></td>
</tr>

<tr>
<td colspan="2" class="color-red">*변경할 비밀번호를 입력해주세요</td>
</tr>
<tr>
<td><br></td>
</tr>

<tr>
<td>비밀번호 확인&nbsp;</td><td><input type="password" name="pwc"></td>
</tr>
</table>



<br>
<div class="align-center">
<input type="button" value="수정" class="btn btn-primary" style="background:#5b98de" onclick="javascript:btn()">&nbsp;<input type="reset" class="btn btn-primary" style="background:#5b98de" value="취소" onclick="location.href='mypage.do?id=${sessionScope.id}'">
<input type="hidden" name="id" value="${sessionScope.id }">
<br><br>
<a href="mypage.do?id=${sessionScope.id}">뒤로 가기</a>
</div>
</form>
</div>
</body>
</html>