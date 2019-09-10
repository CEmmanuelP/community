<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

.photo2 {
    width: 150px; 
    height: 150px;
    object-fit: cover;
    object-position: top;
    border-radius: 30%;
}
  .shadow{
            width:170px;
            height:170px;
            margin:3px auto;
           
        }
         
        .shadow img:hover{
            cursor:pointer;
            -webkit-transform:scale(1.2); /*  크롬 */
            -moz-transform:scale(1.2); /* FireFox */
            -o-transform:scale(1.2); /* Opera */
            transform:scale(1.2);
            transition: transform .35s;
            -o-transition: transform .35s;
            -moz-transition: transform .35s;
            -webkit-transition: transform .35s;
        }
                /* #topMenu {            
                        height: 30px; 
                        width: 850px; 
                } */
                /* #topMenu ul li {                       
                        list-style: none;           
                        color: white;               
                       /*  background-color: #2d2d2d; */  
                        float: left;              
                       /*  line-height: 30px;   */       
                        vertical-align: middle;     
                        text-align: center;         
                }
                #topMenu .menuLink {                             
                                             
                        color: white;                              
                        display: block;                            
                         width: 150px;                              
                        font-size: 20px;                         
                        /* font-weight: bold;                        
                        font-family: "Trebuchet MS", Dotum, Arial;  */
                }
                #topMenu .menuLink:hover {           
                        color:#225187;                 
                         background-color: #61a0e8;   
                }
                #topMenu .bar{
                font-size:20px;
                color:white;
                }
 */
</style>
<title>메인 페이지</title>
</head>
<body>
<%! int count;%>
<%
    count = (Integer) application.getAttribute("conutValue");
%>
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header" class="a_style"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;">Community Site</a></h1></div>
<div id="menubar">
<nav>
                <ul>
                 	 <li><a class="menuLink2" >TOTAL <%=count%></a></li>
                      <li><a class="menuLink2" >&nbsp;</a></li>
                        
                        <li><a class="menuLink2">&nbsp;</a></li>
                       
                        <li><a class="menuLink2" >&nbsp;</a></li>
                      
                        <li><a class="menuLink2" >&nbsp;</a></li> 
                       
                        <li><a class="menuLink" href="mypage.do?id=${sessionScope.id}"><img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-user-19.png&r=31&g=71&b=153" width="20px" height="20px">&nbsp;My page</a></li>
                       <li><a class="menuLink2" >${sessionScope.id }님 환영합니다</a></li>
                        
                        
                </ul>
        </nav> 
</div>


<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content">
<br><br>
<table border="0" align="center">

<tr>
<td><div class="shadow"><a href="getAllInfo2.do?page=1&whatpost=A"><img class="photo2" src="img/sport.jpg" ></a></div><br>
</td>
<td><h4>Sports&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4></td>
<td><div class="shadow"><a href="#"><img class="photo2" src="img/game.jpg"></a></div>
</td>
<td><h4>Game</h4>
</td>
</tr>

<tr>
<td><div class="shadow"><a href="getAllInfo2.do?page=1&whatpost=B"><img class="photo2" src="img/travel.jpg" ></a></div><br>
</td>
<td><h4>Travel</h4></td>
<td><div class="shadow"><a href="#"><img class="photo2" src="img/study.jpg"></a></div>
</td>
<td><h4>Study</h4>
</td>
</tr>

<tr>
<td><div class="shadow"><a href="getAllInfo2.do?page=1&whatpost=C"><img class="photo2" src="img/fashion.jpg"></a></div><br>
</td>
<td><h4>Fashion</h4>
</td>
<td><div class="shadow"><a href="#"><img class="photo2" src="img/food.jpg" ></a></div><br>
</td>
<td><h4>Food</h4></td>
</tr>


</table>

<!-- <br><br><br>
<div class="shadow"><a href="sport.jsp"><img class="photo2" src="https://pixabay.com/get/55e4d2424955ad14f1dc8460825668204022dfe05556744b702979d2/football-3471371_640.jpg" ></a></div><br>
<div class="shadow"><a href="travel.jsp"><img class="photo2" src="https://pixabay.com/get/55e7d5414c55aa14f1dc8460825668204022dfe05556744b70297cdd/aircraft-3702676_640.jpg" ></a></div><br>
<div class="shadow"><a href="food.jsp"><img class="photo2" src="https://pixabay.com/get/54e2dc424352a414f1dc8460825668204022dfe05556744b702a73d1/pancakes-2291908_640.jpg" ></a></div> -->
</div>






<jsp:include page="layout/bottom.jsp"></jsp:include>
</body>
</html>