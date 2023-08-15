<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Todo</title>
</head>
<body>
<h2>Add Todo</h2>
<form action="/TodoController/save" method="post">
    <label for="content">Content:</label>
    <input type="text" id="content" name="content"><br>

    <label for="status">Status:</label>
    <select id="status" name="status">
        <option value="true">Hoạt động</option>
        <option value="false">Not Hoạt động</option>
    </select><br>
    <input type="submit" value="save">
</form>
</body>
</html>

