<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Interest Calculator</title>
</head>
<body>
    <h2>Simple Interest Calculator</h2>
    <form method="post">
        <label>Principal (P): </label>
        <input type="text" name="principal" required /><br><br>

        <label>Rate of Interest (R): </label>
        <input type="text" name="rate" required /><br><br>

        <label>Time (T in years): </label>
        <input type="text" name="time" required /><br><br>

        <input type="submit" value="Calculate Interest" />
    </form>

    <%
        String pStr = request.getParameter("principal");
        String rStr = request.getParameter("rate");
        String tStr = request.getParameter("time");

        if (pStr != null && rStr != null && tStr != null) {
            try {
                double p = Double.parseDouble(pStr);
                double r = Double.parseDouble(rStr);
                double t = Double.parseDouble(tStr);

                double si = (p * r * t) / 100;

                out.println("<h3>Simple Interest = " + si + "</h3>");
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Please enter valid numeric values.</p>");
            }
        }
    %>
</body>
</html>
