<%@ include file="header.jsp"%>

<div class="container">


    <h2 class="text-secondary">Add New Course</h2>

    <form:form action="processAddNewCourse" method="post">
        <c:if test="${addNewCourseError}">
            <div>
                <p>
                    <span style="color: #ff0000; font-weight: bold; font-style: italic;">The course name provided already exists. <br/>Please provide a different course name.</span>
                </p>
            </div>
        </c:if>

        <c:if test="${addSuccess}">
            <div>
                <p>
                    <span style="color: #00ff00; font-weight: bold; font-style: italic;">The course was successfully added.</span>
                </p>
            </div>
        </c:if>

        <div class="form-group">
            <label>Course Name</label>
            Course Name: <input class="form-control" id="courseName" name="name" value="${course.name}" type="text" size="30" placeholder="Course name..." required="required">
            <span id="errorCourseName" style="color: #ff0000; font-weight: bold; font-style: italic;"></span>
        </div>

        <div class="form-group">
            Course Instructor Name: <input class="form-control" name="instructorName" value="${course.instructorName}"type="text" size="30" placeholder="Instructor name..." required="required">
        </div>

        <div class="form-group">
            Course Start Date: <input class="form-control" name="startDate" value="${course.startDate}" type="date" placeholder="Start date..." required="required">
            <span id="errorEmail" style="color: #ff0000; font-weight: bold; font-style: italic;"></span>
        </div>

        <div class="form-group">
            Course End Date: <input class="form-control" name="endDate" value="${course.endDate}" type="date" placeholder="End date..." required="required">
        </div>

        <div class="form-group">
            Course Enrollment Limit: <input class="form-control" name="enrollmentLimit" value="${course.enrollmentLimit}" type="number" min="0" size="30" placeholder="Enrollment limit...">
        </div>

        <div class="form-group">
            Course Number Enrolled: <input class="form-control" name="numberEnrolled" value="${course.numberEnrolled}" type="number" min="0" size="30" placeholder="Number enrolled...">
        </div>

        <div class="form-group">
            Course Description: <textarea class="form-control" name="description" rows="10" cols="30" placeholder="Course description..." required="required">${course.description}</textarea>
        </div>

        <input type="submit" value="Submit" class="btn btn-primary">
    </form:form>

    <hr>

    <p>
        <a href="${pageContext.request.contextPath}/admin/">Back to Admin Home Page</a>
    </p>
</div>
<%@ include file="footer.jsp"%>
