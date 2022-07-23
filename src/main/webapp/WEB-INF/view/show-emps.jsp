<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yevheniilim
  Date: 7/20/22
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emps</title>
</head>
<body>
<h2>is this right file world</h2>

<p>bye!</p>
<table>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>dep</th>
        <th>sal</th>
        <th>operations</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}">
        <c:url var="updateBtn" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"></c:param>
        </c:url>
        <c:url var="deleteBtn" value="/deleteEmp">
            <c:param name="empId" value="${emp.id}"></c:param>
        </c:url>
        <c:url var="deleteBtnWithId" value="/deleteEmpWithId">
            <c:param name="empId" value="${emp.id}"></c:param>
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" onclick="window.location.href='${updateBtn}'" value="Update"/>
                <input type="button" onclick="window.location.href='${deleteBtn}'" value="Delete"/>
                <input type="button" onclick="window.location.href='${deleteBtnWithId}'" value="Delete with id"/>

            </td>

        </tr>
    </c:forEach>


</table>
<a href="/add-new-emp">go to add page</a>
</body>
</html>
