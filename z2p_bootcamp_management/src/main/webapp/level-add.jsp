<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title} | ${level.id == 0 ? 'Add' : 'Edit'}</title>
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${level.id == 0 ? 'Add' : 'Edit'}</h3>
			<c:url value="/Levels" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-Level" var = "save"></c:url>
		<form action="${save}" class="form col-5 offset-3" method="post">
				<input type="hidden" class="form-control" value = "${level.id}" name = "levelId"/>
			<div class="mb-3">
				<label class="form-label">Name</label>
				<input value="${level.name}" type="text" class="form-control" placeholder="Enter Level Name"  required="required" name = "name"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Duration(Month)</label>
				<input value="${level.duration}" type="number" class="form-control" placeholder="Enter Duration "  required="required" name = "duration"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Fees</label>
				<input value="${level.fees}" type="number" class="form-control" placeholder="Enter fees"  required="required" name = "fees"/>
			</div>
			<div class="mb-3">
				<button class="btn btn-success w-30" type="submit">Save</button>
				<button class="btn btn-danger w-30" type="reset">Clear</button>
			</div>
			
		</form>
	</div>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>