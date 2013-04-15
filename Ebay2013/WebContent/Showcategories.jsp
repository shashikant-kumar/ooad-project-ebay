<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
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
<title>All Categories</title>
</head>
<body>
<br>
					<br>
					<br>
<div id="ff_cr_outer" class="">
<div id="ff_center_outer" class="">
<div id="CentralArea" class="centerAreaLeftNav"><div><div class="rct"><div style="margin:0px" class="rct_hm hb">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;All Categories</div>
					<div class="rct_cnb">
					<div class="rct_cm"><div class="rcp-content"><table cellspacing="0" cellpadding="0"><tbody><tr><td width="25%" class="cell">
					<div id="v4-0"><div class="hierarchylist-title"><div id="FontGradientLink1" class="gdlnk- gdlnk-1 hierarchylist-title-link">
					
					</td></tr></tbody></table>
					</div></div></div></div></div>
				</div>
			</div></div>
<!-- <table align="center" border="0" cellspacing="20" bgcolor=#EEEEEE>
<tr> -->
 					<table align="center" bordercolor="black" border="0">
								<s:iterator var="itr" value="allcats">
								<s:if test = "subcats.size()>0">
								<tr>
									<td class="main-head" colspan="4" align="left">
									<br><b><s:property value="%{#itr.categ_name}"/></b>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
								<s:iterator var="itr" value="subcats">
												<td valign="top">
															<s:url id="subcat_name" action="fetchitems">
																<s:param name="subcategory" value="subcateg_name"/>
																</s:url>
        														  <s:a href="%{subcat_name}"><s:property value="subcateg_name"/></s:a>
												</td>	
								</s:iterator>
								</tr>
								</s:if>
							</s:iterator>
					</table>
					<br>
					<br>
					<br>
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
