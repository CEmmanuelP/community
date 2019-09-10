<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회사 위치</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no ">

<!-- 내용화면크기(contents 영역), apple에서 시작,
1.0 : 뷰포트의 초기 화면 배율은 1 (0~10 사용)
(device-width, divice-height)
 no: 크기 조절 안 함 -->

<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<!-- <script src = "aa.js"></script> -->

<script>

window.onload = function() {
   var company = new google.maps.LatLng(37.570972, 126.992465);  // 해당 위,경도를 가져와서 
   var mapDesign1 = { zoom: 19, center:company, mapTypeId: google.maps.MapTypeId.ROADMAP};  // 지도의 중앙으로 위치시킴
                                       // mapTypeId: google.maps.MapTypeId.HYBRID -> 건물 중심, ROADMAP은 길 중심
   var map = new google.maps.Map(document.getElementById("jido1"), mapDesign1); // jido1 크기대로, mapDesign1에 따라 지도 띄우기
   var marker = new google.maps.Marker({position: company, map: map});
}

</script>

</head>
<body>
<jsp:include page="layout/top.jsp"></jsp:include>
<div id="header" class="a_style"><h1><a href="mainpage.jsp" style="color:black;text-decoration:none;">Community Site</a></h1></div>
<div id="menubar">
<nav>
                <ul>
                 
                     <li><a class="menuLink" href="getAllInfo2.do?page=1&whatpost=A">Sports</a></li>
                      <li><a class="menuLink" href="getAllInfo2.do?page=1&whatpost=B">Travel</a></li>
                        
                        <li><a class="menuLink" href="getAllInfo2.do?page=1&whatpost=C">Fashion</a></li>
                       
                        <li><a class="menuLink" href="#">Game</a></li>
                       
                        <li><a class="menuLink" href="#">Study</a></li>
                      
                        <li><a class="menuLink" href="#">Food</a></li> 
                        <li><a class="menuLink" href="mypage.do?id=${sessionScope.id}"><img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2012/png/iconmonstr-user-19.png&r=31&g=71&b=153" width="20px" height="20px">&nbsp;My page</a></li>
                      
                        
                        
                </ul>
        </nav> 
</div>


<jsp:include page="layout/content.jsp"></jsp:include>
<div id="content" class="align-center"><br><br>
<p class="align-center">
<img src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2013/png/iconmonstr-map-8.png&r=0&g=0&b=0" width="70px" height="70px"></p>
<h2 class="align-center">회사 위치</h2>
<hr width="300">
<div id="jido1" style="width: 700px; height: 500px;padding:100px; margin:auto;"></div>

<br>

오시는 길  <br>
- 지하철 : 3,5호선 종로3가역 9번출구 옆 금성 골드 빌딩 5층. <br>
- 버  스 : 7737, 212, 750A번 종로3가역 하차. <br>

</div>

</body>
</html>