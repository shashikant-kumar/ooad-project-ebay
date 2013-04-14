<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>eBay Give Feedback to Seller</title>
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
<br>
 <s:set name="theme" value="'simple'" scope="page" />
 <h3><s:property value="msg"/> </h3>
  <s:form action="giveFeedback"> 
  <table>
  <tr><td>Rate the Seller on scale of 1-5.</td></tr>
 <tr>
<td>
<s:hidden name="tranId" value="%{tranId}"/>
<s:select name="feedback" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}" headerKey="" headerValue="Select" required="true"  placeholder="Rate the seller"/>
</td> 
<td><s:submit name="commandButton" value="Give Rating" ></s:submit></td>
</tr>
 </table>
 </s:form>
 
</body>
</html>