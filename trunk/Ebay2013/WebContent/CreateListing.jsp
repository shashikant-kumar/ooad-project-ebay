<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<script type = "text/javascript">
function fnAlphaNumeric(fieldname)
{
	//alert(fieldname.value);
	if(fieldname.value != ""){
		if(fieldname.value.match(/^[0-9a-zA-Z ]+$/)){   
	  		return true;
		}
		else{
			alert ("Only alphanumeric characters and spaces are valid in this field");
			fieldname.value = "";
			fieldname.focus();
			return false;
		}
	}
	return true;
}
function fnNumeric(fieldname)
{
	if (/[^0-9]/gi.test(fieldname.value))
	{
		alert ("Only numeric values are valid in this field");
		fieldname.value = "";
		fieldname.focus();
		return false;
	}
}
function validateForm()
{
	var x=document.forms["createList"]["title"].value;
	var y=document.forms["createList"]["subTitle"].value;
	var z=document.forms["createList"]["condition"].value;
	var a=document.forms["createList"]["buyItNowPrice"].value;
	var b=document.forms["createList"]["buyItNowQuantity"].value;
	var c=document.forms["createList"]["sla"].value;
	var j=document.forms["createList"]["image"].value;
	var off=document.forms["createList"]["offer"].value;
	if (x==null || x=="" || y==null || y=="" ||z==""||z==null||a==""||a==null||b==""||b==null||j==null||j==""||off==null||off=="")
	  {
		  alert("Enter The Mandatory Field's Values");
		  return false;
	  }
	  
	var d = document.forms["createList"]["categ"].value;
	if(d=="Books and Magazines"){
		var e = document.forms["createList"]["author"].value;
		var f = document.forms["createList"]["bookType"].value;
		var g = document.forms["createList"]["edition"].value;
		var h = document.forms["createList"]["language"].value;
		var i = document.forms["createList"]["publisher"].value;
		if(e==null || e=="" || f==null || f=="" ||g==null || g=="" || h==null || h=="" ||i==null||i==""){
			alert("Enter The Mandatory Field's Values");
			  return false;
		}
	}
}
</script>
<title>Start Listing</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<sd:head/>
</head>
<body>

	<div>
		<br />
	</div>
<div>
	<div class="pcontent">
		<!--cacheStatus: false-->
		<span class="ebay"> 
			<%@include file="header.jsp"%>
			<br>
		</span>
	</div>
</div>

<br>

<h5>Create Your Listing</h5>
<br>
 <s:set name="theme" value="'simple'" scope="page" />
  <h3><s:property value="msg"/> </h3>
  <s:form name="createList" action="createListing" onsubmit="return validateForm()">
  <table>
  <tr>
  <th>Categories where your listing will appear</th></tr>
  <tr><td>Category: <s:property value="categ"/> &gt;<s:property value="subCateg"/></td></tr>
  <s:hidden name="categ" value="%{categ}"/>
  <s:hidden name="subCateg" value="%{subCateg}"/>
  <tr><td><a href="listSellItemCateg1">Change category</a></td></tr>
  </table>
  <br>
  <br>
  <table>
  <tr><th>Help buyers find your item with a great title</th></tr>
  <tr></tr><tr></tr>
  <tr><td>Title<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:textfield name="title" placeholder="Enter title for your item." mandatory="yes" onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td>Subtitle<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:textfield name="subTitle" placeholder="Enter subtitle for your item." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td>Offer<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:select name="offer" list="#{'Yes':'Yes','No':'No'}" headerKey="" headerValue="Select" required="true"  placeholder="Select Yes if you want to give offer"/></td> </tr>
   <tr><td>Condition<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:select name="condition" list="#{'Brand New':'Brand New','Like New':'Like New','Very Good':'Very Good','Good':'Good','Acceptable':'Acceptable'}" headerKey="" headerValue="Select" required="true"  placeholder="Select condition of your item." /></td> </tr>
  <table>
  <br>
  <br>
  <tr><th>Item specifics</th></tr>
  <%
  String cat=request.getParameter("categ"); 
  if(cat.equals("Books and Magazines")){%>
  <tr><td>Author Name<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:textfield name="author" placeholder="Enter Author Name." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td>Book Type<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:select name="bookType" list="#{'1':'Hard Cover','2':'Paper Back'}" headerKey="" headerValue="Select" required="true"  placeholder="Enter book type"/></td> </tr>
  <tr><td>Edition<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:textfield name="edition" placeholder="Enter Book Edition." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td>Imported Edition</td></tr>
  <tr><td><s:select name="importedEdition" list="#{'1':'Yes','2':'No'}" headerKey="" headerValue="Select" required="true"  placeholder="Select if imported edition"/></td> </tr>
  <tr><td>ISBN-10</td></tr>
  <tr><td><s:textfield name="isbn10" placeholder="Enter Book ISBN-10." onblur="fnNumeric(this)"/></td> </tr>
  <tr><td>ISBN-13</td></tr>
  <tr><td><s:textfield name="isbn13" placeholder="Enter Book ISBN-13." onblur="fnNumeric(this)"/></td> </tr>
  <tr><td>Language<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:textfield name="language" placeholder="Enter Book Language." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td>Publisher<img src="images/greenStar.gif" alt="Required"/></td></tr>
  <tr><td><s:textfield name="publisher" placeholder="Enter Book Publisher." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <%} %>
  <tr><td>Add your own item specific</td></tr>
  <tr><td><s:textfield name="attr1" placeholder="Enter item specific name." onblur="fnAlphaNumeric(this)"/></td>
  <td><s:textfield name="val1" placeholder="Enter item specific value." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td><s:textfield name="attr2" placeholder="Enter item specific name." onblur="fnAlphaNumeric(this)"/></td>
  <td><s:textfield name="val2" placeholder="Enter item specific value." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td><s:textfield name="attr3" placeholder="Enter item specific name." onblur="fnAlphaNumeric(this)"/></td>
  <td><s:textfield name="val3" placeholder="Enter item specific value." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td><s:textfield name="attr4" placeholder="Enter item specific name." onblur="fnAlphaNumeric(this)"/></td>
  <td><s:textfield name="val4" placeholder="Enter item specific value." onblur="fnAlphaNumeric(this)"/></td> </tr>
    </table>
    <br>
    <br>
    <table>
  <tr><th>Bring your item to life with pictures<img src="images/greenStar.gif" alt="Required"/></th></tr>
  <tr><td><s:file name="image" /></td></tr>
  </table>
  <br>
  <br>
  <table>
  <tr><th>Describe the item you are selling</th></tr>
  <tr><td><s:textarea name="description" cols="100" rows="5" onblur="fnAlphaNumeric(this)"/></td></tr>
  </table>
  <br>
  <br>
  <table>
  <tr><th>Choose how you'd like to sell your item</th></tr>
  <tr><td>Buy It Now price<img src="images/greenStar.gif" alt="Required"/></td><td><s:textfield name="buyItNowPrice" placeholder="Enter price" onblur="fnNumeric(this)"/></td></tr>
  <tr><td>Quantity<img src="images/greenStar.gif" alt="Required"/></td><td><s:textfield name="buyItNowQuantity" placeholder="Enter quantity." onblur="fnNumeric(this)"/></td></tr>
  <tr><td>Duration(in months)</td><td><s:textfield name="buyItNowDuration" placeholder="Enter duration of listing item." onblur="fnNumeric(this)"/></td></tr>
  <tr><td>Discount(If any or can modify in future)</td><td><s:textfield name="discount" placeholder="Enter discount percentage if any." onblur="fnNumeric(this)"/></td></tr>
  <br>
  <!-- tr><td><s:radio label="Listing when?" name="listingTime" list="#{'1':'Start listing immediately','2':'Schedule start time (Rs. 1.00)'}" value="1" ></s:radio></td></tr>
  <tr><td><sd:datetimepicker label="Start Date" name="startDate" required="true" displayFormat="yyyy-MM-dd" /></td>
  </tr-->
  </table>
  <br>
  <br>
  <!-- >table>
  <tr><th>Decide how you'd like to be paid</th></tr>
  <tr><td><s:checkboxlist label="Payment Mode" name="modeOfPayment" list="#{'1':'COD','2':'Credit/Debit Card','3':'Net Banking'}"/></td></tr>
  </table -->
  <br>
  <br>
  <table>
  <tr><th>Pay eBay(percentage of each items price)</th></tr>
  <tr><td>SLA<img src="images/greenStar.gif" alt="Required"/></td><td><s:textfield name="sla" placeholder="Enter SLA percentage" onblur="fnNumeric(this)"/></td></tr>
  </table>
  <br>
  <br>
  <table>
  <tr><th>Give buyers shipping details</th></tr>
  <tr><td>Domestic shipping services</td></tr>
  <tr><td><s:textfield name="courier" placeholder="Enter shipping service." onblur="fnAlphaNumeric(this)"/></td> </tr>
  <tr><td>Shipping Cost to Buyer</td></tr>
  <tr><td>Rs.<s:textfield name="shippingCost" placeholder="Enter shipping Cost in Rs."/></td>
  <td><s:checkbox name="waver" onChange="fnWaver(this)"/></td><td>Free Shipping</td> </tr>
   <tr><td>Handling Time</td></tr>
  <tr><td><s:select name="handlingTime" list="#{'1 Business day':'1 Business day','2 Business day':'2 Business day','3 Business day':'3 Business day','4 Business day':'4 Business day','5 Business day':'5 Business day','10-15 Business day':'10-15 Business day'}" headerKey="" headerValue="Select" required="true"  placeholder="Select a handling time."/></td> </tr>
   <tr><td>Item Location</td></tr>
   <tr><td><s:property value="city"/>,<s:property value="state"/>,<s:property value="pin"/>,<s:property value="country"/></td></tr>
   </table>
   <br>
   <br>
   <table>
  <tr><th>Other things you'd like buyers to know</th></tr>
  <tr><td>Warranty & Return Policies</td></tr>
  <tr><td><s:select name="returnPolicy" list="#{'Returns Accepted':'Returns Accepted','Returns not accepted':'Returns not accepted'}" headerKey="" headerValue="Select" required="true"  placeholder="Select a return policy option."/></td></tr>
  <tr><td>Payment Instructions(note:500 character limited)</td></tr>
  <tr><td><s:textarea name="paymentInstruction" cols="100" rows="5" onblur="fnAlphaNumeric(this)"/></td></tr>
  </table>
  <br>
  <!-- table>
  <tr><td>Fee so far : Rs 1</td></tr>
  </table-->
  </table>
  <br>
  <br>
  <img src="images/greenStar.gif" alt="Required"/> indicates a required field
  <br>
  <br>
  <s:submit name="commandButton" value="Review Your Listing" ></s:submit>
  </s:form> 
  
</body>
</html>