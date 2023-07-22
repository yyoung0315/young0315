<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section>
	<br> <br>
	<h1>Match 목록</h1>
	<br> <br>
	<div align="center">
			<table border="1">
			<tr align='center'>
				<c:forEach items="${li}" var="m" varStatus="status">
					<c:if test="${status.index >= 0 && status.index <= 3}">
						<td> Learner 아이디 :${m.luser_id} <br>
						성별 : ${m.luser_gender} <br>
						선호날짜 : ${m.luser_learnday}<br>
						선호시간 : ${m.luser_time}<br>
						선호장소 : ${m.luser_addr}<br>
						<hr>
						Teacher 아이디 : ${m.tuser_id}<br>
						성별 : ${m.tuser_gender}<br>
						선호날짜 : ${m.tuser_learnday}<br>
						선호시간 : ${m.tuser_time}<br>
						선호장소 : ${m.tuser_addr}<br>
						<fmt:parseDate  value="${m.match_day}" var="registered" pattern="yyyy-MM-dd" />
						match_day :<fmt:formatDate value="${registered}" pattern="yyyy년MM월dd일" /> 
						</td>
					</c:if>
				</c:forEach>
			</tr>
		</table>
	</div>
</section>
<%@ include file="/include/bottom.jsp"%>