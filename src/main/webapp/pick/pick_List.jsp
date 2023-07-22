<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>

<section>
	<br> <br>
	<h1>나를 pick한 learner 목록</h1>
	<br> <br>
	<div align="center">
		<c:if test="${empty li}">
			<h1>아직은 나를 pick한 learner가 없습니다.</h1>
			<h3>
				<a href="<%=path%>/index.jsp"> 메인으로 돌아가기 </a>
			</h3>
			<h3>
				<a href="<%=path%>/productListAll.do"> Market으로 구경하기 </a>
			</h3>
		</c:if>
		<c:forEach items="${li}" var="m">
			<table border="1" width=650 align="center">
				<c:if test="${not empty m}">
					<tr>
						<td>learner 아이디</td>
						<td>성별</td>
						<td>평일/주말</td>
						<td>선호시간</td>
						<td>선호장소</td>
					</tr>
					<tr>
						<c:url value="/lusertkd_GetOne.do" var="url">
							<c:param name="luser_id" value="${m.luser_id}" />
						</c:url>
						<td><c:if test="${id == null}">
								<a href="${url}" />
							</c:if>${m.luser_id}</td>
						<td>${m.luser_gender}</td>
						<td>${m.luser_learnday}</td>
						<td>${m.luser_time}</td>
						<td>${m.luser_addr}</td>
					</tr>
				</c:if>
			</table>
		</c:forEach>
	</div>
</section>
<%@ include file="/include/bottom.jsp"%>