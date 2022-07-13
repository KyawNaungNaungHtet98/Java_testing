<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
				
				<c:url var="student" value="/student"></c:url>
				
				
					<a class="nav-link ${empty requestScope.title ? 'active' : '' }" aria-current="page" href="<%= request.getContextPath() %>">Home</a>
					 <a class="nav-link" href="*">Batch</a>
					  <a class="nav-link ${title eq 'Student' or title eq 'Student|Add' ? 'active' : '' }" href="${student}">Student</a> 
				</div>
			</div>
		</div>
	</nav>