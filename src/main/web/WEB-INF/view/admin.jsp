<%@ include file="header.jsp" %>
<div class="container">
    <h2 class="text-secondary">Welcome to the Admin Page!</h2>

    <h4 class="text-secondary" style="margin-top: 20px;">This page should only be available for users with a role of
        "ADMIN".
    </h4>

    <h4 class="text-secondary" style="margin-bottom: 30px">Please click on either the <em>'View List of Courses'</em> or
        <em>'Add a New Course'</em> link below.</h4>

    <a href="viewListOfCourses">
        <button class="btn btn-info">View List of Courses</button>
    </a>

    <a style="margin-left: 20px;" href="addNewCoursePage">
        <button class="btn btn-info">Add a New Course</button>
    </a>
    <hr>
    <p>
        <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
    </p>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" class="btn btn-primary" value="Log out">
    </form:form>
</div>
<%@ include file="footer.jsp" %>
