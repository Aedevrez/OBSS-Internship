<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%@ include file="header.jsp" %>

<jsp:include page="message.jsp" />

<%
    RequestDispatcher dispatcher = request.getRequestDispatcher("/time-servlet");
    dispatcher.include(request, response);
%>

<%=request.getAttribute("timeContent")%>

</body>
</html>