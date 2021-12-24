<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jungeun_free.controller.*"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<header style="text-align:center;"class="text-dark">예약하기</header>
	<br>
	<hr>
	<br><br>
	
	<div align="center">
	<form>
	<select class="dropdown-item-text dropdown-menu-dark" name="sel">
		<option>강원도</option>
		<option>거제도</option>
		<option>남해</option>
		<option>여수</option>
		<option>울릉도</option>
		<option>제주도</option>
		<option>부산</option>
		<option>통영</option>
		<option>포항</option>
	</select>
	<br>
	<input type=submit value="선택">
	</form>
	
	<c:choose>
	<c:when test="${param.sel == '강원도'}">
		<%@ include file="/map/1_gangwon.html" %>
		<br><br>
	</c:when>
	<c:when test="${param.sel == '거제도'}">
		<%@ include file="/map/2_geoje.html" %>
	</c:when>
	<c:when test="${param.sel == '남해'}" >
		<%@ include file="/map/3_namhae.html" %>
	</c:when>
	<c:otherwise>
	선택하세요.
	</c:otherwise>
	</c:choose>
	</div>
	
	<section class="py-4">
        <div class="container my-4">
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