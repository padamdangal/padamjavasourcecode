<%@page import="cart.shopping.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="cart.shopping.domain.ProductDAOImpl"%>
<%@page import="cart.shopping.domain.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Maintenance</title>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Products</h1>
<table>
	 <tr>
        <th>Code</th>
        <th>Description</th>
        <th class="right">Price</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    
   <%
   
	ProductDAO dao = new ProductDAOImpl("com.mysql.jdbc.Driver",
			"jdbc:mysql://localhost:3306/shopping_cart", "root", "");
   
	List<Product> products = dao.getAllProducts();

	for (Product current : products) {
%> 

        <tr>
			<td> <%= current.getCode() %> </td>
			<td> <%= current.getDescription() %> </td>
			<td> $<%= current.getPrice() %> </td>
			<td><a href="Edit.jsp?code=<%=current.getCode()%>	
            								&description=<%=current.getDescription()%>
            								&price=<%=current.getPrice()%>">Edit</a></td>
            <td><a href="ConfirmDelete.jsp?code=<%=current.getCode()%>	
            								&description=<%=current.getDescription()%>
            								&price=<%=current.getPrice()%>">Delete</a>
           								
            </td>
		</tr>
    
    <%
	    }
    %>
</table>
<br>
  <a href="AddProduct.jsp"><button>Add Product</button></a>
</body>
</html>
