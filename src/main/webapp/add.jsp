<%@ page import="model.Note" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: vbogd
  Date: 13.06.2024
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Note</title>
</head>
<body>
<h1>Add New Note</h1>
<form action="<%= request.getContextPath() %>/notes/add" method="post">
    <label>Title: <input type="text" name="title" required></label><br>
    <label>Content: <textarea name="content" rows="4" required></textarea></label><br>
    <input type="submit" value="Add Note">
</form>
<p><a href="<%= request.getContextPath() %>/notes">Back to Notes List</a></p>
</body>
</html>