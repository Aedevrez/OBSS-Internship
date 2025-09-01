<%--
  Created by IntelliJ IDEA.
  User: *****
  Date: 7/31/25
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/generalstyle.css">
</head>
<body>
<main>
<h2>Login'e hoş geldiniz</h2>
<form action="login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required
           value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <input type="submit" value="Login">
</form>

<% if (request.getAttribute("error") != null) { %>
    <p style="color:red;">Invalid username or password.</p>
<% } %>
</main>
</body>
</html>
