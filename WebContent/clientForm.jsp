<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>form</title>
<link rel="stylesheet" type="text/css" href="izuv.css">
<script>
function findGetParameter(parameterName) {
    var result = null,
        tmp = [];
    location.search
        .substr(1)
        .split("&")
        .forEach(function (item) {
          tmp = item.split("=");
          if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
        });
    return result;
}
function doadd(){
	var z = findGetParameter("action");
	if(z =="add"){
	document.getElementById("id").readOnly = false;
	document.getElementById("idlabel").innerHTML = "id reaquire";
	}
}
</script>
</head>
<body>
<section>
<form dir = "rtl" action = "clientController" method = "post" name ="clientos" id="formC" accept-charset=UTF-8 >
<div>
<lable for="f_name">שם פרטי:</lable>
<input type = "text" name="f_name" value = "<c:out value = "${ clientU.f_name}"/>"/> 
</div>
<div>
<lable for="l_name">שם משפחה:</lable>
<input type = "text" name="l_name" value = "<c:out value = "${ clientU.l_name}"/>"/> 
</div>
<div>
<lable for="client_id">תעודת זהות:</lable>
<input type = "number" name="client_id" value = "<c:out value = "${ clientU.client_id}"/>"/> 
</div>
<div>
<lable for="client_mail">כתובת מייל:</lable>
<input type = "email" name="client_mail" value = "<c:out value = "${ clientU.mail_client}"/>"/> 
</div>
<div>
<lable for="client_phone">טלפון :</lable>
<input type = "number" name="client_phone" value = "<c:out value = "${ clientU.phone_client}"/>"/> 
</div>

<input type = "submit" value="Add" onclick = "{document.clientos.action_type.value = this.value;addClienta2();}"/>
<input type = "hidden" name = "action_type"/>


</form>
</section>



</body>
</html>