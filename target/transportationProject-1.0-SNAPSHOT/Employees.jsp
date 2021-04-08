<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/7/2021
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<table>
    <h2> Employees</h2>
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
<a href="EmployeeSignUp.html" >Create account for employee</a>
</div>
</body>
</html>
