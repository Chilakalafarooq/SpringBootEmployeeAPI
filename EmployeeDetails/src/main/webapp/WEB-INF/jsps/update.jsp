<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/update.css" />
</head>
<body>
    <h1>Update Employee</h1>
    <form action="${pageContext.request.contextPath}/employees/${employee.id}" method="POST">
        <input type="hidden" name="_method" value="PUT" />
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${employee.name}" required />
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${employee.email}" required />
        </div>
        <div>
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" value="${employee.department}" required />
        </div>
        <div>
            <label for="salary">Salary:</label>
            <input type="number" id="salary" name="salary" value="${employee.salary}" required />
        </div>
        <div class="actions">
            <button type="submit">Update</button>
            <a href="${pageContext.request.contextPath}/employees" class="btn-cancel">Cancel</a>
        </div>
    </form>
</body>
</html>
