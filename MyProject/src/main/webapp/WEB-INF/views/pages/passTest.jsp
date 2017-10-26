<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div><h3>${test.name}</h3></div>

<form method="post" action="counting">
    <table  border="0" cellspacing="5" cellpadding="5"> 
        <tr>   
            <td>
                <c:forEach var="question" items="${questions}" >
                    <c:out value="${question.question}" /><br />
                    <c:forEach var="answer" items="${answers}" >
                        <c:if test="${answer.question.questionId == question.questionId}">
                            <input type="radio" name="${question.questionId}" value="${answer.answerId}" /> ${answer.answer}<br />
                        </c:if>
                    </c:forEach>
                </c:forEach>
                    
            </td>
        </tr>
                
    </table>
    <button type="submit">Complete changes</button>
</form>
