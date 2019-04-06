package org.struts2Application.model;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.struts2Application.db.AdminTaskDB;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherRecords extends ActionSupport {
	private List<TeacherInfo> teacherInfoList;
	private ResultSet rs = null;
	private TeacherInfo teacherInfo = null;
	private AdminTaskDB admintaskDB = new AdminTaskDB();
	private boolean noData = false;

	public List<TeacherInfo> getTeacherInfoList() {
		return teacherInfoList;
	}

	public void setTeacherInfoList(List<TeacherInfo> teacherInfoList) {
		this.teacherInfoList = teacherInfoList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public String execute() {
		try {
			teacherInfoList = new ArrayList<TeacherInfo>();
			rs = admintaskDB.showTeachersDeatils();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					teacherInfo = new TeacherInfo();
					teacherInfo.setId(i);
					teacherInfo.settFirstName(rs.getString("firstName"));
					teacherInfo.settLastName(rs.getString("lastName"));
					teacherInfo.settUserName(rs.getString("userName"));
					teacherInfo.settEmail(rs.getString("email"));
					teacherInfo.settPassword(rs.getString("password"));
					teacherInfo.settCPassword(rs.getString("confirmPassword"));
					teacherInfo.settMobileNumber(rs.getString("mobileNumber"));
					teacherInfo.settSalary(rs.getDouble("salary"));
					teacherInfo.settGender(rs.getString("gender"));
					teacherInfo.settDesignation(rs.getString("designation"));
					teacherInfo.settAddress(rs.getString("address"));
					teacherInfo.setImage(rs.getBlob(13));
					teacherInfo.setDateTime(rs.getDate("joiningDate"));
					teacherInfoList.add(teacherInfo);
				}
			}
					
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "RECORD";
	}

}
