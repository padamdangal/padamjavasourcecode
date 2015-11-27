package com.controllers.connectbhutanses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	PrintWriter out = response.getWriter();
	
	String fName = request.getParameter("fName");
	String lName = request.getParameter("lName");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String country = request.getParameter("country");
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String cpassword = request.getParameter("cPassword");
	String question1 = request.getParameter("question1");
	String answer1 = request.getParameter("answer1");
	String question2 = request.getParameter("question2");
	String answer2 = request.getParameter("answer2");
	
	if(password.equals(cpassword)){
		
		
		if(insertData(fName, lName, age, gender, email, country, userId, cpassword, question1, answer1, question2, answer2)){	
			request.getRequestDispatcher("register-success.jsp").forward(request, response);
		}
	}else{
		request.getRequestDispatcher("register-fail.jsp").forward(request, response);
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	protected static boolean insertData(String firstName, String lastName, int age, String gender, String email, String country, String userId, String password,String question1, String answer1, String question2, String answer2){
		boolean success = false;
 try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Connect_Bhutan", "root", "");
			
			String query = "insert into users values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setInt(3, age);
			pstmt.setString(4, gender);
			pstmt.setString(5, email);
			pstmt.setString(6, country);
			pstmt.setString(7, userId);
			pstmt.setString(8, password);
			pstmt.setString(9, question1);
			pstmt.setString(10, answer1);
			pstmt.setString(11, question2);
			pstmt.setString(12, answer2);
			
		System.out.println(query);
			
		if(pstmt.executeUpdate() > 0){
			System.out.println("Data entered successfully...");
			success = true;
		}
		
		con.close();
		pstmt.close();
		
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
		catch (SQLException e) {
        e.printStackTrace();		}
 return success;
	}

}

