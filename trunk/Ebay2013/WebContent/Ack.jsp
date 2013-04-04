<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Author: Ruchika  -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
<title>Thank You</title>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<s:form action="homePage" name="ack" theme="simple">
<h1 align="center">Payment Successful</h1>
<table align="center" border="5" class="table table-hover">
<tr>
<td><h5>Previous Balance</h5></td>
<td><h5>Transaction Balance</h5></td>
<td><h5>Available Balance</h5></td></tr>
<tr><td><s:property value="prevBal"/></td>
<td><s:property value="transBal"/></td>
<td><s:property value="availBal"/></td></tr>
</table>
<h3>Congratulations! Your transaction is successful. Press Continue to go to Home</h3>
<s:submit name="submit" value="Continue" align="center"></s:submit>
</s:form>
</body>
</html>