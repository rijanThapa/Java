<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Find the Greatest Number</title>
</head>
<body>
    <h2>Find the Greatest of Three Numbers</h2>

    <form method="post">
        Enter first number: <input type="number" name="num1" required><br><br>
        Enter second number: <input type="number" name="num2" required><br><br>
        Enter third number: <input type="number" name="num3" required><br><br>
        <input type="submit" value="Find Greatest">
    </form>

<%
    String s1 = request.getParameter("num1");
    String s2 = request.getParameter("num2");
    String s3 = request.getParameter("num3");

    if (s1 != null && s2 != null && s3 != null &&
        !s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {

        try {
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            int num3 = Integer.parseInt(s3);

            int greatest;
            if (num1 >= num2 && num1 >= num3) {
                greatest = num1;
            } else if (num2 >= num1 && num2 >= num3) {
                greatest = num2;
            } else {
                greatest = num3;
            }
%>
            <h3>Result:</h3>
            <p>The greatest number among <%= num1 %>, <%= num2 %>, and <%= num3 %> is: 
               <strong><%= greatest %></strong></p>
<%
        } catch (NumberFormatException e) {
%>
            <p style="color:red;">Invalid input. Please enter valid numbers only.</p>
<%
        }
    }
%>

</body>
</html>
