<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div>Test "${test.name}"</div>
<form method="post" action="delete-questions">
    <table  border="0" cellspacing="5" cellpadding="5">   
        <tr> 
            <td>
                <c:forEach var="question" items="${questions}" >
                    <input type="checkbox" name="questionId" value="${question.questionId}" /> ${question.question}<br />
                </c:forEach>    
            </td>
        </tr>     
    </table>
    <button type="submit">Delete Questions</button>
</form>
        
