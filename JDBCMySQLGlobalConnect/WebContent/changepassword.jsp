<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request password</title>
</head>
<body>
<div id="wrapper">
<%@include file="header.jsp"%>
<form action="changepassword" method="post">
<br>
<br>
<fieldset>
<legend style="text-decoration: underline; text-align: center;"><b>Password Request Form</b></legend>
<br>
<table class="logintable">
<colgroup>
<col width="40%">
<col width="60%">
</colgroup>
<tr>
<td><span class="requiredfield">User Id:</span><span class="requirefieldindicator">*</span>
<input type="text" name="userId"></td>
<tr>
<td><span class="fieldlable">Security Questions:</span></td>
<td>
<select name="question1" required="required">
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
<tr>
<td><input type="submit" value="Request Password"></td>
<td></td>
</table>
<br>
</fieldset>
</form>
<%@include file="footer.jsp" %>
</div>
</body>
</html>