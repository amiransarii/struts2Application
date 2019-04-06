package org.struts2Application.db;
import java.sql.*;
import org.struts2Application.constant.DBConstant;

public class DBConnection {
	public static  PreparedStatement getPreparedStatement(String sqlQuery) {
		PreparedStatement psmt=null;
		try {
				Class.forName(DBConstant.DBCLASSNAME);
				Connection conn=DriverManager.getConnection(DBConstant.DBURL,DBConstant.DBUSER,DBConstant.DBPASSWORD);
				psmt = conn.prepareStatement(sqlQuery);
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		   return psmt;
	   }
	 
}
