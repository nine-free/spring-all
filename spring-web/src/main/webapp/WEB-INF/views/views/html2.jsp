<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>My HTML View</title>
</head>
<body>
<div class="success">
	<h3>name: "${user.name}"</h3>
	<h3>age : "${user.age}"</h3>
</div>
</body>
</html>