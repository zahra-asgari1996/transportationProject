<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 4/3/2021
  Time: 2:28 PM
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
    <title>Manager Page</title>
</head>
<body>
<div class="topnav">
    <a href="employees">Employees</a>
    <a href="customers">Customers</a>
    <a href="logoutEmployee">Log out</a>
</div>
</body>
</html>
