package org.struts2Application.model;
import java.io.File;
import java.sql.Blob;
import java.sql.Date;

public class TeacherInfo {
	
	private int id;
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
	private Blob image;;
	
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	private Date dateTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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
	
	
	
}
