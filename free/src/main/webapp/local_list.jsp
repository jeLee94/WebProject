<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jungeun_free.controller.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Div'in Korea</title>
<link rel="stylesheet" href="resources/styles.css" type="text/css"></link>
</head>
<body>
	<br><br><br>
	<header style="text-align:center;"class="text-dark">지역목록</header>
	<br>
	<hr>
	<br><br>

	<div align=center>
	<form name=form1 method=POST action=local_sel.jsp>
	<jsp:useBean id="local" class="jungeun_free.controller.Local" scope="session"/>
	
	<select class="dropdown-item-text dropdown-menu-dark" name="sel">
		<%
		for(String item : local.getLocalList()) {
			out.println("<option>"+item+"</option>");
		}
		%>
	</select>
	<br>
	<input type="submit" value="선택"/>	
	<div align=center>
	<br><br>

	
	</div>	
	</form>
	</div>
	<section class="py-5">
        <div class="container my-5">
            <div class="row justify-content-center">
			</div>
		</div>
	</section>
	<br>
	<footer class="py-4 bg-dark">
        <div class="container">
        <p class="m-0 text-center text-white">
        <a style="color:white" href="index.html">메인 페이지로 이동</a></p></div>
    </footer>
</body>
</html>