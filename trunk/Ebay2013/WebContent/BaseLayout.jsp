<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Ebay Home</title>
<link href="css1.css" type="text/css" rel="stylesheet">
<link href="css2.css" type="text/css" rel="stylesheet">
<link href="css3.css" type="text/css" rel="stylesheet">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
    <div id="container">
        <div id="header">
        				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <tiles:insertAttribute name="header" />

	</br>
					</span>
					</div>
            
        </div>
         <div id="content">
        				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <tiles:insertAttribute name="body" />

	</br>
					</span>
					</div>
            
        </div>
         <div id="footer">
        				<div class="pcontent">
					<!--cacheStatus: false-->
					<span class="ebay"> <tiles:insertAttribute name="footer" />

	</br>
					</span>
					</div>
            
        </div>
        
  </div>
  </html>

