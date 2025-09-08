package com.nist.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecondServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Retrieve name from session
            HttpSession session = request.getSession();
            String name = (session != null) ? (String) session.getAttribute("name") : "Unknown";

            // Retrieve cookies
            String email = "Unknown";
            String password = "Unknown";

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("email")) email = c.getValue();
                    if (c.getName().equals("password")) password = c.getValue();
                }
            }

            out.println("<html><body>");
            out.println("<h2>User Info</h2>");
            out.println("<p><strong>Name:</strong> " + name + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
            out.println("<p><strong>Password:</strong> " + password + "</p>");
            out.println("</body></html>");
        }

}
 