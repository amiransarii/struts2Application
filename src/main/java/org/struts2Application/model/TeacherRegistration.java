package org.struts2Application.model;
import java.io.File;

import org.struts2Application.db.AdminTaskDB;
import org.struts2Application.db.EmailUserIDExist;
import org.struts2Application.db.TeacherRegDao;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherRegistration extends ActionSupport {
	private String registrationType;
	private String tFirstName;
	private String tLastName;
	private String tUserName;
	private String tEmail;
	private String tPassword;
	private String tCPassword;
	private String tMobileNumber;
	private double tSalary;
	private String tGender;
	private String tDesignation;
	private String tAddress;
	private File image;
	private AdminTaskDB adminTaskDB;
	private int ctr = 0;
	private String savedMsg=null;
	
	public String getSavedMsg() {
		return savedMsg;
	}

	public void setSavedMsg(String savedMsg) {
		this.savedMsg = savedMsg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
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

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String gettCPassword() {
		return tCPassword;
	}

	public void settCPassword(String tCPassword) {
		this.tCPassword = tCPassword;
	}

	public String gettMobileNumber() {
		return tMobileNumber;
	}

	public void settMobileNumber(String tMobileNumber) {
		this.tMobileNumber = tMobileNumber;
	}

	public double gettSalary() {
		return tSalary;
	}

	public void settSalary(double tSalary) {
		this.tSalary = tSalary;
	}

	public String gettGender() {
		return tGender;
	}

	public void settGender(String tGender) {
		this.tGender = tGender;
	}

	public String gettDesignation() {
		return tDesignation;
	}

	public void settDesignation(String tDesignation) {
		this.tDesignation = tDesignation;
	}

	public String gettAddress() {
		return tAddress;
	}

	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}
	
	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
	
	
	public void validate() {
		String userNameQuery ="select *from teacher where userName=?";
		String emailIDQuery = "select *from teacher where email=?";
		boolean isUserIDExist=EmailUserIDExist.isEmailUserIDexist(userNameQuery, gettUserName());
		boolean isEmailIDExist=EmailUserIDExist.isEmailUserIDexist(emailIDQuery,gettEmail());				
		if(isUserIDExist) {
			addFieldError("tUserName", "User Name Already Exist Please Try another One");
		}
		 if(isEmailIDExist ) {
			addFieldError("tEmail", "Email ID Already Exist Please Try another One");
		}
	}
	 
   public String execute() {
	   adminTaskDB= new AdminTaskDB();
	   ctr= adminTaskDB.saveTeacherReg(this);	   
	    if(ctr>0) {
	    	savedMsg= "Registration Successfull";
	    }
	    else {
	    	savedMsg= "Some Error";
	    }
		return "REGISTER";
	}

}
