package org.struts2Application.model;
import org.struts2Application.db.AdminTaskDB;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteTeacherRecord extends ActionSupport {
	private String tEmail;
	private String deleteMsg;
	private AdminTaskDB adminTaskDB= new AdminTaskDB();
	
	public String gettEmail() {
		return tEmail;
	}
	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}
	public String getDeleteMsg() {
		return deleteMsg;
	}
	public void setDeleteMsg(String deleteMsg) {
		this.deleteMsg = deleteMsg;
	}
	
	public String execute() throws Exception{
		 try {
			 int isDeleted=adminTaskDB.deleteTeacherDetails(tEmail);
			  if(isDeleted>0) {
				  deleteMsg="Record deleted successfully";
			  }
			  else {
				  deleteMsg="Some error";
			  }
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		return "DELETE";
		
	}
	
	
	

}
