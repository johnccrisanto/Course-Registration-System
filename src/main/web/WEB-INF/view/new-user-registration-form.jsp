<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 7/25/2018
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New User Registration Page</title>

</head>
<body>
    <h1>New User Registration Form</h1>

    <form:form action="processNewUserRegistration" method="post" modelAttribute="newUser">

        <c:if test="${registrationError}">
            <div>
                <p>
                    <span style="color: #ff0000; font-weight: bold; font-style: italic;">The username provided already exists. <br/>Please provide a different username.</span>
                </p>
            </div>
        </c:if>
        <p>
            Desired Username: <form:input id="username" path="username" type="text" size="30" placeholder="Desired username..." required="required"></form:input>
            <span id="errorUsername" style="color: #ff0000; font-weight: bold; font-style: italic;"></span>
        </p>

        <p>
            Desired Password: <form:input path="password" type="password" size="30" placeholder="Desired password..." required="required"></form:input>
        </p>

        <p>
            Confirm Password: <form:input path="matchingPassword" type="password" size="30" placeholder="Confirm password..." required="required"></form:input>
        </p>

        <p>
            Email Address: <form:input id="email" path="email" type="email" size="30" placeholder="Your email..." required="required"></form:input>
            <span id="errorEmail" style="color: #ff0000; font-weight: bold; font-style: italic;"></span>
        </p>

        <p>
            First Name: <form:input path="firstName" type="text" size="30" placeholder="Your first name..." required="required"></form:input>
        </p>

        <p>
            Last Name: <form:input path="lastName" type="text" size="30" placeholder="Your last name..."></form:input>
        </p>

        <input type="submit" value="Register">
    </form:form>

    <script src="${pageContext.request.contextPath}/resources/vendors/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</body>
</html>
