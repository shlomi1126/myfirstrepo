<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="jscommends.js"> </script>
<link rel="stylesheet" type="text/css" href="izuv.css">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>

<button id = "clientlist">צור רשימת לקוחות כללית</button>

<div id = "homepageclienttable"></div>

<button onclick = "addClienta()">הוסף לקוח</button>
<div id = "formClient"></div>
<button id = "clientbyid" onclick = "findclienta();">חפש לקוח לפי ת.ז</button>
<div id = "homepageclienttable2"></div>



</body>
</html>