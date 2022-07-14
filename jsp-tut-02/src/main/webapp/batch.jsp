<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch</title>
<jsp:include page="common/nav.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/res.jsp"></jsp:include>
	<h3 class="text-center">
		<span class="fs-1 fst-italic text-warning">B</span>atch
	</h3>
	<div class="container">
		<div class="row">
			<div class="col-6 bg-warning">
				<form action="batch-add" method="post" class="form col-5">
					<div class="mb-3">
						<label for="" class="form-label"><span class="fst-italic fw-bold">B</span>atch <span class="fst-italic fw-bold">N</span>ame</label> <input
							type="text" class="form-control" name="batch" required="required" />
					</div>
					<div class="mb-3">
						<label for="" class="form-label"><span class="fst-italic fw-bold">D</span>ate</label> <input type="date"
							class="form-control" name="date" required="required" />
					</div>
					<div class="row pb-3">
						<div class="col">
							<button class="btn btn-danger w-100" type="reset">Clear</button>
						</div>
						<div class="col">
							<button class="btn btn-primary w-100" type="submit">Save</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-6 bg-secondary">
				<table class="table">
					<thead>
						<tr>
							<th>No</th>
							<th>Batch Name</th>
							<th>Date of Start</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${sessionScope.batches}" var = "s" varStatus="i">
						<tr>
							<th>${i.count}</th>
							<th>${s.name}</th>
							<th>${s.start_date}</th>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
