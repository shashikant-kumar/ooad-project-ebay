<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Author: Sruti Davis -->
<html>
<head>
<style type="text/css">
h4.intro {color:blue;font-family: Arial, Verdana;
   font-size: 16px; }
div.important {color:green;}
</style>
<title>My Shopping Cart</title>
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

	<br />
					</span>
					</div>
			</div>

	<br />
</head>
<body>
<s:if test="%{msgToCart!=null}">
<h4><s:property value="msgToCart"/></h4>
</s:if>
<div>
<h4 class="intro">My Shopping Cart</h4>
<ul><li>Your shopping cart might contain items from different sellers.</li></ul>
</div>

<ul id="NOINTERFERE00_menu">
  <li><h4><a href="#">Items in my cart &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></h4></li>
</ul>
<div>
	<table width="100%" cellpadding="10" cellspacing="10" border="0">
	<body>
	<s:form name="buy" action="buyitNow">
	<tr>
		<th></th><th></th>
		<th width="75%" align="right"><div style="padding-right:60px"><b><h3>Price</h3></b></div></th>
	    <th width="15%"><b><h3>Quantity</h3></b></th>
	    <th width="10%"><b><h3>Sub-total</h3></b></th>
	</tr>
	<s:iterator value="items" status="stats">
	<tr>
	<td width="25%">
	<ul id="NOINTERFERE00_menu">
    <li><h4><a href="#">From Seller: <s:property value="seller_name"/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></h4></li>
    </ul>
	</td>
	</tr>
	<tr>
	<td width="10%"><img src="<s:property value = "item_image" />" alt="image text" width="150" height="175"/></td>
	<s:url id="itemDetails" action="ItemDetails">
     <s:param name="item" value="item_id"/>
    </s:url>
	<td><s:a href="%{itemDetails}"><s:property value="item_name"/></s:a></td>
	<td width="30%" align="right"><div style="padding-right:60px"><s:property value="item_price"/></div></td>
	<td width="15%"><s:textfield name="items[%{#stats.index}].selectedQuantity"  size="10"/></td>
	<td width="10%"><s:property value="item_subTotal"/></td>
	<%-- <s:hidden value="items[%{#stats.index}].item_discount"/>
	<s:hidden value="items[%{#stats.index}].item_condition"/>
	<s:hidden value="items[%{#stats.index}].quantity"/>
	<s:hidden value="items[%{#stats.index}].categ_id"/>
	<s:hidden value="items[%{#stats.index}].subcategory_id"/>
	<s:hidden value="items[%{#stats.index}].courier"/>
	<s:hidden value="items[%{#stats.index}].category_name"/>
	<s:hidden value="items[%{#stats.index}].subcategory_name"/>
	<s:hidden value="items[%{#stats.index}].other"/>
	<s:hidden value="items[%{#stats.index}].discount_price"/>
	<s:hidden value="items[%{#stats.index}].save_price"/>
	<s:hidden value="items[%{#stats.index}].sellerId"/> --%>
	
	<s:url id="remove" action="removeFromCart">
     <s:param name="item_id" value="item_id"/>
    </s:url>
    <td><s:a href="%{remove}">Remove</s:a></td>
	<%-- <td><s:form name="buy" action="buyitNow">
	<td><s:submit name="items[%{#stats.index}].item_id" label="Buy it Now" value="Buy It Now"/></td>
	</s:form></td> --%>
	</tr>
	</s:iterator>
	</body>
	</table>
</div>
<div align="right">
<br />
<s:label name="Total" value="Cart Total:" />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <s:property value="cartTotal"/>
</div>
<br/>
<div style="padding-top:20px" align="center">

<s:submit name = "ProceedToPay" value="Proceed To Pay"/>
</s:form>
</div>

</body>
</html>