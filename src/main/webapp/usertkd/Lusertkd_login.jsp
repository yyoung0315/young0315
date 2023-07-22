<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<section>
    <br><br><br>
    <h1> Learner 로그인</h1>
    <br><br>
    <div align="center">
    <form action="<%=path%>/lusertkd_Login.do" method="post">
        <table border="1" align="center">
            <tr>
                <td>아이디</td>
                <td><input type="text" name="luser_id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="luser_password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="로그인"/></td>
            </tr>
        </table>
        </form>
    </div>
</section>


<%@ include file="/include/bottom.jsp"%>