package org.struts2Application.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AdminProfile extends ActionSupport {
	public String adminExecute() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session= request.getSession();
		String s=(String)session.getAttribute("adminLogin");
		
		 if(s!=null && !s.equals("")) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
		
	}

}
