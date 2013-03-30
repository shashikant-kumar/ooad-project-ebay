<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register as an eBay member</title>    
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<link href="register1.css" type="text/css" rel="stylesheet">
<link href="register2.css" type="text/css" rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td width="190"></td>
			<td width="940">
				<div>
					<a rel="nofollow" href="home.jsp"> <img border="0"
						alt="From collectables to cars, buy and sell all kinds of items on eBay"
						src="images/ebay-logo-01.jpg"> </a>
				</div>
				<div class="gh-cl"></div>
				<div class="gh-col">
					<b class="gh-c1"></b> <b class="gh-c2"></b> <b class="gh-c3"></b> <b
						class="gh-c4"></b> <b class="gh-c5"></b> <b class="gh-c6"></b> <b
						class="gh-c7"></b>
					<div class="gh-clr"></div>
				</div>
				<div style="margin:-15px 0 -9px 0;_margin:-15px 0 -10px 0;" class="pageHeader">
				<table cellpadding="0" cellspacing="0" border="0"><tbody><tr><td><b id="mainContent"><h1 class="regPgHeading">Register as an eBay member</h1></b></td></tr></tbody></table></div>
				<div style="padding-left:14px;">
<div class="titleHelpText" style="padding-bottom:22px;">Register now to bid, buy or sell on eBay. It's easy and free.</div>
<div class="titleInfoText" style="padding-bottom:0px;">Already registered or want to change your account info?
<a href="Login" class="ancAsb">Sign in now.</a></div>
<table border="0" cellpadding="0" cellspacing="0">
<tbody><tr><td><span>
<a href="#">Register with a business account?</a>
<noscript>&lt;a href="#"&gt;Want to register as a business&lt;/a&gt;?
</noscript></span></td></tr></tbody></table><div>&nbsp;</div><div class="paraGrph"></div></div>
				</td>
			<td width="190"></td>
		</tr>
	</table>
	<s:form action="Register" name="RegisterUser">
	<div>
	<div>
<div class="reiLeftField">
<div class="greyrcp">
<div class="n">
<div class="e">
<div class="w"></div>
</div>
</div>
<div class="title">
<h2 class="headerAccess">
<span>Tell us about yourself</span>
</h2>
<span class="normalText"> - All fields are required</span>
</div>
<div class="sectionBody" style="padding:7px 0 9px 7px;">
<div style="padding:10px 10px 10px 10px;">Providing accurate contact details are important to have smooth transactions on eBay.</div>
<div style="padding:10px 10px 0px 10px;">
<a name="FullName"></a>
<div id="NAME_GROUP">
<div style="padding-bottom:10px;_padding-bottom:5px;">
<span class="fldGrp" style="padding-right:4px;">
<div>
<span class="standardtitle" style="font-weight:normal">
<label for="firstname">First name</label>
</span>
<br>
<div>
<input id="firstname" type="text" pattern="[a-zA-Z]+" maxlength="10" value="" size="32" name="firstname" required="true">
</div>
</div>
<span class="error"></span>
</span>
<span class="fldGrpInline">
<div>
<span class="standardtitle" style="font-weight:normal">
<label for="lastname">Last name</label>
</span>
<br>
<div>
<input id="lastname" type="text" maxlength="10" pattern="[a-zA-Z]+" value="" size="32" name="lastname" required="true">
</div>
</div>
<span class="error"></span>
</span>
<br>
<br>
<div>
<span>
<img width="94%" height="6" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</span>
</div>
</div>
</div>
<div id="ADDRESS_GROUP">
<div class="module">
<a name="Address"></a>
<div align="left">
<span class="standardtitle" style="font-weight:normal">
<label for="address1">Home address</label>
</span>
<br>
<div>
<input id="address1" type="text" maxlength="128" value="" size="32" name="address1" required="true">
</div>
<span class="error"></span>
</div>
</div>
<div class="module">
<label class="hideLabel" for="address2">Street address continued. Apartment number, floor number, suite number, etc. - optional</label>
<span class="standardtitle" style="font-weight:normal"></span>
<div>
<input id="address2" type="text" maxlength="128" value="" size="32" name="address2">
</div>
<span class="error"></span>
</div>
<div class="module">
<a name="CityId"></a>
<a name="City"></a>
<div style="margin-top:-3px;">
<span class="standardtitle" style="font-weight:normal">
<label for="city">City</label>
</span>
<br>
<div>
<input id="city" type="text" pattern="[a-zA-Z]+" maxlength="15" size="32" name="city" required="true">
</div>
<span class="error"></span>
</div>
</div>
<div>
<span class="fldGrp">
<a name="StateId"></a>
<a name="State"></a>
<div style="padding-right:4px;">
<span class="standardtitle" style="font-weight:normal">
<label for="state">State</label>
</span>
<br>
<div>
<script language="JavaScript1.1" type="text/javascript">
<!--
function fillCity(e){
var iscity = null;
if ( typeof( e.options[e.selectedIndex].attributes[ "isCity" ] ) != "undefined" ){
iscity = e.options[e.selectedIndex].attributes[ "isCity" ].nodeValue;}
else{
iscity = e.options[e.selectedIndex].isCity;
}
if (iscity == 'true') e.form.elements['city'].value = e.options[e.selectedIndex].value; else e.form.elements['city'].value = '';}
//-->
</script>
<select id="state" name="state">
<option value="default">Select your state</option>
<option value="AN">Andaman and Nicobar Islands</option>
<option value="AP">Andhra Pradesh</option>
<option value="AR">Arunachal Pradesh</option>
<option value="AS">Assam</option>
<option value="BR">Bihar</option>
<option value="CH">Chandigarh</option>
<option value="CT">Chhattisgarh</option>
<option value="DN">Dadra and Nagar Haveli</option>
<option value="DD">Daman and Diu</option>
<option value="DL">Delhi</option>
<option value="GA">Goa</option>
<option value="GJ">Gujarat</option>
<option value="HR">Haryana</option>
<option value="HP">Himachal Pradesh</option>
<option value="JK">Jammu and Kashmir</option>
<option value="JR">Jharkhand</option>
<option value="KA">Karnataka</option>
<option value="KL">Kerala</option>
<option value="LD">Lakshadweep</option>
<option value="MP">Madhya Pradesh</option>
<option value="MH">Maharashtra</option>
<option value="MN">Manipur</option>
<option value="ML">Meghalaya</option>
<option value="MZ">Mizoram</option>
<option value="NL">Nagaland</option>
<option value="OR">Orissa</option>
<option value="PY">Pondicherry</option>
<option value="PB">Punjab</option>
<option value="RJ">Rajasthan</option>
<option value="SK">Sikkim</option>
<option value="TN">Tamil Nadu</option>
<option value="TR">Tripura</option>
<option value="UL">Uttaranchal</option>
<option value="UP">Uttar Pradesh</option>
<option value="WB">West Bengal</option>
</select>
</div>
<span class="error"></span>
</div>
</span>
<span class="fldGrpInline">
<a name="ZipCode"></a>
<div style="padding-right:4px">
<span class="standardtitle" style="font-weight:normal">
<label for="zip">Pin Code</label>
</span>
<br>
<div>
<input id="pincode" type="text" maxlength="6" pattern="\d{6}" value="" size="12" name="pincode" required="true">
</div>
<span class="error"></span>
</div>
<span class="help">Example: 400050</span>
</span>
<span class="fldGrpInline">
<label for="countryId">Country or region</label>
<br>
<select id="country" onchange="changeList()" name="countryId">
<option selected="" value="95" name="value">India</option>
<option value="156" name="value">Pakistan</option>
<option value="187" name="value">Sri Lanka</option>
<option value="1" name="value">United States</option>
<option value="3" name="value">United Kingdom</option>
<option value="2" name="value">Canada</option>
<option value="225" name="value">APO/FPO</option>
<option value="4" name="value">Afghanistan</option>
<option value="5" name="value">Albania</option>
<option value="6" name="value">Algeria</option>
<option value="7" name="value">American Samoa</option>
<option value="8" name="value">Andorra</option>
<option value="9" name="value">Angola</option>
<option value="10" name="value">Anguilla</option>
<option value="11" name="value">Antigua and Barbuda</option>
<option value="12" name="value">Argentina</option>
<option value="13" name="value">Armenia</option>
<option value="14" name="value">Aruba</option>
<option value="15" name="value">Australia</option>
<option value="16" name="value">Austria</option>
<option value="17" name="value">Azerbaijan Republic</option>
<option value="18" name="value">Bahamas</option>
<option value="19" name="value">Bahrain</option>
<option value="20" name="value">Bangladesh</option>
<option value="21" name="value">Barbados</option>
<option value="22" name="value">Belarus</option>
<option value="23" name="value">Belgium</option>
<option value="24" name="value">Belize</option>
<option value="25" name="value">Benin</option>
<option value="26" name="value">Bermuda</option>
<option value="27" name="value">Bhutan</option>
<option value="28" name="value">Bolivia</option>
<option value="29" name="value">Bosnia and Herzegovina</option>
<option value="30" name="value">Botswana</option>
<option value="31" name="value">Brazil</option>
<option value="32" name="value">British Virgin Islands</option>
<option value="33" name="value">Brunei Darussalam</option>
<option value="34" name="value">Bulgaria</option>
<option value="35" name="value">Burkina Faso</option>
<option value="37" name="value">Burundi</option>
<option value="38" name="value">Cambodia</option>
<option value="39" name="value">Cameroon</option>
<option value="2" name="value">Canada</option>
<option value="40" name="value">Cape Verde Islands</option>
<option value="41" name="value">Cayman Islands</option>
<option value="42" name="value">Central African Republic</option>
<option value="43" name="value">Chad</option>
<option value="44" name="value">Chile</option>
<option value="45" name="value">China</option>
<option value="46" name="value">Colombia</option>
<option value="47" name="value">Comoros</option>
<option value="48" name="value">Congo, Democratic Republic of the</option>
<option value="49" name="value">Congo, Republic of the</option>
<option value="50" name="value">Cook Islands</option>
<option value="51" name="value">Costa Rica</option>
<option value="52" name="value">Cote d Ivoire (Ivory Coast)</option>
<option value="53" name="value">Croatia, Republic of</option>
<option value="55" name="value">Cyprus</option>
<option value="56" name="value">Czech Republic</option>
<option value="57" name="value">Denmark</option>
<option value="58" name="value">Djibouti</option>
<option value="59" name="value">Dominica</option>
<option value="60" name="value">Dominican Republic</option>
<option value="61" name="value">Ecuador</option>
<option value="62" name="value">Egypt</option>
<option value="63" name="value">El Salvador</option>
<option value="64" name="value">Equatorial Guinea</option>
<option value="65" name="value">Eritrea</option>
<option value="66" name="value">Estonia</option>
<option value="67" name="value">Ethiopia</option>
<option value="68" name="value">Falkland Islands (Islas Malvinas)</option>
<option value="69" name="value">Fiji</option>
<option value="70" name="value">Finland</option>
<option value="71" name="value">France</option>
<option value="72" name="value">French Guiana</option>
<option value="73" name="value">French Polynesia</option>
<option value="74" name="value">Gabon Republic</option>
<option value="75" name="value">Gambia</option>
<option value="76" name="value">Georgia</option>
<option value="77" name="value">Germany</option>
<option value="78" name="value">Ghana</option>
<option value="79" name="value">Gibraltar</option>
<option value="80" name="value">Greece</option>
<option value="81" name="value">Greenland</option>
<option value="82" name="value">Grenada</option>
<option value="83" name="value">Guadeloupe</option>
<option value="84" name="value">Guam</option>
<option value="85" name="value">Guatemala</option>
<option value="86" name="value">Guernsey</option>
<option value="87" name="value">Guinea</option>
<option value="88" name="value">Guinea-Bissau</option>
<option value="89" name="value">Guyana</option>
<option value="90" name="value">Haiti</option>
<option value="91" name="value">Honduras</option>
<option value="92" name="value">Hong Kong</option>
<option value="93" name="value">Hungary</option>
<option value="94" name="value">Iceland</option>
<option value="96" name="value">Indonesia</option>
<option value="99" name="value">Ireland</option>
<option value="100" name="value">Israel</option>
<option value="101" name="value">Italy</option>
<option value="102" name="value">Jamaica</option>
<option value="103" name="value">Jan Mayen</option>
<option value="104" name="value">Japan</option>
<option value="105" name="value">Jersey</option>
<option value="106" name="value">Jordan</option>
<option value="107" name="value">Kazakhstan</option>
<option value="108" name="value">Kenya</option>
<option value="109" name="value">Kiribati</option>
<option value="111" name="value">Korea, South</option>
<option value="112" name="value">Kuwait</option>
<option value="113" name="value">Kyrgyzstan</option>
<option value="114" name="value">Laos</option>
<option value="115" name="value">Latvia</option>
<option value="116" name="value">Lebanon</option>
<option value="120" name="value">Liechtenstein</option>
<option value="121" name="value">Lithuania</option>
<option value="122" name="value">Luxembourg</option>
<option value="123" name="value">Macau</option>
<option value="124" name="value">Macedonia</option>
<option value="125" name="value">Madagascar</option>
<option value="126" name="value">Malawi</option>
<option value="127" name="value">Malaysia</option>
<option value="128" name="value">Maldives</option>
<option value="129" name="value">Mali</option>
<option value="130" name="value">Malta</option>
<option value="131" name="value">Marshall Islands</option>
<option value="132" name="value">Martinique</option>
<option value="133" name="value">Mauritania</option>
<option value="134" name="value">Mauritius</option>
<option value="135" name="value">Mayotte</option>
<option value="136" name="value">Mexico</option>
<option value="226" name="value">Micronesia</option>
<option value="137" name="value">Moldova</option>
<option value="138" name="value">Monaco</option>
<option value="139" name="value">Mongolia</option>
<option value="228" name="value">Montenegro</option>
<option value="140" name="value">Montserrat</option>
<option value="141" name="value">Morocco</option>
<option value="142" name="value">Mozambique</option>
<option value="143" name="value">Namibia</option>
<option value="144" name="value">Nauru</option>
<option value="145" name="value">Nepal</option>
<option value="146" name="value">Netherlands</option>
<option value="147" name="value">Netherlands Antilles</option>
<option value="148" name="value">New Caledonia</option>
<option value="149" name="value">New Zealand</option>
<option value="150" name="value">Nicaragua</option>
<option value="151" name="value">Niger</option>
<option value="152" name="value">Nigeria</option>
<option value="153" name="value">Niue</option>
<option value="154" name="value">Norway</option>
<option value="155" name="value">Oman</option>
<option value="157" name="value">Palau</option>
<option value="158" name="value">Panama</option>
<option value="159" name="value">Papua New Guinea</option>
<option value="160" name="value">Paraguay</option>
<option value="161" name="value">Peru</option>
<option value="162" name="value">Philippines</option>
<option value="163" name="value">Poland</option>
<option value="164" name="value">Portugal</option>
<option value="165" name="value">Puerto Rico</option>
<option value="166" name="value">Qatar</option>
<option value="167" name="value">Romania</option>
<option value="168" name="value">Russian Federation</option>
<option value="169" name="value">Rwanda</option>
<option value="170" name="value">Saint Helena</option>
<option value="171" name="value">Saint Kitts-Nevis</option>
<option value="172" name="value">Saint Lucia</option>
<option value="173" name="value">Saint Pierre and Miquelon</option>
<option value="174" name="value">Saint Vincent and the Grenadines</option>
<option value="175" name="value">San Marino</option>
<option value="176" name="value">Saudi Arabia</option>
<option value="177" name="value">Senegal</option>
<option value="229" name="value">Serbia</option>
<option value="178" name="value">Seychelles</option>
<option value="179" name="value">Sierra Leone</option>
<option value="180" name="value">Singapore</option>
<option value="181" name="value">Slovakia</option>
<option value="182" name="value">Slovenia</option>
<option value="183" name="value">Solomon Islands</option>
<option value="184" name="value">Somalia</option>
<option value="185" name="value">South Africa</option>
<option value="186" name="value">Spain</option>
<option value="189" name="value">Suriname</option>
<option value="190" name="value">Svalbard</option>
<option value="191" name="value">Swaziland</option>
<option value="192" name="value">Sweden</option>
<option value="193" name="value">Switzerland</option>
<option value="195" name="value">Tahiti</option>
<option value="196" name="value">Taiwan</option>
<option value="197" name="value">Tajikistan</option>
<option value="198" name="value">Tanzania</option>
<option value="199" name="value">Thailand</option>
<option value="200" name="value">Togo</option>
<option value="201" name="value">Tonga</option>
<option value="202" name="value">Trinidad and Tobago</option>
<option value="203" name="value">Tunisia</option>
<option value="204" name="value">Turkey</option>
<option value="205" name="value">Turkmenistan</option>
<option value="206" name="value">Turks and Caicos Islands</option>
<option value="207" name="value">Tuvalu</option>
<option value="208" name="value">Uganda</option>
<option value="209" name="value">Ukraine</option>
<option value="210" name="value">United Arab Emirates</option>
<option value="3" name="value">United Kingdom</option>
<option value="1" name="value">United States</option>
<option value="211" name="value">Uruguay</option>
<option value="212" name="value">Uzbekistan</option>
<option value="213" name="value">Vanuatu</option>
<option value="214" name="value">Vatican City State</option>
<option value="215" name="value">Venezuela</option>
<option value="216" name="value">Vietnam</option>
<option value="217" name="value">Virgin Islands (U.S.)</option>
<option value="218" name="value">Wallis and Futuna</option>
<option value="219" name="value">Western Sahara</option>
<option value="220" name="value">Western Samoa</option>
<option value="221" name="value">Yemen</option>
<option value="223" name="value">Zambia</option>
<option value="224" name="value">Zimbabwe</option>
</select>
<input type="hidden" value="true" name="preferredcountrylist">
<script language="JavaScript">
<!--
function CountryList() {
javascript:submitToTargetPage('https://scgi.ebay.in/ws/eBayISAPI.dll','RegisterChangeCountry',1);
}
//-->
</script>
<noscript>&lt;input type="submit" name="changecountry" value="Change"&gt;</noscript>
</span>
</div>
<div>
<span>
<img width="94%" height="1" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</span>
</div>
</div>
<a name="Telephone1"></a>
<div id="PHONE_GROUP">
<div class="moduleNoMargins" style="padding-top:6px;">
<label for="phone">10 digit mobile number</label>
<input id="phone" type="text" title="Primary telephone number" maxlength="10" minlength="10" value="" pattern="\d{10}" name="mobile" size="17" required="true">
<div>
<span class="error"></span>
<span id="secdayphone1" class="help">
Example: 09812345678 for Mobile or 022 25123456 for Landline
<br>
We will contact you if we have questions about your account.
</span>
</div>
</div>
</div>
<div id="EMAIL_GROUP">
<div class="module">
<a name="EmailAddress"></a>
<span class="standardtitle" style="font-weight:normal">
<label for="email">Email address</label>
</span>
<br>
<div>
<input title="deepthi.bhagi@gmail.com" id="email" type="email" value="" maxlength="64" size="32" name="email" required="true">
</div>
<span class="error"></span>
</div>
<div class="module" style="margin-top:-3px;">
<a name="EmailAddressReType"></a>
<span class="standardtitle" style="font-weight:normal">
<label for="retype_email">Re-enter your email address</label>
</span>
<br>
<div>
<input title="deepthi.bhagi@gmail.com" id="retype_email" type="email" value="" maxlength="64" size="32" name="retype_email">
</div>
<div id="div_retype_email" class="quickwinError" style="color:red;"></div>
<div id="secremail" class="YukHelpTxt">Please use a valid email address that you frequently access.</div>
</div>
</div>
</div>
</div>
<div class="subTitle">
<h2 class="headerAccess">
<span>Choose your user ID and password</span>
</h2>
<span class="normalText"> - All fields are required</span>
</div>
<div class="sectionBody" style="padding:17px 0 20px 17px;">
<div id="USERID_GROUP">
<span class="fldGrp" style="margin-right:-22px;">
<div>
<a name="UserId"></a>
<span class="standardtitle" style="font-weight:normal">
<label for="userid">Create your eBay user ID</label>
</span>
<br>
<div>
<img id="img_newuserid" alt="Error" style="display:none;margin-bottom:-2px;_margin-bottom:0px;" src="https://securepics.ebaystatic.com/aw/pics/icons/iconFormError_16x16.gif">
<img id="chgImg" alt="Success" style="display:none;margin-bottom:-2px;_margin-bottom:0px;margin-right:2px" name="chgImg" src="https://securepics.ebaystatic.com/aw/pics/icon/iconSuccess_16x16.gif">
<input id="userid" type="text" maxlength="64" size="32" name="userid">
<span id="user_throbberdiv" style="display:none;color:#A5A6A5;" name="user_throbberdiv">
<img alt="Loading" src="https://securepics.ebaystatic.com/aw/pics/globalAssets/imgLoading_15x15.gif">
Checking...
</span>
<span id="chgDiv" class="changeDiv" name="chgDiv" style="display:none;">
[
<a id="chg" name="chg" href="javascript:void(0)">Change user ID</a>
]
</span>
</div>
</div>
</span>
<span class="fldGrpInline" style="padding:0 0 0 15px;">
<div>
<br>
<script language="JavaScript">
<!--
ebay.oDocument.oPage.createConfig = function()
{
var c=this.oDocument.addConfig(new EbayConfig("Registration.OnePage.UserIdOptimization"));
c.sThrobone ="user_throbberdiv";//span Id of small throbberimage and checking....
c.sTickImg="chgImg";//Tick imgage name that gets displayed after selecting a sugesstion
c.sClass="quickwin";//Success message div class
c.sErrClass ="quickwinError";// Error;
//c.aAutoTabTxt = ["dayphone1","dayphone2","dayphone3","dayphone4"];
c.sFrameId="userIdLookupFrame"; //Iframe Id
c.sUserIdLookupBtnId="CheckUserId"; //Button Id (Check availability)
c.sContinueButtonId="continue"; //Continue Btn Id
c.sErrorLayerId="userIdErrorLayer";//Error layer to display error message when the requested user id is not available
c.sHelpLayerId="userIdHelpLayer";//Help layer to display help message
c.sUserIdTextElemName="userid"; //User Id text field name
c.sUserIdParam="TextUserId";
c.aParams = ["firstname","lastname","zip","dayphone1","dayphone2","dayphone3","birthdate1","birthdate2","birthdate3"];
c.sUserSecDiv="suserid";
c.sErrorClass="Error";
c.sCountParam="refreshcount";
c.sEmailIdTextElemName = "email";//Email text field ID
c.sErrorImage="img_userid";
c.sPostUrl="https://scgi.ebay.in/ws/eBayISAPI.dll?ChooseUserIdAndPassword&mode=1&btnCheckUserId=1&onepagereg=1";
c.iTimeout=40000;
c.sErrorText='Sorry, we are not able to perform user id check at this time. Please click the User ID check button and try again!'; // Error div
c.sEmptyErrorText="Please enter a user ID."; // Empty Error Text
c.sSuccessText="Good news! This user ID is available for you to use.";// Success message text
c.sUserIdLookupBtnText='Check availability';
this._getControlEx("Registration.OnePage.UserIdOptimization")._exec("writeCheckUserIdButton",c);
c.bInitSuggOnLoad = false;
var oLaycfg=this.oDocument.addConfig(new EbayConfig("Registration.OnePage.overlay"));
oLaycfg.OvlyId="UserIDPreview";//Overlay Id
oLaycfg.sUseridOverlayboxId="Useridoverlaybox";
oLaycfg.sOvlthrobId="OverlayThrob";//overlay throbberid
oLaycfg.aOvltxtId=["uword1","uword2","uword3"];//Overlay text id
oLaycfg.aOvlyParams = ["firstname","lastname","zip","dayphone1","dayphone2","dayphone3","birthdate1","birthdate2","birthdate3","email"];
oLaycfg.sOvlyCloseId="UserIDPreviewClose";//overlay close image id
oLaycfg.sOvlyShadow = "switchbackdialogpanelolpshadow"; // overlay shadow id
var ocfg=this.oDocument.addConfig(new EbayConfig("Registration.OnePage.oLyUserIdSugg"));
ocfg.iMaxUserIds=5; //Max number of userid sugesstions
ocfg.iMaxPerSet=5; //Max displayed per set
ocfg.sUserLinkId="anchorOvly"; //Prefix - Anchor id prefix for all the userid links
ocfg.sUserLinkImg="imageOvly"; //Image Id of the "+" symbol apprars before each userid
ocfg.sUserIdDiv="InnerdivOvly";//Layer that contains user ids + and text
ocfg.sUserIdSet="indivOver";//Layer that contains user ids, previous and next links
ocfg.sSuggestDiv = "outerdiv"; // Layer that encloses the user ids and previous, next links in a gray background
ocfg.sUserNxtLink="nextlinkOver"; //Prefix - Next link id
ocfg.sUserNxtImg="nextimgOver";//Prefix - Arrow image id for next link
ocfg.sUserPrevLinks="previouslinkOver"; //Prefix - Previous link id
ocfg.sUserPrevImg="previousimgOver"; //Prefix - Arrow image id for previous link
ocfg.sGreyImg="https://securepics.ebaystatic.com/aw/pics/icons/iconGreyAdd_9x9.gif";//url for grey plus image
ocfg.sBlueImg="https://securepics.ebaystatic.com/aw/pics/icons/iconBlueAdd_9x9.gif";//url for blue plus image
ocfg.sNextBlueImg="https://securepics.ebaystatic.com/aw/pics/icons/iconNextBlue_8x10.gif";//url for next blue image
ocfg.sNextGreyImg="https://securepics.ebaystatic.com/aw/pics/icons/iconNextGrey_8x10.gif";//url for next grey image
ocfg.bisOverlay = true;
var cfg=this.oDocument.addConfig(new EbayConfig("Registration.OnePage.UserIdSugg"));
cfg.iMaxUserIds=5; //Max number of userid sugesstions
cfg.iMaxPerSet=5; //Max displayed per set
cfg.sUserLinkId="anchor"; //Prefix - Anchor id prefix for all the userid links
cfg.sUserLinkImg="image"; //Image Id of the "+" symbol apprars before each userid
cfg.sUserIdDiv="Innerdiv";//Layer that contains user ids + and text
cfg.sUserIdSet="indiv";//Layer that contains user ids, previous and next links
cfg.sSuggestDiv = "div1"; // Layer that encloses the user ids and previous, next links in a gray background
cfg.sSugFirstAnc = "anchor1";
cfg.sUserNxtLink="nextlink"; //Prefix - Next link id
cfg.sUserNxtImg="nextimg";//Prefix - Arrow image id for next link
cfg.sUserPrevLinks="previouslink"; //Prefix - Previous link id
cfg.sUserPrevImg="previousimg"; //Prefix - Arrow image id for previous link
cfg.sGreyImg="https://securepics.ebaystatic.com/aw/pics/icons/iconGreyAdd_9x9.gif";//url for grey plus image
cfg.sBlueImg="https://securepics.ebaystatic.com/aw/pics/icons/iconBlueAdd_9x9.gif";//url for blue plus image
cfg.sNextBlueImg="https://securepics.ebaystatic.com/aw/pics/icons/iconNextBlue_8x10.gif";//url for next blue image
cfg.sNextGreyImg="https://securepics.ebaystatic.com/aw/pics/icons/iconNextGrey_8x10.gif";//url for next grey image
cfg.bisOverlay = false;
}
ebay.oDocument.oPage.createConfig();
//-->
</script>
<img width="10" height="1" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
<input id="CheckUserId" type="hidden" style="padding:0 .25em 0 .25em; width:auto; overflow:visible;" name="CheckUserId" value="Check availability">

</div>
</span>
<div id="userIdEmailIdLayer" style="clear:both;" name="userIdEmailIdLayer">
<span class="error"></span>
</div>
<div id="userIdErrorLayer" style="clear:both;display:none" role="alert" aria-live="assertive" name="userIdErrorLayer">
<span class="error"></span>
</div>
<div id="userIdLookupLayer" style="padding-bottom:15px;" name="userIdLookupLayer"></div>
<div id="result1" class="classAutoSugg2" style="margin-top:-2px;display:none;position:absolute;"></div>
<input id="as_un" type="hidden" value="0" name="as_un">
<div id="suserid" class="YukHelpTxt" name="suserid" style="margin:-15px 0 10px 0;">
Use letters or numbers, but not ( ) &lt; &gt; &amp; @.
<a class="ancAsb" onclick="return openContextualHelpWindow(this.href);" target="helpwin" href="createuserid.jsp">
How to pick a great user ID
<b class="g-hdn"> - opens in a new window or tab</b>
</a>
.
</div>
<div id="div1" style="display:none" name="div1">
</div>
<div id="PASSWORD_GROUP">
<div style="clear:both;">
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td>
<a name="Password"></a>
<div>
<div>
<label for="password">Create your password</label>
</div>
<img id="img_pass" alt="Error" style="display:none;margin-bottom:-2px;_margin-bottom:0px;" src="https://securepics.ebaystatic.com/aw/pics/icons/iconFormError_16x16.gif">
<img id="passErrImg" alt="Error" style="display:none;margin-bottom:-2px;_margin-bottom:0px;" src="https://securepics.ebaystatic.com/aw/pics/icons/iconFormError_16x16.gif">
<input id="password" type="password" value="" oncut="return false" onpaste="return false" oncopy="return false" size="32" name="password">
<div class="hideLabel">
    <span id="passwordlayer" style="display:none; position:absolute;height:177px;width:240px"></span>

<div id="div1_pass" class="quickwinError" role="alert" aria-live="assertive" style="display:none;">Please enter your password</div>
<div id="div_pass" class="quickwinError" role="alert" aria-live="assertive" style="display:none;width:94%;"></div>
<div id="passInlineErrMsg" class="quickwinError" role="alert" aria-live="assertive"></div>
</div>
<div style="width:94%;">
<div id="passHelpText" class="YukHelpTxt">
caSe sensiTive.
<a id="passHelpAnc" class="ancAsb" target="helpwin" onclick="ebayShowPopupWindow(this.href, '', 413, 461, 0, 0, 0, 1, 1, 0, 450, 100); return false;" href="suggest_password.jsp">
Learn about secure passwords
<b class="g-hdn"> - opens in a new window or tab</b>
</a>
.
</div>
</td>
<td></td>
</tr>
</tbody>
</table>
</div>
<div style="border:1px solid #FFFFFF;">
<div class="paraGrph" style="clear:both">
<label for="rpass">Re-enter your password</label>
</div>
<div class="module" style="padding-bottom:10px;">
<img id="img_rpass" alt="Error" style="display:none;margin-bottom:-2px;_margin-bottom:0px;" src="https://securepics.ebaystatic.com/aw/pics/icons/iconFormError_16x16.gif">
<input id="rpass" type="password" value="" oncut="return false" onpaste="return false" oncopy="return false" size="32" name="rpass">
<div id="div1_rpass" class="quickwinError" style="display:none;">Please enter your password again</div>
<div id="div_rpass" class="quickwinError" role="alert" aria-live="assertive" style="display:none;"></div>
</div>
<div style="margin-top:-13px"></div>
</div>
</div>
<div class="module">
<div id="SECRET_QUESTION_GROUP">
<div class="module">
<a name="SecretQuestion"></a>
<div>
<label for="SECRET_QUESTION">Pick a secret question</label>
</div>
<div>
<select id="secquestion" name="secQuestion">
<option value="0">Select your secret question...</option>
<option value="1">Who is your favourite cricket player?</option>
<option value="2">What is your mother's maiden name?</option>
<option value="3">Who is your favourite film star?</option>
<option value="4">What is the name of your first school?</option>
<option value="5">What is your pet's name?</option>
</select>
</div>
<span class="error"></span>
</div>
<div class="module" style="margin-bottom:0px;">
<a name="SecretAnswer"></a>
<div>
<label for="SECRET_ANSWER">Your secret answer</label>
</div>
<div>
<input id="secanswer" type="text" maxlength="20" value="" size="32" name="secAnswer">
</div>
<span class="error"></span>
</div>
<div id="secanswer" class="YukHelpTxt" style="clear:both;">If you forget your password, we'll verify your identity with your secret question</div>
</div>
</div>
<a name="DOB"></a>
<div id="DOB_GROUP">
<div class="paraGrph">Your date of birth</div>
<div class="resetMarginsDOB">
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td>
<span style="display:block;left:-9999px;position:absolute;">
<label for="birthdate">Date of birth, Day</label>
</span>
<select id="birthdate" name="date">
<option value="1">01</option>
<option value="2">02</option>
<option value="3">03</option>
<option value="4">04</option>
<option value="5">05</option>
<option value="6">06</option>
<option value="7">07</option>
<option value="8">08</option>
<option value="9">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>
</td>
<td>
<img id="yearImg" alt="Error" style="display:none;margin-bottom:-2px;_margin-bottom:0px;" src="https://securepics.ebaystatic.com/aw/pics/icons/iconFormError_16x16.gif">
<span style="display:block;left:-9999px;position:absolute;">
<label for="birthmonth">Date of birth, Month</label>
</span>
<select id="birthmonth" name="month" onchange="ChangeOptionDays('birth')">
<option value="1">Jan</option>
<option value="2">Feb</option>
<option value="3">Mar</option>
<option value="4">Apr</option>
<option value="5">May</option>
<option value="6">Jun</option>
<option value="7">Jul</option>
<option value="8">Aug</option>
<option value="9">Sep</option>
<option value="10">Oct</option>
<option value="11">Nov</option>
<option value="12">Dec</option>
</select>
</td>
<td>

<td><label for="birthdate3" style="padding-right:5px;"><b class="g-hdn">Year of birth, four digit format.</b>
</label><select name="year" id="birthdate3"><option value="0">--Year--</option>
<option value="1995">1995</option><option value="1994">1994</option><option value="1993">1993</option>
<option value="1992">1992</option><option value="1991">1991</option><option value="1990">1990</option>
<option value="1989">1989</option><option value="1988">1988</option><option value="1987">1987</option>
<option value="1986">1986</option><option value="1985">1985</option><option value="1984">1984</option>
<option value="1983">1983</option><option value="1982">1982</option><option value="1981">1981</option>
<option value="1980">1980</option><option value="1979">1979</option><option value="1978">1978</option>
<option value="1977">1977</option><option value="1976">1976</option><option value="1975">1975</option>
<option value="1974">1974</option><option value="1973">1973</option><option value="1972">1972</option>
<option value="1971">1971</option><option value="1970">1970</option><option value="1969">1969</option>
<option value="1968">1968</option><option value="1967">1967</option><option value="1966">1966</option><option value="1965">1965</option><option value="1964">1964</option>
<option value="1963">1963</option><option value="1962">1962</option><option value="1961">1961</option><option value="1960">1960</option><option value="1959">1959</option>
<option value="1958">1958</option><option value="1957">1957</option><option value="1956">1956</option><option value="1955">1955</option><option value="1954">1954</option>
<option value="1953">1953</option><option value="1952">1952</option><option value="1951">1951</option><option value="1950">1950</option><option value="1949">1949</option>
<option value="1948">1948</option><option value="1947">1947</option><option value="1946">1946</option><option value="1945">1945</option><option value="1944">1944</option>
<option value="1943">1943</option><option value="1942">1942</option><option value="1941">1941</option><option value="1940">1940</option><option value="1939">1939</option>
<option value="1938">1938</option><option value="1937">1937</option><option value="1936">1936</option><option value="1935">1935</option><option value="1934">1934</option>
<option value="1933">1933</option><option value="1932">1932</option><option value="1931">1931</option><option value="1930">1930</option><option value="1929">1929</option>
<option value="1928">1928</option><option value="1927">1927</option><option value="1926">1926</option><option value="1925">1925</option><option value="1924">1924</option>
<option value="1923">1923</option><option value="1922">1922</option><option value="1921">1921</option><option value="1920">1920</option><option value="1919">1919</option>
<option value="1918">1918</option><option value="1917">1917</option><option value="1916">1916</option><option value="1915">1915</option><option value="1914">1914</option>
<option value="1913">1913</option><option value="1912">1912</option><option value="1911">1911</option><option value="1910">1910</option><option value="1909">1909</option>
<option value="1908">1908</option><option value="1907">1907</option><option value="1906">1906</option><option value="1905">1905</option><option value="1904">1904</option>
<option value="1903">1903</option><option value="1902">1902</option><option value="1901">1901</option><option value="1900">1900</option><option value="1899">1899</option>
<option value="1898">1898</option><option value="1897">1897</option><option value="1896">1896</option><option value="1895">1895</option><option value="1894">1894</option>
<option value="1893">1893</option></select>
<script language="JavaScript"><!--
					  (function(){  
						var c = ebay.oDocument.addConfig(new EbayConfig('registration.birthdate3'));                                                                   
						c.sTextBox = "birthdate3"; //Name of the Text Box
						c.sTextValue = Localize("YYYY");   
						c.sTextClass = "greyOut"; // CSS Class name for grayout text.
						c.sTextClass_1 = "ordinary"; // CSS Class name for standard font color
						c.sYearImg = "yearImg";
						c.sYearText = "yearErr";
						c.sGreyTxt = "secbirthid";
					   })();
					   ebay.oDocument.oPage.initbirthdate3();  
					--></script></td>

</td>
</tr>
</tbody>
</table>
</div>
<span class="error"></span>
<div id="secbirthid" class="YukHelpTxt">
You must be at least 18 years old to use eBay.
<br>
<br>
</div>
</div>
</div>
<div class="subTitle">
<h2 class="headerAccess">Terms of use and your privacy</h2>
</div>
<a name="TokenString"></a>
<div>
<span class="standard">
For
<a class="ancAsb" target="_blank" href="http://pages.ebay.in/help/newtoebay/verification-code.html">
added security
<b class="g-hdn"> - opens in a new window or tab</b>
</a>
, please enter the verification code hidden in the image.
</span>
</div>
<br>
<div>
<img id="img_tokentext" alt="Error" style="display:none;margin-bottom:-2px;_margin-bottom:0px;" src="https://securepics.ebaystatic.com/aw/pics/icons/iconFormError_16x16.gif">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<title>eBay - The World's Online Marketplace</title>
</head>
<body bgcolor="#ffffff">
<form id="GetBotImage" name="GetBotImage">
<table>
<tr><td><div id="d1"/></div><s:actionerror/></td></tr>
<tr><td><input type="text" name="captcha"/></td></tr>
</table>
<input id="tokenstring" type="hidden" value="wAl00AUAAAA%3D" maxlength="6" name="tokenstring">
<img width="1" height="1" border="0" alt=" " name="i_sGauge" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</form>
</body>
</html>
<div id="div1_tokentext" class="quickwinError" style="display:none;">Please enter the verification code</div>
<div>
<a id="linkBotRefresh" name="linkBotRefresh" href="#">Refresh the image</a>
&nbsp;&nbsp;|&nbsp;&nbsp;
<a id="linkBotListen" name="linkBotListen" href="https://scgi.ebay.in/ws/eBayISAPI.dll?ShowAudioChallengePage&parentPage=RegisterEnterInfo&siteid=203&co_brandId=2">
Listen to the verification code
<b style="display:block;left:-9999px;position:absolute;"> - opens in a new window or tab</b>
</a>
</div>
<div style="margin-left:10px;">
<a name="uapp"></a>
<div>
<div style="padding:10px 10px 10px 8px;">
<link rel="stylesheet" media="all" href="css/register3.css" type="text/css">
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td valign="top" nowrap="">
<b>
<u> eBay User Agreement, the eBay Rules &amp; Policies &amp; the Privacy Policy</u>
</b>
(
<a class="ancAsb" href="http://pages.ebay.in/help/policies/uapp.html" onclick="return openWindow('http://pages.ebay.in/help/policies/uapp.html')">Printer-friendly version</a>
)
<br>
(please click on the hyperlinks as underlined below)
</td>
</tr>
</tbody>
</table>
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td valign="top" align="right"></td>
</tr>
<tr>
<td>
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
</tbody>
</table>
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td valign="top" colspan="2">
<b>Please check the box below:</b>
</td>
</tr>
<tr>
<td>
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
</tbody>
</table>
<table width="600px" cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td width="25" valign="top">
<span class="resetMargins">
<input id="acceptq1" type="checkbox" value="1" name="acceptq1" required="true">
</span>
</td>
<td colspan="2">
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
<tr>
<td colspan="3">
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
<tr>
<td colspan="3">
<label for="acceptq1">
That by clicking on the box I agree that I have read and understood the
<a class="ancAsb" href="http://pages.ebay.in/help/policies/ebay-user-agreement.html" onclick="return openWindow('http://pages.ebay.in/help/policies/ebay-user-agreement.html')">eBay User Agreement</a>
,
<a class="ancAsb" href="http://pages.ebay.in/help/policies/ebay-rules-policy.html" onclick="return openWindow('http://pages.ebay.in/help/policies/ebay-rules-policy.html')">the eBay Rules &amp; Policies</a>
&amp;
<a class="ancAsb" href="http://pages.ebay.in/help/policies/ebay-privacy-policy.html" onclick="return openWindow('http://pages.ebay.in/help/policies/ebay-privacy-policy.html')">the Privacy Policy</a>
(hereinafter referred as the "User Agreement &amp; eBay Policies") and unconditionally accept to be legally bound by the following:
</label>
</td>
</tr>
<tr>
<td>
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
<tr>
<td colspan="3">
<ul>
<li> That I have had reasonable opportunity and time to read, understand and take proper advice; </li>
<li> That while using the services &amp; facilities on the eBay Website www.ebay.in, I unequivocally agree &amp; undertake to abide by and comply with the User Agreement &amp; eBay Policies; </li>
<li> I agree that the User Agreement &amp; eBay Policies are in all respects fair, reasonable and necessary in order to protect the users of www.ebay.in and the legitimate business interests of eBay; </li>
<li> I agree that I have provided true, accurate, current and complete information about myself as prompted by eBay's registration form (such information being the "Registration Data") and nothing contained therein is false, inaccurate or misleading; </li>
<li> I agree that eBay is only providing a platform for communication and it is agreed that the contract for sale of any of the products or services shall be a strictly bipartite contract between myself and other registered Users; </li>
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td valign="top">
<img width="5" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
-
<img width="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
<td>I accept that the manner, terms and conditions of delivery, payment, insurance etc. are to be independently agreed upon when transacting with the other registered Users; </td>
</tr>
<tr>
<td valign="top">
<img width="5" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
-
<img width="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
<td>At no time shall any right, title or interest over the items vest with eBay nor shall eBay have any obligations or liabilities in respect of such contract;</td>
</tr>
</tbody>
</table>
<li> I understand that the information I provide will be collected by eBay India Private Ltd and stored and processed by eBay Inc. located San Jose, CA, USA; </li>
</ul>
</td>
</tr>
<tr>
<td colspan="3">
<img width="1" height="10" alt="" src="#">
</td>
</tr>
</tbody>
</table>
</div>
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td valign="top" nowrap="">
<b>
<u>PaisaPay User Agreement</u>
</b>
<br>
(please click on the hyperlinks as underlined below)
</td>
</tr>
<tr>
<td>
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
</tbody>
</table>
<table cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td valign="top" colspan="2">
<b>Please check the box below:</b>
</td>
</tr>
<tr>
<td>
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
</tbody>
</table>
<table width="600px" cellspacing="0" cellpadding="0" border="0">
<tbody>
<tr>
<td width="25" valign="top">
<span class="resetMargins">
<input id="acceptq5" type="checkbox" value="1" name="acceptq5" required="true">
</span>
</td>
</tr>
<tr>
<td>
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
<tr>
<td width="185%" colspan="2">
<label for="acceptq5">
That by clicking on the box I agree that I have read and understood the
<a class="ancAsb" href="http://pages.ebay.in/help/policies/pspx-user-agreement.html" onclick="return openWindow('http://pages.ebay.in/help/policies/pspx-user-agreement.html')">
PaisaPay User Agreement
<b class="g-hdn"> - opens in a new window or tab</b>
</a>
(hereinafter referred as the ("PaisaPay UA") and unconditionally accept to be legally bound by the following:
</label>
</td>
</tr>
<tr>
<td>
<img width="1" height="10" alt="" src="https://securepics.ebaystatic.com/aw/pics/s.gif">
</td>
</tr>
<tr>
<td colspan="2">
<ul>
<li> That my acceptance of the PaisaPay UA has been given of my own free will after having reasonable opportunity and time to read, understand and take proper advice; </li>
<li> That while using PaisaPay services, I unequivocally agree &amp; undertake to abide by and comply with the PaisaPay UA. </li>
<li> I agree that the PaisaPay UA are in all respects fair, reasonable and necessary in order to protect the users of PaisaPay services and the legitimate business interests of PaisaPay; </li>
<li> I agree that PaisaPay is only a service provider and is not responsible for any non-performance or breach of contract between users of PaisaPay. </li>
</ul>
</td>
</tr>
</tbody>
</table>
<div style="margin:0px 0px 0px 7px;_margin:-7px 0px -10px 10px;">
</div>
</div>
</div>
<div id="regerrorDiv" class="quickwinError" style="display:none;margin-top:15px;_margin-top:15px;margin-left:10px;">We need some additional information from you. Please check and try again.</div>
<div style="padding-top:10px;"></div>
<div class="s">
<div class="e">
<div class="w"></div>
</div>
</div>
</div>
</div>
</div>
</div>
<!-- <div class="reiRightField"><div class="greyBoxRCP" style="width:265px;"><div class="n"><div class="e"><div class="w"></div></div></div>
<div class="greyInnerLayer"><div><h4 class="textboxAlign" style="margin:0px;padding:0 0 10px 0;">Your privacy is important to us</h4></div><div class="textbox">
eBay does not rent or sell your personal information to third parties without your consent. To learn more, read our <a href="javascript:void(0);" style="text-decoration:underline" onclick="return window.open('#', 'personal info', 'width=600,height=560,toolbar=0,location=0,status=0,scrollbars=1,resizable=0,menubar=0');" class="ancAsb">privacy policy<b class="g-hdn"> - opens in a new window or tab</b></a>.
					</div><br>
<div class="textbox"><b>Provide correct contact details as your trading partners may want to get in touch with you. 
Incorrect or incomplete contact information can lead to account suspension.</b></div></div><div class="s">
<div class="e"><div class="w"></div></div></div></div><div class="greyBoxBottomPadding"></div></div> -->
	<div style="clear:both;"></div>
	</div></div>
</s:form>
<s:form action="Register"> 
<s:actionerror /> 
<div style="margin:0px 0px 0px 7px;_margin:-7px 0px -10px 10px;"><button type="submit" id="continue" name="commandButton" class="ButtonNormal"><span class="btn">
<span class="btn">Continue Register</span></span></button></div>
 <%-- <s:submit name="commandButton" value="Register" ></s:submit> --%>
</s:form>
<div class="greyBoxBottomPadding"></div>
	<div class="ContentContainer ClearBoth" id="BottomContainer">
			<div>
				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>
					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>
					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>
			</div>
		</div>
	<style type="text/css">
.c-sgf .r3_fm {
	padding-bottom: 8px !important;
	border-bottom: 1px solid #ccc !important
}
</style>
</body>
</html>