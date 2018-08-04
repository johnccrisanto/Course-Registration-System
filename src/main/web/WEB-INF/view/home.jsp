<%@include file="header.jsp" %>

<div class="container">

    <h2 class="text-secondary">Welcome to the Course Registration System!</h2>

    <h4 class="text-secondary" style="margin-top: 20px;">Please click on the images below to either navigate to your profile page or to view the list of courses.
    </h4>



    <div class="row">
        <div class="col-sm-6">
            <img id="myProfileImg" class="img-fluid" src="${pageContext.request.contextPath}/resources/img/my_profile.jpg"
                             style="max-width: 300px; margin-top: 30px;">
        </div>

        <div class="col-sm-6">
            <img id="coursesImg" class="img-fluid" src="${pageContext.request.contextPath}/resources/img/our_courses.png"
                             style="max-width: 300px;">
        </div>
    </div>

    <div class="registrationMessage" style="margin-bottom: 20px;">

    </div>

    <div class="course_data">

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
<%@ include file="footer.jsp" %>