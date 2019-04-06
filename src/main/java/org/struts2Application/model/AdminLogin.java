package org.struts2Application.model;

import java.util.*;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.struts2Application.db.AdminLoginDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLogin extends ActionSupport implements SessionAware {
	private String adminEmail;
	private String adminPass;
	private SessionMap<String, String> sessionMap;
	private SessionMap<String, String> mAdminEmail;

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public String regDisplay() {
		return NONE;
	}

	public void setSession(Map<String, Object> session) {
		sessionMap = (SessionMap) session;
		sessionMap.put("adminLogin", "true");
		mAdminEmail = (SessionMap) session;
	}

	public String adminLogOut() {
		sessionMap.invalidate();
		mAdminEmail.invalidate();
		return SUCCESS;
	}

	public String execute() {
		if (AdminLoginDao.adminValidate(adminEmail, adminPass)) {
			mAdminEmail.put("mAdminEmail", adminEmail);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String adminHome() {
		return SUCCESS;
	}

}
