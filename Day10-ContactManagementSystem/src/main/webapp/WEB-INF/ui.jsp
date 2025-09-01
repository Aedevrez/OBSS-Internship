<%@ page import="java.util.List" %>
<%@ page import="com.example.contactmanagementsystem.model.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UI</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/generalstyle.css">
</head>
<body>
<main>

<h2><%=request.getSession().getAttribute("username")%> için Kullanıcı Arayüzü</h2>

<form action="user-interface" method="GET">
    <div class="search-container">
        <input type="text" placeholder="Search..." name="content">
        <button type="submit"><i class="search-button"></i></button>
    </div>
</form>

<ul>

        <%
            List<Contact> contacts = (List<Contact>) request.getSession().getAttribute("contacts");
            for (Contact contact : contacts) {
        %>
        <li>
            <%= contact.getName() %>
            <form action="user-interface" method="POST">
                <input type="hidden" name="contact" value="<%= contact.getId() %>"/>
                <input type="hidden" name="mode" value="edit"/>
                <button type="submit">Edit</button>
            </form>

            <form action="user-interface" method="POST">
                <input type="hidden" name="contact" value="<%= contact.getId() %>"/>
                <input type="hidden" name="mode" value="delete"/>
                <button type="submit">Delete</button>
            </form>
        </li>

        <%
            }
        %>



</ul>

<form action="user-interface" method="POST">
    <input type="hidden" name="mode" value="create"/>
    <button type="submit">Create</button>
</form>

<form action="logout" method="POST">
    <button type="submit" class="button">Logout</button>
</form>
</main>
</body>
</html>
