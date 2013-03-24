<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ebay Home</title>
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
<title>Deals</title>
</head>
<body>

<ul id="NOINTERFERE00_menu">
							
    <li><a href="#">Deals &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>	<br>
   <br>
   <br>
   <%-- <s:set name="theme" value="'simple'" scope="page" />		 --%>
<table align="center" border="1" cellspacing="20" bgcolor=#EEEEEE>
<tr><td>
<s:if test="%{list.size()==0}">
<h2>No deals now</h2>
</s:if>
<s:else>
<table align="center" border="1" hcellspacing="100">
<s:iterator var="itr" value="list">
       <tr><td><s:property value="#itr[0].category_name"/><br>
    <s:iterator value="#itr" status="stat">
    <tr><td><table align="center" border="1" hcellspacing="100">
        <tr><td><s:property value="item_name"/><br></td></tr>
        <tr><td><s:property value="item_price"/><br></td></tr>
        <tr><td><s:property value="item_discount"/><br></td></tr>
        <tr><td><br></td></tr>
        </table></td></tr>
    </s:iterator>
    </td></tr>
</s:iterator>
</table>
</s:else></td></tr>
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
</body>
</html>
