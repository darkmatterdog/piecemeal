<%@ tag language="java" description="Main page layout" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
<%@ attribute name="user" required="false"%>
<%@ attribute name="currentPage" required="true"%>

<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Piecemeal</title>
</head>


<nav class ="navbar navbar-expand-lg navbar-dark p-1 mb-4 sticky-top" id="pageheader" style="background-color: darkgreen">
	<a class="navbar-brand" href="/">Piecemeal</a>
	<div class="collapse navbar-collapse m-1" id="navbarSupportedContent">
		<ul class="navbar-nav">
			<li class="nav-item">
				<c:choose>
					<c:when test="${currentPage == \"Home\"}"><a class="nav-link active" href="/">Home</a></c:when>
					<c:otherwise><a class="nav-link" href="/">Home</a></c:otherwise>
				</c:choose>
			</li>
			<li class="nav-item">
				<c:choose>
					<c:when test="${currentPage == \"Order\"}"><a class="nav-link active" href="/order">Order</a></c:when>
					<c:otherwise><a class="nav-link" href="/order">Order</a></c:otherwise>
				</c:choose>
			</li>
			<li class="nav-item">
				<c:choose>
					<c:when test="${currentPage == \"Group\"}"><a class="nav-link active" href="/group">Group</a></c:when>
					<c:otherwise><a class="nav-link" href="/group">Group</a></c:otherwise>
				</c:choose>
			</li>
			<li class="nav-item">
				<c:choose>
					<c:when test="${currentPage == \"About\"}"><a class="nav-link active" href="/about">About</a></c:when>
					<c:otherwise><a class="nav-link" href="/about">About</a></c:otherwise>
				</c:choose>
			</li>
		</ul>
	</div>
	<div>
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${user == null}">
					<li class="nav-item">
					<c:choose>
						<c:when test="${currentPage == \"Login\"}"><a class="nav-link active" href="/login">Login</a></c:when>
						<c:otherwise><a class="nav-link" href="/login">Login</a></c:otherwise>
					</c:choose>
					</li>
						
					<li class="nav-item">
					<c:choose>
							<c:when test="${currentPage == \"Register\"}"><a class="nav-link active" href="/register">Register</a></c:when>
							<c:otherwise><a class="nav-link" href="/register">Register</a></c:otherwise>
					</c:choose>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">	
					<c:choose>
						<c:when test="${currentPage == \"Account\"}"><a class="nav-link active" href="/"><c:out value="${user.getHouseName()}"/></a></c:when>
						<c:otherwise><a class="nav-link" href="/account"><c:out value="${user.getHouseName()}"/></a></c:otherwise>
					</c:choose>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/logout">Logout</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>	
	</div>
	<jsp:invoke fragment="header"/>
</nav>

<div id="body" class="container">
	<jsp:doBody/>
</div>

<div id="pagefooter">
	<jsp:invoke fragment="footer"/>
</div>