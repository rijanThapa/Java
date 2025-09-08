package com.nist.sms.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentController() {
        super();
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
    }

    // Handles form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String faculty = request.getParameter("faculty");
        String gender = request.getParameter("gender");

        String insertSql = "INSERT INTO students (name, address, phone, email, faculty, gender) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(insertSql)) {

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, faculty);
            ps.setString(6, gender);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }

        // After inserting, show updated list
        doGet(request, response);
    }

    // Handles GET (used after deletion or refresh)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectSql = "SELECT * FROM students";
        ArrayList<Student> studentList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(selectSql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setFaculty(rs.getString("faculty"));
                s.setGender(rs.getString("gender"));
                studentList.add(s);
            }

            request.setAttribute("nlist", studentList);
            RequestDispatcher rd = request.getRequestDispatcher("studentDetails.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
