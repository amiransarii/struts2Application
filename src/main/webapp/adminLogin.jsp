<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>
body {
	text-align: center;
	position:absolute;
    width:300px;
    height:300px;
    background:#E6E6FA;
    bottom:70px;
    right:25%;
    left:50%;
    margin-left:-150px;
}


</style>
</head>
<body>
	<h2>Admin Login</h2>
	<s:form action="adminLoginprocess">
		<s:textfield name="adminEmail" label="Email"></s:textfield>
		<s:password name="adminPass" label="Password"></s:password>
		<s:submit value="Login"></s:submit>
	</s:form>

</body>
</html>