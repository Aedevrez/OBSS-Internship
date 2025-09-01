<%--
  Created by IntelliJ IDEA.
  User: *****
  Date: 7/30/25
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.TextStyle" %>
<%@ page import="java.util.Locale" %>

<%
  String today = LocalDate.now()
          .getDayOfWeek()
          .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
%>

<p>We're dynamically importing the day: <%= today %> with this one.</p>
