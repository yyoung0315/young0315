<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
function delK(k1) {
	alert(k1);
	location.href="<%=path%>/CartDelete.do?cidx="+k1;
}
</script>

<section>
	<br>
	<div align="center">
		<h2>My Cart 목록</h2>
		<form action="" method="post" name="f1" id="f1">
		<input type="hidden" value="${m.cidx}" name="cidx">
			<table border="1" width="700px">
				<tr>
					<td>장바구니 번호</td>
					<td>User ID</td>
					<td>상품번호</td>
					<td>상품 이름</td>
					<td>가격</td>
					<td>수량</td>
					<td>삭제</td>
				</tr>
				<c:forEach items="${li}" var="m">
					<tr>
						<td>${m.cidx}</td>
						<td>${m.user_id}</td>
						<td>${m.product_id}</td>
						<td>${m.product_name}</td>
						<td><fmt:formatNumber value="${m.product_price}" pattern="#,###" />원</td>
						<td><input type="number" value="${m.amount}" size="5"></td>
						<td><input type="button" value="삭제" onclick="delK(${m.cidx})"></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7">최종 합계 금액 : <fmt:formatNumber value="${sumMoney}" pattern="#,###"/>원</td></td>
				</tr>
				<tr>
					<td colspan="7" align="center">
						<input type="submit" value="수정하기" onclick="javascript:action='cartUpdate.do'">
						<input type="submit" value="구매하기" onclick="javascript:action='cartOrder.do'">
					</td>
				</tr>
			</table>
		</form>
		<br>
	</div>
</section>
<%@ include file="/include/bottom.jsp"%>