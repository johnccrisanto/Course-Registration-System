<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 7/19/2018
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unauthorized Access Page</title>
</head>
<body>
    <h1>Unauthorized Access</h1>
    <p>Unfortunately, you are not authorized to view this page.</p>
    <p>Please click on the link below to return to the home page</p>
    <a href="${pageContext.request.contextPath}/">Home Page</a>
</body>
</html>
