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
<title>Piecemeal - Login</title>
</head>

<t:layout currentPage="Login">
<body>
	<h1 class='text-center'>Login</h1>

	<form:form action="/login" method="post" modelAttribute="loginUser">
		<p>
		<form:label path="email">Email:</form:label>
		<form:input type="email" path="email"/><br>
		<form:errors class="text-danger" path="email"/>
		</p>
	
		<p>
		<form:label path="password">Password:</form:label>
		<form:input type="password" path="password"/><br>
		<form:errors class="text-danger" path="password"/>
		</p>
	
		<input type="submit" value="Login"/>
	</form:form>

</body>
</t:layout>

</html>