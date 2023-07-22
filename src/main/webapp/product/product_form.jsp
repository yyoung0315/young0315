<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>

<section>
	<br>
	<div align="center">
		<h2> 쇼핑 상품 등록 하기</h2>
		<form action="<%=path%>/product_Insert.do" method="post" enctype="multipart/form-data">
			<table border="1" width=550px align="center">
				<tr>
					<td> 상품이름 </td>
					<td><input type=text name=product_name></td>
				</tr>
				<tr>
					<td> 상품가격 </td>
					<td><input type=text name=product_price></td>
				</tr>
				<tr>
					<td> 상품설명 </td>
					<td><textarea name=product_desc rows="8" cols="55"></textarea></td>
				</tr>
				<tr>
					<td> 사진첨부 </td>
					<td><input type="file" name=product_img></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type=submit value="상품등록">
					&emsp;<input type="reset" value="다시작성"></td>
				</tr>
			</table>
		</form>
	</div>

</section>
<%@ include file="/include/bottom.jsp"%>