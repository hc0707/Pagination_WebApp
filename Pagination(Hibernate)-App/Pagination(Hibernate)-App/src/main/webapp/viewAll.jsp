<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<br />
<br />
<c:choose>
	<c:when test="${records ne null || !empty records }">
		<h1 align="center" style="color:magenta">Flowers List</h1>
		<table border='1'>
			<tr>
				<th><h2>Name</h2></th>
				<th><h2>Information</h2></th>
				<th><h2>Image</h2></th>
			</tr>
			<c:forEach var='row' items='${records}'>
				<tr>
					<td>
						<h2 align="center">${row.name}</h2>
					</td>
					<td>
						<h3 align="center">${row.information}</h3>
					</td>
					<td>
						<img src="data:image/jpg;base64,${row.image}" width="240" height="240"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>
<br />
<br />
<br />
<br />
<center>
	<c:if test="${pageNumber>1}">
		<b> 
		<button onclick="location.href='/pagination-app/controller?pageNumber=${pageNumber-1}'" type="button" style="background-color: Orange; color: Black; height:30px;width:70px">previous</button>
			&nbsp;&nbsp;
		</b>
	</c:if>
	<h3 style="display:inline">
	<c:forEach var='pages' begin='1' end='${noOfPages}'>
	<c:choose>
	<c:when test="${pageNumber eq pages}">
		<a href="/pagination-app/controller?pageNumber=${pages}" style="color: green;style=font-size: 400px">[${pages}]</a>
	</c:when>
	<c:otherwise>
		<a href="/pagination-app/controller?pageNumber=${pages}" style="color: red;style=font-size: 400px">[${pages}]</a>
	</c:otherwise>
	</c:choose>
	</c:forEach>
	</h3>
	<c:if test="${pageNumber<noOfPages}">
		<b>
		&nbsp;&nbsp;
		<button onclick="location.href='/pagination-app/controller?pageNumber=${pageNumber+1}'" type="button" style="background-color: Orange; color: Black; height:30px;width:70px">next</button>
			&nbsp;&nbsp;
		</b>
	</c:if>
	<br /> 
	<br /> 
	<button onclick="location.href='./index.html'" type="button" style="background-color: Lime; height:40px;width:60px">Home</button>
</center>