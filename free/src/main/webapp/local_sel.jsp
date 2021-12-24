<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Div'in Korea</title>
<link rel="stylesheet" href="resources/styles.css" type="text/css"></link>
</head>
<body>
	
	<br><br><br>
	<header style="text-align:center;"class="text-dark">다이빙 포인트 알아보기</header>
	<br>
	
	<p style="text-align:center;"> 선택지역 : ${param.sel}</p>
	<form name=form1 method=POST action=local_sel.jsp>
	<div align=center>
	<jsp:useBean id="local" class="jungeun_free.controller.Local" scope="session"/>
	
	<select name="sel">
		<%
		for(String item : local.getLocalList()) {
			out.println("<option>"+item+"</option>");
		}
		%>
	</select>	
	<input type="submit" value="선택"/>	
	</div>
	</form>
	<hr>
	<table>
	 <tr><td id="td" style="text-align:right; position: relative;"><img src="resources/point1.jpg" style="width:90%; height:90%;"></td>
        <td id="td" style="text-align:center; position: relative;">        
        <h2>강원도 고성</h2><br>
       	우리나라 최북단의 스쿠버 다이빙 지역인 강원도 고성은 산과 바다가 이어지는 곳이 많아 수중에서 아름다운 절경을 감상할 수 있는 포인트가 있다. 수중 지형이 마이산의 산세를 닮은 ‘마이산 포인트’, 수중 금강산이라 불리는 ‘낙산내기 포인트’가 대표적이다. 수도권과 가까운 거리에 위치해 있고, 낚시배와 서핑 등 함께 즐길 수 있는 해양레포츠 시설도 마련되어 있기 때문에 다이버들의 발길이 끊이지 않고 있다.
        </h4>
        </td>
        </tr>
	</table>
	
	
	<div align=center>
	<br><br>
	<h3><a href="reservation1.jsp">다이빙샵 예약하러 가기</a></h3>
	<br><br>
	<hr>
	<h2>다이빙포인트 지도로 보기</h2>
	<%@ include file="/map/0_total.html" %>
	</div>
	<hr>
	<footer class="py-4 bg-dark">
        <div class="container">
        <p class="m-0 text-center text-white">
        <a style="color:white" href="index.html">메인 페이지로 이동</a></p></div>
    </footer>

</body>
</html>