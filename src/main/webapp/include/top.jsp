<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>My own 1:1 TKDclass</title>
<style>
body {
	font-family: "맑은 고딕", "고딕", "굴림";
	background-color: #FAF8F4;
}

#wrapper {
	width: 1000px;
	margin: 0 auto;
}

header {
	width: 100%;
	height: 200px;
	background-color: #E7FFDE;
	background-image: url(images/nav2.png);
	background-repeat: no-repeat;
	background-position: right center;
}

header nav {
	float: left;
	width: 100%;
	height:50px
}
nav ul {
	list-style-type: none;
}
nav ul li {
	display: inline;
	float: left;
	font-weight: bold;
	margin-top: 10px;
	padding-left: 10px;
	padding-bottom: 40px;
}
nav ul li a {
	color: #000000;
	text-decoration: none;
}
aside {
	float: right;
	width: 200px;
	height: auto;
	margin-top: 80px;
	border: 1px solid darkgreen;
	text-align: center;
}

footer p {
	padding: 20px;
}

h1 {
	text-align: center;
	padding-top: 20px;
}

h2 {
	font-size: 1.5em;
	text-align: center;
}

h3 {
	font-size: 1.0em;
}

p {
	font-size: 15px;
	line-height: 30px;
	padding: 10px;
}

section {
	float: left;
	width: 580px;
	padding: 5px;
	padding-left: 70px;
}

footer {
	clear: both;
	width: 1000px;
	background-color: #333;
	color: white;
	text-align: center;
	height: 100px;
}

img {
	width: 150px;
	height: 200px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<header>
			<c:if test="${empty tuser_id && empty m_id && empty luser_id}">
				<h1 align="center">
					<a href="<%=path%>/index.jsp">My own 1:1 TKDclass</a>
				</h1>
				<h2 align="center">안녕하세요 My own 1:1 TKDclass 입니다!</h2>
			</c:if>
			
			<c:if test="${not empty m_id}">
				<h1 align="center">
					<a href="<%=path%>/index.jsp">My own 1:1 TKDclass</a>
				</h1>
				<h3 align="center">
					<a href="<%=path%>/usertkd_logout.do"> ${m_id}님 </a>&emsp;
					환영합니다!
				</h3>
			</c:if>
			
			<c:if test="${not empty luser_id}">
				<h1 align="center">
					<a href="<%=path%>/index.jsp">My own 1:1 TKDclass</a>
				</h1>
				<h3 align="center">
					<a href="<%=path%>/usertkd_logout.do"> ${luser_id}님 </a>&emsp;
					환영합니다!
				</h3>
			</c:if>
			<c:if test="${not empty tuser_id}">
				<h1 align="center">
					<a href="<%=path%>/index.jsp">My own 1:1 TKDclass</a>
				</h1>
				<h3 align="center">
					<a href="<%=path%>/usertkd_logout.do"> ${tuser_id}님 </a>&emsp;
					환영합니다!
				</h3>
			</c:if>
			<nav>
				<ul>
					<c:if test="${empty tuser_id && empty luser_id && empty m_id}">
						<li><h3><a href="<%=path%>/usertkd/Tusertkd_form.jsp"> &ensp;&ensp; Teacher회원가입 </a></h3></li>
						<li><h3><a href="<%=path%>/usertkd/Lusertkd_form.jsp"> &ensp;&ensp; Learner회원가입 </a></h3></li>
						<li><h3><a href="<%=path%>/usertkd/Tusertkd_login.jsp"> &ensp;&ensp; Teacher로그인 </a></h3></li>
						<li><h3><a href="<%=path%>/usertkd/Lusertkd_login.jsp"> &ensp;&ensp; Learner로그인 </a></h3></li>
						<li><h3><a href="<%=path%>/manager/manager_login.jsp">&ensp;&ensp; 관리자 로그인</a></h3></li>
					</c:if>
					
					<c:if test="${not empty m_id}">
						<li><a href="<%=path%>/lusertkd_List.do">&emsp;learner목록보기</a></li>
						<li><a href="<%=path%>/tusertkd_List.do">&emsp;&emsp;teach목록보기</a></li>
						<li><a href="<%=path%>/product/product_form.jsp">&emsp;&emsp;상품등록하기</a></li>
						<li><a href="<%=path%>/MproductListAll.do">&emsp;&emsp;상품목록보기</a></li>
						<li><a href="<%=path%>/match_List.do">&emsp;&emsp;today matching</a></li>
					</c:if>
					<c:if test="${not empty luser_id}">
						<li><a href="<%=path%>/tusertkd_List.do?luser_id=${luser_id}">&ensp;teach 목록보기</a></li>
						<li><a href="<%=path%>/productListAll.do">&ensp;&ensp;상품목록보기</a></li>
						<li><a href="<%=path%>/cart.do?user_id=${luser_id}"> &ensp;&ensp;my cart</a></li>
						<li><a href="<%=path%>/luser_count.do?luser_id=${luser_id}"> &ensp;&ensp;회원정보수정</a></li>
					</c:if>
					<c:if test="${not empty tuser_id}">
						<li><a href="<%=path%>/pick_List.do">&ensp;Picked me 목록보기</a></li>
						<li><a href="<%=path%>/productListAll.do">&ensp;&ensp;상품목록보기</a></li>
						<li><a href="<%=path%>/cart.do?user_id=${tuser_id}"> &ensp;&ensp;my cart</a></li>
						<li><a href="<%=path%>/tuser_count.do?tuser_id=${tuser_id}"> &ensp;&ensp;회원정보수정</a></li>
					</c:if>
				</ul>
			</nav>
		</header>