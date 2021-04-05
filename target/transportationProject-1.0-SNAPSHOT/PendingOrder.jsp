<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/5/2021
  Time: 11:09 AM
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
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.state}</td>
            <td>${l.employee.id}</td>
            <td>${l.date}</td>
            <td>${l.packet.id}</td>
            <td>${l.description}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<form action="pendingorder" method="post">
    <input type="number" name="number" id="number">
    <input type="text" name="des" id="des">
    <input type="checkbox" id="sending" name="check" value="sending">
    <label for="sending"> Sending</label><br>
    <input type="checkbox" id="delivered" name="check" value="delivered">
    <label for="delivered"> Delivered </label><br>
    <button type="submit" >submit</button>

</form>
</body>
</html>
