<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Occurred</title>
</head>
<body>

<s:form action="homePage" name="ack" theme="simple">
<h1>Sorry, some error occurred</h1>
<h3>Your transaction was not successful.</h3>
<!-- <s:submit name="submit" value="Continue"/> -->
</s:form>
</body>
</html>