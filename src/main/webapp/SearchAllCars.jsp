<%@page import="com.jspiders.cardekhowithservlet.jdbc.CarJDBC"%>
<%@page import="com.jspiders.cardekhowithservlet.object.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Car> cars = CarJDBC.searchAllCars();
	if (cars != null && cars.size() > 0) {
	%>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>COLOR</th>
				<th>PRICE</th>
			</tr>
				<%
			for (Car car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getColor()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	}else{
	%>
	<h1>Car not available</h1>
	<%} %>

</body>
</html>