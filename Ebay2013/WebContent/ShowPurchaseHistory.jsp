<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Order Tracking</title>
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

	
	<ul id="NOINTERFERE00_menu">
							
    <li><a href="#">Order Details &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>
<h1 align="center">      </h1> 
<table align="center">

<s:if test="%{orderlist.size()==0}">
<h2>This user has no orders</h2>
</s:if>
<s:else>
<table align="center" cellspacing="50">

<tr> 
    <th><h4>Order Id</h4></th>
    <th><h4>Total Price</h4></th>
    <th><h4>Order Date</h4></th>
    <th><h4>Check Order Status</h4></th>
    <th><h4>Cancel Order</h4></th>
    </tr>
<s:iterator value="orderlist">
<tr>
<td> <s:property value="order_id"/></td>
<td> <s:property value="total_price"/></td>
<td> <s:property value="order_date"/></td>
<td>
<s:url id="orderid" action="showItemDetails">
<s:param name="order" value="order_id"/>
</s:url>
<s:a href="%{orderid}">Track Order Status</s:a></td>
<td>
<s:url id="cancelorder" action="cancelOrder">
<s:param name="order" value="order_id"/>
</s:url>
<s:a href="%{cancelorder}">Cancel Order</s:a></td>

</tr>
</s:iterator>
<h3><s:property value="msg"/> </h3>
</table> 
</s:else>
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