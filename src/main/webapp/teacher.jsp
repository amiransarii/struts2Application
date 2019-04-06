<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher</title>
<style>
body {
	text-align: center;
	position: absolute;
	width: 600px;
	height: 300px;
	background: #E6E6FA;
	top: 3px;
	right: 25%;
	left: 50%;
	margin-left: -150px;
}
</style>
</head>
<body>
	<s:form action="teacherRegistration" method="POST" enctype="multipart/form-data">
		<s:select cssStyle="width:155px;" list="{'Teacher','Student'}"
			name="registrationType" label="Registration Type"></s:select>
		<s:textfield name="tFirstName" label="First Name"></s:textfield>
		<s:textfield name="tLastName" label="Last Name"></s:textfield>
		<s:textfield name="tUserName" label="User Name"></s:textfield>
		<s:textfield name="tEmail" label="Email ID"></s:textfield>
		<s:password name="tPassword" label="Password"></s:password>
		<s:password name="tCPassword" label="Confirm Password"></s:password>
		<s:textfield name="tMobileNumber" label="Mobile Number"></s:textfield>
		<s:textfield name="tSalary" label="Salary"></s:textfield>
		<s:radio list="{'Male','Female'}" name="tGender" label="Gender"></s:radio>
		<s:select cssStyle="width:155px;"
			list="{'Mr','Mrs','Professor','Senior Professor'}"
			name="tDesignation" label="Designation"></s:select>
		<s:textarea label="Address" name="tAddress" cols="40" rows="10" />
		<s:file name="image" label="Select Image" />
		<s:submit value="Registration"></s:submit>
	</s:form>
	<s:if test="ctr>0">
		<span style="color: green;"><s:property value="savedMsg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="savedMsg" /></span>
	</s:else>
	
</body>
</html>