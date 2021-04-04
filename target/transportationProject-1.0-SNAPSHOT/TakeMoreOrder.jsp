<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/4/2021
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>State</th>
        <th>Employee</th>
        <th>Date</th>
        <th>Packet Id</th>
        <th>Description</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach items="${histories}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.state}</td>
            <td>${list.employee.id}</td>
            <td>${list.date}</td>
            <td>${list.packet.id}</td>
            <td>${list.description}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<div>
    <input type="number" id="num" placeholder="Delivery number">
</div>

</body>
</html>
