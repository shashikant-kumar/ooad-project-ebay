<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Selling History</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
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
<h2  class="cellcolor">ORDERED ITEMS</h2>
<s:if test="prev_acc_bal!=0">
<div align="right">Previous Account Bal is Rs<s:property value="prev_acc_bal"/></div>
</s:if>
<s:if test="new_acc_bal!=0">
<div align="right">New Account Bal is Rs<s:property value="new_acc_bal"/></div>
</s:if>

<s:if test="orderItemList.size()!=0">
       <s:set name="theme" value="'simple'" scope="page" />
      
<table align="center" cellspacing="40">
<tr><th>ITEM NAME</th>
<th > IMAGE</th>
<th> QUANTITY</th>

<th>PRICE</th>
<th>TRANS DATE</th>
<th>TRANS STATUS</th>

</tr>

<s:iterator value ="orderItemList">
<tr><td><s:property value="item_name"/></td>
<td><img src="./images/<s:property value = "item_image" />" alt="image text" width="150" height="175"/></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="selectedQuantity"/></td>
<td><s:property value="cum_price"/></td>
<td><s:property value="tran_date"/></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="tran_status"/></td>
<s:form action="sellingHistory">
<s:hidden name="transactionId" value="%{tranId}" />
<s:hidden name="SLA" value="%{sla}" />
<s:hidden name="cumPrice" value="%{cum_price}" />
<td><s:submit name="commandButton"  value="Update to be shipped"/></td>

<hr>
</s:form>

</tr>
</s:iterator>
</table>
</s:if>
<s:if test="orderItemList.size()==0">
<h3><i>No Item Has been ordered</i></h3>
</s:if>
<h2  class="cellcolor">SOLD ITEMS</h2>
<s:if test="soldItemList.size()!=0">
       <s:set name="theme" value="'simple'" scope="page" />
      
<table align="center" cellspacing="40">
<tr><th>ITEM NAME</th>
<th > IMAGE</th>
<th> QUANTITY</th>

<th>PRICE</th>
<th>TRANS DATE</th>
<th>TRANS STATUS</th>
</tr>
<s:iterator value ="soldItemList">

<tr><td><s:property value="item_name"/></td>
<td><img src="./images/<s:property value = "item_image" />" alt="image text" width="150" height="175"/></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="selectedQuantity"/></td>
<td><s:property value="cum_price"/></td>
<td><s:property value="tran_date"/></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="tran_status"/></td>


</tr>

</s:iterator>
</table>



</s:if>
<s:if test="soldItemList.size()==0">
<h3><i>No Item has been shipped</i></h3>
</s:if>
<h2  class="cellcolor">ACTIVE ITEMS</h2>
<s:if test="activeItemList.size()!=0">
       <s:set name="theme" value="'simple'" scope="page" />
      
<table align="center" cellspacing="40">
<tr><th>NAME</th>
<th > IMAGE</th>
<th> STOCK</th>
<th>ORIGINAL PRICE</th>
<th>DISCOUNT</th>
<th>DIS. PRICE</th>
</tr>
<s:iterator value ="activeItemList">

<tr><td><s:property value="item_name"/></td>
<td><img src="./images/<s:property value = "item_image" />" alt="image text" width="150" height="175"/></td>
<td><s:property value="selectedQuantity"/></td>
<td><s:property value="item_price"/></td>
<td><s:property value="item_discount"/></td>
<td><s:property value="discount_price"/></td>
<s:form action="editItemDetail">
<s:hidden name="itemId" value="%{item_id}" />
<td><s:submit name="commandButton"  value="Edit Details"/></td>


</s:form>





</tr>

</s:iterator>
</table>



</s:if>
<s:if test="activeItemList.size()==0">
<h3><i>No Item is currently on sale</i></h3>
</s:if>


</body>
</html>

