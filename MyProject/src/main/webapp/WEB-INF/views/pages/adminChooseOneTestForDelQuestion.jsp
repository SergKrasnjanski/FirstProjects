<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Choose test</h3>
<form method="post" action="del-quest2">
    <table  border="0" cellspacing="5" cellpadding="5">
                
        <tr>
                    
            <td>
                <c:forEach var="test" items="${tests}" >
                    <input type="radio" name="testId" value="${test.testId}" /> ${test.name}<br />
                </c:forEach>    
            </td>
        </tr>
                
    </table>
    <button type="submit">Choose Test</button>
</form>