<%@ page import="com.example.contactmanagementsystem.model.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/generalstyle.css">
</head>
<body>
    <%
        String contactName = "";
        String contactPhone = "";
        if (request.getSession().getAttribute("mode").equals("edit")) {
            contactName = (String) request.getAttribute("contactName");
            contactPhone = (String) request.getAttribute("contactPhone");
        }
    %>
    <h2>Edit ${contactName}</h2>
    <form action="edit" method="post">
        <label>Name:
            <input type="text" name="name" value="${contactName}" required>
        </label><br>

        <label>Phone:
            <input type="tel" name="phone" value="${contactPhone}">
        </label><br>

        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
