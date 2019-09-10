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
	
	function numcheck(num)
	{
	   var reg1= /[^0-9]/g;
	   
	   if(reg1.test(num.value))
	   {
	      /* alert("핸드폰 번호는 숫자만 입력 가능합니다"); */
	      num.value = num.value.replace(reg1,"");
	      num.focus();
	      return false;
	   }
	}

	function chkfindpw() 
	{
		if(!findpw.id.value)
		{
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(((findpw.id.value < "0") || (findpw.id.value > "9")) && ((findpw.id.value < "A") || (findpw.id.value > "Z")) && ((findpw.id.value < "a") || (findpw.id.value > "z" ))) 
		{
			alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
			return false;
		} 
		
		if(!findpw.name.value)
		{
			alert("이름을 입력하세요.");
			return false;
		} 
		
		if(!findpw.jb1.value || !findpw.jb2.value)
		{
			alert("주민 번호를 입력하세요.");
			return false;
		} 
		
		var jb = findpw.jb1.value + findpw.jb2.value;
		
 		if( jb.length < 13 )
 		{
			alert("올바른주민 번호를 입력해주세요.");
			return false;
		} 
 		
 		findpw.submit();
	}

</script>
</head>
<body>

	<div style="text-align:center; font-family:LotteMartHappy; font-size:30px">
      <h1>비밀번호 찾기</h1>
      <hr>
      <br>
      <form action="pwFind.do" name="findpw">
         <table border="0" align=center>
         	
         	<tr>
               <th align=left>아이디</th>
            </tr>
            <tr>
               <td align=left><input type="text" name="id" placeholder="아이디입력" style="border-radius:5px; width:90%; height:25px"></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
         
            <tr>
               <th align=left>이름</th>
            </tr>
            <tr>
               <td align=left><input type="text" name="name" placeholder="이름입력" style="border-radius:5px; width:90%; height:25px"></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <th align=left>주민번호</th>
            </tr>
            <tr>
            	<td align=left>
            		<input type="text" name="jb1" style="border-radius:5px; width:40%; height:25px" maxlength="6" onkeyup="numcheck(this);"> -
            		<input type="password" name="jb2" style="border-radius:5px; width:40%; height:25px" maxlength="7" onkeyup="numcheck(this);">
            	</td>
            </tr>
            
         </table>
         <br>
         <table border="0" align=center>
            <tr>
                <td align="center" colspan=2><input type="button" value="비밀번호찾기" style="border-radius:5px;" onclick="chkfindpw();"></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td align="center" colspan=1><input type="button" value="취소" onclick="location.href='login.jsp'" style="border-radius:5px;"></td>
            </tr>
         </table>
      </form> 
     </div>
     
     <c:if test="${sessionScope.pw == '없음' }">
     	<% session.setAttribute("pw", null); %>
		<script>
			setTimeout(function()
			{
				alert("해당 정보가 존재하지 않습니다.");
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
<title>비밀번호 찾기</title>
<script>

function numcheck(num)
{
   var reg1= /[^0-9]/g;
   
   if(reg1.test(num.value))
   {
      /* alert("핸드폰 번호는 숫자만 입력 가능합니다"); */
      num.value = num.value.replace(reg1,"");
      num.focus();
      return false;
   }
}

function chkfindpw() 
{
	if(!findpw.id.value)
	{
		alert("아이디를 입력하세요.");
		return false;
	}
	
	if(((findpw.id.value < "0") || (findpw.id.value > "9")) && ((findpw.id.value < "A") || (findpw.id.value > "Z")) && ((findpw.id.value < "a") || (findpw.id.value > "z" ))) 
	{
		alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
		return false;
	} 
	
	if(!findpw.name.value)
	{
		alert("이름을 입력하세요.");
		return false;
	} 
	
	if(!findpw.jb1.value || !findpw.jb2.value)
	{
		alert("주민등록 번호를 입력하세요.");
		return false;
	} 
	
	var jb = findpw.jb1.value + findpw.jb2.value;
	
		if( jb.length < 13 )
		{
		alert("올바른 주민등록 번호를 입력해주세요.");
		return false;
	} 
		
		findpw.submit();
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
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;">Community Site</a></h1></div>
<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
<p class="align-center">
<br><br>
<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-magnifier-1.png&r=0&g=0&b=0" width="70" height="70">
</p>
<h2 class="align-center">비밀번호 찾기</h2>
<hr width="300">

<form action="pwFind.do" name="findpw">
<table align="center">
<tr>
<td>이름&nbsp;</td>
</tr>

<tr>
<td><input type="text" name="name" placeholder="이름을 입력하세요"></td>
</tr>

<tr>
<td><br></td>
</tr>

<tr>
<td>아이디&nbsp;</td>
</tr>
<tr>
<td><input type="text" name="id" placeholder="아이디를 입력하세요"></td>
</tr>

<tr>
<td><br></td>
</tr>

<tr>
<td>주민등록 번호&nbsp;</td>
</tr>
<tr>
<td>
<input type="text" name="jb1" maxlength="6" onkeyup="numcheck(this);"> -
<input type="password" name="jb2" maxlength="7" onkeyup="numcheck(this);">
</td>
</tr>
</table>
<br>
 <table border="0" align=center>
            <tr>
                <td align="center" colspan=2><input type="button" value="다음" class="btn btn-primary" style="background:#5b98de" onclick="chkfindpw();"></td>
                <td>&nbsp;</td>
                <td align="center" colspan=1><input type="button" value="취소" onclick="location.href='login.jsp'" class="btn btn-primary" style="background:#5b98de"></td>
            </tr>
         </table>
       
</form>
</div>

         <c:if test="${sessionScope.pw == '없음' }">
     	<% session.setAttribute("pw", null); %>
		<script>
			setTimeout(function()
			{
				alert("해당 정보가 존재하지 않습니다.");
			},200);
		</script>
	</c:if>


</body>
</html>