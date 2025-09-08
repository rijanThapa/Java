package com.nist.sms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TeacherController() {
        super();
    }
    
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost३/sms", "root", "");    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
       
        String sql = "INSERT INTO teachers (name, address, phone, email) VALUES (?, ?, ?, ? )";
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
        	conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
        	ps.setString(4, email);
        	
        	ps.executeUpdate();
        	
        	  response.getWriter().println("Teacher added successfully.");
        }catch(Exception ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
        
	
		doGet(request, response);
	}

}
