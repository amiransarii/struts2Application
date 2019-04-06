<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile</title>
<style>  
        body{  
        text-align: center;
         background:#E6E6FA;
        }  
    </style>  
</head>
<body>
Welcome to Admin Profile,<s:property value="#session.mAdminEmail" />|<jsp:include page="adminSuccessPage.jsp"></jsp:include>
</body>
</html>