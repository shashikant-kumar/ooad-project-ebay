<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-/
/W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function fnWaver(a){
	
	
}
</script>
<title>Review Listing</title>
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

<h5>Review Your Listing</h5>
<br>
 <s:set name="theme" value="'simple'" scope="page" />
  <h3><s:property value="msg"/> </h3>
  <s:form name="createList" action="createListing">
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
  <tr><td>Title: </td><td><s:property value="title"/></td> </tr>
  <s:hidden value="%{title}" name="title"/>
  <tr><td>Subtitle: </td><td><s:property value="subTitle"/></td> </tr>
  <s:hidden value="%{subTitle}" name="subTitle"/>
  <tr><td>Condition: </td><td><s:property value="condition"/></td> </tr>
  <s:hidden value="%{condition}" name="condition"/>
  <table>
  <br>
  <br>
  <tr><th>Item specifics</th></tr>
  <%
  String cat=request.getParameter("categ"); 
  if(cat.equals("Books and Magazines")){%>
  <tr><td>Author Name :</td><td><s:property value="author"/></td> </tr>
  <s:hidden value="%{author}" name="author"/>
  <tr><td>Book Type :</td><td><s:property value="bookType"/></td> </tr>
  <s:hidden value="%{bookType}" name="bookType"/>
  <tr><td>Edition: </td><td><s:property value="edition"/></td> </tr>
  <s:hidden value="%{edition}" name="edition"/>
  <tr><td>Imported Edition: </td><td><s:property value="importedEdition"/></td> </tr>
  <s:hidden value="%{importedEdition}" name="importedEdition"/>
  <tr><td>ISBN-10: </td><td><s:property value="isbn10"/></td> </tr>
  <s:hidden value="%{isbn10}" name="isbn10"/>
  <tr><td>ISBN-13: </td><td><s:property value="isbn13"/></td> </tr>
  <s:hidden value="%{isbn13}" name="isbn13"/>
  <tr><td>Language: </td><td><s:property value="language"/></td> </tr>
  <s:hidden value="%{language}" name="language"/>
  <tr><td>Publisher: </td><td><s:property value="publisher"/></td> </tr>
  <s:hidden value="%{publisher}" name="publisher"/>
  <%} %>
  <tr><td>Add your own item specific</td></tr>
  <tr><td><s:property value="attr1"/></td>
  <s:hidden value="%{attr1}" name="attr1"/>
  <td><s:property value="val1"/></td> </tr>
  <s:hidden value="%{val1}" name="val1"/>
  <tr><td><s:property value="attr2"/></td>
  <s:hidden value="%{attr2}" name="attr2"/>
  <td><s:property value="val2"/></td> </tr>
  <s:hidden value="%{val2}" name="val2"/>
  <tr><td><s:property value="attr3"/></td>
  <s:hidden value="%{attr3}" name="attr3"/>
  <td><s:property value="val3"/></td> </tr>
  <s:hidden value="%{val3}" name="val3"/>
  <tr><td><s:property value="attr4"/></td>
  <s:hidden value="%{attr4}" name="attr4"/>
  <td><s:property value="val4"/></td> </tr>
  <s:hidden value="%{val4}" name="val4"/>
    </table>
    <br>
    <br>
    <table>
  <tr><th>Bring your item to life with pictures	</th></tr>
  <tr><td><img src="./images/<s:property value = "image" />" alt="image text" width="150" height="175"/></td></tr>
  <s:hidden value="%{image}" name="image"/>
  </table>
  <br>
  <br>
  <table>
  <tr><th>Describe the item you are selling</th></tr>
  <tr><td><s:property value="description"/></td></tr>
  <s:hidden value="%{description}" name="description"/>
  </table>
  <br>
  <br>
  <table>
  <tr><th>Choose how you'd like to sell your item</th></tr>
  <tr><td>Buy It Now price</td><td><s:property value="buyItNowPrice"/></td></tr>
  <s:hidden value="%{buyItNowPrice}" name="buyItNowPrice"/>
  <tr><td>Quantity</td><td><s:property value="buyItNowQuantity"/></td></tr>
  <s:hidden value="%{buyItNowQuantity}" name="buyItNowQuantity"/>
  <tr><td>Duration</td><td><s:property value="buyItNowDuration"/></td></tr>
  <s:hidden value="%{buyItNowDuration}" name="buyItNowDuration"/>
  <tr><td>Discount(If any or can modify in future)</td><td><s:property value="discount" /></td></tr>
  <s:hidden value="%{discount}" name="discount"/>
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
  <tr><td>SLA</td><td><s:property value="sla"/></td></tr>
  <s:hidden value="%{sla}" name="sla"/>
  </table>
  <br>
  <br>
  <table>
  <tr><th>Give buyers shipping details</th></tr>
  <tr><td>Domestic shipping services: </td><td><s:property value="courier"/></td> </tr>
  <s:hidden value="%{courier}" name="courier"/>
  <tr><td>Shipping Cost to Buyer: </td><td>Rs.<s:property value="shippingCost"/></td>
  <s:hidden value="%{shippingCost}" name="shippingCost"/>
  </tr>
   <tr><td>Handling Time: </td><td><s:property value="handlingTime"/></td> </tr>
   <s:hidden value="%{handlingTime}" name="handlingTime"/>
   <tr><td>Item Location: </td><td><s:property value="city"/>,<s:property value="state"/>,<s:property value="pin"/>,<s:property value="country"/></td></tr>
   </table>
   <br>
   <br>
   <table>
  <tr><th>Other things you'd like buyers to know</th></tr>
  <tr><td>Warranty & Return Policies: </td><td><s:property value="returnPolicy"/></td></tr>
  <s:hidden value="%{returnPolicy}" name="returnPolicy"/>
  <tr><td>Payment Instructions(note:500 character limited)</td></tr>
  <tr><td><s:property value="paymentInstruction"/></td></tr>
  <s:hidden value="%{paymentInstruction}" name="paymentInstruction"/>
  </table>
  <br>
  <!-- table>
  <tr><td>Fee so far : Rs 1</td></tr>
  </table-->
  </table>
  <br>
  <br>
  
  <s:submit name="commandButton" value="Cancel" ></s:submit>
  <s:submit name="commandButton" value="Modify" ></s:submit>
  <s:submit name="commandButton" value="List Your Item" ></s:submit>
  </s:form> 
  
</body>
</html>