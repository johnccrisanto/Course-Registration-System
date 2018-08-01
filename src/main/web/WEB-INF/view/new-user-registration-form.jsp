<%@ include file="header.jsp"%>
<div class="container">


    <h2 class="text-secondary">New User Registration Form</h2>

    <form:form action="processNewUserRegistration" method="post" modelAttribute="newUser">

        <c:if test="${registrationError}">
            <div class="alert alert-danger" style="margin-top: 20px; padding-top: 20px; text-align: center;">
                <p>The username provided already exists.<br/>Please provide a different username.</p>
            </div>
        </c:if>

        <div class="form-group">
            <label for="username">Desired Username:</label>
            <form:input cssClass="form-control" id="username" path="username" type="text" size="30" placeholder="Desired username..." required="required"></form:input>
            <span id="errorUsername" style="color: #ff0000; font-weight: bold; font-style: italic;"></span>
        </div>

        <div class="form-group">
            <label for="password">Desired Password:</label>
            <form:input cssClass="form-control" id="password" path="password" type="password" size="30" placeholder="Desired password..." required="required"></form:input>
        </div>

        <div class="form-group">
            <label for="matchingPassword">Confirm Username:</label>
            <form:input cssClass="form-control" id="matchingPassword" path="matchingPassword" type="password" size="30" placeholder="Confirm password..." required="required"></form:input>
        </div>

        <div class="form-group">
            <label for="email">Email Address:</label>
            <form:input cssClass="form-control" id="email" path="email" type="email" size="30" placeholder="Your email..." required="required"></form:input>
            <span id="errorEmail" style="color: #ff0000; font-weight: bold; font-style: italic;"></span>
        </div>

        <div class="form-group">
            <label for="firstName">First Name:</label>
            <form:input cssClass="form-control" id="firstName" path="firstName" type="text" size="30" placeholder="Your first name..." required="required"></form:input>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <form:input cssClass="form-control" id="lastName" path="lastName" type="text" size="30" placeholder="Your last name..."></form:input>
        </div>

        <input type="submit" value="Register" class="btn btn-primary">
    </form:form>

    <hr>
    <p>
        <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
    </p>
</div>

<%@ include file="footer.jsp"%>
