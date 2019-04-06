<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Success</title>
<style type="text/css">
body {
	text-align: center;
	background: #E6E6FA;
}
.errorMessage{color:red;}  

</style>
</head>
<body>
	<s:property value="#session.mAdminEmail" />|
	<jsp:include page="adminSuccessPage.jsp"></jsp:include>
	<br><br>
<jsp:include page="teacher.jsp"></jsp:include>

</body>
</html>