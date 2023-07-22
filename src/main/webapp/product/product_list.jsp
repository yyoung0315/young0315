<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<section>
	<br>
	<div align="center">
		<h2>상품 목록 &emsp;${totalcount}</h2>
		<table>
			<tr align='center'>
				<c:forEach items="${li}" var="m" varStatus="status">
					<c:if test="${status.index >= 0 && status.index <= 3}">
						<td>상품번호:${m.product_id} <br> <br> <img
							src="<%=path%>/product/files/${m.product_imgStr}" width=70
							height=70> <br> <br> <a
							href="<%=path%>/product_GetOne.do?product_id=${m.product_id}">상품이름:${m.product_name}</a>
							<br>상품가격:${m.product_price}
						</td>
					</c:if>
				</c:forEach>

			</tr>
			<tr align='center'>
				<c:forEach items="${li}" var="m" varStatus="status">
					<c:if test="${status.index >= 4}">
						<td>상품번호:${m.product_id} <br> <br> <img
							src="<%=path%>/product/files/${m.product_imgStr}" width=70
							height=70> <br> <br> <a
							href="<%=path%>/product_GetOne.do?product_id=${m.product_id}">상품이름:${m.product_name}</a>
							<br>상품가격:${m.product_price}
						</td>
					</c:if>
				</c:forEach>
			</tr>
		</table>
		<br>
		<br> <a href=${path}/productListAll.do?start=1>처음으로</a> &emsp;

		<c:if test="${m.listStartpage > m.pageListSize }">
			<c:set var="start"
				value="${(m.listStartpage - m.pageListSize -1) * m.pageSize + 1 }" />
			<a href=${path}/productListAll.do?start=${start}>이전페이지</a>
			&emsp;
		</c:if>

		<c:if test="${m.listStartpage <= m.pageListSize }">
  이전페이지&emsp;
 </c:if>

		<c:forEach var="i" begin="${m.listStartpage}" end="${m.listEndPage}">
			<c:if test="${ i <= m.totalPage }">
				<c:set var="start" value="${(i-1)*m.pageSize+1}" />
	  [<a href=${path}/productListAll.do?start=${start}>${i}</a>]
  </c:if>
		</c:forEach>

		<c:if test="${ m.listEndPage < m.totalPage }">
			<c:set var="start" value="${m.listEndPage * m.pageSize + 1 }" />
			&emsp;
			<a href=${path}/productListAll.do?start=${start}>다음페이지</a>
			&emsp;
		</c:if>

		<c:if test="${ m.listEndPage >= m.totalPage }">
   &emsp;다음페이지 &emsp;
 </c:if>

		<c:set var="start" value="${m.endPage}" />
		<a href=${path}/productListAll.do?start=${start}>마지막으로 </a> <br>

	</div>
	<br>
</section>
<%@ include file="/include/bottom.jsp"%>