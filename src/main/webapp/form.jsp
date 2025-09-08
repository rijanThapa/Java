<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function showForm(role) {
            if (role === 'student') {
                document.getElementById("studentForm").style.display = 'block';
                document.getElementById("teacherForm").style.display = 'none';
                document.getElementById("btnStudent").classList.add("btn-primary");
                document.getElementById("btnStudent").classList.remove("btn-secondary");
                document.getElementById("btnTeacher").classList.add("btn-secondary");
                document.getElementById("btnTeacher").classList.remove("btn-primary");
            } else {
                document.getElementById("studentForm").style.display = 'none';
                document.getElementById("teacherForm").style.display = 'block';
                document.getElementById("btnStudent").classList.add("btn-secondary");
                document.getElementById("btnStudent").classList.remove("btn-primary");
                document.getElementById("btnTeacher").classList.add("btn-primary");
                document.getElementById("btnTeacher").classList.remove("btn-secondary");
            }
        }

        // Automatically show student form when the page loads
        window.onload = function () {
            showForm('student');
        }
    </script>
</head>
<body class="bg-light">
<%@ include file="navbar.jsp" %>
    <div class="container mt-5">
        <h2 class="mb-4 text-center">Registration Form</h2>
        <div class="text-center mb-4">
            <button id="btnStudent" class="btn me-2" onclick="showForm('student')">Student</button>
            <button id="btnTeacher" class="btn" onclick="showForm('teacher')">Teacher</button>
        </div>

        <!-- Student Form -->
        <div id="studentForm">
            <form class="border p-4 rounded bg-white shadow-sm" method="post" action="StudentController">
    <h4 class="mb-3">Student Registration</h4>

    <div class="mb-3">
        <label for="studentName" class="form-label">Name</label>
        <input type="text" class="form-control" id="studentName" name="name" required>
    </div>

    <div class="mb-3">
        <label for="studentAddress" class="form-label">Address</label>
        <input type="text" class="form-control" id="studentAddress" name="address" required>
    </div>

    <div class="mb-3">
        <label for="studentPhone" class="form-label">Phone Number</label>
        <input type="tel" class="form-control" id="studentPhone" name="phone" required>
    </div>

    <div class="mb-3">
        <label for="studentEmail" class="form-label">Email</label>
        <input type="email" class="form-control" id="studentEmail" name="email" required>
    </div>

    <div class="mb-3">
        <label for="studentFaculty" class="form-label">Faculty</label>
        <select class="form-select" id="studentFaculty" name="faculty" required>
            <option value="">Select Faculty</option>
            <option value="bca">BCA</option>
            <option value="csit">CSIT</option>
            <option value="bim">BIM</option>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Gender</label>
        <select class="form-select" name="gender" required>
            <option value="">Select Gender</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>
    </div>

    <button type="submit" class="btn btn-success">Register Student</button>
</form>
            
        </div>

        <!-- Teacher Form -->
        <div id="teacherForm" style="display: none;">
            <form class="border p-4 rounded bg-white shadow-sm" action="TeacherController" method="post">
                <h4 class="mb-3">Teacher Registration</h4>
                <div class="mb-3">
                    <label for="teacherName" class="form-label">Name</label>
                    <input type="text" class="form-control" id="teacherName" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="teacherAddress" class="form-label">Address</label>
                    <input type="text" class="form-control" id="teacherAddress" name="address" required>
                </div>
                <div class="mb-3">
                    <label for="teacherPhone" class="form-label">Phone Number</label>
                    <input type="tel" class="form-control" id="teacherPhone" name="phone" required>
                </div>
                <div class="mb-3">
                    <label for="teacherEmail" class="form-label">Email</label>
                    <input type="email" class="form-control" id="teacherEmail" name="email" required>
                </div>
                <button type="submit" class="btn btn-success">Register Teacher</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
