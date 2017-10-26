<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div>${question.test.name}</div>
<form:form method="post" modelAttribute="question" action="choose-ans">
    <table  border="0" cellspacing="5" cellpadding="5">
        <tr>
            <td>Question</td>
            <td><form:input path="question" /></td>
            <td><form:errors path="question" class="has-error" /></td>
        </tr>
        
        <tr>
            <td>Answers (write using "--" between answers)</td>
            <td><form:input path="answer" /></td>
            <td><form:errors path="answer" class="has-error" /></td>
        </tr>
        
        <tr>
            <td>Test</td>
            <td><input type=text READONLY name="testName" value="${question.test.name}"/></td>
            
        </tr>
    </table>
    <button type="submit">Add Question and choose right Answer</button>
</form:form>
