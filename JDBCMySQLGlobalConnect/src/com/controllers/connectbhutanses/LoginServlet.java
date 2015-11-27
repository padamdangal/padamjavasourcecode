package com.controllers.connectbhutanses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.connectbhutanses.User;
import com.domain.connectbhutanses.UserDAO;
import com.domain.connectbhutanses.UserService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userN = request.getParameter("userId");
		String pass = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		System.out.println("Your Data is going to chck now.");
		
		UserService user = new UserService();
		
		if(user.validatelogin(userN, pass)){
			User userDetails = user.getUserDetails(userN);
			request.setAttribute("user", userDetails);
			
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}else{
			out.print("You have Enter wrong user Id and Password.\nPlease Try again...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
	}
}
