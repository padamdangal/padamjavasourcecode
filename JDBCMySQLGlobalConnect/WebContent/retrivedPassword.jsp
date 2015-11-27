<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<html>
<head>
<meta charset="UTF-8">
<title>Register-Success</title>
<link rel="stylesheet" type="text/css" href="css/loginregister.css"/>
</head>
<body>
<div id="wrapper">
<%@include file="header.jsp" %>
<div class="model-content">
<div class="model-header" style="height: 62px; font-size: 80%;color: Red;">
<br>
*Your password is : ${user.password}
</div>
<div class="model-body" style="overflow:auto; height: 352px; width: 100%">

<div class="link">

<!-- action for login -->
<form action="login" method="post">
<br>
<br>
<center><font color="black"><b>Please Login In Using your Password</b></font></center>
<hr style="width: 95%; height: 1px; border: 1px solid lightblue;">
<br>
<table class="logintable" border = "0" bordercolor="green" width="100" align="center">
<tr>
<td><span class="requiredfield">User Id:</span><span class="requirefieldindicator">*</span>
<input type="text" name="userId"></td>
</tr>
<tr>
<td><span class="requiredfield">Password:</span><span class="requirefieldindicator">*</span>
<input type="password" name="password"></td>
</tr>
<tr>
<td><input type="reset" value="Clear">
<input type="submit" value="Login"></td>
</table>
<br>
<center><a href="changepassword.jsp"><span class="requiredfield">Forget your password?</span></a></center>
<br><br>
</form>
<div class="footer" style="width: 97%">
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</div>
</body>
</html>
</body>
</html>