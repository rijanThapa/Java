<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Input Form</title>
</head>
<body>

<h2>User Registration Form</h2>
<form action="FirstServlet" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Submit">
</form>

<form action="Session" method="post">
Name: <input type="text" name="name" required><br><br>
Email: <input type="text" name="email" required><br><br>
Password: <input type="text" name="password" required><br><br>

</form>

</body>
</html>
