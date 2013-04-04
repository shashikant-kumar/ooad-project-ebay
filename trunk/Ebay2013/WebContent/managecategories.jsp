<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.ArrayList,models.*, com.opensymphony.xwork2.ActionContext,java.util.Map,java.util.List" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Categories and SubCategories</title>
<%-- <script language="javascript">
function doValidation() {
	var semester=document.getElementById("semester").value;
	var course=document.getElementById("course").value;
	if (semester==""){
		alert("Semester field is manadatory.Please enter appropriately");
		return false;
	}
	if (course==""){
		alert("Course field is manadatory.Please enter appropriately");
		return false;
	}
	return true;
}
</script> --%>
</head>
<body>

<s:form action="manageCategoriesSubcategories">
<s:if test="%{parameter=='subcats'}">
<table id="text" align="center">
<tr><td><b>Create Sub Categories</b></td></tr>
<tr></tr>
<tr><td><span STYLE="color: blue; font-size: 10pt">
<s:property value="msg" /> </span>	</td></tr>
<tr>
<td><s:select label="Select Category" headerKey="" headerValue="-none-" list="categoryList" listvalue="categoryList.categ_name" key="categoryName" name="categoryName" id="category" style="width: 150px"></s:select></td>
</tr>
<tr>
<td><s:textfield label="Sub Category Name" name="subcategoryName" ></s:textfield></td>
</tr>

<tr></tr>
<tr>
<td><s:submit name="commandButton" value="Add Sub Category" id = "mysubmit"  style="height: 30px; width: 200px" >
</s:submit></td>
<td><s:submit name = "commandButton" value="View Sub Categories" id = "mysubmit" style="height: 30px; width: 200px" onclick="return doValidation()">
</s:submit></td>
</tr>
</table>
<table >
<s:form action="back" align="right" name = "Back">
<tr><td><center>
<s:submit name = "commandButton" value="Back to Admin Home" id = "mysubmit" style="height: 30px; width: 200px">
</s:submit></center></td></tr></s:form>
</table>

</s:if>
<s:else>
<h2>Create Categories</h2>
<table id="text" align="center">
<tr></tr>
<tr><td><span STYLE="color: blue; font-size: 10pt">
<s:property value="msg" /> </span>	</td></tr>
<tr>
<tr>
<td><s:textfield label="Category Name" name="categoryName" ></s:textfield></td>
</tr>

<tr></tr>
<tr>
<td><s:submit name="commandButton" value="Add Category" id = "mysubmit"  style="height: 30px; width: 200px" >
</s:submit></td>
<td><s:submit name = "commandButton" value="View Categories" id = "mysubmit" style="height: 30px; width: 200px" onclick="return doValidation()">
</s:submit></td>
</tr>
</table>
<table >
<s:form action="back" align="right" name = "Back">
<tr><td><center>
<s:submit name = "commandButton" value="Back to Admin Home" id = "mysubmit" style="height: 30px; width: 200px">
</s:submit></center></td></tr></s:form>
</table>
</s:else>
</s:form>

</body>
</html>