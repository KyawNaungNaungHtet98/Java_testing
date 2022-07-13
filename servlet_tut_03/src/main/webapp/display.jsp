<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scopes</title>
</head>
<body>
	<h2>Scope Objects</h2>
	
	<h3>Application Scope : <% out.println(application.getAttribute("contextScope")); %></h3>
	<h3>Session Scope : <%= session.getAttribute("sessionScope") %></h3>
	<h3>Request Scope : <%= request.getAttribute("requestScope") %></h3>
	<h2>Current Date : <%= LocalDate.now() %></h2>
</body>
</html>