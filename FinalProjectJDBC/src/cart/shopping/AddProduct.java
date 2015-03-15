package cart.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		String desc = request.getParameter("description");
		
		double price = Double.parseDouble(request.getParameter("price"));

		if((code != " ") || (code != null) ||  (desc != " ") || (desc != null) || (request.getParameter("price") != " ") || (request.getParameter("price") != null)){
		  
	           if(insertProduct(code, desc, price)){
			             request.getRequestDispatcher("success.jsp").forward(request, response);
	                }
	  }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static boolean insertProduct(String code, String description, double price) {

		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shopping_cart", "root", "");

			String query = "insert into products values (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, code);
			pstmt.setString(2, description);
			pstmt.setDouble(3, price);

			if(pstmt.executeUpdate() > 0){
				status = true;
			}

			con.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
