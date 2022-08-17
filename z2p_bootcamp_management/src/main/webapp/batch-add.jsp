<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title} | ${batch.id == 0 ? 'Add' : 'Edit'}</title>
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${batch.id == 0 ? 'Add' : 'Edit'}</h3>
			<c:url value="/batches" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-batch" var = "save"></c:url>
		<form action="${save}" class="form col-5 offset-3" method="post">
				<input type="hidden" class="form-control" value = "${batch.id}" name = "batchId"/>
			<div class="mb-3">
				<label class="select-label">Level</label>
				<select name="level" class="form-select">
					<c:forEach items= "${level}" var = "lvl">
						<option value="${lvl.id}">${lvl.name}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Name</label>
				<input value="${batch.name}" type="type" class="form-control" placeholder="Enter Batch Name "  required="required" name = "name"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Start Date</label>
				<input value="${batch.startDate}" type="date" class="form-control" placeholder="Enter Start Date"  required="required" name = "startDate"/>
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