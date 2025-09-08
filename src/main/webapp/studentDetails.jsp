<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.nist.sms.controller.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .table-container {
            margin-top: 40px;
        }
    </style>
</head>
<body>
	<%@ include file="navbar.jsp"%>

<div class="container table-container">
    <h2 class="text-center mb-4">Student List</h2>

    <table class="table table-striped table-bordered shadow-sm">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Faculty</th>
                <th>Gender</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("nlist");
                if (studentList != null && !studentList.isEmpty()) {
                    for (Student s : studentList) {
            %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getAddres() %></td> 
                <td><%= s.getPhone() %></td>
                <td><%= s.getFaculty() %></td>
                <td><%= s.getGender() %></td>
                <td>
                    <a href="EditStudentController?id=<%= s.getId() %>" class="btn btn-sm btn-warning">Edit</a>
                  <a href="DeleteStudentController?id=<%= s.getId() %>" class="btn btn-sm btn-danger"
   onclick="return confirm('Are you sure you want to delete this student?');">
   Delete
</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8" class="text-center">No student records found.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
