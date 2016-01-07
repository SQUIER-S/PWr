<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SQUIER
  Date: 2015-12-21
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Note</title>
</head>
<body>
${noteAdded}
<br>
<h1>Add your note here!</h1>

<form:form action="/notes/saveNote" method="post">
    <div style="width: 650px">
        <h3>Note title:<br></h3>
        <input name="title" class="form-control"/>
    </div>
    <div style="width: 650px">
        <h3>Note content:<br></h3>
        <textarea name="content" class="form-control" rows="10"></textarea>
    </div>
    <div style="width: 650px; text-align: center">
        <input type="submit" value="Add note">
    </div>

</form:form>

</body>
</html>
