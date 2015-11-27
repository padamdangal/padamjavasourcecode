<%@page import="com.domain.connectbhutanses.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
<div id="wrapper">
<%@include file="header.jsp"%>
<br>
<fieldset>
<legend style="text-align: center; color: Grey;"><strong>Your Profile</strong></legend>

<!-- Getting Data from Database of the particular user  -->
<strong>Full Name:</strong>
${user.firstName} ${user.lastName} <br>
<strong>Age:</strong>
${user.age}<br>
<strong>Sex:</strong>
${user.gender} <br>
<strong>Email:</strong>
${user.email} <br>
<strong>Country:</strong>
${user.country} <br>
</fieldset>
<%@include file="footer.jsp" %>
</div>
</body>
</html>