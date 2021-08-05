<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="Style.css">


</head>
<body>

<div class="center">
		<h1>Sign Up</h1>
			<form action="Register"  method="POST" >
			<div class="txt_field"><input type="text" name="name" required>	<label>Full Name</label></div>
			<div class="txt_field"><input type="text" name="email" required>	<label>E-mail</label></div>
			<div class="txt_field"><input type="password" name="password" required><label>Password</label></div>
			<div class="txt_field"><input type="txt_field" name="phoneno" required><label>phoneno</label></div>
			<input type="submit" value="Register">
	<br>
	<br>
	
	</form>
	</div>
</body>
</html>