<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">

				<c:url var="level" value="/levels"></c:url>
				<c:url var="batch" value="/batches"></c:url>
				<c:url var="course" value="/courses"></c:url>


				<a class="nav-link ${empty requestScope.title ? 'active' : '' }"
					aria-current="page" href="<%= request.getContextPath() %>">Home</a>
				<a class="nav-link ${title eq 'level' ? 'active' : '' }"
					href="${level}">Level</a> <a
					class="nav-link ${title eq 'Batch' ? 'active' : '' }"
					href="${batch}">Batch</a> <a
					class="nav-link ${title eq 'Course' ? 'active' : '' }"
					href="${course}">Course</a>

			</div>
		</div>
	</div>
</nav>