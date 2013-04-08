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
<title>All Categories</title>
</head>
<body>
<div id="ff_cr_outer" class="">
<div id="ff_center_outer" class="">
<div id="CentralArea" class="centerAreaLeftNav"><div><div class="rct"><div style="margin:0px" class="rct_hm hb">All Categories</div>
					<div class="rct_cnb">
					<div class="rct_cm"><div class="rcp-content"><table cellspacing="0" cellpadding="0"><tbody><tr><td width="25%" class="cell">
					<div id="v4-0"><div class="hierarchylist-title"><div id="FontGradientLink1" class="gdlnk- gdlnk-1 hierarchylist-title-link">
					
					</td></tr></tbody></table>
					</div></div></div></div></div>
				</div>
			</div></div>
<!-- <ul id="NOINTERFERE00_menu">
							
    <li><a href="#">All Categories &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
   </ul> -->			
<table align="center" border="0" cellspacing="20" bgcolor=#EEEEEE>
<tr><s:iterator var="itr" value="%{list}">
    <s:iterator var="itr" value="#itr" status="stat">
          <%-- <s:property value="[#stat.index].categ_name"/> --%>
    <th><s:property value="categ_name"/></th>
    </s:iterator><br/>
</s:iterator>
</tr>
<tr>
<td>

<table align="center" border="0" hcellspacing="100">
<s:iterator var="itr" value="%{list}">
    <s:iterator var="itr" value="#itr" status="stat1">
          <%-- <s:property value="[#stat.index].categ_name"/> --%>
          <tr><s:url id="book_name" action="fetchitems">
<s:param name="subcategory" value="book_subcategory_name"/>
</s:url>
          <s:a href="%{book_name}"><s:property value="book_subcategory_name"/></s:a></tr>
    </s:iterator><br/>
</s:iterator>
</table>
</td>
<td>
<table align="center" border="0" hcellspacing="100">
<s:iterator var="itr" value="%{list}">
    <s:iterator var="itr" value="#itr" status="stat2">
    
    <tr><s:url id="cosmetic_name" action="fetchitems">
<s:param name="subcategory" value="cosmetics_subcategory_name"/>
</s:url>
          <s:a href="%{cosmetic_name}"><s:property value="cosmetics_subcategory_name"/></s:a></tr>
        <%--   <tr><a href="<s:property value="cosmetics_subcategory_name"/>"><s:property value="cosmetics_subcategory_name"/></a></tr> --%>
    </s:iterator><br/>
</s:iterator>
</table>
</td>
<td>
<table align="center" border="0" hcellspacing="100">
<s:iterator var="itr" value="%{list}">
    <s:iterator var="itr" value="#itr" status="stat2">
     <tr><s:url id="mobile_name" action="fetchitems">
<s:param name="subcategory" value="mobiles_subcategory_name"/>
</s:url>
          <s:a href="%{mobile_name}"><s:property value="mobiles_subcategory_name"/></s:a></tr>
    	<%-- <tr><a href="<s:property value="mobiles_subcategory_name"/>"><s:property value="mobiles_subcategory_name"/></a></tr> --%>
    </s:iterator><br/>
</s:iterator>
</table>
</td>
</tr>
<%-- <s:iterator var ="test1" value="%{list}"> &nbsp; 
<s:iterator value="test1.allcats" var="test">
<tr> 
<th><h2><s:property value = "test.categ_name" /></h2></th>
</tr></s:iterator>
    
    </s:iterator> --%>
    
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
