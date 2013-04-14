<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>eBay Sell Item</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div>
		<br />
	</div>
<div>
	<div class="pcontent">
		<!--cacheStatus: false-->
		<span class="ebay"> 
			<%@include file="header.jsp"%>
			<br>
		</span>
	</div>
</div>

<br>
<h5>Sell Your Item</h5>
<br>
 <s:set name="theme" value="'simple'" scope="page" />
 <h3><s:property value="msg"/> </h3>
  <s:form action="sellItem"> 
  <table>
  <tr><p>Enter 3-5 words about your item.</p></tr>
 <tr>
<td>
<s:textfield name="shortDesc" placeholder="Enter 3-5 words about your item." /></td> 
<td><s:submit name="commandButton" value="Start Selling" ></s:submit></td>
</tr>
<!-- tr>
<td>
<a href="listSellItemCateg1">Browse Categories</a></td>
 </tr-->
 </table>
 </s:form>
 
</body>
</html>