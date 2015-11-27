package com.domain.connectbhutanses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

	private static Statement statement = null;
	
public boolean validatelogin(String username, String password){
		
		boolean success = false;
		try {
			
			String query ="SELECT * FROM users WHERE UserID ='" + username + "'" + " AND Password = '" + password +"'";
			System.out.println(query);
			
			PreparedStatement pstmt = UserDAO.createConnection().prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				success=true;
			}
			UserDAO.shutDown();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;
	}
	
	public User getUserDetails(String userId)
	{
		
		User user = null;
		try {
			String query = "SELECT * from users where userId = '" + userId + "'";
			
			statement = UserDAO.createConnection().createStatement();
			
			ResultSet result = statement.executeQuery(query);
			
			user = new User();
			
			while(result.next()){
				
				String firstname = result.getString("FirstName");
				String lastname = result.getString("Lastname");
				int age = Integer.parseInt(result.getString("Age"));
				String gender = result.getString("Sex");
				String email = result.getString("Email");
				String country = result.getString("Country");
				String securityQuestion1 = result.getString("SecurityQuestion1");
				String answer1 = result.getString("Answer1");
				String securityQuestion2 = result.getString("SecurityQuestion2");
				String answer2 = result.getString("Answer2");
				
				//setting the data in the user object
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setAge(age);
				user.setGender(gender);
				user.setEmail(email);
				user.setCountry(country);
				user.setSecurityQuestion1(securityQuestion1);
				user.setAnswer1(answer1);
				user.setSecurityQuestion2(securityQuestion2);
				user.setAnswer2(answer2);
				
				
			}
			UserDAO.shutDown();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getPassword(String userId, String securityQuestion1, String answer1, String securityQuestion2, String answer2){
		
		User userpassword = null;
		try {
			String query = "SELECT Password from users where userId = '" + userId + "' AND SecurityQuestion1 ='" + securityQuestion1 + "' AND Answer1 ='" + answer1 + "' AND SecurityQuestion2 ='" + securityQuestion2 + "' AND Answer2 ='" + answer2 + "'";
			
			statement = UserDAO.createConnection().createStatement();
			
			ResultSet result = statement.executeQuery(query);
			
			userpassword = new User();
			while(result.next()){
				
				String password = result.getString("Password");
				
				userpassword.setPassword(password);
			}
			UserDAO.shutDown();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userpassword;
	}
}
