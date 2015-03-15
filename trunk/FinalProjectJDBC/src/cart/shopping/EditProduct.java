package cart.shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.shopping.domain.ProductDAO;
import cart.shopping.domain.ProductDAOImpl;

/**
 * Servlet implementation class EditProduct
 */
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("editCode");
		String desc = request.getParameter("editDescription");
		double price = Double.parseDouble(request.getParameter("editPrice"));
		
		
		
		ProductDAO dao = new ProductDAOImpl("com.mysql.jdbc.Driver",
      			"jdbc:mysql://localhost:3306/shopping_cart", "root", "");
		
          HttpSession session = request.getSession();
          String originalCode =  (String) session.getAttribute("codeEdit");   
          
         
        if(dao.editProducts(originalCode, code, desc, price)){
        	request.getRequestDispatcher("Products.jsp").forward(request, response);
        }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
