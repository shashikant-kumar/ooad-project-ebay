<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<html>
<head>
<title>Selling History</title>
</head>
<body>
<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="header.jsp"%>

	</br>
					</span>
</div>
<br/>
<br/>


<h3 class="cellcolor">EDIT ITEM DETAILS</h3>
<form action="editItemDetail">
<table align="center" cellspacing="3" cellpadding="2"><tr>
<td>Name</td><td><s:textfield name="item_name" label = "Name "  value="%{item.item_name}"/></td></tr>
   <tr> <td>Price</td><td><s:textfield name="price" label = "Price "  value="%{item.item_price}"  size="20"  /></td></tr>
  <tr>  <td>Discount</td><td><s:textfield name="discount" label = "Discount " value="%{item.item_discount}"  size="20"  /></td></tr>
  <tr>  <td>Stock</td><td><s:textfield name="stock" label = "Stock" value="%{item.quantity}"  size="20"  /></td></tr>
  <tr><td></td><td><img src="<s:property value = "item.item_image" />" alt="image text" width="150" height="150"/></td></tr>
  </table>
  <table align="center">
   <tr><s:file name="image" label="Item Image" value="%{item_detail.item_image}"/></tr>
   <s:hidden name="item_id" value="%{item.item_id}"/>
  <tr> <s:submit name = "commandButton"   value="Update"/></tr></table>
  </form>
 </body>
 </html>