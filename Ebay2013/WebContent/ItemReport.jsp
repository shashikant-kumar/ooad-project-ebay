<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Item Report</title>
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
					<span class="ebay"> <%@include file="header.jsp"%>

	</br>
					</span>
					</div>
			</div>

	</br>
	<br/>
	<br/>
	<s:set name="theme" value="'simple'" scope="page" />
                            <table align="right">
                            <tr>
                            
	    
<title>show Item Details</title>
</head>
<body>
<ul id="NOINTERFERE00_menu">
<br/>
							
    <li><a href="#">All Items &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>
<!-- <h1 align="center">Items</h1>  -->
<table align="center">

<s:if test="%{report.size()==0}">
<tr><td>This item has not been bought by any buyer!!</td></tr>
</s:if>
<s:else>
<table align="center" cellspacing="60">
<tr> 
    <th><h4>Buyer Id</h4></th>
    <th><h4>Add1</h4></th>
    <th><h4>Add2</h4></th>
    <th><h4>City</h4></th>
    <th><h4>State</h4></th>
    <th><h4>Pin</h4></th>
    <th><h4>Country</h4></th>
    <th><h4>Quantity</h4></th>
</tr>

<s:iterator value="report">
<tr>
<td><s:property value="buyerId"/></td>
<td><s:property value="add1"/></td>
<td><s:property value="add2"/></td>
<td><s:property value="city"/></td>
<td><s:property value="state"/></td>
<td><s:property value="pin"/></td>
<td><s:property value="country"/></td>
<td><s:property value="quantity"/></td>
</tr>
</s:iterator>

</table>
 
</s:else>
</table>
</body>
</html>