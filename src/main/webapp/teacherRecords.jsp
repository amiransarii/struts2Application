<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Teacher Record</title>
<style>
table, td, th {border: 1px solid black;}
table {border-collapse: collapse;width: 60%;}
th {height: 30px;}
.button-update {background-color: #008CBA;color: white;}
.button-delete {background-color: red;color: white;}

body {
	text-align: center;
	background: #E6E6FA;
}

</style>
</head>
<body>
<s:property value="#session.mAdminEmail" />|
<jsp:include page="adminSuccessPage.jsp"></jsp:include><br>
	<h2>Registered Teacher </h2>
	<div style="margin-top: 40px;">
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Sr.No.</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>User Name</th>
						<th>Email ID</th>
						<th>Password</th>
						<th>Confirm Password</th>
						<th>Mobile Number</th>
						<th>Salary</th>
						<th>Gender</th>
						<th>Designation</th>
						<th>Address</th>
						<th>Image</th>
						<th>Joining Date</th>					
					</tr>
				</thead>
				<s:iterator value="teacherInfoList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="tFirstName" /></td>
						<td><s:property value="tLastName" /></td>
						<td><s:property value="tUserName" /></td>
						<td><s:property value="tEmail" /></td>
						<td><s:property value="tPassword" /></td>
						<td><s:property value="tCPassword" /></td>
						<td><s:property value="tMobileNumber" /></td>
						<td><s:property value="tSalary" /></td>
						<td><s:property value="tGender" /></td>
						<td><s:property value="tDesignation" /></td>
						<td><s:property value="tAddress" /></td>
						
					   <td><img width="100" height="100" src="<s:url value='showTeacherRecord.action?email='/><s:property value='tEmail'/>"></td>	
		
						<%-- <td><s:property value="base64Image" width="240" height="300"/></td> --%>
						<td><s:property value="dateTime" /></td>
						<td>
							<a href="updateTeacherRecord.action?submitType=updatedata&tEmail=<s:property value="tEmail"/>">
								<button class="button-update">Update</button>
							</a>
							<a href="deleteTeacherRecord.action?tEmail=<s:property value="tEmail"/>">
								<button class="button-delete">Delete</button>
							</a>
						</td>
						
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
	</div>
</body>
</html>