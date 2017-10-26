<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


            <form:form method="post" modelAttribute="test" action="save-test">
                <table  border="0" cellspacing="5" cellpadding="5">
                    <tr>
                        <td>Test's title</td>
                        <td><form:input path="name" /></td>
                        <td><form:errors path="name" class="has-error" /></td>
                    </tr>
                </table>
                <input type ="submit">
            </form:form>
