<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form method="post" action="del-user2">
    <table  border="0" cellspacing="5" cellpadding="5">
                
        <tr>
                    
            <td>
                <c:forEach var="user" items="${users}" >
                    <input type="checkbox" name="userId" value="${user.userId}" /> Name: ${user.name}, Login: ${user.login}<br />
                </c:forEach>    
            </td>
        </tr>
                
    </table>
    <button type="submit">Delete User</button>
</form>
