<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<title>Delete</title>
<style type="text/css">
body {
	text-align: center;
	background: #E6E6FA;
}
</style>
</head>
<body>
<s:property value="#session.mAdminEmail" />|
<jsp:include page="adminSuccessPage.jsp"></jsp:include><br><br>
	<span><s:property value="deleteMsg" /></span><
</body>
</html>