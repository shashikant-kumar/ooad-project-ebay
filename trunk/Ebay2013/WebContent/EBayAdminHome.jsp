<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EBay Admin</title>
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

	</br>
<div style="margin:-15px 0 -9px 0;_margin:-15px 0 -10px 0;" class="pageHeader"><table cellpadding="0" cellspacing="0" border="0">
<tbody><tr><td><b id="mainContent">
<h1 class="regPgHeading">Welcome to Ebay Admin portal</h1> <b class="standardtitle">(<a href="signout">Sign out</a>)</b></td></tr>
</tbody></table></div>														
<s:set name="theme" value="'simple'" scope="page" />

<h3><s:property value="msg"/> </h3>
<ul> 
					<ul id="NOINTERFERE00_menu">
							
      <li>
    <s:url id="cats" action="manageCategoriesSubcategories">
<s:param name="param" value="'categories'"/>
</s:url>
<s:a href="%{cats}">Manage Categories</s:a>
    </li>
   <li>
    <s:url id="subcats" action="manageCategoriesSubcategories">
<s:param name="param" value="'subcategories'"/>
</s:url>
<s:a href="%{subcats}">Manage Sub Categories</s:a>
    </li>
    <li>
    <s:url id="manageUsers" action="AdminManageUsers"/>
    <s:a href="%{manageUsers}">Manage Users</s:a>
    </li>
    <li>
    <s:url id="seller" action="AdminViewSellerList">
	</s:url>
    <s:a href="%{seller}">View FeedBack</s:a></li>
</ul>

<br><br>

</br>
	 
  <div>
				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="body.jsp"%>

	</br>
					</span>
					</div>
			</div>
</br>

</body>
<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>
</html>