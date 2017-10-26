<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div>
    <h2>Enter your login and password</h2>
            <form:form method="post" modelAttribute="user" action="valid">
                <table  border="0" cellspacing="5" cellpadding="5">
                    <tr>
                        <td>Login</td>
                        <td><form:input path="login" /></td>
                        <td><form:errors path="login" class="has-error" /></td>
                    </tr> 
                    <tr>
                        <td>Password</td>
                        <td><form:password path="password" /></td>
                        <td><form:errors path="password" class="has-error" /></td>
                    </tr>
                </table>
                <input type ="submit">
            </form:form>
</div>
