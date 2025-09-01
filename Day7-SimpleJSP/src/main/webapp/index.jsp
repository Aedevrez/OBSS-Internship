<%@ page import="java.util.Random" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String name = "Adem";
    int age = 22;

    Random rand = new Random();
    ArrayList<Integer> randArray = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        randArray.add(rand.nextInt(100) + 1);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="hello-servlet">Hello Servlet</a>

<h2>Name: <%=name%></h2>
<h2>Age: <%=age%></h2>

<h3>Random numbers for you!</h3>
<ul>
    <% for (Integer integer: randArray) { %>
            <li><%=integer%></li>
    <% } %>
</ul>
</body>
</html>