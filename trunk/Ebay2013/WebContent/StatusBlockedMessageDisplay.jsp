<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Status Blocked</title>
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
</head>
<body>

<table align="center">
<tr><td><center><h2>Sorry <s:property value="username" />, you have been blocked from selling items on eBay.</h2></center></td></tr>
<tr>
<s:url id="goBack" action="Login">
<s:param name="userid" value="userId"/>
<s:param name="password" value="password"/>
</s:url>
<td><h4><s:a href="%{goBack}">Click here to go back to home page.</s:a></h4></td>
</table>

</body><br><br><br><br>
<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>

</html>