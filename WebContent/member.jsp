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
<script type="text/javascript">

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
   
	function checkValue() {
		 
		if(!userInfo.pw.value){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if(userInfo.pw.value != userInfo.pwc.value){
			alert("재확인 비밀번호와 일치하지 않습니다.");
			return false;
		}
		
		if(!userInfo.dob.value){
			alert("생년월일을 입력하세요.");
			return false;
		}
		
		if(!userInfo.pn1.value || !userInfo.pn2.value || !userInfo.pn3.value){
			alert("핸드폰 번호를 입력하세요.");
			return false;
		}
		
		
		var pn = userInfo.pn1.value + userInfo.pn2.value + userInfo.pn3.value;
		
 		if( pn.length < 11 ){
			alert("올바른 핸드폰 번호를 입력해주세요.");
			return false;
		} 
		
		
		userInfo.submit();
	}

   
</script>
</head>
<body>
   <div style="text-align:center; font-family:LotteMartHappy; font-size:30px">
      <h1>회원가입</h1>
      <hr>
      <br>
      <form action="Insert.do" name="userInfo">
         <table border="0" align=center>
            <tr>
               <th align=left>이름</th>
            </tr>
            <tr>
               <td align=left><input type="text" name="name" value="${ sessionScope.name }" style="border-radius:5px; width:90%; height:25px" readonly></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <th align=left>주민번호</th>
            </tr>
            <tr>
            	<td align=left>
            		<input type="text" name="jb1" value="${ sessionScope.jb1 }" style="border-radius:5px; width:40%; height:25px" maxlength="6" readonly> -
            		<input type="password" name="jb2" value="${ sessionScope.jb2 }" style="border-radius:5px; width:40%; height:25px" maxlength="7" readonly>
            	</td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <th align=left >아이디</th>
            </tr>
            <tr>
               	<td align=left><input type="text" name="id" value="${ sessionScope.id }" style="border-radius:5px; width:90%; height:25px" onkeydown="inputIdChk()" readonly>
            </tr>
            <% session.invalidate(); %>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <th align=left >비밀번호</th>
            </tr>
            <tr>
               <td align=left><input type="password" name="pw" placeholder=" 비밀번호" style="border-radius:5px; width:90%; height:25px"></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <th align=left >비밀번호 재확인</th>
            </tr>
            <tr>
               <td align=left><input type="password" name="pwc" placeholder=" 비밀번호 재확인" style="border-radius:5px; width:90%; height:25px"></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <th align=left >생년월일</th>
            </tr>
            <tr>
                <td align=left><input type="date" name="dob" width="50px" min="1950-01-01" max="2001-12-31" style="border-radius:5px; width:90%; height:25px"></td>
             </tr>
   
             <tr>
               <td><br></td>
            </tr>
   
             <tr>
                <th align=left>핸드폰 번호</th>
             </tr>
             <tr>
                <td align=left>
                	<input type="text" name="pn1" size=3 maxlength="3" style="border-radius:5px; width:25%; height:25px" onkeyup="numcheck(this);"> -
                	<input type="text" name="pn2" size=4 maxlength="4" style="border-radius:5px; width:25%; height:25px" onkeyup="numcheck(this);"> -
                	<input type="text" name="pn3" size=4 maxlength="4" style="border-radius:5px; width:25%; height:25px" onkeyup="numcheck(this);">
                </td>
             </tr>
             
         </table>
         <br>
         <table border="0" align=center>
            <tr>
                <td align="center" colspan=2><input type="button" value="회원가입" style="border-radius:5px;" onclick="checkValue();"></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td align="center" colspan=1><input type="button" value="취소" onclick="location.href='login.jsp'" style="border-radius:5px;"></td>
            </tr>
         </table>
      </form>
   </div>
   
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript">

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
   
	function checkValue() {
		 
		if(!userInfo.pw.value){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if(userInfo.pw.value != userInfo.pwc.value){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		if(!userInfo.dob.value){
			alert("생년월일을 입력하세요.");
			return false;
		}
		
		if(!userInfo.pn1.value || !userInfo.pn2.value || !userInfo.pn3.value){
			alert("핸드폰 번호를 입력하세요.");
			return false;
		}
		
		
		var pn = userInfo.pn1.value + userInfo.pn2.value + userInfo.pn3.value;
		
 		if( pn.length < 11 ){
			alert("올바른 핸드폰 번호를 입력해주세요.");
			return false;
		} 
		
		
		userInfo.submit();
	}

   
</script>
<style>
#content-2 {
margin: auto;
width: 70%;
height: 700px;
margin-bottom: 20px;
} 
</style>
</head>
<body>
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;">Community Site</a></h1></div>
<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content-2">
<p class="align-center">
<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-check-mark-12.png&r=255&g=0&b=0" width="70" height="70">
</p>
<h2 class="align-center">회원 가입</h2>
<hr width="300">
 <form action="Insert.do" name="userInfo">
         <table border="0" align=center>
            <tr>
               <td>이름</td>
            </tr>
            <tr>
               <td><input type="text" name="name" value="${ sessionScope.name }"  readonly></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <td>주민등록 번호</td>
            </tr>
            <tr>
            	<td>
            		<input type="text" name="jb1" value="${ sessionScope.jb1 }"  maxlength="6" size="10" readonly> -
            		<input type="password" name="jb2" value="${ sessionScope.jb2 }"  maxlength="7" size="10" readonly>
            	</td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <td>아이디</td>
            </tr>
            <tr>
               	<td><input type="text" name="id" value="${ sessionScope.id }" onkeydown="inputIdChk()" readonly>
            </tr>
            <% session.invalidate(); %>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <td>비밀번호</td>
            </tr>
            <tr>
               <td><input type="password" name="pw" placeholder="비밀번호" ></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <td>비밀번호 재확인</td>
            </tr>
            <tr>
               <td><input type="password" name="pwc" placeholder="비밀번호 재확인"  ></td>
            </tr>
            
            <tr>
               <td><br></td>
            </tr>
            
            <tr>
               <td>생년월일</td>
            </tr>
            <tr>
                <td><input type="date" name="dob" width="50px" min="1950-01-01" max="2001-12-31" ></td>
             </tr>
   
             <tr>
               <td><br></td>
            </tr>
   
             <tr>
                <td>전화번호</td>
             </tr>
             <tr>
                <td>
                	<input type="text" name="pn1" size=5 maxlength="3"  onkeyup="numcheck(this);"> -
                	<input type="text" name="pn2" size=5 maxlength="4"  onkeyup="numcheck(this);"> -
                	<input type="text" name="pn3" size=5 maxlength="4" onkeyup="numcheck(this);">
                </td>
             </tr>
             
         </table>
         <br>
         <table border="0" align=center>
            <tr>
                <td align="center" colspan=2><input type="button" value="회원가입" class="btn btn-primary" style="background:#5b98de" onclick="checkValue();"></td>
                <td>&nbsp;</td>
                <td align="center" colspan=1><input type="button" value="취소" onclick="location.href='login.jsp'" class="btn btn-primary" style="background:#5b98de"></td>
            </tr>
         </table>
      </form>
</div>
 

</body>
</html>