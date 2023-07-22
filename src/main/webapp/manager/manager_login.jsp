<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<section>
	<br><br><br>
	<h1>관리자 로그인</h1>
	<br><br>
	<form action="<%=path%>/manager_Login.do">
		<div align="center">
			<table border="1" align="center">
				<tr>
					<td>아이디</td>
					<td><input type="text" name=manager_id size=20 value="admin"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name=manager_password size=21 value="77777"></td>
				</tr>
				<tr>
					<td>유형</td>
					<td><select name=role ><option value="manager">manager</option></select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</div>
	</form>
</section>


<%@ include file="/include/bottom.jsp"%>