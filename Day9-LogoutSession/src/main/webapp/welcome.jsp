<%--
  Created by IntelliJ IDEA.
  User: *****
  Date: 7/31/25
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome <%= session.getAttribute("username")%>!</h2>
    <p>You have successfully logged in to the system.</p>
    <a href="logout">Logout</a>
</body>
</html>
