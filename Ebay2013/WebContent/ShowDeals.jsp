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
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="jquery.sudoSlider.js"></script>
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
					</td></tr>
					<!-- start of each category -->
					<tr>
						<td>
							<table bordercolor="black" border="0">
								<s:iterator var="itr" value="allCats">
								<tr>
								<s:if test = "allItems.size()>0">
									<td class="main-head" colspan="4" align="left">
									<br><b><s:property value="%{#itr.categ_name}"/></b>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<%-- <s:property value="bookCategs.size()"/> --%>
									<s:if test = "allItems.size()<4">
									</s:if>
									<s:else>
									<s:url id="seeMore" action="viewAllDeals">
									<s:param name="categ_id" value="categ_id"/>
									</s:url>
									<div style="float: right;padding-right:5px;"><s:a href="%{seeMore}">See more>></s:a></div>
									</s:else>
									</td>
								</tr>
								
								<s:iterator var="itr" value="allItems">
									<td>
				<!--						 PRODUCTS ROW 1,1-->
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td valign="top">
				<!--										 PRODUCT 1 -->
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
													<div class="container1 container">
													<div style="position:relative;">
													<div class="slider" style="overflow: hidden; position: relative; width: 811px;">
														<li style="float: left;">
														<tbody>
														<td width="4" class="nodealCol">&nbsp;</td>
														<td width="193" class="dealCol">
														<s:url id="ItemName" action="ItemDetails">
														<s:param name="item" value="item_id"/>
														</s:url>
														<div class="mdt"><s:a href="%{ItemName}"><s:property value="item_name"/></s:a></div>
														<br>
														<div class="dealImg" target="_top" style="text-decoration:none;"><s:a href="%{ItemName}">
														<img src="./images/<s:property value="item_image"/>" class="lazy" data-original="" width="140" height="140" border="0" style="top: 0px; display: inline-block;"></s:a></div>
														<div class="priceDiv"><span class="WebRupee WebRupeeMain">Rs.</span> <s:property value = "discount_price"/></div>
														<div class="priceinfoDiv">MRP <span class="WebRupee WebRupeeInfo">Rs.</span> <s:property value = "item_price"/> | Save <span class="WebRupee WebRupeeInfo">Rs.</span> <s:property value = "save_price"/></div><div class="dealButton"><div style="float: left;">
														<span class="discDiv">-<s:property value = "item_discount"/>%</span></div>
														<div style="float: right;padding-right:5px;">
														<s:a href="%{ItemName}" target="_top" style="text-decoration:none;">
														<img height="20" border="0" width="70" src="./images/getit.jpg"></s:a></div></div></td>
														<%-- <span id="controls"><a href="#" class="prevBtn"> previous </a><a href="#" class="nextBtn"> next </a></span> --%>
														</tbody></li></div></div></div>
														
													</table>
												</td>	
											</tr>
										</table>
									</td>
								</s:iterator>
							</s:if>
						</s:iterator>
					</table>
				</td>
			</tr>
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
