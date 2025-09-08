<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
}

.contact-container {
	margin-top: 50px;
	margin-bottom: 50px;
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container contact-container">
		<h2 class="text-center mb-5">Contact Us</h2>
		<div class="row">
			<!-- Contact Form -->
			<div class="col-md-6">
				<form action="ContactServlet" method="post"
					class="p-4 bg-white rounded shadow-sm">
					<div class="mb-3">
						<label for="name" class="form-label">Your Name</label> <input
							type="text" class="form-control" id="name" name="name" required>
					</div>

					<div class="mb-3">
						<label for="email" class="form-label">Your Email</label> <input
							type="email" class="form-control" id="email" name="email"
							required>
					</div>

					<div class="mb-3">
						<label for="message" class="form-label">Your Message</label>
						<textarea class="form-control" id="message" name="message"
							rows="5" required></textarea>
					</div>

					<button type="submit" class="btn btn-primary">Send Message</button>
				</form>
			</div>

			<!-- Contact Info -->
			<div class="col-md-6">
				<div class="p-4 bg-white rounded shadow-sm h-100">
					<h5>Contact Information</h5>
					<p>
						<strong>Address:</strong> 123 School Street, Education City, 45678
					</p>
					<p>
						<strong>Phone:</strong> +1 (123) 456-7890
					</p>
					<p>
						<strong>Email:</strong> contact@school.edu
					</p>
					<p>
						<strong>Office Hours:</strong> Mon - Fri, 9am - 5pm
					</p>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
