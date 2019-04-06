package org.struts2Application.db;
import org.struts2Application.model.TeacherRegistration;
import java.io.FileInputStream;
import java.sql.*;

public class TeacherRegDao {
	private static int status = 0;
	private static PreparedStatement psmt = null;

	public static int saveTeacherReg(TeacherRegistration tr) {
		String teachesqlQuery = "INSERT INTO teacher(firstName,lastName,userName,email,password,confirmPassword,mobileNumber,salary,"
				+ "gender,designation,address,image)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			psmt = DBConnection.getPreparedStatement(teachesqlQuery);
			if (psmt != null) {
				psmt.setString(1, tr.gettFirstName());
				psmt.setString(2, tr.gettLastName());
				psmt.setString(3, tr.gettUserName());
				psmt.setString(4, tr.gettEmail());
				psmt.setString(5, tr.gettPassword());
				psmt.setString(6, tr.gettCPassword());
				psmt.setString(7, tr.gettMobileNumber());
				psmt.setDouble(8, tr.gettSalary());
				psmt.setString(9, tr.gettGender());
				psmt.setString(10, tr.gettDesignation());
				psmt.setString(11, tr.gettAddress());
				FileInputStream inputStream = new FileInputStream(tr.getImage());
				psmt.setBinaryStream(12, inputStream);
				status = psmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}
