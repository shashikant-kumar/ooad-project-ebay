<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd"> -->
   <!--Author: Ruchika  -->
   <%@taglib uri="/struts-tags" prefix="s" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
<title>Bank Transfer</title>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript">
function doValidation() {
	 var userid = document.getElementById("userid").value;
	 var password = document.getElementById("password").value;	 
	 if (userid==""||password=="")
		{
		alert("Userid and Password should not be blank. Please enter appropriately!");
		return false;
		}
	 return true;
}
</script>
</head>
<body>
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<h2> Payment through <s:property value="banks"/></h2>
<h3>Payments made using this facility can NOT be stopped or modified.</h3>

<s:form name="bank" method="post" action="bankPayment" theme="simple" class="form-horizontal">
<div class="control-group">
         <label class="control-label" for="userid">User ID</label>
         <div class="controls">
    <s:textfield name="userid" id="userid" size="20" placeholder="User ID"/>
  </div>
  </div>
    <div class="control-group">
  <label class="control-label" for="password">Password</label>
  <div class="controls">
     <s:password name="password" id="password" size="20" placeholder="Password"/>
    </div>
  </div>
  <s:submit name = "commandButton" id="mysubmit" value="Payment Login" onClick="return doValidation()" align="center" class="btn btn-success"/>
 </s:form>
</body>
</html>