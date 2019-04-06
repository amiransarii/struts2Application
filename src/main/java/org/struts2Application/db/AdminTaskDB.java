package org.struts2Application.db;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.struts2Application.model.TeacherRegistration;

public class AdminTaskDB {
	private int status = 0;
	private  PreparedStatement psmt = null;
    private  ResultSet rs=null;	
	// method for save teacher data in database
	public  int saveTeacherReg(TeacherRegistration tr) {
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
			status=0;
			e.printStackTrace();
		}
		return status;
			
	}
	// method for fetch saved teacher data
	 public ResultSet showTeachersDeatils() throws SQLException, Exception{
		String showteacherQuery="SELECT firstName,lastName,userName,email,password,confirmPassword,mobileNumber,salary,gender,designation,address,image,joiningDate from teacher";
		 try {
			 psmt=DBConnection.getPreparedStatement(showteacherQuery);
			 if(psmt!=null) {
				 rs=psmt.executeQuery();
			 }			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 rs= null;
		 }
		 return rs;
	 }
	 
	public ResultSet fetchTeacherDetails(String temail) throws SQLException,Exception{
		  String teacherQuery="SELECT firstName,lastName,userName,email,mobileNumber from teacher where email=?";		
		  try {
			  psmt=DBConnection.getPreparedStatement(teacherQuery);
			  if(psmt!=null) {
				  psmt.setString(1, temail);
				  rs=psmt.executeQuery();
			  }
			  
		  } catch(Exception e) {
			  rs=null;
			  e.printStackTrace();
		  }	  
		return rs;
		    
	  }
	  
	// method for update new data in database
	  public int updateTeacherDetails(String firstName,String lastName,String userName,String email,String mobileNumber,
			  String temailhidden) 
			  throws SQLException, Exception {
		  String updatesql = "UPDATE teacher SET firstName=?,lastName=?,userName=?,email=?,mobileNumber=? WHERE email=?";
		   try {
			   psmt=DBConnection.getPreparedStatement(updatesql);
			   if(psmt!=null) {
				 psmt.setString(1, firstName);
				 psmt.setString(2, lastName);
				 psmt.setString(3, userName);
				 psmt.setString(4, email);
				 psmt.setString(5, mobileNumber);
				 psmt.setString(6, temailhidden);				 
				 status=psmt.executeUpdate();
			   }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   status=0;
		   }
		   return status;		  
	  }
	
	  // method for delete the record  
	   public int deleteTeacherDetails(String temail) {
		   String deleteQuery="DELETE FROM teacher WHERE email=?";
		   
		   try {
			  psmt=DBConnection.getPreparedStatement(deleteQuery);
			  if(psmt!=null) {
				  psmt.setString(1, temail);
				  status=psmt.executeUpdate();
			  }			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   status=0;
		   }
		   
		   return status;	   
	   }
	
	 
	   
	   
	   
	
}
