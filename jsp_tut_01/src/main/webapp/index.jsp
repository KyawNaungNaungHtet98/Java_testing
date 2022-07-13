<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bootstrap</title>
<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" />
<script type="text/javascript"
	src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>

<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="webjars/font-awesome/6.1.1/css/fontawesome.min.css" />
</head>
<body>

	<div class="container">
		<h3 class="mt-2">Register Form</h3>
		<hr />
		<div class="row">
		<form action="register" class="form" method="post">
			<div class="col-6">
				
					<div class="mb-3">
						<label for="name" class="form-label">Username</label>
						<input name="username" id="name" type="text" class="form-control" placeholder="username"/>
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Email</label>
						<input name="email" type="email" class="form-control" placeholder="example@gmail.com" required="required"/>
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Age</label>
						<input name="age" type="number" class="form-control" placeholder="Age" required="required"/>
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Birthday</label>
						<input name="dob" type="date" class="form-control" placeholder="Birthday" />
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Region</label>
						<select name="region" id="" class="form-select">
							<option value="mandalay">Mandalay</option>
							<option value="yangon">Yangon</option>
							<option value="sagaing">Sagaing</option>
						</select>
					</div>
					<div class="row mb-3">
					<div class="col-3"><span>Gender</span></div>
					<div class="col">
						<div class="mb-3 form-check">
							<input name ="gender" value="male" type="radio" class="form-check-input" checked="checked" id="male" />
							<label for="male" class="form-check-label">Male</label>
						</div>
					</div>
					<div class="col">
						<div class="mb-2 form-check">
							<input name ="gender" value="female" type="radio" class="form-check-input" id="female" />
							<label for="female" class="form-check-label">Female</label>
						</div>
					</div>
					</div>
					
					
				
			</div>
			
			<div class="col-6">
				<div class="mt-5 mb-3">
						<label for="" class="form-label">Address</label>
						<textarea name="address" id="" cols="30" rows="10" placeholder="Enter Address" class="form-control"></textarea>
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="chk" name="old_student" />
					<label for="chk" class="form-check-label">Old Student</label>
				</div>
				<div class="row">
					<div class="col">
						<button class="btn btn-danger w-100" type="reset">Reset</button>
					</div>
					<div class="col">
						<button class="btn btn-success w-100" type="submit">Register</button>
					</div>
					
				</div>
			</div>
			</form>
		</div>
	</div>


</body>
</html>