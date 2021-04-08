<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/8/2021
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>

<table>
    <h2>Show Customers Information</h2>
    <thead>
    <tr>
        <th>User Name</th>
        <th>Password</th>
        <th>name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Gender</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.userName}</td>
            <td>${c.password}</td>
            <td>${c.name}</td>
            <td>${c.lastName}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td>${c.phoneNumber}</td>
            <td>${c.gender}</td>
        </tr>
    </c:forEach>
    </tbody>
</table><br><br>


</body>
</html>
