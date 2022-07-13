<%@page import="com.mmit.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link rel="stylesheet"
	href="webjars/font-awesome/6.1.1/css/fontawesome.min.css" />
</head>
<body>
		<div>
		<h3>Profile</h3>
		<%
			Student st =(Student) request.getAttribute("student");
			if(st == null)
				st = new Student();
		
		%>
		<table>
			<tr>
				<td>Name</td>
				<td><%= st.getName() %></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><%= st.getEmail() %></td>
			</tr>
			
			<tr>
				<td>Age</td>
				<td><%= st.getAge() %></td>
			</tr>
			
			<tr>
				<td>Birthday</td>
				<td><%= st.getBirthday() %></td>
			</tr>
			
			<tr>
				<td>Region</td>
				<td><%= st.getRegion() %></td>
			</tr>
			
		</table>
		</div>
</body>
</html>