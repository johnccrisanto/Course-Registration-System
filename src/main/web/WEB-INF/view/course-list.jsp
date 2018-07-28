<%@ include file="header.jsp" %>
<div class="container">
    <h2 class="text-secondary" style="margin-bottom: 30px;">List of Courses</h2>

    <a href="addNewCoursePage">
        <button class="btn btn-primary">Add a New Course</button>
    </a>
    <br/></br>

    <c:if test="${deleteSuccess}">
        <div>
            <p>
                <span style="color: #00ff00; font-weight: bold; font-style: italic;">The course was successfully deleted.</span>
            </p>
        </div>
    </c:if>
    <table class="table table-striped table-hover table-condensed table-bordered table-responsive">
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Instructor Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Enrollment Limit</th>
            <th>NumberEnrolled</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="course" items="${courses}">

            <c:url var="updateLink" value="/admin/showAddNewFormForUpdate">
                <c:param name="courseId" value="${course.id}"></c:param>
            </c:url>

            <c:url var="deleteLink" value="/admin/deleteCourse">
                <c:param name="courseId" value="${course.id}"></c:param>
            </c:url>

            <tr>
                <td>${course.name}</td>
                <td>${course.description}</td>
                <td>${course.instructorName}</td>
                <td>${course.startDate}</td>
                <td>${course.endDate}</td>
                <td>${course.enrollmentLimit}</td>
                <td>${course.numberEnrolled}</td>
                <td><a href="${updateLink}"><i class="fas fa-pencil-alt"></i></a></td>
                <td><a href="${deleteLink}"><i class="fa fa-times" aria-hidden="true"></i></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <hr>

    <p>
        <a href="${pageContext.request.contextPath}/admin/">Back to Admin Home Page</a>
    </p>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" class="btn btn-primary" value="Log out">
    </form:form>
</div>
<%@ include file="footer.jsp" %>
