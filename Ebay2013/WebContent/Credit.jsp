<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Author: Ruchika  -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
<title>Credit Card Payment</title>
</head>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
<body>
<body>
<h1>Credit Card Details</h1>
<s:if test="hasActionErrors()">
			<span style="color:red;text-align:center;"><s:actionerror /></span>
		</s:if>
<s:form id="credit" name="credit" method="post" action="cardPayment" theme="simple">
<table width="968" height="239" border="0">
  <tr>
    <td>&nbsp;
    Credit Card Number
    <s:textfield name="cardNo" />
    <th></th>
    
    <!-- <td>&nbsp;Valid Till</td> -->
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td colspan="2">
    Card holder name 
    <br>(as it appears on card) 
       <s:textfield name="accHoldername" value=""></s:textfield>
    </td>
    
    </tr>
    <tr>
    <td colspan="2">&nbsp;
     <table>
    <tr><td>CVV (3-digit card verification number)</td>
    <td><s:password size="5" name="cvv" value=""/></td><td><img alt="" src="images/icon_card_back.gif" height="30" width="100"></td></tr>
    </table>
    </td>
  </tr>
  
</table>
<s:submit name="payNow" value="Pay Now" class="btn">In the next step you may be redirected to your bank's website to verify yourself.</s:submit>
</s:form> 
</body>
</html>