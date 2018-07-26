<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 7/25/2018
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation Page</title>
</head>
<body>
    <h1>New User Registration Confirmation Page</h1>

    <p>You have submitted the following information.</p>
    <p>Username: ${newUser.username}</p>
    <p>Password: ${newUser.password}</p>
    <p>Email Address: ${newUser.email}</p>
    <p>First Name: ${newUser.firstName}</p>
    <p>Last Name: ${newUser.lastName}</p>
</body>
</html>
