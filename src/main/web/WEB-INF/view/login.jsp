<%@ include file="header.jsp" %>

<div class="container center_div">

    <div class="text-center">
        <img src="${pageContext.request.contextPath}/resources/img/logo.jpg" class="img-responsive" width="100">
    </div>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
               method="post">

        <!-- Check for login error -->
        <c:if test="${param.error != null}">
            <div class="alert alert-danger" style="margin-top: 20px; padding-top: 20px; text-align: center;">
                <p>The username and password provided did not match.</p>
            </div>
        </c:if>

        <c:if test="${param.logout != null}">
            <div class="alert alert-success" style="margin-top: 20px; padding-top: 20px; text-align: center;">
                <p>You have been successfully logged out.</p>
            </div>
        </c:if>

        <div class="form-group">
            <label for="usernameLogin">Username</label>
            <input id="usernameLogin" name="username" class="form-control" placeholder="Username..." type="text">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" placeholder="Password..." type="password">
        </div>

        <input type="submit" class="btn btn-primary" value="Log In" style="width: 100%;">
    </form:form>

    <p style="color: #999999; text-align: center; margin-top: 20px;">Are you a new user?</p>

    <div style="text-align: center; margin-top: 20px">
        <a href="${pageContext.request.contextPath}/register/newUserRegistrationPage">
            <button class="btn btn-info">Create Account</button>
        </a>
    </div>

    <p style="margin-top: 20px; text-align: center;">&copy;2018-2019 </p>

</div>


<%@ include file="footer.jsp" %>