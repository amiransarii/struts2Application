package org.struts2Application.model;

import java.sql.ResultSet;
import org.struts2Application.db.AdminTaskDB;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateTeacherRecord extends ActionSupport {
	private String tFirstName;
	private String tLastName;
	private String tUserName;
	private String tEmail;
	private String tMobileNumber;
	private String tEmailhidden;
	private String updateMsg;
	private ResultSet rs = null;
	private AdminTaskDB adminTaskDB = new AdminTaskDB();
	private String submitType;
	

	
	public String getUpdateMsg() {
		return updateMsg;
	}

	public void setUpdateMsg(String updateMsg) {
		this.updateMsg = updateMsg;
	}

	
	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String gettFirstName() {
		return tFirstName;
	}

	public void settFirstName(String tFirstName) {
		this.tFirstName = tFirstName;
	}

	public String gettLastName() {
		return tLastName;
	}

	public void settLastName(String tLastName) {
		this.tLastName = tLastName;
	}

	public String gettUserName() {
		return tUserName;
	}

	public void settUserName(String tUserName) {
		this.tUserName = tUserName;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String gettMobileNumber() {
		return tMobileNumber;
	}

	public void settMobileNumber(String tMobileNumber) {
		this.tMobileNumber = tMobileNumber;
	}

	public String gettEmailhidden() {
		return tEmailhidden;
	}

	public void settEmailhidden(String tEmailhidden) {
		this.tEmailhidden = tEmailhidden;
	}

	public String execute() {
		 try {
			if (submitType.equals("updatedata")) {
				rs = adminTaskDB.fetchTeacherDetails(tEmail.trim());
				if (rs != null) {
					while (rs.next()) {
						tFirstName = rs.getString("firstName");
						tLastName = rs.getString("lastName");
						tUserName = rs.getString("userName");
						tEmail = rs.getString("email");
						tMobileNumber = rs.getString("mobileNumber");
					}

				} 
			}else {
				int i = adminTaskDB.updateTeacherDetails(tFirstName, tLastName, tUserName, tEmail, tMobileNumber,
						tEmailhidden);
				if (i > 0) {
					updateMsg = "Record Updated Successfuly";
				} else {
					updateMsg = "error";
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UPDATE";

	}

}
