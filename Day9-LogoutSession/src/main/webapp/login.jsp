<%--
  Created by IntelliJ IDEA.
  User: *****
  Date: 7/31/25
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required
               value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <input type="submit" value="Login">
    </form>

    <p style="color:red;">
        <%= request.getParameter("error") != null ? request.getParameter("error") : "" %>
    </p>
</body>
</html>
