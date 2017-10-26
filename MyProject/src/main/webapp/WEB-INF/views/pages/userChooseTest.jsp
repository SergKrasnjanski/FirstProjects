<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>
            Select test!
        </h3>
        <form method="post" action="choise-test-user">
            <table  border="0" cellspacing="5" cellpadding="5">
                
                <tr>
                    
                    <td>
                            <c:forEach var="test" items="${tests}" >
                                <input type="radio" name="testId" value="${test.testId}" /> ${test.name}<br />
                            </c:forEach>
                        
                    </td>
                </tr>
                
            </table>
            <button type="submit">Start!</button>
        </form>
    </body>
</html>
