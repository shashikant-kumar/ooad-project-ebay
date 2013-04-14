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
<script src="jquery-1.9.1.min.js"></script>
<script>
$(document).ready(function(){
  $(".button").click(function(){
	 // alert("button clicked");
    //alert("Value: " + $(".itemId").length);
    //alert("Value again: " + $(".itemId.items").val());
    $("#item").val($(".itemId").val());
  });
});
</script>
	<br/>
	<br/>
	<s:set name="theme" value="'simple'" scope="page" />
                            <table align="right">
                            <tr>
                            
	<s:form action="fetchitems"> 
	<s:hidden name="subcategory" value="%{subcategory}"></s:hidden>
<td>
Rs<s:textfield name="price1" value="" size="10" placeholder="enter price" /> &nbsp; &nbsp; &nbsp;Rs<s:textfield name="price2" value="" size="10" placeholder="enter price" /></td>
 <td><s:submit name="commandButton" value="search" ></s:submit></td>
                            </s:form>
                            </tr>
                            </table>
    
<title>show all items</title>
</head>
<body>
<ul id="NOINTERFERE00_menu">
<br/>
							
    <li><a href="#">All Items &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>
<!-- <h1 align="center">Items</h1>  -->
<table align="center">

<s:if test="%{itemlist.size()==0}">
<h2>This Subcategory has no items under this</h2>
</s:if>
<s:else>

<table align="center" cellspacing="60">
<s:form name="buy" action="buyitNow">
<td>
<s:iterator value="itemlist" status="stats" id="list">
<tr>
<td><img src="./images/<s:property value = "item_image" />" alt="image text" width="150" height="175"/></td>
<s:url id="ItemName" action="ItemDetails">
<s:param name="item" value="item_id"/>
</s:url>
<td><s:a href="%{ItemName}"><s:property value="item_name"/></s:a></td>
<td  class="itemId"><s:hidden name="itemID" id="items" value="%{item_id}"/></td>

<td class="button"><s:submit name="commandButton" label="Buy it Now" value="Buy It Now"/></td>

<td>Bid or Buying</td>
<td>Rs. <s:property value="item_price"/></td>
<td></td>
<td><img src="./images/pay.jpg" alt="image text" width="70" height="55"/></td></tr>
</s:iterator>
</td>
<s:hidden name="itemId" id="item"/>
</s:form>
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