package com.controllers.connectbhutanses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.connectbhutanses.User;
import com.domain.connectbhutanses.UserService;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String securityQuestion1 = request.getParameter("question1");
		String answer1 = request.getParameter("answer1");
		String securityQuestion2 = request.getParameter("question2");
		String answer2 = request.getParameter("answer2");
		
		if(userId != null && securityQuestion1 !=null && answer1 !=null && securityQuestion2 !=null && answer2 !=null){
			UserService user = new UserService();
		User password = user.getPassword(userId, securityQuestion1, answer1, securityQuestion2, answer2);
		request.setAttribute("user", password);
		
		request.getRequestDispatcher("retrivedPassword.jsp").forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("You have Entered the Wrong credential.");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
