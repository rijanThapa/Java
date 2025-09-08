<%@page import="com.nist.sms.controller.Exam"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        padding: 8px;
    }
</style>
</head>
<body>
<h1>Student Details</h1>

<%
ArrayList<Exam> name = (ArrayList<Exam>) request.getAttribute("slist");
%>

<table>
<tr>
    <th>Id</th> 
    <th>Name</th> 
    <th>Address</th> 
    <th>Age</th> 
</tr>

<% 
if (name != null) {
    for(Exam e : name) {
%>
<tr>
    <td><%= e.getId() %></td>
    <td><%= e.getName() %></td>
    <td><%= e.getAddress() %></td>
    <td><%= e.getAge() %></td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="4">No student data available.</td>
</tr>
<%
}
%>

</table>
</body>
</html>
