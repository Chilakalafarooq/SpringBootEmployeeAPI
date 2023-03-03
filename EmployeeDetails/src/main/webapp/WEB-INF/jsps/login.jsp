<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required />
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required />
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
    <c:if test="${not empty error}">
        <p class="error">Invalid username or password.</p>
    </c:if>
    <c:if test="${not empty logout}">
        <p class="logout">You have been logged out.</p>
    </c:if>
</body>
</html>
