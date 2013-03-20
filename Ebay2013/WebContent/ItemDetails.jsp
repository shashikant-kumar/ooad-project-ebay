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
							
    <li><a href="#">Item Details &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>
   
<table align="center">
<tr>
<td><img src="./images/<s:property value = "item_detail.item_image" />" alt="image text" width="350" height="375"/></td>
<td><table id="text" cellspacing="5">
    <tr><td><s:property value="item_detail.item_name"/></td></tr><tr></tr><tr></tr>
  <tr> <td>Item Condition:&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<s:property value="item_detail.item_condition"/></td><td></td><td></td><td></td><td></td><td></td>
<s:url id="seller" action="sellerInfo">
<s:param name="sellername" value="item_detail.seller_name"/>
</s:url>
<td><s:a href="%{seller}">View Seller Information: <s:property value="item_detail.seller_name"/></s:a></td></tr> <tr></tr><tr></tr>
    <tr><td><s:textfield label = "Quantity"  name="quantity"  size="10" /></td><td><s:property value="item_detail.quantity"/> available</td></tr><tr></tr><tr></tr>
    <tr><td>Price:  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; Rs.<s:property value="item_detail.item_price"/></td></tr><tr></tr><tr></tr>
    <tr><td><s:submit name = "AddtoCart"  value="Add to Cart" align="center" /></td></tr><tr></tr><tr></tr>
    <tr><td><s:submit name = "Addtolist"  value="Add to List" align="center" /></td></tr><tr></tr><tr></tr>
    <tr><td>Shipping:&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<s:property value="item_detail.courier"/></td></tr><tr></tr><tr></tr>
    <tr><td>Payments:  PaisaPay(Online Bank Tranfer)</td></tr><tr></tr><tr></tr>
    <tr><td>Returns :&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;   7days, Exchange</td></table></td><tr></tr><tr></tr>
</table>
</body>
<div>
				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>
			</div>
</html>