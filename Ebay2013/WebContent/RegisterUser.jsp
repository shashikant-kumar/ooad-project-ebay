<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList, models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Register as an eBay Member</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="register1.css" >
<link rel="stylesheet" type="text/css" href="register2.css" >
</head>
<body>
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

	</br>
<script type="text/javascript">

   //Created / Generates the captcha function    
    function DrawCaptcha()
    {
        var a = Math.ceil(Math.random() * 10)+ '';
        var b = Math.ceil(Math.random() * 10)+ '';       
        var c = Math.ceil(Math.random() * 10)+ '';  
        var d = Math.ceil(Math.random() * 10)+ '';  
        var e = Math.ceil(Math.random() * 10)+ '';  
        var f = Math.ceil(Math.random() * 10)+ '';  
        var g = Math.ceil(Math.random() * 10)+ '';  
        var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
        document.getElementById("txtCaptcha").value = code;
    }

    // Validate the Entered input aganist the generated security code function   
    function ValidCaptcha(){
        var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
        var str2 = removeSpaces(document.getElementById('txtInput').value);
        if (str1 == str2) return true;        
        return false;
        
    }

    // Remove the spaces from the entered and generated code
    function removeSpaces(string)
    {
        return string.split(' ').join('');
    }
  
    function validateForm() {
		var val = true;
		var a = document.forms["myForm"]["firstName"].value;
		var b = document.forms["myForm"]["lastName"].value;
		var c = document.forms["myForm"]["address"].value;
		var d = document.forms["myForm"]["city"].value;
		var e = document.forms["myForm"]["state"].value;
		var f = document.forms["myForm"]["pincode"].value;
		var g = document.forms["myForm"]["Mobile"].value;
		var h = document.forms["myForm"]["email"].value;
		var i = document.forms["myForm"]["re_enterEmail"].value;
		var j = document.forms["myForm"]["username"].value;
		var k = document.forms["myForm"]["password"].value;
		var l = document.forms["myForm"]["re_enterPassword"].value;
		var m = document.forms["myForm"]["day"].value;
		var n = document.forms["myForm"]["month"].value;
		var o = document.forms["myForm"]["year"].value;
		var p = document.forms["myForm"]["secQuestion"].value;
		var q = document.forms["myForm"]["secAnswer"].value;
		var r = document.forms["myForm"]["captcha"].value;
		if (a == null || a == "" || b == null || b == "" || c == null
				|| c == "" || d == null || d == "" || e == null || e == ""
				|| f == null || f == "" || g == null || g == "" || h == null ||
				h == "" || i == null || i == "" || j == null || j== "" || k == null
				|| k == "" || l == null || l == "" || m == null || m == "" || n == null
				|| n == "" || o == null || o == "" || p == null || p == "" || q == null || q == ""
				|| r == null || r == "" || document.myForm.ebayAgreement.Checked==false ||
				document.myForm.paisaPayAgreement.Checked==false) {
			alert("All required fields are mandatory");
			return false;
		}
		var atpos=h.indexOf("@");
		var dotpos=h.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=h.length)
		  {
		  alert("Not a valid e-mail address");
		  return false;
		  }
		if(g.length<10 || g.length>10)
		{
			  alert("Not a valid phone number");
			  return false;
			  }
		return val;
	}
    
    </script>
</head>

<body onload="DrawCaptcha();">

	<s:form action="Register" theme="simple" onsubmit="return validateForm();">
<div style="margin:-15px 0 -9px 0;_margin:-15px 0 -10px 0;" class="pageHeader"><table cellpadding="0" cellspacing="0" border="0"><tbody><tr><td><b id="mainContent"><h1 class="regPgHeading">Register as an eBay member</h1></b></td></tr></tbody></table></div>
<div style="padding-left:14px;"><div class="titleHelpText" style="padding-bottom:22px;">Register now to bid, buy or sell on eBay. It's easy and free. </div><div class="titleInfoText" style="padding-bottom:0px;">Already registered or want to change your account info? <a href="Login" class="ancAsb">Sign in now.</a></div><table border="0" cellpadding="0" cellspacing="0"><tbody><tr><td><span>
<a href="#">Register with a business account?</a></span></td></tr></tbody></table><div>&nbsp;</div><div class="paraGrph"></div></div>
<span STYLE="color: red; font-size: 10pt">
<h3><s:property value="msg" /> </h3></span>		
<div>
<div class="reiLeftField">
<div class="greyrcp">			
<div class="n">
<div class="e">
<div class="w"></div>
</div>
</div>		
<div class="title"><h2 class="headerAccess"><span>Tell us about yourself</span></h2><span class="normalText"> - All fields are required</span></div>
<div class="sectionBody" style="padding:7px 0 9px 7px;">
<div style="padding:10px 10px 10px 10px;">Providing accurate contact details are important to have smooth transactions on eBay.</div>
<div style="padding:10px 10px 0px 10px;">

<span class="fldGrp" style="padding-right:4px;">
<div>
<span class="standardtitle" style="font-weight:normal">
<label for="firstname">First name</label>
</span>
<br>
<div>
<s:textfield name="firstName" required="true" />
</div>
</div>
<span class="error"></span>
</span>
<span class="fldGrpInline">
<div>
<span class="standardtitle" style="font-weight:normal">
<label for="lastname">Last name</label>
</span>
<div>
<s:textfield name="lastName" required="true" />
</div>
</div>
<span class="error"></span>
</span>
	
		<table>
				<tr>
				<td><span class="standardtitle" style="font-weight:normal">Home address</span></td>
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
				<td>
				<div class="moduleNoMargins" style="padding-top:6px;">
<span class="standardtitle" style="font-weight:normal">Primary Telephone Number</span>				
<s:textfield name="mobile" />
<div>
<span class="error"></span>
<span id="secdayphone1" class="help">
Example: 09812345678 for Mobile or 022 25123456 for Landline
<br>
We will contact you if we have questions about your account.
</span>
</div>
</div></td></tr>
						
			<tr>
				<td><span class="standardtitle" style="font-weight:normal">Email address</span>	</td>
			</tr>
			<tr>
				<td><s:textfield name="email" />
				</td>
			</tr>
			<tr>
			<td><span class="standardtitle" style="font-weight:normal">Re-enter your email address</span>	</td>
				</tr>
			<tr>
				<td><s:textfield name="re_enterEmail" />
				</td>
			</tr>
			<tr>
				<td><div id="secremail" class="YukHelpTxt">Please use a valid email address that you frequently access.</div></td>
			</tr>
					</table>
		</div>
</div>

		<br>
<div class="subTitle">
<h2 class="headerAccess">
<span>Choose your user ID and password</span>
</h2>
<span class="normalText"> - All fields are required</span>
</div>
<!-- <div class="sectionBody" style="padding:17px 0 20px 17px;"> -->
		<table>
			<tr>
			<td><span class="standardtitle" style="font-weight:normal">Create your eBay user ID</span>	</td>
				
			</tr>
			<tr>
				<td><s:textfield name="userid" />
				</td>
			</tr>
			<tr>
				<td>Use letters or numbers, but not ( )</td>
				<td></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
			<td><span class="standardtitle" style="font-weight:normal">Create your password</span>	</td>
			</tr>
			<tr>
				<td><s:password name="password" />
				</td>
			</tr>
			<tr>
				<td><div id="passHelpText" class="YukHelpTxt">caSe sensiTive.</div></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
			<td><span class="standardtitle" style="font-weight:normal">Re-enter your password</span></td>
			</tr>
			<tr>
				<td><s:password name="re_enterPassword" />
				</td>
			</tr>
			<tr>
			<td><span class="standardtitle" style="font-weight:normal">Pick a secret question</span></td>
			</tr>
			<tr>
			<tr>
				<td><s:select label="secretQuestion"
						headerKey="Select your secret question"
						headerValue="Select your secret question"
						list="{'Who is your favourite cricket player?', 'What is your mother`s maiden name?', 'Who is your favourite film star?', 'What is the name of your first school', 'What is your pet name'}"
						name="secQuestion">
					</s:select>
				</td>
			</tr>
			<tr>
			<td><span class="standardtitle" style="font-weight:normal">Your secret answer</span></td>
			</tr>
			<tr>
				<td><s:textfield name="secAnswer" />
				</td>
			</tr>
			<tr>
				<td><div id="secanswer" class="YukHelpTxt" style="clear:both;">If you forget your password, we'll verify your identity with your secret question</div></td>
				<td></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Your date of birth</td>
				<td></td>
			</tr>
			<tr>
				<td><s:select label="day" headerKey="--Day--"
						headerValue="--Day--"
						list="{'1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', 
						        '12', '13', '14', '15', '16', '17', '18', '19', '20',
						        '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'}"
						name="date">
					</s:select> <s:select label="month" headerKey="--Month--"
						headerValue="--Month--"
						list="{'January', 'February', 'March', 'April', 'May', 'June', 'July',
						       'August', 'September', 'October', 'November', 'December'}"
						name="month">
					</s:select> <s:select label="year" headerKey="--Year--" headerValue="--Year--"
						list="{'1975', '1976', '1977', '1978', '1979', '1980', '1981', '1982', '1983',
						        '1984', '1985', '1986', '1987', '1988', '1989', '1990', '1991', '1992',
						         '1993', '1994', '1995'}"
						name="year">
					</s:select>
				</td>
			</tr>

			<tr><td><div id="secbirthid" class="YukHelpTxt">You must be at least 18 years old to use eBay.<br><br></div></td></tr>
		</table>
		<br>
		<div class="subTitle"><h2 class="headerAccess">Terms of use and your privacy</h2></div>
		
		<br>
		<div id="div1_tokentext" class="quickwinError" style="display:none;">Please enter the verification code</div>

		<table>
			<tr>
				<td><s:textfield id="txtCaptcha"
						style="background-image:url(1.jpg); text-align:center; border:none;
            font-weight:bold; font-family:Modern" />
					<s:textfield id="txtInput" name="captcha" /></td>
			</tr><tr>
			<div>
<a id="linkBotRefresh" name="linkBotRefresh" href="Register">Refresh the image</a> &nbsp;&nbsp;|&nbsp;&nbsp;
<a id="linkBotListen" name="linkBotListen" href="#">Listen to the verification code
</a>
</div></tr>
			<tr>
				<%-- <td><s:submit id="btnrefresh" value="Refresh"
						name="commandButton" onclick="DrawCaptcha();" /></td> --%>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
		<br>
		<b><u>eBay User Agreement, the eBay Rules and Policies and the
				Privacy Policy</u>
		</b>
		<br>
		<br>
		<b>Please check the box below:</b>
		<br>
		<s:checkbox name="eBayAgreement" fieldValue="true" />
		<br>
That by clicking on the box I agree that I have read and understood the eBay User Agreement, the eBay <br>
Rules & Policies & the Privacy Policy (hereinafter referred as the "User Agreement & eBay Policies")<br>
 and unconditionally accept to be legally bound by the following:<br>
		<br>
		
		<ul>
<li> That I have had reasonable opportunity and time to read, understand and take proper advice; </li>
<li> That while using the services &amp; facilities on the eBay Website www.ebay.in, I unequivocally agree &amp; undertake to abide by and comply with the User Agreement &amp; eBay Policies; </li>
<li> I agree that the User Agreement &amp; eBay Policies are in all respects fair, reasonable and necessary in order to protect the users of www.ebay.in and the legitimate business interests of eBay; </li>
<li> I agree that I have provided true, accurate, current and complete information about myself as prompted by eBay's registration form (such information being the "Registration Data") and nothing contained therein is false, inaccurate or misleading; </li>
<li> I agree that eBay is only providing a platform for communication and it is agreed that the contract for sale of any of the products or services shall be a strictly bipartite contract between myself and other registered Users; </li>
<li> I agree that eBay is only providing a platform for communication and it is agreed that the contract<br>
   &nbsp;&nbsp;&nbsp;for sale of any of the products or services shall be a strictly bipartite contract between myself and<br>
   &nbsp;&nbsp;&nbsp;other registered Users;<br>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - I accept that the manner, terms and conditions of delivery, payment, insurance etc. are to be<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;independently agreed upon when transacting with the other registered Users;<br>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - At no time shall any right, title or interest over the items vest with eBay nor shall eBay have<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;any obligations or liabilities in respect of such contract;</li>
<li>I understand that the information I provide will be collected by eBay India Private Ltd and stored<br>
   &nbsp;&nbsp;&nbsp;&nbsp;and processed by eBay Inc. located San Jose, CA, USA;</li>
</ul>		
	<br>
		<b><u>PaisaPay User Agreement</u>
		</b>
		<br>
		<br>
		<b>Please check the box below:</b>
		<br>
		<s:checkbox name="paisaPayAgreement" fieldValue="true" />
		<br>
That by clicking on the box I agree that I have read and understood the PaisaPay User Agreement<br>
(hereinafter referred as the ("PaisaPay UA") and unconditionally accept to be legally bound by the<br>
following:<br>
		<br>
		
<ul>
<li> That my acceptance of the PaisaPay UA has been given of my own free will after having reasonable opportunity and time to read, understand and take proper advice; </li>
<li> That while using PaisaPay services, I unequivocally agree &amp; undertake to abide by and comply with the PaisaPay UA. </li>
<li> I agree that the PaisaPay UA are in all respects fair, reasonable and necessary in order to protect the users of PaisaPay services and the legitimate business interests of PaisaPay; </li>
<li> I agree that PaisaPay is only a service provider and is not responsible for any non-performance or breach of contract between users of PaisaPay. </li>
</ul>
<%-- <button type="submit" id="continue" name="continue" class="ButtonNormal"><span class="btn"><span class="btn">Continue</span></span></button> --%>

		<s:submit name="commandButton" value="Continue" id="s1"/>
		
</div>
</div>

<div class="greyBoxBottomPadding"></div>
</div>
<div style="clear:both;"></div>
</div>		
	</s:form>
</body>
<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <%@include file="footer.jsp"%>


					</span>
					<script type="text/javascript">var _GlobalNavHeaderStatic=false,_GlobalNavHeaderCookieTracking=true,_GlobalNavHeaderSrcPageId=PageHomePagePortal=3907;</script>

					<!--vo{2d71f+}0nd{71hj,,RlogId p4kjkbsdabjkrk9%3Fvo%7B2d71f%2B%7D0nd%7F%7B71hj-1368e4f8187-0x153-->
				</div>
</html>