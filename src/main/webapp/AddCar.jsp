<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#head {
	padding: 50px;
	background-color: silver;
	width: 400px;
	color: black;
	margin: auto;
}

#head2 {
	color: black;
	background-color: silver;
	border-radius: 10px;
	width: 400px;
	margin: auto;
}

.inp {
	border: 1px solid;
	border-radius: 10px;
	font-size: 20px;
	padding: 20px;
}

body {
	background-color: black;
	font-size: 20px;
}
caption{
font-size:25px;
margin-bottom: 15px;
}

</style>
</head>
<body>
	<div id="head" align="center">
		<form action="carAdd" method="post">
			<table align="center">
				<caption>Add Car</caption>
				<tr>
					<td>Id:</td>
					<td><input required class="inp" type="text" name="id"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input required class="inp" type="text" name="name"></td>
				</tr>
				<tr>
					<td>Color:</td>
					<td><input required class="inp" type="text" name="color"></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input required class="inp" type="text" name="price"></td>
				</tr>
			</table>
			<input class="inp" type="submit" value="Add">
		</form>
	</div>

	<div id="head2" align="center">
		<%
		String mesg;
		%>
		<%
		mesg = (String) request.getAttribute("mesg");
		if (mesg != null) {
		%>
		<h4 class="inp"><%=mesg%></h4>
		<%
		}
		%>
	</div>
	<div>
	<button align="center"> <a href="http://localhost:8080/cardekhowithservlet/UpdateCar.jsp">UpdateCar</a> </button>
	<button align="center"> <a href="http://localhost:8080/cardekhowithservlet/DeleteCar.jsp">DeleteCar</a> </button>
	</div>

</body>
</html>