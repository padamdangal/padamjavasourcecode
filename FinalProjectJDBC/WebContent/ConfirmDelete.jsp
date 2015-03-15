<%@page import="cart.shopping.domain.LineItem"%>
<%@page import="java.util.List"%>
<%@page import="cart.shopping.domain.Product"%>
<%@page import="cart.shopping.domain.ProductDAOImpl"%>
<%@page import="cart.shopping.domain.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Maintenance</title>
<style type="text/css">
body { 
    font-family: Arial, Helvetica, sans-serif;
    font-size: 85%;
    margin-left: 2em;
    margin-right: 2em;
}
h1 {     
    font-size: 140%;
    color: teal;
    margin-bottom: .5em;    
}
br {
    clear: both;
}
</style>
</head>
<body>
<h1>Are you sure you want to delete this product?</h1>
<%


%> 
<form action="delete" method="post">
<table>
<tr>
<td><strong>Code:</strong></td>
<td><%=request.getParameter("code")%></td>
</tr>
<tr>
<td><strong>Description:</strong></td>
<td><%=request.getParameter("description")%></td>
</tr>
<tr>
<td><strong>Price:</strong></td>
<td><%=request.getParameter("price")%></td>
</tr>
</table>
<input type="submit" value="Yes">
</form>
<a href="Products.jsp"><button>No</button></a>
</body>
</html>

<%
session.setAttribute("deleteCode", request.getParameter("code"));
%>
