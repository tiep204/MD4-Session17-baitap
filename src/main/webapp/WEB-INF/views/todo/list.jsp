<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/14/2023
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST</title>
</head>
<body>
<h1>Danh sách công việc</h1>
<a href="/TodoController/add">Add</a>
<table colspan="10" cellspacing="10" cellpadding="10" >
    <thead>
    <tr>
        <th>STT</th>
        <th>Content</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="t" varStatus="item">
        <tr>
            <td>${item.count}</td>
            <td>${t.content}</td>
            <td>${t.status?"Hoàn thành":"Chưa hoàn thành"}</td>
            <td><a  href="/TodoController/edit/${t.id}">Edit</a></td>
            <td><a onclick="return confirm('Are you sure delete this item?')" href="/TodoController/delete/${t.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>