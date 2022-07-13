<%@page import="java.util.ArrayList"%>
<%@page import="com.mmit.init.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("title") %></title>
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-2">
			<h3 class="col-10">Student List</h3>
			<a href="student-add" class="btn btn-primary col text-center"><i class="fa-solid fa-plus fa-large">Add New Student</i></a>
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
				<%
				List<Student> list =(ArrayList<Student>) session.getAttribute("students");
				if(list == null) {
					list = new ArrayList<>();
				}
				for(int i=0 ; i < list.size() ; i++) {
					Student tem = list.get(i);
					%>
					<tr>
						<td><%= i+1 %></td>
						<td><%= tem.getName() %></td>
						<td><%= tem.getPhone() %></td>
						<td><%= tem.getEmail() %></td>
						<td><%= tem.getBatch() %></td>
						<td><%= tem.getRegisterDate() %></td>
						<td><%= tem.isOld_student() %></td>
					</tr>
				<%}
				%>
			</tbody>
		</table>
	</div>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>