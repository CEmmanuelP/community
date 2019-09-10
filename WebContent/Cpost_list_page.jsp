<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/custom.css">
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
<meta charset="UTF-8">
<title>Fashion 게시판 목록</title>
<style>
#hd {
 margin: auto;
 width: 70%;
}
#content {
margin: auto;
width: 70%;
height: 600px;
margin-bottom: 20px;
} 
.align-center{text-align:center;}
</style>
<script>
	function postmove()
	{
		writepost.submit();
	}
	
</script>
</head>
<body>
<form name="allinfo" action="getAllInfo3.do"></form>

<div id="hd"><h1>C 게시판</h1></div>	
	<div align="right" id="hd">
		<form name="writepost" action="writepost.jsp" method="get">
			<input type="button" name="newpost" value="새 게시글 작성" onclick="postmove();">
			<input type="hidden" name="gesipan" value="C">
		</form>
		<br>
		<form name="searchpost" action="어딘가">
			<select name="kindsofsearch">
				<option value="게시물 제목">게시물 제목
				<option value="작성자 이름">작성자 이름
			</select>
			<input type="text" name="search">
			<input type="submit" value="검색">
		</form>
	<hr> 
<table class="table table-hover" id="content">
     <thead>
      <tr>
     <th>번호</th>
     <th>제목</th>
     <th>작성자</th>
     <th>날짜</th>
     </tr>
     </thead>
     <tbody>
	     <c:forEach var="vo1" items="${requestScope.alist1 }">
		     <tr>
			     <td>${vo1.board_id }</td>
			     <td><a href="">${vo1.title }</a>${vo1.title }</td>
			     <td>${vo1.id }</td>
			     <td>${vo1.d }</td>
		     </tr>
	     </c:forEach>
     </tbody>
     </table>
     <div class="align-center">
  <ul class="pagination">
  <li><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  </ul>
  </div>
</body>
</html> --%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fashion 게시판 목록</title>
<style>
.my-hr2 {
    border: 0;
    height: 2px;
    background: #ccc;
  }
  
.textborder1{
border:0;
font-size:25px;
font-weight:700;
}

input:focus{outline:none;}

.textborder2{
border:0;
resize:none;
}
textarea:focus{outline:none;}


</style>
<script>
	function postmove()
	{
		writepost.submit();
	}
	
 	window.onkeydown = function() 
	{
		var kcode = event.keyCode;
		if(kcode == 116) 
		{
			event.returnValue = false;
			location.href="getAllInfo2.do?page=1";
		}
	} 
 	
 	function upp()
 	{
 		uppost.submit();
 	}
</script>
</head>
<body>
<jsp:include page="/layout/top.jsp"></jsp:include>
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;">Fashion 게시판</a></h1></div>
<div id="menubar">
<nav>
                <ul>
                 
                     <li><a class="menuLink" href="Apost_list_page.jsp">Sports</a></li>
                      <li><a class="menuLink" href="Bpost_list_page.jsp">Travel</a></li>
                        
                        <li><a class="menuLink" href="Cpost_list_page.jsp">Fashion</a></li>
                       
                        <li><a class="menuLink" href="#">Game</a></li>
                       
                        <li><a class="menuLink" href="#">Study</a></li>
                      
                        <li><a class="menuLink" href="#">Food</a></li> 
                        <li><a class="menuLink"  href="mypage.do?id=${sessionScope.id}"><img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-user-19.png&r=31&g=71&b=153" width="20px" height="20px">&nbsp;My page</a></li>
                      
                        
                        
                </ul>
        </nav> 
</div>
<jsp:include page="/layout/content.jsp"></jsp:include>

<c:if test="${requestScope.title != null }">
	<div id="content">
	<br>
	<form action="updatepost.jsp" name="uppost">
		<input type="text" class="textborder1" name="title" readonly style=" width:45%; height:25px" value=" ${sbv.title }">
		<br><br>
		&nbsp;&nbsp;작성자:${sbv.id }&nbsp;|&nbsp;${sbv.d }
		&nbsp;&nbsp;<a name="modifypost" onclick="upp();" style="cursor: pointer;">수정</a>&nbsp;|<a name="deletepost" style="cursor: pointer;" onclick="location.href='deletepost.do?board_id=${sbv.board_id }'">삭제</a>
		<hr class="my-hr2">
		<c:if test="${sbv.filename!=null }">
		<br>
		<img src="Save/${sbv.filename }" width="70%" height="70%"><br>
		</c:if>
		
		<textarea class="textborder2" readonly name="text" style="width:100%; height:100px;">${sbv.text }</textarea>
		<br>
		
		<input type="hidden" name="gesipan" value="C">
		<input type="hidden" name="board_id1" value="${sbv.board_id }">
	</form>
		<c:set var="id3" value="${sessionScope.id }"/>
		<c:if test="${sbv.id == id3 }">
		
	<%-- 	<input type="button" name="modifypost" value="수정" onclick="upp();">
		<input type="button" name="deletepost" value="삭제" onclick="location.href='deletepost.do?board_id=${sbv.board_id }'"> --%>
		</c:if>
	
	
</div>
</c:if>
<table class="table table-hover" id="content" style="font-size:17px;">

     <thead>
     <c:if test="${requestScope.title!=null}">
	<tr>
	<td colspan="4"><a href="getAllInfo2.do?page=1"><input class="btn btn-primary" style="background:#5b98de" value="전체 글" ></a></td>
	</tr>
	</c:if>
	
      <tr>
     <th>번호</th>
     <th>제목</th>
     <th>작성자</th>
     <th>날짜</th>
     </tr>
     </thead>
     <tbody>
	     <c:forEach var="vo1" items="${requestScope.alist1 }">
		     <tr>
			     <td>${vo1.board_id }</td>
			     <td><a href="titleinfo.do?title=${vo1.title }&page=${requestScope.page }&kindsofsearch=${requestScope.kindsofsearch }&search=${requestScope.search}">${vo1.title }</a></td>
			     <td>${vo1.id }</td>
			     <td>${vo1.d}</td>
		     </tr>
	     </c:forEach>
     </tbody>
     </table>
<table border="0" align="center">
	<tr>	
		<td>
		<form name="search" action="search.do">
			<table>
				<tr>
					<td>
						<select name="kindsofsearch">
							<c:if test ="${requestScope.kindsofsearch == '게시물 제목' }">
				      		   <option value="게시물 제목" selected>게시물 제목</option>
				      		   <option value="작성자 이름">작성자 이름</option>
			      		   	</c:if>
							<c:if test ="${requestScope.kindsofsearch == '작성자 이름' }">
				      		   <option value="게시물 제목">게시물 제목</option>
				      		   <option value="작성자 이름" selected>작성자 이름</option>
			      		   	</c:if>
			      		   	<c:if test ="${requestScope.kindsofsearch == null }">
				      		   <option value="게시물 제목">게시물 제목</option>
				      		   <option value="작성자 이름">작성자 이름</option>
			      		   	</c:if>
						</select>&nbsp;
     				</td>
     				<td>
     					<input type="text" name="search" value="${requestScope.search }">
     					<input type="hidden" name="page" value="1">
     				</td>
     				<td><input type="submit" style="background:#5b98de;color:white;border:0px;outline:0px;height:26px;" value="검색"></td>
     			</tr>
     		</table>
     	</form>
     	</td>
     	
    	 <td><form name="writepost" action="writepost.jsp" method="get">&nbsp;
     	   <input type="button" name="newpost" style="background:#5b98de;color:white;border:0px;outline:0px;height:26px;" value="새 게시글 작성" onclick="postmove();">
     	   <input type="hidden" name="gesipan" value="C">
    	 </form></td>
     </tr>
</table>
     <br>
<div class="align-center">
  <ul class="pagination">
 	<c:forEach var="i" begin="1" end="${requestScope.maxpage }" step="1">
  	<li>
  		<c:if test ="${requestScope.kindsofsearch == null }">
  			<a href="getAllInfo2.do?page=${i }">${i }</a>
  		</c:if>
  		<c:if test ="${requestScope.kindsofsearch != null }">
  			<a href="search.do?page=${i }&search=${requestScope.search }&kindsofsearch=${requestScope.kindsofsearch}">${i }</a>
  		</c:if>
  	</li>
	</c:forEach>
  </ul>
  </div>
<jsp:include page="/layout/bottom.jsp"></jsp:include>
</body>
</html>