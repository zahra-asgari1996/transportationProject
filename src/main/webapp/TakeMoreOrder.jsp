<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/4/2021
  Time: 8:07 PM
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
    <title>Take More Order</title>
    <link rel="stylesheet" href="/css/PendingorderStyleSheet.css">
</head>
<body>
<table>
    <h2>Take More Orders</h2>
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
</table><br><br>

<div class="container">
    <h2>Please fill information </h2>
    <form action="takeOrder" method="post">
        <input type="number" id="num" name="number" placeholder="Delivery number"><br><br>
        <input type="text" id="des" name="description" placeholder="Description"><br><br>
        <button type="submit" >submit</button>
    </form>
</div>

<div class="logout">
    <a href="logoutEmployee">Log out</a>
</div>

</body>
</html>
