<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div>
    <h3>User ${user.login} answered on ${user.testResult}% questions.</h3>
    <br/>
    <a href="startPage"><h3>Return to Start Page</h3></a>
</div>

