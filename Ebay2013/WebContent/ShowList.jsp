<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>My eBay Watch List</title>
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
<title>My eBay Watch List</title>
</head>
<body>
<br/><br/><br/>
<div><div id="myRCP240" style="width:100%">
<div class="r3 c gy-br">
<div id="myRCP240h" class="gy">
<div>
<div class="r3_hm" style="border-width: 1px 1px 0; padding: 0; height: 5px; font-size:0; overflow:hidden;">
</div>
</div>
<div class="r3_hm" id="myRCP240_hm"><table cellpadding="0" cellspacing="0" class="ic-mt">
<tbody>
<tr>
<td align="left"><h2 class="g-m g-m0">Items in your watch list</h2></td>
<td align="right"><div id="MyeBayNextEditComponent240" style="margin-right:-4px">
<span id="MyebayPrintId"></span>
<span class="ed-mn">
<span><div id="editLink_240mc_div" style="display:none;overflow:hidden;width:180px" class="mn ml-pm ml-md">
</div></span></span>
</div></td></tr>
</tbody></table></div></div>
<div id="myRCP240cm" class="r3_c"><div class="r3_cm po" id="myRCP240_ct">
<div class="ic-hw">
<div class="h-dmnu h-mnu" id="240"><div class="h-ht"><a href="javascript:;" id="240_r" class="h-lad"></a>
<span id="240_c" class="h-cnt"><div id="240_i" class="h-ic" style="left: 0px; width: 209px;">
</div></span>
<a href="javascript:;" id="240_l" class="h-rad"></a>
</div></div></div>
<table class="ic-srt">
<tbody><tr><td></td><td align="left">
<div class="g_sort">
<div class="dd-dc" id="v4-My_68_27_outer">
<!-- <input id="v4-My_68_27" type="hidden" value=""> -->
</b><div id="v4-My_68_27_dddddiv" class="SM mn" style="display:none"></div></div></div></td></tr></tbody></table>
<div class="my_itl-itdisp"><div style="display:none;" id="ithr240">
<div class="thr thrL">
<div id="v4-My_68_37_th" class="thr-img thr-p">
<div class="thr-txt">Loading</div></div></div></div><div class="dtc" id="IDD240">
<div class="dt-dtbl" style="position: relative;">
<table border="0" cellpadding="0" cellspacing="0" width="inherit" id="v4-My_68_36_tab_0" class="my_itl-iT">
<thead><tr class="dt-tblHdr">
<th scope="col" id="v4-My_68_36_tab_0_srtHCol_0" class="dt-colCnt dt-rowSeptr dt-colHdr dt-alignCntr" width="300px" colspan="1">
<span>&nbsp;</span></th>
<th scope="col" id="v4-My_68_36_tab_0_srtHCol_1" class="dt-colCnt dt-rowSeptr dt-colHdr dt-alignCntr" width="254px" colspan="1">
<span>&nbsp;</span></th>
<th scope="col" id="v4-My_68_36_tab_0_srtHCol_4" class="dt-colCnt dt-rowSeptr dt-colHdr dt-alignRgt dt-prgt" width="150px" colspan="1">
<span class="g-clRght">Price</span></th>
<th scope="col" id="v4-My_68_36_tab_0_srtHCol_6" class="dt-colCnt dt-rowSeptr dt-colHdr dt-alignLft" width="100px" colspan="1">Actions</th></tr></thead>
<s:form> 
<s:iterator value="listDetails">
<tbody>
<s:url id="ItemDetailsPage" action="ItemDetails">
<s:param name="item" value="itemId"/>
</s:url>
<tr class="my_itl-itR">
 <td class="dt-alignLft my_itl-alT"><div><div class="my_itl-imrel">
<div class="my_idd-posrel my_idd-wrpr my_idd-i_ms">
<s:a href="%{ItemDetailsPage}">
<img src="./images/<s:property value="itemImage"/>" alt="Item picture" border="0" width="150" height="150"/></s:a>
<br/>
<br/>
</div></div></div></td>
<td class="dt-alignLft my_itl-alT">
<div>
<div id="itIn">
<s:a href="%{ItemDetailsPage}"><s:property value="itemName"/></s:a>
<div>
<div class="g-pt10"></div>
<s:url id="sellerInfoPage" action="sellerInfo">
<s:param name="sellername" value="sellerName"/>
</s:url>
<div id="mb">
<s:a href="%{sellerInfoPage}">
<s:property value="sellerName"/></s:a>
<div class="g-pt10"></div></div><div><span class="g-v33">Quantity available: </span>
<span class="g-v33"><s:property value="itemQuantity"/></span></div>
<div></div>
<div class="g-v33"></div>
<div>
<div id="nn2.WatchingNext_160996575473" class="my_itl-nnt" style="display:none"></div></div>
<div></div></div></div>
</td>
<!-- <td class="dt-alignCntr dt-prgt my_itl-alT"><p>--</p></td> -->
<td class="dt-alignRgt dt-prgt my_itl-alT">
<div class="g-clRght"><p class="g-a00 g-PdgTp">Rs. <s:property value="itemPrice"/><br><br></p><span class="g-v66-10">Buy it Now</span>
<div class="g-pt10"></div><p class="g-v33">Free shipping</p></div></td>
<!-- <td class="dt-alignRgt dt-prgt my_itl-alT"><p class="g-a33 g-clTRght">1d 00h </p></td> -->
<td class="dt-alignLft my_itl-alT">
<div class="cta-ca">
<div><table cellspacing="0" cellpadding="0" width="100" class="cta-tw cta-tl">
<tbody>
<tr><td valign="top" id="itIn" class="cta-cp">
<s:a href="%{ItemDetailsPage}">Buy it now</s:a></td></tr>
<tr><td valign="top" id="itIn" class="cta-cp">
<s:a href="%{sellerInfoPage}">Visit seller's Shop</s:a></td></tr>
<tr><td valign="top" id="itIn" class="cta-cp">
<s:url id="DeleteFromListPage" action="DeleteFromList">
<s:param name="item_id" value="itemId"/>
</s:url>
<s:a href="%{DeleteFromListPage}">Remove</s:a></td></tr>
</tbody></table>
</div></div></td></tr></s:iterator>
</s:form>
</div></div></div>
<div class="r3_hm" style="border-width: 0pt 0px 1px; padding: 0px; height: 4px;font-size:0;overflow:hidden"></div></div></div></div></div>
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
