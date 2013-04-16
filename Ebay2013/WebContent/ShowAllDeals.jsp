<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ebay Home</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<link href="css4.css" type="text/css" rel="stylesheet">
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
<br>
<br>
<br>

<ul id="NOINTERFERE00_menu">
							
    <li><a href="#">Deals &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul>	<br>
   <br>
   <br>
   <%-- <s:set name="theme" value="'simple'" scope="page" />		 --%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr >
					<td></td>
					</tr>
					<!-- ITERATE -->
					<tr><td>
					<br></br>
					</td></tr>
					<!-- start of books and magazine category -->
					<tr>
						<td>
							<table bordercolor="black" >
								<tr>
									<td class="main-head" colspan="4" align="left">
									<b><s:property value="itemDetails.get(0).getCategory_name()"/></b>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
								<%int i=0; %>
								<s:iterator var="itr" value="itemDetails">
									<td>
				<!--						 PRODUCTS ROW 1,1-->
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td valign="top">
				<!--										 PRODUCT 1 -->
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<td width="4" class="nodealCol">&nbsp;</td>
														<td width="193" class="dealCol">
														<s:url id="ItemName" action="ItemDetails">
														<s:param name="item" value="item_id"/>
														</s:url>
														<div class="mdt"><s:a href="%{ItemName}"><s:property value="item_name"/></s:a></div>
														<br>
														<div class="dealImg" target="_top" style="text-decoration:none;"><s:a href="%{ItemName}">
														<img src="<s:property value="item_image"/>" class="lazy" data-original="" width="140" height="140" border="0" style="top: 0px; display: inline-block;"></s:a></div>
														<div class="priceDiv"><span class="WebRupee WebRupeeMain">Rs.</span> <s:property value = "discount_price"/></div>
														<div class="priceinfoDiv">MRP <span class="WebRupee WebRupeeInfo">Rs.</span> <s:property value = "item_price"/> | Save <span class="WebRupee WebRupeeInfo">Rs.</span> <s:property value = "save_price"/></div><div class="dealButton"><div style="float: left;">
														<span class="discDiv">-<s:property value = "item_discount"/>%</span></div>
														<div style="float: right;padding-right:5px;">
														<s:a href="%{ItemName}" target="_top" style="text-decoration:none;">
														<img height="20" border="0" width="70" src="./images/getit.jpg"></s:a></div></div></td>
													</table>
													<%i++; %>
												</td>
																								
										</table>
										<%-- <s:if test = "itemDetails.size()%4==0">
										
										</s:if> --%>
									</td>
									<% if (i%4==0)
													out.println("</tr><tr>");
												%>

								</s:iterator>
							</table>
						</td>
					</tr>
					<!-- end of books and magazine category -->
					<!-- END ITERATE -->
				</table>
			<div>
			<br><br></br>
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
