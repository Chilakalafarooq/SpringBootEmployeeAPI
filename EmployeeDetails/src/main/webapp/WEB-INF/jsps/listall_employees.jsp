
	<%@ pagelanguage=" language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>List of Employees</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>listall_employees.css" />
    
</head>
<body>
    <h1>List of Employees</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Action</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/${employee.id}" class="btn-edit">Edit</a>
                    <form action="${pageContext.request.contextPath}/employees/${employee.id}" 
                    method="POST" style="display: inline-block;">
                        <input type="hidden" name="_method" value="DELETE" />
                        <button type="submit" class="btn-delete">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="actions">
        <a href="${pageContext.request.contextPath}/employees/new" class="btn-add">Add Employee</a>
    </div>
</body>
</html>