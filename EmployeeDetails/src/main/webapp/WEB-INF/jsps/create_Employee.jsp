<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Employee</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>create_Employee.css" />
</head>
<body>
    <h1>Create Employee</h1>
    <form action="${pageContext.request.contextPath}/employees" method="POST">
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" id="name" name="name" /></td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><input type="text" id="email" name="email" /></td>
            </tr>
            <tr>
                <td><label for="department">Department:</label></td>
                <td><input type="text" id="department" name="department" /></td>
            </tr>
            <tr>
                <td><label for="salary">Salary:</label></td>
                <td><input type="text" id="salary" name="salary" /></td>
            </tr>
        </table>
        <input type="submit" value="Create" />
    </form>
</body>
</html>
