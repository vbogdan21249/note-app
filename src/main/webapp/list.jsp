<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Note" %><%--
  Created by IntelliJ IDEA.
  User: vbogd
  Date: 13.06.2024
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Notes</title>
</head>
<body>
<h1>List of Notes</h1>
<ul>
    <% for (Note note : (List<Note>) request.getAttribute("notes")) { %>
    <li><strong><%= note.getTitle() %></strong>: <%= note.getContent() %></li>
    <% } %>
</ul>
<p><a href="<%= request.getContextPath() %>/notes/add">Add a New Note</a></p>
</body>
</html>
