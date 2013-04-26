<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    
<script language="JavaScript" type="text/javascript">
function Pager(tableName, itemsPerPage) { 
	this.tableName = tableName; 
	this.itemsPerPage = itemsPerPage; 
	this.currentPage = 1; 
	this.pages = 0; 
	this.inited = false; 

	this.showRecords = function(from, to) { 
	var rows = document.getElementById(tableName).rows; 
	// i starts from 1 to skip table header row 
	for (var i = 1; i < rows.length; i++) { 
	if (i < from || i > to) 
	rows[i].style.display = 'none'; 
	else 
	rows[i].style.display = ''; 
	} 
	} 

	this.showPage = function(pageNumber) { 
	if (! this.inited) { 
	alert("not inited"); 
	return; 
	} 

	var oldPageAnchor = document.getElementById('pg'+this.currentPage); 
	oldPageAnchor.className = 'pg-normal'; 

	this.currentPage = pageNumber; 
	var newPageAnchor = document.getElementById('pg'+this.currentPage); 
	newPageAnchor.className = 'pg-selected'; 

	var from = (pageNumber - 1) * itemsPerPage + 1; 
	var to = from + itemsPerPage - 1; 
	this.showRecords(from, to); 
	} 

	this.prev = function() { 
	if (this.currentPage > 1) 
	this.showPage(this.currentPage - 1); 
	} 

	this.next = function() { 
	if (this.currentPage < this.pages) { 
	this.showPage(this.currentPage + 1); 
	} 
	} 

	this.init = function() { 
	var rows = document.getElementById(tableName).rows; 
	var records = (rows.length - 1); 
	this.pages = Math.ceil(records / itemsPerPage); 
	this.inited = true; 
	} 

	this.showPageNav = function(pagerName, positionId) { 
	if (! this.inited) { 
	alert("not inited"); 
	return; 
	} 
	var element = document.getElementById(positionId); 

	var pagerHtml = '<h3><span onclick="' + pagerName + '.prev();" class="pg-normal"> &#171 </span> Previous Next</h3>'; 
	for (var page = 1; page <= this.pages; page++) 
	pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');"></span>'; 
	pagerHtml += '<h3><span onclick="'+pagerName+'.next();" class="pg-normal"> »</span></h3>'; 

	element.innerHTML = pagerHtml; 
	} 
	} 
	</script>
<style type="text/css">
            .pg-normal {
                color: black;
                font-weight: normal;
                text-decoration: none;   
                cursor: pointer;   
            }
            .pg-selected {
                color: black;
                font-weight: bold;       
                text-decoration: underline;
                cursor: pointer;
            }
        </style>
        
<s:form>
<table align="center" id='results' cellspacing="20">
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
<s:if test="%{report.size()==0}">
<tr><td>This item has not been bought by any buyer!!</td></tr>
</s:if>
<s:else>
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
</s:else>
</table>
<center>
<%-- <s:form action="logout" align="center">
<s:submit name = "submit" value="Back to Home Page" align="center"/>--%>
<!-- <div id="pageNavPosition"></div>  -->
</s:form> 
</center>

<script type="text/javascript"><!-- 
var pager = new Pager('results', 2); 
pager.init(); 
pager.showPageNav('pager', 'pageNavPosition'); 
pager.showPage(1); 
//--></script>
<div>
			<br><br></br>
			<div class="pcontent">
				<!--cacheStatus: false-->
				<span class="ebay"> <%@include file="footer.jsp"%>


				</span>
				<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

				<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
			</div>
		</div>

</body>
</html>