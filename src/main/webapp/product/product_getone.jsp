<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<section>
	<br>
	<div align=center>
		<h2>상품 상세보기 &emsp;</h2>
		<c:choose>
			<c:when test="${count==0}">
				<br />
				<br />
				<br /> 장바구니가 비어 있습니다. 
 </c:when>
			<c:otherwise>
				<form method=post action="${path}/cartInsert.do">
				<input type=hidden name=product_id value="${m.product_id}" />
					<table border=1 width=700 height=350>
						<tr>
							<td align="center">상품이름</td>
							<td>&emsp;<input type=text name=product_name value="${m.product_name}" />
							</td>
							<td rowspan=3 align="center">
							<img src="${path}/product/files/${m.product_imgStr}" width=200 height=250 /></td>
						</tr>
						<tr>
							<td align="center">상품가격</td>
							<td>&emsp;<input type=text name=product_price value="${m.product_price}" />
							</td>
						</tr>
						<tr>
							<td align="center">상품설명</td>
							<td align="center"><textarea cols=40 rows=9 name=product_desc>${m.product_desc}</textarea></td>

						</tr>
						<tr>
							<td align="center">구매수량</td>
							<td colspan=2>&emsp; <select name=amount>
									<c:forEach begin="1" end="5" var="i">
										<option value="${i}">${i}개</option>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td colspan=3 align="center"><input type=submit value="In 장바구니"></td>
						</tr>
					</table>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>