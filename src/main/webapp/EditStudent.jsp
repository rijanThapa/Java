<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.nist.sms.controller.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="navbar.jsp"%>
<%
    Student s = (Student) request.getAttribute("student");
    if (s == null) {
%>
    <div class="container mt-5">
        <div class="alert alert-danger">Student data not found.</div>
    </div>
<%
    } else {
%>
<div class="container mt-5">
    <h2 class="text-center mb-4">Edit Student</h2>

    <form action="UpdateStudentController" method="post" class="shadow p-4 rounded bg-light">
        <input type="hidden" name="id" value="<%= s.getId() %>">

        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" class="form-control" name="name" value="<%= s.getName() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" class="form-control" name="email" value="<%= s.getEmail() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Address:</label>
            <input type="text" class="form-control" name="address" value="<%= s.getAddres() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Phone:</label>
            <input type="text" class="form-control" name="phone" value="<%= s.getPhone() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Faculty:</label>
            <input type="text" class="form-control" name="faculty" value="<%= s.getFaculty() %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Gender:</label>
            <select class="form-select" name="gender" required>
                <option value="Male" <%= "Male".equals(s.getGender()) ? "selected" : "" %>>Male</option>
                <option value="Female" <%= "Female".equals(s.getGender()) ? "selected" : "" %>>Female</option>
                <option value="Other" <%= "Other".equals(s.getGender()) ? "selected" : "" %>>Other</option>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Update</button>
        <a href="StudentController" class="btn btn-secondary">Cancel</a>
    </form>
</div>
<%
    }
%>
</body>
</html>
