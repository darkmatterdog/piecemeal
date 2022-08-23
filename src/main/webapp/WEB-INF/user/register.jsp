<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Piecemeal - Register</title>
</head>

<t:layout currentPage="Register">
<body>
	<h3>Register</h3>
	<form:form action="/register" method="post" modelAttribute="newUser">
		
		<p>
		<form:label path="email">Email:</form:label>
		<form:input type="email" path="email"/><br>
		<form:errors class="text-danger" path="email"/>
		</p>

		<p>
		<form:label path="houseName">House Name:</form:label>
		<form:input path="houseName"/><br>
		<form:errors class="text-danger" path="houseName"/>
		</p>
		
	
		<p>
		<form:label path="password">Password:</form:label>
		<form:input type="password" path="password"/><br>
		<form:errors class="text-danger" path="password"/>
		</p>
		
		<p>
		<form:label path="confirm">Confirm Password:</form:label>
		<form:input type="password" path="confirm"/><br>
		<form:errors class="text-danger" path="confirm"/>
		</p>
	
		<input type="submit" value="Register"/>
	</form:form>
</body>
</t:layout>
</html>