<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>

<section>
	<br><br>
	<h1> Learner 목록</h1>
	<br><br>
	<div align="center">
		<table border="1" width=650 align="center">
			<tr>
				<td>아이디</td>
				<td>성별</td>
				<td>평일/주말</td>
				<td>선호시간</td>
				<td>선호장소</td>
			</tr>
			<c:forEach items="${li}" var="m">
			<tr>
				<c:url value="/lusertkd_GetOne.do" var="url">
					<c:param name="user_id" value="${m.luser_id}"/>
				</c:url>
				<td>
			<c:if test="${m_id == null}">
				<a href="${url}" /></c:if>${m.luser_id}
			</td>
				<td>${m.luser_gender}</td>
				<td>${m.luser_learnday}</td>
				<td>${m.luser_time}</td>
				<td>${m.luser_addr}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</section>
<%@ include file="/include/bottom.jsp"%>