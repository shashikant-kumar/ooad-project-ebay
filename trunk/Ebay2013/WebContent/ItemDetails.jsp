<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
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
   <br><br>
<table align="left" border="0">
<s:if test="%{nlist.size()!=0}">
<s:url id="WatchList" action="WatchList">
<s:param name="item" value="item_detail.item_id"/>
</s:url>
<!-- <h3>Saved in your Watch list |Remove</h3> -->
<tr>
<td>
<h4>Added to your <s:a href="%{WatchList}">Watch list</s:a></h4>
</td></tr>
</s:if>
<s:if test="%{msg=='saved'}">
<s:url id="WatchList" action="WatchList">
<s:param name="item" value="item_detail.item_id"/>
</s:url>
<tr>
<td>
<h4>Added to your <s:a href="%{WatchList}">Watch list</s:a></h4>
</td></tr>
</s:if>
<s:if test="%{msg=='alreadyAdded'}">
<s:url id="WatchList" action="WatchList">
<s:param name="item" value="item_detail.item_id"/>
</s:url>
<tr>
<td>
<h4>Already Added to your <s:a href="%{WatchList}">Watch list</s:a></h4>
</td></tr>
</s:if>

</table>
<br>
<br>
<br><br><br>
<s:form>   
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
    <tr><td><s:textfield label = "Quantity"  name="quantity" value="1" size="10" /></td><td><s:property value="item_detail.quantity"/> available</td></tr><tr></tr><tr></tr>
    <tr><td>Price:  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; Rs.<s:property value="item_detail.discount_price"/></td></tr><tr></tr><tr></tr>
     <s:hidden name="item_id" value="%{item_detail.item_id}"/>
    <tr><td><s:submit name = "AddtoCart"  value="Add to Cart" align="center" onclick='this.form.action="myShoppingCart";'/></td></tr><tr></tr><tr></tr>
    <tr><td><s:submit name = "Addtolist"  value="Add to List" align="center" onclick='this.form.action="AddToList";'/></td></tr><tr></tr><tr></tr>
    <tr><td>Shipping:&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<s:property value="item_detail.courier"/></td></tr><tr></tr><tr></tr>
    <tr><td>Payments:  PaisaPay(Online Bank Tranfer)</td></tr><tr></tr><tr></tr>
    <tr><td>Returns :&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;   7days, Exchange</td></table></td><tr></tr><tr></tr>
</table>
</s:form>
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