<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function fnGetSubCat(a){
	document.listSellCateg.submit();
}
</script>
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
<h5>Tell us what you sell</h5>
<br>
 <s:set name="theme" value="'simple'" scope="page" />
 <h3><s:property value="msg"/> </h3>
  <s:form name="listSellCateg" action="listSellItemCateg"> 
  <table>
  <tr><p>Enter 3-5 words about your item.</p></tr>
 <tr>
<td>
<s:textfield name="shortDesc" placeholder="Enter 3-5 words about your item." /></td> 
<td><s:submit name="commandButton" value="Start Selling" ></s:submit></td>
</tr>
</table>
 
 <s:if test="%{suggestedCategList.size()!=0 or suggestedCateg != null}">
 <p>Suggested Categories<p>
 <s:select label="Categories" name="categ" id="categ" list="suggestedCategList" headerKey="" headerValue="Select" required="true" onChange="fnGetSubCat(this)"/>
</s:if>
<s:else>
<p>Sorry. There are no matching categories for the given description. Try searching with different words or select a suitable category.</p>
</s:else>
<% String cat=request.getParameter("categ");
	System.out.println("category in jsp is"+cat);
	if(cat != null){
%>
<s:select name="subCateg" id="subCateg" list="suggestedSubCategList" required="true"/>

<%
}
%>
<s:submit name="commandButton" value="Continue" ></s:submit>
<br>
<br>
<a href="listSellItemCateg1">Select a suitable category</a></td>
 </s:form>
 
</body>
</html>