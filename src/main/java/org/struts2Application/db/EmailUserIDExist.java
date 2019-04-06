package org.struts2Application.db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmailUserIDExist {
	public static boolean isEmailUserIDexist(String userEmailQuery,String userEmail) {
		boolean isEmailValid=false;
		 try {
			 PreparedStatement psmt = DBConnection.getPreparedStatement(userEmailQuery);
			 psmt.setString(1,userEmail );
			 ResultSet rs= psmt.executeQuery();
			 
			 while(rs.next()) {	
				 isEmailValid=true;
			 } 
		 }
		 catch(Exception e) {
			 isEmailValid=false;
			 e.printStackTrace();
		 }
		
    	return isEmailValid;	
	}

}
