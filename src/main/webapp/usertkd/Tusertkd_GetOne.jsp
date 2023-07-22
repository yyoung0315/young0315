<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pick.you.*"%>
<%@ include file="/include/top.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<section>
	<br> <br>
	<h1> Teacher 회원 상세보기</h1>
	<br> <br>
	<div align="center">
		<form action="<%=path %>/pick_Insert.do">
			<input type="hidden" name="luser_id" value="${luser_id}"> 
			<table border="1" width="580" align="center">
				<tr>
					<td align="center">Teacher 아이디</td>
					<td><input type="text" name="tuser_id" value="${mt.tuser_id}">
					</td>
				</tr>
				<tr>
					<td align="center">Teacher 성별</td>
					<td><input type="text"  value="${mt.tuser_gender}"></td>
				</tr>
				<tr>
					<td align="center">평일/주말</td>
					<td><input type="text"
						value="${mt.tuser_learnday}"></td>
				</tr>
				<tr>
					<td align="center">Teacher 선호 시간</td>
					<td><input type="text" value="${mt.tuser_time}"></td>
				</tr>
				<tr>
					<td align="center">Teacher 선호 장소</td>
					<td><input type="text" value="${mt.tuser_addr}"></td>
				</tr>				
				<tr>
					<td colspan="2">
						<div id="map" style="width: 100%; height: 250px;"></div>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="Pick"></td>
				</tr>
			</table>
		</form>
	</div>
</section>


<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3ceae49505873bd43967ab76117e154b&libraries=services"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(37.5509895, 126.9908991), // 지도의 중심좌표
		level : 6
	// 지도의 확대 레벨
	};

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					"${dt.metroNew}",
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">Teacher</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
</script>
<%@ include file="/include/bottom.jsp"%>