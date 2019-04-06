package org.struts2Application.db;

import java.sql.*;

public class AdminLoginDao {
	private static boolean status = false;
	private static PreparedStatement psmt = null;

	public static boolean adminValidate(String email, String password) {
		String adminQuery = "select *from admin where email=? and password=?";
		try {
			psmt = DBConnection.getPreparedStatement(adminQuery);
			if (psmt != null) {
				psmt.setString(1, email);
				psmt.setString(2, password);
				ResultSet rs = psmt.executeQuery();
				status = rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}
