<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Shipping Address</title>
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
<title>Shipping Address</title>
</head>
<body>

   <br>
   <br>
 <table>
 <tr>
 <s:form name="changAdd" action="buyitNow">
 <table align="center">

	<tr>
				<td><span class="standardtitle" style="font-weight:normal">Shipping address</span></td>
			</tr>
			<tr>
				<td><s:textfield name="address1" required="true" /></td>
			</tr>
			<tr>
				<td><s:textfield name="address2" required="true" /></td>
			</tr>
			<tr>
				<td><span class="standardtitle" style="font-weight:normal">City</span></td>
			</tr>
			<tr>
				<td><s:textfield name="city" required="true" /></td>
			</tr>
			<tr>
			<td><span class="standardtitle" style="font-weight:normal">State</span></td>
			<td><span class="standardtitle" style="font-weight:normal">Pin Code</span></td>
			<td><span class="standardtitle" style="font-weight:normal">Country or region</span></td>
				
			</tr>
			<tr>
				<td><s:select label="State" headerKey="Select your state"
						headerValue="Select your state"
						list="{'Andaman and Nicobar Islands', 'Andhra Pradesh', 'Arunachal Pradesh', 'Assam', 'Bihar', 'Chandigarh', 'Delhi', 'Gujarat', 'Haryana', 'Himachal Pradesh', 'Jammu and Kashmir', 'Karnataka', 'Kerala', 'Madhya Pradesh', 'Punjab', 'Rajasthan', 'Sikkim', 'TamilNadu', 'Uttar Pradesh', 'West Bengal'}"
						name="state">
					</s:select>
				</td>
				<td><s:textfield name="pincode" required="true" />
				</td>
				<td><s:select label="Country" headerKey="Country"
						headerValue="India"
						list="{'Pakistan', 'Sri Lanka', 'United States', 'United Kingdom', 'Canada', 'Afghanistan', 'Australia', 'Bangladesh', 'Belgium', 'Brazil', 'China', 'France', 'Germany', 'Kenya', 'South Africa'}"
						name="country">
					</s:select><br>
				</td>
			</tr>
			<tr>
				<td></td>
				
				<td><h6><span class="help">Example: 400050</span></h6>
				</td>
				<td></td>
			</tr>
			<tr>
			<s:hidden name="itemIdAdd"/>
				<td>
				<<%-- div class="moduleNoMargins" style="padding-top:6px;">
<span class="standardtitle" style="font-weight:normal">Primary Telephone Number</span>				
<s:textfield name="mobile" /> --%>
    <s:submit name="add" value="Gifting Address "/>
    
</table>
</s:form>
</tr>
<br>
<br>
<br>
<br>
<br>
<tr>
</tr>
</table>
<div>
				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>
			</div>
<%-- <s:textfield label = "Seller Rating"  name="avgRating"  size="10" />
<s:textfield label = "Location"  name="location"  size="10" />
<s:textfield label = "Member Since"  name="memberSince"  size="10" />
<s:textfield label = "Number Of Ratings"  name="noOfRating"  size="10" />
<input name="star1" type="radio" class="star {split:2}"/>
<input name="star1" type="radio" class="star" checked="checked"/>
<input name="star1" type="radio" class="star"/>
<input name="star1" type="radio" class="star"/>
<input name="star1" type="radio" class="star"/> --%>
</body>
</html>