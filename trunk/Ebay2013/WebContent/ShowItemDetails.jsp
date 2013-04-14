<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>show all items in order</title>
</head>
<body>
<ul id="NOINTERFERE00_menu">
							
  <li><a href="#">Item Details &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>
   
<s:if test="%{orderItemList.size()==0}">
<h4>This order has no items</h4>
</s:if>
<s:else>
<table align="center" cellspacing="60">
<tr> 
    <th><h4>Item Image</h4></th>
    <th><h4>Item Name</h4></th>
    <th><h4>Item Price</h4></th>
    <th><h4>Order Status</h4></th>
    <th><h4>Order Date</h4></th>
    <th><h4>Give Feedback</h4></th>
        </tr>
<s:iterator value="orderItemList">
<tr><td><img src="./images/<s:property value = "item_image" />" alt="image text" width="150" height="175"/></td>
<td><s:property value="item_name"/></td>
<td><s:property value="item_price"/></td>
<td><s:property value="tran_status"/></td>
<s:hidden name="tran_status" value="%{tran_status}"/>
<td><s:property value="trans_date"/></td>
<s:if test="%{tran_status == \"S\"}" >
<td><a href="giveFeedback?tranId=<s:property value = "tran_id" />" >Give Feedback</a></td>
</s:if>
</tr>
</s:iterator>
</table> 
</s:else>
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