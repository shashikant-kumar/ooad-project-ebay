<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Manage Users</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="register1.css" >
<link rel="stylesheet" type="text/css" href="register2.css" >
</head>
<body>
<div>
					<a rel="nofollow" href="home.jsp"> <img border="0"
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
<body>

<br />
<br />
<center><div style="margin:-15px 0 -9px 0;_margin:-15px 0 -10px 0;" class="pageHeader"><table cellpadding="0" cellspacing="0" border="0"><tbody><tr><td><b id="mainContent"><h1 class="regPgHeading">Sellers with Low Rating</h1></b></td></tr></tbody></table></div></center>
<s:form action="AdminManageUsers">
<table align="center" cellpadding="0" cellspacing="0" border="0">
<tr>
<th><h3>Seller ID</h3></th>
<th><h3>Seller Rating</h3></th>
<th><h3>Block Seller?</h3></th>
</tr>
<s:iterator value="sellersToBeBlocked">
<tr>
<td><h4><s:property value="userId" /></h4></td>
<td><h4><s:property value="sellerRating" /></h4></td>
<s:url id="block" action="AdminManageUsers">
<s:param name="blockSeller" value="true"/>
<s:param name="sellerId" value="userId"/>
</s:url>
<td><h4><s:a href="%{block}">Block Seller</s:a></h4></td>
</tr>
</s:iterator>
<tr><td><center>
<s:submit name = "commandButton" value="Back to Admin Home" id = "mysubmit" style="height: 30px; width: 200px">
</s:submit>
</center></td></tr>
</table>
</s:form>
</body><br><br><br><br>
<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>

</html>