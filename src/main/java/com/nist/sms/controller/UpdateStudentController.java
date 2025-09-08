package com.nist.sms.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection method
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
    }

    // Handle POST request - Update student data
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String faculty = request.getParameter("faculty");
        String gender = request.getParameter("gender");

        String updateSql = "UPDATE students SET name=?, address=?, phone=?, email=?, faculty=?, gender=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(updateSql)) {

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, faculty);
            ps.setString(6, gender);
            ps.setInt(7, id);

            int updated = ps.executeUpdate();

            if (updated > 0) {
                response.sendRedirect("StudentController"); // Success - redirect
            } else {
                response.getWriter().println("Update failed. No student found with ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    
}
