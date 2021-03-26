<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<title>transportationSystem</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
    <button class="w3-bar-item w3-button w3-large"
            onclick="w3_close()">Close &times;</button>
    <a href="CustomerSignup.html" class="w3-bar-item w3-button">Customer</a>
    <a href="#" class="w3-bar-item w3-button">Employee</a>
    <a href="#" class="w3-bar-item w3-button">Manager</a>
</div>

<div id="main">

    <div class="w3-teal">
        <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
        <div class="w3-container">
            <h1>Transportation System</h1>
        </div>
    </div>


    <div class="w3-container">
    </div>

</div>

<script src="Scripts.js"></script>

</body>
</html>
