<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 11/8/2020
  Time: 2:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table id="coordinates-table" border="1" width="100%" cellpadding="5">
    <thead>
    <tr>
        <th style="text-align: center">X</th>
        <th>Y</th>
        <th>R</th>
        <th>RESULT</th>
        <th>TIME</th>
        <th>BENCHMARK</th>
    </tr>
    </thead>
    <c:forEach items="${pointsArray}" var="point">
        <tr>
            <td> ${point.x}</td>
            <td> ${point.y}</td>
            <td> ${point.r}</td>
            <td> ${point.result}</td>
            <td> ${point.currentDate}</td>
            <td> ${point.time} ms</td>
        </tr>
    </c:forEach>
</table>
