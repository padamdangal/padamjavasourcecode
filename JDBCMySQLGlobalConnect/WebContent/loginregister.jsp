<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>LogIn Form</title>
<link rel="stylesheet" type="text/css" href="css/loginregister.css"/>
</head>
<body>
<div id="wrapper">
<%@include file="header.jsp"%>
<div class="model-content">
<div class="model-header">
<h4>Registration From</h4>
</div>
<div class="model-body" style="overflow:auto;">
<div class="login" style="width:60%; float:left;">

<!-- action for register -->
<form action="register" method="post"><br>
<fieldset>
<legend style="text-align: center; color: blue;"><strong>Sign Up</strong></legend>
<table>
<colgroup>
<col width="35%">
<col width="65%">
</colgroup>
<tr>
<td><span class="fieldlable">First Name:</span></td>
<td><input type="text" name="fName" required="required"></td>
</tr>
<tr>
<td><span class="fieldlable">Last Name:</span></td>
<td><input type="text" name="lName" required="required"></td>
</tr>
<tr>
<td><span class="fieldlable">Age:</span></td>
<td><input type="text" name="age"></td>
</tr>
<tr>
<td><span class="fieldlable">Sex:</span></td>
<td><input type="radio" name="gender" value="male"> Male
<input type="radio" name="gender" value="female"> Female</td>
</tr>
<tr>
<td><span class="fieldlable">Email:</span></td>
<td><input type="text" name="email" required="required"></td>
</tr>
<tr>
<td><span class="fieldlable">Country:</span></td>
<td><input type="text" name="country"></td>
</tr>
<tr>
<td><span class="fieldlable">User ID:</span></td>
<td><input type="text" name="userId" required="required"></td>
</tr>
<tr>
<td><span class="fieldlable">Password:</span></td>
<td><input type="password" name="password" required="required"></td>
</tr>
<tr>
<td><span class="fieldlable">Confirm Password:</span></td>
<td><input type="password" name="cPassword" required="required"></td>
</tr>
<tr>
<td><span class="fieldlable">Security Questions:</span></td>
<td>
<select name="question1" required="required">
  <option value="N/A">Security Question</option>
  <option value="What is the name of your first pet?">What is the name of your first pet?</option>
  <option value="What is of the make your first car?">What is of the make your first car?</option>
  <option value="What is the name of your first school?">What is the name of your first school?</option>
   <option value="Where did you celebrate your first birthday?">Where did you celebrate your first birthday?</option>
    <option value="Where your parent met for the first time?">Where your parent met for the first time?</option>
</select>
</td>
</tr>
<tr>
<td><span class="fieldlable">Answer:</span></td>
<td><input type="text" name="answer1" required="required"></td>
</tr>
<tr>
<td><span class="fieldlable">Security Question:</span></td>
<td>
<select name="question2" required="required">
  <option value="N/A">Security Question</option>
  <option value="What is the name of your first pet?">What is the name of your first pet?</option>
  <option value="What is the make of your first car?">What is of the make your first car?</option>
  <option value="What is the name of your first school?">What is the name of your first school?</option>
   <option value="Where did you celebrate your first birthday?">Where did you celebrate your first birthday?</option>
    <option value="Where your parent met for the first time?">Where your parent met for the first time?</option>
</select>
</td>
</tr>
<tr>
<td><span class="fieldlable">Answer:</span></td>
<td><input type="text" name="answer2" required="required"></td>
</tr>
<tr>
<td></td>
<td></td>
</tr>
<br>
<br>
<tr>
<td><input type="reset" name="Clear"></td>
<td><input type="submit" name="Register"></td>
</tr>
</table>
<br>
</fieldset>
<div class="footer">
</div>
</form>
</div>
<div class="link" style="width: 39.5%; float: right;">

<!-- action for login -->
<form action="login" method="post">
<br>
<br>
<fieldset>
<legend style="text-decoration: underline;"><b>Have an Account</b></legend>
<br>
<table class="logintable">
<colgroup>
<col width="40%">
<col width="60%">
</colgroup>
<tr>
<td><span class="requiredfield">User Id:</span><span class="requirefieldindicator">*</span>
<input type="text" name="userId"></td>
</tr>
<tr>
<td><span class="requiredfield">Password:</span><span class="requirefieldindicator">*</span>
<input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
<td></td>
</table>
<br>
<a href="changepassword.jsp"><span class="requiredfield">Forget your password?</span></a>
</fieldset>
</form>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</div>
</body>
</html>
