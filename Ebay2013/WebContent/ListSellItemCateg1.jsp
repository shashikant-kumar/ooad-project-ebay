<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function fnGetSubCat1(a){
	document.listSellCateg1.submit();
}
</script>
<title>Start Listing</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
</head>
<body>
<p></p>
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
<h5>Tell us what you sell</h5>
<br>
 <s:set name="theme" value="'simple'" scope="page" />
  <s:form name="listSellCateg1" action="listSellItemCateg1"> 
 <p>Category</p>
 <s:select label="Categories" name="categ" id="categ" list="categList" headerKey="" headerValue="Select" required="true" onChange="fnGetSubCat1(this)"/>
<% String cat=request.getParameter("categ");
	System.out.println("category in jsp is"+cat);
	if(cat != null){
%>
<p>Sub Category</p>
<s:select name="subCateg" id="subCateg" list="subCategList" required="true"/>

<%
}
%>
<s:submit name="commandButton" value="Create Your Listing" ></s:submit>
<br>
<br>
 </s:form>
 
</body>
</html>