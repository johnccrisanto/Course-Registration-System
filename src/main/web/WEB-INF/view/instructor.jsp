<%@ include file="header.jsp"%>
<h1>Instructor Page</h1>
<p>Welcome Back Instructor <security:authentication property="principal.username"></security:authentication> !</p>
<p>This page should only be available for users with a role of "INSTRUCTOR".</p>
<hr>
<a href="${pageContext.request.contextPath}/">Back to Home Page</a>

<%@ include file="footer.jsp"%>
