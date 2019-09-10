<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script>
function btn(){
    alert('비밀번호가 변경되었습니다');
}

window.history.forward();
function noBack() {
window.history.forward();
}

</script>
<style>
.vl {
  border-right: 1px solid green;
  height: 70%;
}
.color-red{
color:red;
}
</style>
</head>
<body>
<c:if test="${requestScope.Alist == null || requestScope.Blist == null || requestScope.Clist == null}">
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;" >Community Site</a></h1></div>
<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
<p class="align-center">
<br><br>

<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-user-5.png&r=0&g=0&b=0" width="70" height="70">
</p>
<h2 class="align-center">회원 정보</h2>
<p class="align-center"><a href="mypost.do?id=${sessionScope.id}&page1=1&page2=1&page3=1">내 게시물 보기</a>	|	<a href="mainpage.jsp">메인</a></p>

<hr width="300">

<table align="center">
<tr>
<td>이름&nbsp;</td><td><input type="text" readonly name="name" value="${stv.name }"></td>
</tr>

<tr>
<td><br></td>
</tr>
<tr>

<td>아이디&nbsp;</td><td><input type="text" readonly name="id" value="${stv.id }"></td>
</tr>
<tr>
<td><br></td>
</tr>
<tr>

<td>생년월일&nbsp;</td><td><input type="text" readonly name="dob" value="${stv.dob }"></td>
</tr>
<tr>
<td><br></td>
</tr>

<tr>
<td>전화번호&nbsp;</td><td>
<input type="text" name="pn1" size=5 maxlength="3"  value="${stv.pn1 }"> -
                	<input type="text" name="pn2" size=5 maxlength="4"  value="${stv.pn2 }"> -
                	<input type="text" name="pn3" size=5 maxlength="4" value="${stv.pn3 }">
</td>
</tr>
</table>



<br>
<div class="align-center">

<a href="login.jsp">로그아웃</a>	|	<a href="terminate.jsp">회원 탈퇴</a>	|	<a href="changepw_page.jsp">비밀번호 변경</a>
</div>
</div>
</c:if>
<c:if test="${requestScope.Alist != null || requestScope.Blist != null || requestScope.Clist != null}">
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;" >Community Site</a></h1></div>
<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
<p class="align-center">
<br><br>

<img src="https://cdns.iconmonstr.com/wp-content/assets/preview/2012/240/iconmonstr-book-24.png" width="70" height="70">
</p>
<h2 class="align-center">내 게시물 보기</h2>
<p class="align-center"><a href="mypage.do?id=${sessionScope.id}">마이페이지</a>	|	<a href="mainpage.jsp">메인</a></p>

<hr width="300">


<br>
	<div id="content"><button type="button" class="btn btn-primary" style="cursor:default;width:200px;height:40px;font-size:20px;background:#5b98de;">Sports</button></div>
	<table class="table table-hover" id="content" style="font-size:17px; text-align:center">

      <tr>
     <td style="font-size:18px">제목</td>
     <td style="font-size:18px">날짜</td>
     
     </tr>

	     <c:forEach var="vo1" items="${requestScope.Alist }">
		     <tr>
			     <td><a href="titleinfo.do?title=${vo1.title }&page=${requestScope.page1 }&kindsofsearch=${requestScope.kindsofsearch }&search=${requestScope.search}&whatpost=A">${vo1.title }</a></td>
			     <td>${vo1.d}</td>
		     </tr>
	     </c:forEach>
    
     </table>
     
     <div class="align-center">
		  <ul class="pagination">
		 	<c:forEach var="i" begin="1" end="${requestScope.maxpage1 }" step="1">
		  	<li>
		  		<a href="mypost.do?page1=${i }&page2=1&page3=1&id=${sessionScope.id}">${i }</a>
		  	</li>
			</c:forEach>
		  </ul>
	  </div>
	  <br>
     <div id="content"><button type="button" class="btn btn-primary" style="cursor:default;width:200px;height:40px;font-size:20px;background:#5b98de;">Travel</button></div>
	<table class="table table-hover" id="content" style="font-size:17px; text-align:center">

      <tr>
     <td style="font-size:18px">제목</td>
     <td style="font-size:18px">날짜</td>
     </tr>

	     <c:forEach var="vo1" items="${requestScope.Blist }">
		     <tr>
			     <td><a href="titleinfo.do?title=${vo1.title }&page=${requestScope.page2 }&kindsofsearch=${requestScope.kindsofsearch }&search=${requestScope.search}&whatpost=B">${vo1.title }</a></td>
			     <td>${vo1.d}</td>
		     </tr>
	     </c:forEach>
    
     </table>
     <div class="align-center">
		  <ul class="pagination">
		 	<c:forEach var="i" begin="1" end="${requestScope.maxpage2 }" step="1">
		  	<li>
		  		<a href="mypost.do?page1=1&page2=${i }&page3=1&id=${sessionScope.id}">${i }</a>
		  	</li>
			</c:forEach>
		  </ul>
	  </div>
      <br>
     <div id="content"><button type="button" class="btn btn-primary" style="cursor:default;width:200px;height:40px;font-size:20px;background:#5b98de;">Fashion</button></div>
	<table class="table table-hover" id="content" style="font-size:17px; text-align:center">

      <tr>
     <td style="font-size:18px">제목</td>
     <td style="font-size:18px">날짜</td>
     </tr>

	     <c:forEach var="vo1" items="${requestScope.Clist }">
		     <tr>
			     <td><a href="titleinfo.do?title=${vo1.title }&page=${requestScope.page3 }&kindsofsearch=${requestScope.kindsofsearch }&search=${requestScope.search}&whatpost=C">${vo1.title }</a></td>
			     <td>${vo1.d}</td>
		     </tr>
	     </c:forEach>
    
     </table>
     <div class="align-center">
		  <ul class="pagination">
		 	<c:forEach var="i" begin="1" end="${requestScope.maxpage3 }" step="1">
		  	<li>
		  		<a href="mypost.do?page1=1&page2=1&page3=${i }&id=${sessionScope.id}">${i }</a>
		  	</li>
			</c:forEach>
		  </ul>
	  </div>
	  </div>
</c:if>
</body>
</html>