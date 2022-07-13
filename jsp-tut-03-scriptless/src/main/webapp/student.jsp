<%@page import="com.mmit.init.Student"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${requestScope.title}</title>
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-2">
			<h3 class="col-10">Student List</h3>
			<c:url var = "student_add" value="/student-add"></c:url>
			<a href="${student_add}" class="btn btn-primary col text-center"><i class="fa-solid fa-plus fa-large">Add New Student</i></a>
		</div>
		<hr />
		<table class="table">
			<thead>
				<tr>
					<th>No</th>
					<th>Student Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Batch</th>
					<th>Register Date</th>
					<th>Old Student</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${sessionScope.students}" var = "s" varStatus="i">
				 <tr>
						<td>${i.count}</td>
						<td>${s.name}</td>
						<td>${s.phone}</td>
						<td>${s.email}</td>
						<td>${s.batch}</td>
						<td>${s.registerDate}</td>
						<td>${s.old_student}</td>
					</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>