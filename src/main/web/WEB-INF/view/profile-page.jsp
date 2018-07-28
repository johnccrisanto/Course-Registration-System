<%@include file="header.jsp"%>

<div class="container">
    <h1>My Profile Page</h1>

    <div class="row">
        <div class="col-sm-6">
            <a href=""><img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/my_profile.jpg" style="max-width: 300px;"></a>
        </div>
        <div class="col-sm-6">
            <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/our_courses.png" style="max-width: 300px;">
        </div>
    </div>


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

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" class="btn btn-primary" value="Log out">
    </form:form>

</div>
<%@ include file="footer.jsp"%>