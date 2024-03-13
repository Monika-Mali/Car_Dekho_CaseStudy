<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<form action="updateCar" method="post">
			<table border=1px>
			<caption>Update Car</caption>
				<tr>
					<td>Enter Car Name</td>
					<td><input type="text" name="oldname"></td>
				</tr>
				<tr>
					<td>Enter Car New Name</td>
					<td><input type="text" name="newname"></td>
				</tr>
				
			</table><input type="submit" value="Update">
		</form>
	</div>
	<div align="center">
		<%!String mesg;%>

		<%
		mesg = (String) request.getAttribute("mesg");
		if (mesg != null) {
		%>
		<h4><%=mesg%></h4>
			<%
		}
		%>
	</div>


</body>
</html>