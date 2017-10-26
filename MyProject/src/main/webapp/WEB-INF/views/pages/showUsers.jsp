<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h2>All Users</h2>
 
        <table border="1">
            <tr>
                <th>User Id</th>
                <th>Name</th>
                <th>Login</th>
                <th>Result</th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.login}</td>
                    <td>${user.testResult}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
