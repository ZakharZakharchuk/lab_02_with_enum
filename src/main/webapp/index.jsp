<%--
  Created by IntelliJ IDEA.
  User: zahar
  Date: 14.03.2022
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input:placeholder-shown {
            border: 2px red;
        }
    </style>
</head>
<body>
<form action="calculate" method="get">
    Параметр a:<br>
    <input type="number" name="a" placeholder=" " value="${sessionScope.get("a")}" required><br>
    Параметр b:<br>
    <input type="text" name="b" placeholder=" " value="${sessionScope.get("b")}" required><br>
    Параметр c:<br>
    <input type="text" name="c" placeholder=" " value="${sessionScope.get("c")}" required><br>
    Параметр d:<br>
    <input type="text" name="d" placeholder=" " value="${sessionScope.get("d")}" required><br>
    <input type="submit" value="Calculate">
</form>
</body>
</html>
