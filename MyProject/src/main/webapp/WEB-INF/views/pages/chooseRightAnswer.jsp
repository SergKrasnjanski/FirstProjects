<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Choose Right answer</h3>
<div>${question.question}</div>
<form method="post" action="choose-rightAns">
    <table  border="0" cellspacing="5" cellpadding="5">
                
        <tr>
                    
            <td>
                <c:forEach var="ans" items="${answer}" >
                    <input type="radio" name="answerId" value="${ans.answerId}" /> ${ans.answer}<br />
                </c:forEach>    
            </td>
        </tr>
                
    </table>
    <button type="submit">Complete changes</button>
</form>
