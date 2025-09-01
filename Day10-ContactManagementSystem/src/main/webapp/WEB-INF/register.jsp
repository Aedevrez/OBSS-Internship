<%--
  Created by IntelliJ IDEA.
  User: *****
  Date: 8/1/25
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/generalstyle.css">
</head>
<body>
<main>
  <h2>Register'a hoş geldiniz</h2>
  <form action="register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required
           value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <input type="submit" value="Login">
  </form>
</main>
</body>
</html>
