<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/7/2021
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    HttpSession session1= request.getSession(false);
    if (session1==null ||session1.getAttribute("userName")==null){
        request.getRequestDispatcher("ManagerLogin.html").forward(request,response);
    }
%>
<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" href="css/EmployeesStyleSheet.css">
</head>
<body>
<table>
    <h2>Employees Information</h2>
    <thead>
    <tr>
        <th>Id</th>
        <th>User Name</th>
        <th>Password</th>
        <th>name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Gender</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.userName}</td>
            <td>${e.password}</td>
            <td>${e.name}</td>
            <td>${e.lastName}</td>
            <td>${e.email}</td>
            <td>${e.phone}</td>
            <td>${e.employeeAddress}</td>
            <td>${e.gender}</td>
        </tr>
    </c:forEach>
    </tbody>
</table><br><br>

<div class="container">
    <a href="EmployeeSignUp.html">Create account for employee</a><br><br>
    <a href="managerLogout">Log out</a>
</div>
</body>
</html>
