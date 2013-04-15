<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="hover.css" type="text/css" rel="stylesheet">
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<head>
</head>
<body>
    <div>
		<br />
	</div>
	<table>
		<tr>
			<td width="190"></td>
			<td width="940">
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
				<div id="AreaTitle" class="AreaTitle">
					<div class="title">
						<b id="mainContent">
							<b class="g-nav coreFooterLegalNotice">Welcome! </b>&nbsp;
							<s:if test="%{username==null}">
                            <a href="Login">Sign in</a> or <a href="Register">Register</a><br>&nbsp;<br />
                            </s:if>
                             <s:elseif test="%{username==''}">
                            <a href="Login">Sign in</a> or <a href="Register">Register</a><br>&nbsp;<br />
                            </s:elseif>						
                            <s:else>
                             Hi, <s:property value="username"/>!
                            (<a href="signout">Sign out</a>)<br>&nbsp;<br />
                            </s:else>
                            <s:set name="theme" value="'simple'" scope="page" />
                            <table>
                            <tr>
                            <s:form action="searchItem"> 
<td>
<s:textfield label= " Search by item or category" name="searchValue" value="" size="30" placeholder="search by item or category" /></td> &nbsp; &nbsp; &nbsp;
 <td><s:submit name="commandButton" value="search" ></s:submit></td>
                            </s:form>
                            </tr>
                            </table>
							<ul id="NOINTERFERE00_menu">
							
    <!-- <li><a href="categories">CATEGORIES</a></li> -->
 <ul class="cssMenu">
	<li>
		<a href="allcategories">Categories</a>  
		        
		<ul>
		<s:iterator value="allcats"> 
	    	<li><a href="categories?categoryName=<s:property value="categ_name"/>"><s:property value="categ_name"/></a></li>
			</s:iterator>
		</ul>
		
	</li>
	</ul>
    <!-- <li><a href="#">GLOBAL EASYBUYs</a></li>
    <li><a href="#">FASHION</a></li>
    <li><a href="#">HOLIDAYS</a></li>
<li><a href="#">INSURANCE</a></li> -->
<li><a href="sellItem">Sell</a></li>
<li><a href="purchasehistory">PURCHASE HISTORY </a></li>
<li><a href="sellingHistory">SELLING HISTORY</a></li>
<li><a href="viewdeals">DEALS</a></li>
</ul>			
</body>
</html>				