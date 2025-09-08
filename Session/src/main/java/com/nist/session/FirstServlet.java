package com.nist.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import javax.servlet.http.*;
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Store name in session
//            HttpSession session = request.getSession();
//            session.setAttribute("name", name);
            
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            // Store email and password in cookies
//            Cookie emailCookie = new Cookie("email", email);
//            Cookie passwordCookie = new Cookie("password", password);
            
            Cookie emailCookie = new Cookie("email", email);
            Cookie passwordCookie = new Cookie("password", password);

            // Set expiry time for 1 hour
//            emailCookie.setMaxAge(60 * 60);
//            passwordCookie.setMaxAge(60 * 60);
            
            emailCookie.setMaxAge(60 * 60);
            passwordCookie.setMaxAge(60 * 60);

//            response.addCookie(emailCookie);
//            response.addCookie(passwordCookie);

            response.addCookie(emailCookie);
            response.addCookie(passwordCookie);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Data saved successfully!</h3>");
            out.println("<form action='SecondServlet' method='get'>");
            out.println("<input type='submit' value='Go to Next Page'>");
            out.println("</form>");
            out.println("</body></html>");
        }

}
