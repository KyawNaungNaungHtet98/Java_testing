<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Without EL</h3>
	<%
	String name = request.getParameter("uname");
	String email = request.getParameter("email");
	if(name == null) {
		name = "";
	}
	if(email == null) {
		email = "";
	}
	%>
	<form action="">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="uname" value="<%= name %>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" value= "<%= email %>" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form>

	<hr />

	
	<%
	if(!name.equals("") && !email.equals("")) {
		%>
		<h3>Result</h3>
		<p>Name : <%= name %></p>
		<p>Email : <%= email %></p>
	<%}
	%>
	
</body>
</html>