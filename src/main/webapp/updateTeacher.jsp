<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Update</title>
<style type="text/css">
body {
	text-align: center;
	background: #E6E6FA;
}
</style>
</head>
<body>
<s:property value="#session.mAdminEmail" />|
<jsp:include page="adminSuccessPage.jsp"></jsp:include><br>

<h2>Update Record of Selected Teacher</h2>
<form action=updateTeacherRecord method="post">
		<pre>
<b>First Name:         </b><input type="text" name="tFirstName" value='<s:property value="tFirstName"/>'>

<b>Last Name:         </b><input type="text" name="tLastName" value='<s:property value="tLastName"/>'>

<b>User Name:         </b><input type="text" name="tUserName" value='<s:property value="tUserName"/>'>

<b>Mobile Number:         </b><input type="text" name="tMobileNumber" value='<s:property value="tMobileNumber"/>'>
		
<b>Email:        </b><input type="email"  name="tEmail" value='<s:property value="tEmail"/>'>
		            <input type="hidden" name="tEmailhidden" value='<s:property value="tEmail"/>'>	
		
		<button name="submitType" value="update" type="submit">Update</button>
		</pre>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="updateMsg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="updateMsg" /></span>
	</s:else>
</body>
</html>