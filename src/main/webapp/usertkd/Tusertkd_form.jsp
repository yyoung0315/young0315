<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<script>
jQuery.ajaxSetup({cache:false});

function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};

$(document).ready( function(){
	  $('#idCheck').click( function(){	
		  var path = getContextPath();
		  var  dataStr={
				  user_id : $('#tuser_id').val()			  
		  };
		  		 
		  $.ajax({			 
			  type: "GET",
			  url :  path+"/tidCheck.do",
			  data : dataStr,
			  success: function (data){
			   if(data == "null"){
				   alert("사용가능한 아이디 입니다.!!"); 
			   } else {
				   alert(data+"는 벌써 사용하고 있습니다.!!");
				   $('#tuser_id').val("");
				   $('#tuser_id').focus();
			   }
				  
			  
			  }	  
		  })
		 
	  }) 
})

</script>
<section >
	<br>
	<br>
	<h2>Teacher 회원가입</h2>
	<br>
	<br>
	<form action="<%=path%>/tusertkd_Insert.do">
		<table border="1" height=500 width=720 >
			<tr>
				<td align="center">이름</td>
				<td colspan="3"><input type=text name=tuser_name />
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td colspan="3"><input type=text name=tuser_id /><input type="button" value="중복체크" id="idCheck"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type=password name=tuser_password />
				<td align="center">성별</td>
				<td>&emsp;<select name=tuser_gender><option value="남자">남</option>
						<option value="여자">여</option></select>
			</tr>
			<tr>
				<td align="center">희망하는 요일</td>
				<td>
			  &emsp;<select name=tuser_learnday>
					<option value="평일선호">평일</option>
					<option value="주말선호">주말</option>
					</select></td>
				<td align="center">원하는 시간</td>
				<td>
				<input type="radio" name="tuser_time" value="오전">오전
				<input type="radio" name="tuser_time" value="오후">오후</td>
			</tr>
			<tr>
				<td align="center">휴대폰 번호</td>
				<td colspan="3"><input type=text name=tuser_phone /></td>
			</tr>
			<tr>
				<td align="center">원하는 장소</td>
				<td colspan="3">
					<input type="text" name=tuser_addr placeholder="가까운 역을 입력하세요 ex)서울역" size="30"/>
				</td>
			</tr>
			<tr>
				<td align="center">경력사항 및 <br>learner에게</td>
				<td colspan="3"><textarea cols="70" rows="9" name=tuser_etc></textarea></td>
			</tr>
			<tr>
				<td align="center" colspan="4">
					<input type="submit" value="회원가입">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</section>


<%@ include file="/include/bottom.jsp"%>