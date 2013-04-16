<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Author: Ruchika  -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Mode</title>
<!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"/> -->
<link rel="stylesheet" type="text/css"
	href="buyitnow/44sahi3l3azqpahlonk2cetjj.css">
<link rel="stylesheet" type="text/css"
	href="buyitnow/43j513lpmi0mzpaok33s5y2u0.css">
	<%-- <script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script> --%>
<script src="jquery-1.9.1.min.js"></script>
<script src="jquery.validate.js"></script>
<script src="jquery.validate.min.js"></script>
<script>
$(document).ready(function() {
	  $("#SSPMformID").validate({
	        rules: {
	          quantity: {// compound rule
	          required: true,
	          Integer: true
	          }
	        }
	  messages: {
		  quantity: "Please enter a comment."
        }

	      });
	 });

/* $(document).keypress(function(e) {
    if(e.which == 13) {
        if (/[^0-9]/gi.test(fieldname.value))
    	{
    		alert ("Only numeric values are valid in this field");
    		fieldname.value = "";
    		fieldname.focus();
    		document.getElementById("makePayment").onSubmit= false;
    		return false;
    	}
    }
});
 */</script>
    <script type = "text/javascript">
function fnNumeric(fieldname)
{
	if (/[^0-9]/gi.test(fieldname.value))
	{
		alert ("Only numeric values are valid in this field");
		fieldname.value = "";
		fieldname.focus();
		document.getElementById("makePayment").onSubmit= false;
		return false;
	}
}
function validateForm()
{
	var b=document.forms["makePayment"]["quantity"].value;
	var j=document.forms["makePayment"]["banks"].value;
	var c=document.getElementsByName('paymentmode');
	
	if (b==""||b==null)
	  {
		  alert("Enter Quantity");
		  return false;
	  }
	for(var i=0; i< c.length; i++){
		if(c[i].checked && c[i].value=="3" && j=="-1"){
			
			alert("Select the bank");
			  return false;
	  
	}
	}
}
</script>
<script src="jquery-1.9.1.min.js"></script>
<script type="text/javascript">
/* var address;
function loadtextarea(a){
	$('#shippingaddressbox').slideDown();
	
	alert("hello");
	$('#change').remove();
	$('#shippingaddressbox').html('<textarea id="t1" cols="20" rows="4"/><input type="button" value="submit" id="b1" onclick="changeaddress()"/>');
}
$(document).ready(function(){
	  $("button").click(function(){
	    $("#test").hide(); //id =test and .test for class="test"
	  });
	});
function changeaddress(){
	//alert("hello");
	var a=document.getElementById('t1').value;
	address=a;
	$('#addrrow1').text(a);
	$('#t1').remove();
	$('#b1').remove();
	transaction();
	//add code to store in transaction table

}
function transaction(){
	var request;
	request=new XMLHttpRequest();
	request.open("GET","ChangeShipping.action?temp="+address,true);
	request.send();
}
 */</script>
 <script language="JavaScript" type="text/javascript">
function CheckingMode() {
	 var paymentmode = document.getElementById("paymentmode").value;
	 if (paymentmode=="")
		{
		alert("Payment mode should not be blank. Please enter appropriately!");
		return false;
		}
	 return true;
}
</script>
 
	<script type="text/javascript">var _GlobalNavHeaderUtf8Encoding=true;
</script>
</head>
<body>
<s:if test="hasActionErrors()">
		<span style="color: red; text-align: center;"><s:property value="error"/><s:actionerror />
		</span>
	</s:if>
						<div>
								<!-- headerType=MIN:DEFAULT:BUY-->
								<script type="text/javascript">var svrGMT = 1333797554828;</script>
								<div></div>
								<div class="gh-eb" style="visibility: hidden; display: none;">
									<div class="gh-emn">&nbsp;</div>
								</div>
								<div class="gh-log">
									<span class="gh-lg"><a href="home.jsp"
										rel="nofollow"> <img
											src="buyitnow/logoEbay_x45.gif" alt="eBay"
											border="0">
									</a>
									</span>
								</div>
								<span></span>
								<div class="gh-cl"></div>
								<div class="gh-col">
									<b class="gh-c1"></b><b class="gh-c2"></b><b class="gh-c3"></b><b
										class="gh-c4"></b><b class="gh-c5"></b><b class="gh-c6"></b><b
										class="gh-c7"></b>
									<div class="gh-clr"></div>
								</div>
								<a name="mainContent"></a>
							</div>
						
					<div class="AreaNavigation" id="AreaNavigation"></div>
					<div class="AreaTitle" id="AreaTitle">
						<table class="widthpercent">
							<tbody>
								<tr>
									<td><div class="sp-w">
											<table cellpadding="0" cellspacing="0">
												<tbody>
													<tr>
														<td style="width: 50%;"><div class="sp-c">
																<u></u>Order
															</div>
														</td>
														<td style="width: 50%;"><div class="sp-d">Pay
																Securely</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</td>
									
								</tr>
							</tbody>
						</table>
					</div>
					<div class="CentralArea" id="CentralArea">
						<table style="width: 100%;">
							<tbody>
								<tr>
									<td><s:form name="makePayment" autocomplete="OFF"
											action="makePayment"
											method="post" id="SSPMformID" theme="simple" onsubmit="return validateForm()">
											
	<div class="mainHeader">
												<div>
													<div class="mainHeader">
				<div>
					<div class="pageIntroSC" style="padding-top: 15px;">
						<div style="color: #333333">
							Please select a payment method, and click the <b>Continue</b>
							button at the bottom of the page.
						</div>
						<span style="float: right; margin-top: -15px;"><span><a
								href="javascript:void()"><img
									src="buyitnow/ico_Livehelp_new.gif" id="livechathelp"
									name="livechathelp" border="0"> </a> </span> </span>
					</div>
					<div>
						<table class="cr-w cr-nr" style="width: 100%;" cellpadding="0"
							cellspacing="0">
							<tbody>
								<tr>
									<td><div class="cr-hr">
											<div class="itemsumstyle">
												<b>Review the items you are buying and your order total</b>
											</div>
										</div></td>
								</tr>
									
									<tr>
										<td><div class="cr-cnt">
												<div>
													<div
														style="margin-left: -10px; margin-right: -10px; margin-top: -7px;"
														class="sellerinst">
														<table style="width: 100%; border: 0px none;">
															<tbody>
																<tr>
																	<td class="txt-black13bold"
																		style="width: 71%; text-align: right;">Price</td>
																	<td style="width: 14%;"><span
																		class="txt-black13bold"
																		style="text-align: middle; padding-left: 70px;">Quantity</span>
																	</td>
																	<td class="txt-black13bold"
																		style="width: 15%; text-align: right; padding-right: 10px;">Sub-total</td>
																</tr>
															</tbody>
														</table>
													</div>
													<div>
														<div
															style="color: #333333; border-bottom: 1px solid #cccccc">
															<div id="270950260152">
																<div class="item-summ-body-c">
																	<div class="item-summ-body-image">
																		<div style="Height: 80px; Width: 80px;">
																			<a href="#"><img height="75" width="75"
																				src="<s:property value="itemImage"/>"
																				alt="" border="0"> </a>
																		</div>
																	</div>
																	<div class="item-summ-body-title-57"
																		style="padding-bottom: 40px;">
																		<div>
																			<div class="item-summ-body-titleinline">
						<!-- add proper href which will redirect to item page   -->	
																				<a
																				href="ItemDetails.action?item=<s:property value="itemId"/>"
																					style="color: rgb(0, 51, 255);"><s:property
																						value="itemName" />
																				</a>
					   <!-- add proper href which will redirect to item page   -->
																			</div>
																		</div>
																		<div>
																			<b class="item-summ-bseller-pad">From seller:</b>
																			<div class="item-summ-body-titleinline"
																				style="color: #0033ff;">
																				<a title="Member id itplaza2011"
																					href="http://myworld.ebay.in/itplaza2011"><b
																					class="g-hdn">Member id </b><span class="mbg-nw"><s:property
																							value="sellerName" />
																				</span> </a>
																			</div>
																		</div>
																	</div>
																	<div class="single-item-summ-body-price">
																		Rs.
																		<s:property value="itemPrice" />
																	</div>
																	<div class="single-item-summ-body-qty">
																	<div class="controls">
																		<s:textfield name="quantity" value="%{quantity}" size="2" width="2" id="inputInfo" placeholder="Enter quantity of product, you would like to purchase" onblur="return fnNumeric(this)" onSubmit="return fnNumeric(this)"/>
																		</div>
																	</div>
																	<div class="stDiv">
																		<table class="amountTable">
																			<tbody>
																				<tr>
																					<td class="symDivTd"><div class="symDiv">Rs.</div>
																					</td>
																					<td class="priceDivTd"><div class="priceDiv"
																							id="regsubtotal">
																							<s:property value="itemTotal" />
																						</div></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																	<input name="req_item" id="req_item"
																		value="270950260152" type="hidden">
																</div>
															</div>
														</div>
													</div>
												</div>
											</div></td>
									</tr>
			
							</tbody>
						</table>
					</div>
					<div class="tbl1viewaddr1"></div>
					<div>
						<div class="left-blue-box">
							<div>
								<div style="color: #333333">
									<div class="cr-w">
										<div class="cr-hr">
											<div>
												<b><div><br>
														<span>Your shipping address</span>
													</div> </b>
											</div>
										</div>
										<br>
										<div class="cr-cnt">
											<div style="height: 150px; padding-left: 5px">
												<div>
													<input id="addDsplCountry"
														value="com.ebay.darwin.app.spark.pres.AddressLayoutIN"
														type="hidden">
													<div class="g-std" id="addrrow1">
														<div id="addrrow">
															<b><s:property value="userName" />
															</b>
														</div>
														<div id="addrrow">
															<span><s:property value="userHomeAddress" />
															</span>
														</div>
														
														<div id="addrrow"></div>
														<div id="addrrow">
															<span><s:property value="userCity" />
															</span>
														</div>
														<div id="addrrow">
															<span><s:property value="userState" />
															</span>
														</div>
														<div id="addrrow">
															<span><s:property value="userCountry" />
															</span>
														</div>
													</div>
				 
													<div id="shippingaddressbox"></div>
				<!-- Make change address page									<s:submit id="change" name="changeAdd"
														value="Change Shipping Address" action="changeAdd"
														onclick="loadtextarea(this)" />Make change address page -->

												</div>
				 
												<div style="padding-top: 10px;"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="right-blue-box">
							<div style="color: #333333">
								<div>
									<div>
										<div>
											<div class="cr-w">
												<div class="cr-hr"><br>
													<div class="shipmethod">
														<span><b>Order Total and Shipping Charges</b> </span>
													</div>
												</div>
												<div class="cr-cnt">
													<div>
														<div>
															<div class="sub-div" style="height: 100px;"
																id="gxoshippingid">
																<div class="sub-div-left2">
																	<b>Sub-Total</b>
																</div>
																<div class="sub-div-middle2">Rs.</div>
																<div class="sub-div-right2">
																	<s:property value="itemTotal" />
																</div>
																<div class="sub-div-left">
																	<b>Shipping method: </b><input name="shipping_method"
																		id="shipping_method" value="20301" type="hidden">
																		<s:property value="courier"/>
																</div>
																<div class="sub-div-middle" style="width: 7.7%">Rs.</div>
																<!-- <div class="sub-div-right">
																	<s:property value="item_shipping_charge" />
																</div> -->
																<div class="separator">
																	<img src="buyitnow/s.gif" height="1" width="1">
																</div>
																<div class="sub-div-ltotal">Total</div>
																<div class="sub-div-mtotal" style="width: 7.7%">Rs.</div>
																<div class="sub-div-rtotal">
																	<s:property value="itemTotal" />
																</div>
																<div class="taxmessage">The item price is
																	inclusive of all applicable taxes.</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="spacer10" style="clear: both"></div>
				<div style="color: #333333">
					<div>
						<table class="cr-w cr-nr" style="width: 100%;" cellpadding="0"
							cellspacing="0">
							<tbody>
								<tr>
									<td><div class="cr-hr">
											<div class="widthpercent paymentheader">
												<b>Select payment method</b>
											</div>
										</div></td>
								</tr>
								<tr>
									<td><div class="cr-cnt">
											<div>
												<table cellpadding="0" cellspacing="0">
													<tbody>
														<tr>
															<td valign="top" width="68%"><div>
																	<div class="ps-ppImgEscrow"
																		style="padding-left: 25px; float: none;">
																		<img
																			src="buyitnow/pp_escrow_full_tag_130807_135x70.gif"
																			height="70" width="135"><span class="ps-span"
																			style="padding-left: 10px; font-size: 11px">To
																			know more about PaisaPay <a
																			href="http://pages.ebay.in/help/buy/payment.html"
																			target="_blank">click here.</a> </span>
																	</div>
																</div>
																<div class="ps-ppButton">
																	<s:radio label="paymentmode" name="paymentmode"
																		list="#{'1':'Credit Card','2':'Debit Card','3':'Net Banking'}" value="1" />&nbsp;
																	<s:select name="banks" label="Net Banking" headerKey="-1" headerValue="--Select Bank--" list = "listBanks"/>Net banking
																	<!-- <input name="payment_method" value="29"
																												id="29"> -->
																	<!-- onclick='return vjo.Registry._7.handlePaymentMethod("emiselected", "29", true);'
																												checked="checked" type="radio"> -->
																</div> <!-- <div style="margin-left: 26px;">Credit
																											card, debit card, online bank transfer, cash
																											cards, mobile payments and eBay gift voucher
																											/ promotion code.</div> -->

																<div></div></td>
															<td rowspan="2" class="ps-tdEscrow" width="22%"><div>
																	<div class="cr-w">
																		<div class="cr-hr">
																			<div
																				style="border-bottom: 1px solid #cccccc; padding-bottom: 5px">
																				<b>PaisaPay, the smart choice</b>
																			</div>
																		</div>
																		<div class="cr-cnt">
																			<div style="white-space: nowrap;">
																				<img src="buyitnow/icoPasiaPay_GXO_110311.gif"
																					alt="" class="ps-bImg" height="25" width="25"><font
																					color="#333333">PaisaPay sends your money to
																					the seller</font>
																				<div
																					style="padding-left: 43px; margin-top: -5px; color: #333333">
																					<font color="#333333">after you get the item</font>
																				</div>
																				<br> <img
																					src="buyitnow/icoShipping_GXO_180311.jpg" alt=""
																					class="ps-bImg" height="25" width="25"><font
																					color="#333333">Most items are shipped
																					within 2 days</font>
																				<div
																					style="padding-left: 43px; margin-top: -5px; color: #333333">
																					<font color="#333333">of payment</font>
																				</div>
																				<br> <img
																					src="buyitnow/icoGuarantee_GXO_110311.gif" alt=""
																					class="ps-bImg" height="25" width="25"><font
																					color="#333333">Replacement or Refund if you
																					are not</font>
																				<div
																					style="padding-left: 43px; margin-top: -5px; color: #333333">
																					<font color="#333333">100% satisfied*</font>
																				</div>
																				<br>
																				<div align="right">
																					<a
																						href="http://pages.ebay.in/help/policies/paisapay/paisapay-refund-claim.html"
																						target="_blank" style="color: rgb(0, 51, 255);">Know
																						more</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font
																						color="#333333">*T&amp;C apply</font>
																				</div>
																			</div>
																		</div>
																	</div>
																</div></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="spacer"></div>
													</div>
												</div>
											</div>
											<div
												style="margin-left: 8px; padding-left: 8px; display: none; color: #0000cc; width: 40%; padding: 5px 5px 5px 5px"
												id="orderMsgId" class="orderTotalAlert">
												<b>Your order total may have changed. Please review your
													order before proceeding</b>
											</div>
											<div>
												<div class="btnMsgBar">
													<span
														style="vertical-align: middle;"><b id="continue"
														class="btn-w btn-m btn-p"><span
															id="spn_continue" class="btn-b moz btn-b pbn-P"><s:submit
																id="but_continue" name="continue" value="continue" class="btn btn-danger" onclick="return CheckingMode();"/>
														</span>
													</b>
													</span>&nbsp;&nbsp;<span class="msg">You will confirm the
														order in the next step.</span>
												</div>
											</div>
											</s:form>
											</td>
											</tr>
											</tbody>
											</table>
											</div>
									

											
</body>
</html>