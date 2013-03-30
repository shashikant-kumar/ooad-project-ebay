<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ebay Items</title>
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
<title>show all items</title>
</head>
<body>
<ul id="NOINTERFERE00_menu">
<li><a href="#">Ebay My World seller name &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>
   <br>
   <br>
 <table>
 <tr>
 <table align="center">

<tr></tr>
   <tr> <td>Seller Rating:</td><td><s:property value="avgRating"/></td></tr>
   <tr><td>Number Of Ratings:</td><td><s:property value="noOfRating"/></td></tr>
  <tr><td>Location:</td><td><s:property value="location"/></td></tr>
    <tr><td>Member Since:</td><td><s:property value="memberSince"/></td></tr>
    
    
</table>
</tr>
<br>
<br>
<br>
<br>
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
<div>
				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>
			</div>
<%-- <s:textfield label = "Seller Rating"  name="avgRating"  size="10" />
<s:textfield label = "Location"  name="location"  size="10" />
<s:textfield label = "Member Since"  name="memberSince"  size="10" />
<s:textfield label = "Number Of Ratings"  name="noOfRating"  size="10" />
<input name="star1" type="radio" class="star {split:2}"/>
<input name="star1" type="radio" class="star" checked="checked"/>
<input name="star1" type="radio" class="star"/>
<input name="star1" type="radio" class="star"/>
<input name="star1" type="radio" class="star"/> --%>
</body>
</html>