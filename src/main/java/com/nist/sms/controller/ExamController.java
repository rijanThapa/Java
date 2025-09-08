package com.nist.sms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExamController")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExamController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO student (name,address,age) VALUES (?,?,?)";
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, age);
			ps.executeUpdate();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		ArrayList<Exam> studentList = new ArrayList<>();
		String sql1 = "select * from student";
		
		try {
			ps= getConnection().prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name1= rs.getString("name");
				String address1= rs.getString("address");
				int age1= rs.getInt("age");
				int id = rs.getInt("id");
				Exam exam1 = new Exam();
				exam1.setName(name1);
				exam1.setAddress(address1);
				exam1.setAge(age1);
				exam1.setId(id);
				studentList.add(exam1);
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
	RequestDispatcher rd = request.getRequestDispatcher("ExamDetails.jsp");
	request.setAttribute("slist", studentList);
	rd.forward(request, response);
		
		doGet(request, response);
	}
public Connection getConnection () throws Exception {
Class.forName("com.mysql.cj.jdbc.Driver");
return DriverManager.getConnection("jdbc:mysql://localhost/csit", "root", "");
}
}
