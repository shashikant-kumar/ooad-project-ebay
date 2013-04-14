<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Seller Feedback</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<link href="css4.css" type="text/css" rel="stylesheet">
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
<h1 align="center"><s:property value="sellername"/> Seller Feedback</h1> 
   <br>
   <br>
 <table>
 <tr>
 <table align="center" border="0">
<tr></tr>
<tr><td align="left"><b>Seller Rating:</b></td><td align="left"><s:property value="avgRating"/></td></tr>
<tr><td align="left"><b>Number Of Ratings:</b></td><td align="left"><s:property value="noOfRating"/></td></tr>
<tr><td align="left"><b>Location:</b></td><td align="left"><s:property value="location"/></td></tr>
<tr><td align="left"><b>Member Since:</b></td><td align="left"><s:property value="memberSince"/></td></tr>
</table>
</tr>
<br>
<tr>
<table align="center">
<tr></tr>
<tr><s:iterator var="itr" value="itemList">
									<td>
				<!--						 PRODUCTS ROW 1,1-->
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td valign="top">
				<!--										 PRODUCT 1 -->
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
													<div class="container1 container">
													<div style="position:relative;">
													<li style="float: left;">
														<tbody>
														<td width="4" class="nodealCol">&nbsp;</td>
														<td width="193" class="dealCol">
														<s:url id="ItemName" action="ItemDetails">
														<s:param name="item" value="item_id"/>
														</s:url>
														<div class="mdt"><s:a href="%{ItemName}"><s:property value="item_name"/></s:a></div>
														<br>
														<div class="dealImg" target="_top" style="text-decoration:none;"><s:a href="%{ItemName}">
														<img src="./images/<s:property value="item_image"/>" class="lazy" data-original="" width="140" height="140" border="0" style="top: 0px; display: inline-block;"></s:a></div>
														<div class="priceinfoDiv">MRP <span class="WebRupee WebRupeeInfo">Rs.</span> <s:property value = "item_price"/>
														</div>
														</td>
														</tbody></li></div></div></div>
														
													</table>
												</td>	
											</tr>
										</table>
									</td>
								</s:iterator></tr> 
</table>
</tr>
</table>
<center>
<s:form action="manageCategoriesSubcategories" align="center">
<s:submit name = "commandButton" value="Back to Admin Home" id = "mysubmit" style="height: 30px; width: 200px">
</s:submit>
</s:form>
</center>
</body><br><br><br><br>
<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>

</html>