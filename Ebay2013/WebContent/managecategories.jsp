<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Manage Categories and SubCategories</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="register1.css" >
<link rel="stylesheet" type="text/css" href="register2.css" >
</head>
<body>
	<div>
					<a rel="nofollow" href="EBayAdminHome.jsp"> <img border="0"
						alt="From collectables to cars, buy and sell all kinds of items on eBay"
						src="images/ebay-logo-01.jpg"> </a>
				</div>
<div class="gh-cl"></div>
				<div class="gh-col">
					<b class="gh-c1"></b> <b class="gh-c2"></b> <b class="gh-c3"></b> <b
						class="gh-c4"></b> <b class="gh-c5"></b> <b class="gh-c6"></b> <b
						class="gh-c7"></b>
					<div class="gh-clr"></div>
				</div>

	<br>

<script language="javascript">
function doValidation() {
	var categ=document.getElementById("category").value;
	var subcat=document.getElementById("subcategory").value;
	if (categ==""){
		alert("Please select a Category");
		return false;
	}
	if (subcat==""){
		alert("Please enter sub Category  name");
		return false;
	}
	return true;
}
function doValidateCategory() {
	var cat=document.getElementById("category").value;
	if (cat==""){
		alert("Please enter Category Name");
		return false;
	}
	return true;
}

</script>
</head>
<body>

<s:form action="manageCategoriesSubcategories" theme="simple">

<div class="sectionBody" style="padding:7px 0 9px 7px;">
<s:if test="%{parameter=='subcats'}">
<center><div style="margin:-15px 0 -9px 0;_margin:-15px 0 -10px 0;" class="pageHeader"><table cellpadding="0" cellspacing="0" border="0"><tbody><tr><td><b id="mainContent"><h1 class="regPgHeading">Create Sub Categories</h1></b></td></tr></tbody></table></div></center>
<table id="text" align="center">
<tr><td><b></b></td></tr>
<tr></tr>
<tr><td><span STYLE="color: blue; font-size: 10pt">
<s:property value="msg" /> </span>	</td></tr>
<tr>
<td>
<span class="fldGrp" style="padding-right:4px;">
<div>
<span class="standardtitle" style="font-weight:normal">
<label for="categoryName">Select Category</label>
</span>
<div>
<s:select label="Select Category" headerKey="" headerValue="-none-" list="categoryList" listvalue="categoryList.categ_name" key="categoryName" name="categoryName" id="category" style="width: 150px"></s:select>
</div>
</div>
<span class="error"></span>
</span>
</td>
<%-- <s:select label="Select Category" headerKey="" headerValue="-none-" list="categoryList" listvalue="categoryList.categ_name" key="categoryName" name="categoryName" id="category" style="width: 150px"></s:select></td> --%>
</tr>
<tr></tr><tr></tr><tr></tr><tr>
<td>
<span class="fldGrp" style="padding-right:4px;">
<div>
<span class="standardtitle" style="font-weight:normal">
<label for="subcategoryName">Sub Category Name</label>
</span>
<div>
<s:textfield label="Sub Category Name" name="subcategoryName" id ="subcategory"></s:textfield>
</div>
</div>
<span class="error"></span>
</span>
</td>
<%-- <s:textfield label="Sub Category Name" name="subcategoryName" id ="subcategory"></s:textfield></td> --%>
</tr>

<tr></tr>
<tr></tr><tr></tr><tr></tr><tr>
<td><s:submit name="commandButton" value="Add Sub Category" onClick="return doValidation()"  id = "mysubmit"  style="height: 30px; width: 200px" >
</s:submit></td></tr><tr></tr><tr></tr><tr></tr><tr>
<td><s:submit name = "commandButton" value="View Sub Categories" id = "mysubmit" style="height: 30px; width: 200px">
</s:submit></td>
</tr>
<tr><td><center>
<s:submit name = "commandButton" value="Back to Admin Home" id = "mysubmit" style="height: 30px; width: 200px">
</s:submit></center></td></tr>
</table>

</s:if>
<s:else>
<center><div style="margin:-15px 0 -9px 0;_margin:-15px 0 -10px 0;" class="pageHeader"><table cellpadding="0" cellspacing="0" border="0"><tbody><tr><td><b id="mainContent"><h1 class="regPgHeading">Create Categories</h1></b></td></tr></tbody></table></div></center>
<table id="text" align="center">
<tr></tr>
<tr><td><span STYLE="color: blue; font-size: 10pt">
<s:property value="msg" /> </span>	</td></tr>
<tr>
<tr>
<td>

<span class="fldGrp" style="padding-right:4px;">
<div>
<span class="standardtitle" style="font-weight:normal">
<label for="categoryName">Category Name</label>
</span>
<div>
<s:textfield label="Category Name" name="categoryName" id="category"></s:textfield></div>
</div>
<span class="error"></span>
</span>
</td>
</tr>

<tr></tr><tr></tr><tr></tr><tr></tr>
<tr>
<td><s:submit name="commandButton" value="Add Category" id = "mysubmit"  style="height: 30px; width: 200px" onclick="return doValidateCategory()" >
</s:submit></td><tr></tr><tr></tr><tr>
<td><s:submit name = "commandButton" value="View Categories" id = "mysubmit" style="height: 30px; width: 200px" >
</s:submit></td>
</tr><tr></tr><tr></tr><tr>
<tr><td><center>
<s:submit name = "commandButton" value="Back to Admin Home" id = "mysubmit" style="height: 30px; width: 200px">
</s:submit></center></td></tr></table>
</s:else>
</div>
</s:form>
</body><br><br><br><br><br><br>
<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>

</html>