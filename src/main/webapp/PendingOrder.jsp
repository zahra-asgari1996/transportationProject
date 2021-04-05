<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/5/2021
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1= request.getSession(false);
    if (session1==null ||session1.getAttribute("userName")==null){
        request.getRequestDispatcher("EmployeeLogin.html").forward(request,response);
    }
%>
<html>
<head>
    <title>Pending Order</title>
    <link rel="stylesheet" href="/css/PendingorderStyleSheet.css">
</head>
<body>
<table>
    <h2> Pending Orders</h2>
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
</table><br><br>

<div class="container">
    <h2>Please fill information </h2>
    <form action="pendingorder" method="post">
        <input type="number" name="number" id="number" placeholder="Tracking number" required><br><br>
        <input type="text" name="des" id="des" placeholder="Description"><br><br>
        <input type="checkbox" id="sending" name="check" value="sending">
        <label for="sending"> Sending</label><br>
        <input type="checkbox" id="delivered" name="check" value="delivered">
        <label for="delivered"> Delivered </label><br><br>
        <button type="submit">Click</button>
    </form>
</div>
</body>
</html>
