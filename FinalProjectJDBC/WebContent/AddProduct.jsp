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
<h1>Product</h1>
<form action="addproduct" method="post">
<table>
<tr>
<td><strong>Code:</strong></td>
<td><input type="text" name="code" size="12"></td>
</tr>
<tr>
<td><strong>Description:</strong></td>
<td><input type="text" name="description" size="55"></td>
</tr>
<tr>
<td><strong>Price:</strong></td>
<td><input type="text" name="price" size="12"></td>
</tr>
</table>
<p style="text-indent: 92px;"><input type="submit" value="Update Product"></p>
</form>
<a href="Products.jsp"><button>View Products</button></a>
</body>
</html>