<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%	String username = (String) request.getAttribute("username");%>
    <%	String id = (String) request.getAttribute("id");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Azure Demo </title>
</head>
<body>
	<h1> Hello <%= username %>, your id is <%= id %>  </h1>
</body>
</html>