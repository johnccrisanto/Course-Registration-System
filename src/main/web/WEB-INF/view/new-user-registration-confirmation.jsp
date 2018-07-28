<%@ include file="header.jsp"%>
    <h1>New User Registration Confirmation Page</h1>

    <p>You have submitted the following information.</p>
    <p>Username: ${newUser.username}</p>
    <p>Password: ${newUser.password}</p>
    <p>Email Address: ${newUser.email}</p>
    <p>First Name: ${newUser.firstName}</p>
    <p>Last Name: ${newUser.lastName}</p>
<%@ include file="footer.jsp"%>
