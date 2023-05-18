<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:if test="${empty member}">
	<a href="/login">Login</a>
	<a href="/sign-up">Join</a>
</c:if>
<c:if test="${not empty member}">
	<a href="#">Logout</a>	
	<a href="#">My Page</a>
</c:if>

</body>
</html>