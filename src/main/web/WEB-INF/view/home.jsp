<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 7/13/2018
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Course Registration System Home Page</title>
  </head>
  <body>
    <h1>Course Registration System</h1>
    <p>Welcome to the Course Registration System!</p>
    Username: <security:authentication property="principal.username"></security:authentication>
    <br/><br/>
    Roles (s): <security:authentication property="principal.authorities"></security:authentication>

    <security:authorize access="hasRole('ADMIN')">
    <hr>
        <!-- Add a link to point to other resources such /admin for admins... -->
        <p>
            <a href="${pageContext.request.contextPath}/admin/">Link for Admins</a>
            (Admins Only)
        </p>
    </security:authorize>

    <security:authorize access="hasRole('INSTRUCTOR')">
    <hr>
    <!-- Add a link to point to other resources such /instructor for instructors... -->
    <p>
        <a href="${pageContext.request.contextPath}/instructor/">Link for Instructors</a>
        (Instructors Only)
    </p>
    </security:authorize>
    <br/> <br/>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
      <input type="submit" value="Log out">
    </form:form>

  <br/><br/>
  <a href="listUsers">List of Users</a>
  </body>
</html>
