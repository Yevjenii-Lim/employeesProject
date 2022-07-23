<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yevheniilim
  Date: 7/22/22
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new emp</title>
</head>
<body>
<h2>ADD NEW EMP</h2>

<form:form action="save-emp" modelAttribute="employee">

    <form:hidden path="id"/>
    name:
    <form:input path="name"></form:input>

    <br>

    surname:
    <form:input path="surname"></form:input>

    <br>

    salary:
    <form:input path="salary"></form:input>
    <br>
    dep:
    <form:input path="department"></form:input>

    <input  type="submit" value="add" ></input>

</form:form>
</body>
</html>
