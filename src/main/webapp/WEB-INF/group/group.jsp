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
<title>Piecemeal - Group</title>
</head>
<t:layout currentPage="Group">
<body>
<c:choose>
	<c:when test="${group == null }">
	
	<h1 class='text-center'>Groups</h1>
	<p class='text-center'>You are not part of a group. <a href="/groups/new" class="fst-italic">Create one</a> or ask to be added to one.</p>
	<p class='text-center'><a href="/">Home</a></p>
	
	</c:when>
	<c:otherwise>
	
	<h1 class='text-center'><c:out value="${group.getName()}"/></h1>
	<p class='text-center fst-italic' >ordering every X weeks - next pickup by [name]</p>

	<p>todo: show current group details, order status and date, add or remove members if admin</p>

	<p>if selected as pickup person for order, and the date matches the pickup date, add "submit order" button. figure out payment.</p>

	<p>leave group button, small at the bottom. ask for confirmation.</p>
	</c:otherwise>
</c:choose>
</body>
</t:layout>
</html>