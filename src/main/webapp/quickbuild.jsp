<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hvore
  Date: 06-05-2022
  Time: 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Byg selv carport</title>
</head>
<body>

<form action="fc/register" method="post">
    <input type="hidden" name="command" value="quickbuild"/>
    <label for="width">Bredde:</label><br>
    <select id="width" name="width" placeholder="Vælg bredde">
        <c:forEach items="${applicationScope.widthArrayList}" var="items">
            <option value="${item.width}">
            </option>
        </c:forEach>
    </select><br>
    <label for="length">Længde:</label><br>
    <select id="length" name="length" placeholder="Vælg længde">
        <c:forEach items="${applicationScope.lengthArrayList}" var="items">
            <option value="${item.length}">
            </option>
        </c:forEach>
    </select><br>
    <label for="roof">Tag:</label><br>
    <select id="roof" name="roof" placeholder="Vælg tagtype">
        <c:forEach items="${applicationScope.roofArrayList}" var="items">
            <option value="${item.roof}">
            </option>
        </c:forEach>
    </select><br>
    <label for="shedwidth">Redskabsrum bredde:</label><br>
    <select id="shedwidth" name="shedwidth" placeholder="Ønsker ikke redskabsskur">
        <c:forEach items="${applicationScope.shedArrayList}" var="items">
            <option value="${item.shedwidth}">
            </option>
        </c:forEach>
    </select><br>
    <label for="shedlength">Redskabsrum længde:</label><br>
    <select id="shedlength" name="shedlength" placeholder="Ønsker ikke redskabsskur">
        <c:forEach items="${applicationScope.shedArrayList}" var="items">
            <option value="${item.shedlength}">
            </option>
        </c:forEach>
    </select><br>
</form>
</body>
</html>
