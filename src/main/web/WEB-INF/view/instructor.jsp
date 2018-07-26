<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 7/19/2018
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instructor Page</title>
</head>
<body>
<h1>Instructor Page</h1>
<p>Welcome Back Instructor <security:authentication property="principal.username"></security:authentication> !</p>
<p>This page should only be available for users with a role of "INSTRUCTOR".</p>
<hr>
<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>
</html>
