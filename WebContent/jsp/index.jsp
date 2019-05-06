<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Header -->
	<header>
	    <!-- Menu Bar -->
	    <div class="menubar">
	    	<div class="formbox">
		    	<form action="AuthenticationController" method="post"> 
		    		<input type="text" name="username" class="try" placeholder="Username.." tabindex="1"> 
		    		<input type="password" name="password" class="try" placeholder="Password.." tabindex="2">
		    		<input type="submit" value="Log in" name="login" tabindex="3">
					<input type="submit" value="Sign in" tabindex="4">
				</form>
			</div>
	    </div>
	</header>
</body>
</html>