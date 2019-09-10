<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
.file_input label {
    position:relative;
    cursor:pointer;
    display:inline-block;
    vertical-align:middle;
    overflow:hidden;
    width:100px;
    height:30px;
    background:white;
    color:#5b98de;
    text-align:left;
    line-height:30px;
}
.file_input label input {
    position:absolute;
    width:0;
    height:0;
    overflow:hidden;
}
.file_input input[type=text] {
    vertical-align:middle;
    display:inline-block;
    width:400px;
    height:28px;
    line-height:28px;
    font-size:11px;
    padding:0;
    border:0;
    border:0px solid #777;
}

</style>
<script>
   function modify()
   {   
      var test = document.getElementById("title").value;
      var test2 = document.getElementById("text").value;
      var sw = 0;
      var sw2 = 0;
      
      
      if(test == "")
         {
         sw = 0;
         alert("제목을 입력해주세요");
         return;
         }
      else
         sw = 1;
      
      if(test2 == "")
      {
         sw2 = 0;
         alert("내용을 입력해주세요");
         return;
      }
      else
         sw2 = 1;
      
      
      if(sw==1 && sw2==1)
         updatecheck.submit();
   }
   
   function can()
   {
      cancel.submit();
   }
   
</script>
</head>
<body>
<jsp:include page="layout/top.jsp"></jsp:include>
   <c:choose>
      <c:when test="${param.gesipan == 'A'}">
         <div id="header"><h1>Sports 게시판</h1></div>
         <c:set var="gesi_param" value="A"></c:set>
      </c:when>
      
      <c:when test="${param.gesipan == 'B'}">
        <div id="header"><h1>Travel 게시판</h1></div>
         <c:set var="gesi_param" value="B"></c:set>
      </c:when>
      
      <c:when test="${param.gesipan == 'C'}">
         <div id="header"><h1>Fashion 게시판</h1></div>
         <c:set var="gesi_param" value="C"></c:set>
      </c:when>
   </c:choose>

<div id="menubar"></div>
<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
   <form name="updatecheck" action="updatepost.do" method="post" enctype="multipart/form-data">
   <%--    제목 <input type="text" name="title" id="title" value="${param.title }" style="border-radius:5px; width:45%; height:25px">
      <br><br>
      <textarea name="text" id="text" style="border-radius:5px; width:50%; height:300px;">${param.text }</textarea>
      <br><br>
      <input type="hidden" name="board_id" value="${param.board_id1 }"> --%>
      <br>
      <input type="text" class="textborder1" name="title"  id="title" style="width:45%; height:25px" value="${param.title }"><br><br>
      <div class="file_input">
    <label>
       &nbsp;&nbsp;File Upload
        <input type="file" name="file" onchange="javascript:document.getElementById('file_route').value=this.value">
    </label>
    <input type="text" readonly="readonly" title="File Route" id="file_route">
</div>
      <hr class="my-hr2">
      <textarea class="textborder2"  name="text" id="text" style="width:100%; height:500px;">${param.text }</textarea>
      <input type="hidden" name="board_id" value="${param.board_id1 }">
      <input type="hidden" name="whatpost" value="${param.gesipan }">
      
   </form>
<table border="0" align="center">

   <tr>
      <td>

      <div class="align-center"></div>
        <input type="button" name="modi" class="btn btn-primary" style="background:#5b98de" value="수정" onclick="modify();">
      </td>
      <td>
   <c:choose>
      <c:when test="${param.gesipan == 'A'}">
         <form name="cancel" action="getAllInfo2.do">
            <input type="button" name="cancelbutton"class="btn btn-primary" style="background:#5b98de"  value="취소" onclick="can();">
            <input type="hidden" name="page" value="1">
            <input type="hidden" name="whatpost" value="A">
         </form>
      </c:when>
      
      <c:when test="${param.gesipan == 'B'}">
         <form name="cancel" action="getAllInfo2.do">
            <input type="button" name="cancelbutton" class="btn btn-primary" style="background:#5b98de" value="취소" onclick="can();">
                        <input type="hidden" name="page" value="1">
            <input type="hidden" name="whatpost" value="B">
         </form>
      </c:when>
      
      <c:when test="${param.gesipan == 'C'}">
         <form name="cancel" action="getAllInfo2.do">
            <input type="button" name="cancelbutton" class="btn btn-primary" style="background:#5b98de" value="취소" onclick="can();">
                        <input type="hidden" name="page" value="1">
            <input type="hidden" name="whatpost" value="C">
         </form>
      </c:when>
   </c:choose>
      </td>
   </tr>
   </table>
</div>

<jsp:include page="layout/bottom.jsp"></jsp:include>

</body>
</html>