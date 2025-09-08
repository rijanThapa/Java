<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.login-container {
	min-height: 100vh;
}

.illustration-img {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.form-container {
	padding: 50px;
}

@media ( max-width : 768px) {
	.form-container {
		padding: 30px;
	}
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container-fluid login-container d-flex">
		<div class="row flex-grow-1 w-100">
			<!-- Left Side: Rendered Image -->
			<div class="col-md-6 p-0 d-none d-md-block">
				<img
					src="https://media.istockphoto.com/id/1281150061/vector/register-account-submit-access-login-password-username-internet-online-website-concept.jpg?s=612x612&w=0&k=20&c=9HWSuA9IaU4o-CK6fALBS5eaO1ubnsM08EOYwgbwGBo="
					alt="School Illustration" class="illustration-img">
			</div>

			<!-- Right Side: Login Form -->
			<div
				class="col-md-6 d-flex align-items-center justify-content-center bg-white">
				<div class="form-container w-100" style="max-width: 400px;">
					<h3 class="mb-4 text-center">Login to Your Account</h3>
					<form action="LoginServlet" method="post">
						<div class="mb-3">
							<label for="username" class="form-label">Username or
								Email</label> <input type="text" class="form-control" id="username"
								name="username" required>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password</label> <input
								type="password" class="form-control" id="password"
								name="password" required>
						</div>
						<div class="d-grid">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
						<div class="mt-3 text-center">
							<small>Don't have an account? <a href="form.jsp">Register</a></small>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
